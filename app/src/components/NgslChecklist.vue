<script setup>
import { ref, computed, watch } from 'vue'
import ngslData from '@data/ngsl-top1000.json'

const STORAGE_KEY = 'ngsl-known-words'

// Load known state from localStorage
function loadKnown() {
  try {
    const saved = localStorage.getItem(STORAGE_KEY)
    return saved ? JSON.parse(saved) : {}
  } catch {
    return {}
  }
}

const knownMap = ref(loadKnown())

// Save to localStorage on change
watch(knownMap, (val) => {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(val))
}, { deep: true })

// Filter state
const filter = ref('all') // 'all' | 'unknown' | 'known' | 'has-it'
const searchQuery = ref('')
const groupSize = 100

// Current group (0 = rank 1-100, 1 = rank 101-200, etc.)
const currentGroup = ref(0)
const totalGroups = Math.ceil(ngslData.words.length / groupSize)

const groups = computed(() => {
  const result = []
  for (let i = 0; i < totalGroups; i++) {
    const start = i * groupSize
    const end = Math.min(start + groupSize, ngslData.words.length)
    const words = ngslData.words.slice(start, end)
    const knownCount = words.filter(w => knownMap.value[w.rank]).length
    result.push({
      index: i,
      label: `${start + 1}–${end}`,
      knownCount,
      total: words.length
    })
  }
  return result
})

const filteredWords = computed(() => {
  const start = currentGroup.value * groupSize
  const end = Math.min(start + groupSize, ngslData.words.length)
  let words = ngslData.words.slice(start, end)

  if (filter.value === 'known') {
    words = words.filter(w => knownMap.value[w.rank])
  } else if (filter.value === 'unknown') {
    words = words.filter(w => !knownMap.value[w.rank])
  } else if (filter.value === 'has-it') {
    words = words.filter(w => w.meanings && w.meanings.it)
  }

  if (searchQuery.value) {
    const q = searchQuery.value.toLowerCase()
    words = words.filter(w =>
      w.word.toLowerCase().includes(q) ||
      (w.meanings && w.meanings.general && w.meanings.general.includes(q)) ||
      (w.meanings && w.meanings.it && w.meanings.it.includes(q))
    )
  }

  return words
})

// Stats
const totalKnown = computed(() =>
  ngslData.words.filter(w => knownMap.value[w.rank]).length
)
const totalWords = ngslData.words.length
const totalItWords = ngslData.words.filter(w => w.meanings && w.meanings.it).length
const progressPercent = computed(() =>
  Math.round((totalKnown.value / totalWords) * 100)
)

function toggleKnown(rank) {
  knownMap.value[rank] = !knownMap.value[rank]
}

function markAllInGroup(known) {
  const start = currentGroup.value * groupSize
  const end = Math.min(start + groupSize, ngslData.words.length)
  for (let i = start; i < end; i++) {
    knownMap.value[ngslData.words[i].rank] = known
  }
}
</script>

<template>
  <h1>NGSL 基礎語彙チェック</h1>
  <p class="description">
    NGSL（New General Service List）上位1,000語のチェックリストです。
    日常の意味とIT文脈の意味を確認して、知っている単語にチェックを入れましょう。
  </p>

  <!-- Progress bar -->
  <div class="progress-section">
    <div class="progress-stats">
      <span class="progress-count">{{ totalKnown }} / {{ totalWords }} 語</span>
      <span class="progress-percent">{{ progressPercent }}%</span>
    </div>
    <div class="progress-bar">
      <div class="progress-fill" :style="{ width: progressPercent + '%' }"></div>
    </div>
    <div class="it-stats">IT意味あり: {{ totalItWords }} 語</div>
  </div>

  <!-- Controls -->
  <div class="controls">
    <input
      v-model="searchQuery"
      type="text"
      placeholder="単語・意味を検索..."
      class="search-input"
    />
    <div class="filter-buttons">
      <button
        :class="['filter-btn', { active: filter === 'all' }]"
        @click="filter = 'all'"
      >すべて</button>
      <button
        :class="['filter-btn', { active: filter === 'unknown' }]"
        @click="filter = 'unknown'"
      >未知のみ</button>
      <button
        :class="['filter-btn', { active: filter === 'known' }]"
        @click="filter = 'known'"
      >既知のみ</button>
      <button
        :class="['filter-btn filter-btn-it', { active: filter === 'has-it' }]"
        @click="filter = 'has-it'"
      >IT意味あり</button>
    </div>
  </div>

  <!-- Group selector -->
  <div class="group-selector">
    <button
      v-for="group in groups"
      :key="group.index"
      :class="['group-btn', { active: currentGroup === group.index }]"
      @click="currentGroup = group.index"
    >
      <span class="group-label">{{ group.label }}</span>
      <span class="group-progress">{{ group.knownCount }}/{{ group.total }}</span>
    </button>
  </div>

  <!-- Bulk actions -->
  <div class="bulk-actions">
    <button class="bulk-btn" @click="markAllInGroup(true)">このグループを全て既知にする</button>
    <button class="bulk-btn" @click="markAllInGroup(false)">このグループを全てリセット</button>
  </div>

  <!-- Word list (list layout) -->
  <div class="word-list">
    <div
      v-for="word in filteredWords"
      :key="word.rank"
      :class="['word-item', { known: knownMap[word.rank], 'has-it-meaning': word.meanings && word.meanings.it }]"
      @click="toggleKnown(word.rank)"
    >
      <input
        type="checkbox"
        :checked="knownMap[word.rank]"
        class="word-checkbox"
        @click.stop="toggleKnown(word.rank)"
      />
      <span class="word-rank">#{{ word.rank }}</span>
      <span class="word-text">{{ word.word }}</span>
      <span class="word-meaning-general">{{ word.meanings?.general || '―' }}</span>
      <span v-if="word.meanings?.it" class="word-meaning-it">
        <span class="it-badge">IT</span>
        {{ word.meanings.it }}
      </span>
    </div>
    <div v-if="filteredWords.length === 0" class="empty-state">
      該当する単語がありません
    </div>
  </div>
</template>

<style scoped>
.description {
  color: #666;
  font-size: 0.9rem;
  margin-bottom: 24px;
  line-height: 1.6;
}

/* Progress */
.progress-section {
  margin-bottom: 24px;
}

.progress-stats {
  display: flex;
  justify-content: space-between;
  margin-bottom: 6px;
}

.progress-count {
  font-size: 0.9rem;
  color: #555;
}

.progress-percent {
  font-size: 0.9rem;
  font-weight: 600;
  color: #1565c0;
}

.progress-bar {
  height: 8px;
  background: #e0e0e0;
  border-radius: 4px;
  overflow: hidden;
}

.progress-fill {
  height: 100%;
  background: #1565c0;
  border-radius: 4px;
  transition: width 0.3s;
}

.it-stats {
  margin-top: 6px;
  font-size: 0.8rem;
  color: #888;
}

/* Controls */
.controls {
  display: flex;
  gap: 12px;
  margin-bottom: 16px;
  align-items: center;
  flex-wrap: wrap;
}

.search-input {
  flex: 1;
  min-width: 180px;
  padding: 8px 12px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 0.9rem;
  outline: none;
}

.search-input:focus {
  border-color: #1565c0;
}

.filter-buttons {
  display: flex;
  gap: 4px;
}

.filter-btn {
  padding: 6px 14px;
  border: 1px solid #ddd;
  border-radius: 6px;
  background: #fff;
  font-size: 0.85rem;
  cursor: pointer;
  color: #555;
  transition: all 0.15s;
}

.filter-btn:hover {
  background: #f5f5f5;
}

.filter-btn.active {
  background: #e3f2fd;
  color: #1565c0;
  border-color: #1565c0;
  font-weight: 600;
}

.filter-btn-it.active {
  background: #fff3e0;
  color: #e65100;
  border-color: #e65100;
}

/* Group selector */
.group-selector {
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
  margin-bottom: 16px;
}

.group-btn {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 6px 10px;
  border: 1px solid #ddd;
  border-radius: 6px;
  background: #fff;
  cursor: pointer;
  transition: all 0.15s;
  min-width: 70px;
}

.group-btn:hover {
  background: #f5f5f5;
}

.group-btn.active {
  background: #e3f2fd;
  border-color: #1565c0;
}

.group-label {
  font-size: 0.8rem;
  font-weight: 600;
  color: #333;
}

.group-progress {
  font-size: 0.7rem;
  color: #888;
}

/* Bulk actions */
.bulk-actions {
  display: flex;
  gap: 8px;
  margin-bottom: 16px;
}

.bulk-btn {
  padding: 6px 12px;
  border: 1px solid #ddd;
  border-radius: 6px;
  background: #fff;
  font-size: 0.8rem;
  cursor: pointer;
  color: #666;
  transition: all 0.15s;
}

.bulk-btn:hover {
  background: #f5f5f5;
  color: #333;
}

/* Word list - list layout */
.word-list {
  display: flex;
  flex-direction: column;
  gap: 2px;
}

.word-item {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 10px 12px;
  border-radius: 6px;
  cursor: pointer;
  transition: background 0.15s;
  user-select: none;
  border-bottom: 1px solid #f0f0f0;
}

.word-item:hover {
  background: #f5f5f5;
}

.word-item.known {
  background: #e8f5e9;
}

.word-item.known:hover {
  background: #c8e6c9;
}

.word-checkbox {
  cursor: pointer;
  width: 16px;
  height: 16px;
  flex-shrink: 0;
  accent-color: #2e7d32;
}

.word-rank {
  font-size: 0.75rem;
  color: #aaa;
  min-width: 36px;
  flex-shrink: 0;
}

.word-text {
  font-size: 0.95rem;
  font-weight: 600;
  color: #333;
  min-width: 80px;
  flex-shrink: 0;
}

.word-item.known .word-text {
  color: #2e7d32;
}

.word-meaning-general {
  font-size: 0.85rem;
  color: #666;
  min-width: 120px;
  flex-shrink: 0;
}

.word-meaning-it {
  font-size: 0.85rem;
  color: #e65100;
  display: flex;
  align-items: center;
  gap: 6px;
}

.it-badge {
  display: inline-block;
  padding: 1px 6px;
  background: #fff3e0;
  color: #e65100;
  border-radius: 4px;
  font-size: 0.7rem;
  font-weight: 700;
  flex-shrink: 0;
}

.empty-state {
  text-align: center;
  padding: 40px;
  color: #999;
  font-size: 0.9rem;
}
</style>
