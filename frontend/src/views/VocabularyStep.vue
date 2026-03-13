<template>
  <div class="vocabulary-page">
    <!-- 検索窓 -->
    <div class="search-bar">
      <input
        v-model="searchKeyword"
        type="text"
        placeholder="単語を検索..."
        class="search-input"
        @input="onSearchInput"
      />
    </div>

    <!-- フィルタバー -->
    <div class="filter-bar">
      <div class="filter-group">
        <button
          v-for="opt in knownOptions"
          :key="opt.value"
          :class="['filter-btn', { active: filters.known === opt.value }]"
          @click="filters.known = opt.value"
        >
          {{ opt.label }}
        </button>
      </div>
      <div class="filter-group">
        <button
          v-for="opt in levelOptions"
          :key="opt.value"
          :class="['filter-btn', { active: filters.level === opt.value }]"
          @click="filters.level = opt.value"
        >
          {{ opt.label }}
        </button>
      </div>
      <div class="filter-group">
        <button
          v-for="opt in sourceOptions"
          :key="opt.value"
          :class="['filter-btn', { active: filters.source === opt.value }]"
          @click="filters.source = opt.value"
        >
          {{ opt.label }}
        </button>
      </div>
    </div>

    <!-- 品詞略語の凡例 -->
    <div class="pos-legend">
      <span class="legend-item">n.=名詞</span>
      <span class="legend-item">v.=動詞</span>
      <span class="legend-item">adj.=形容詞</span>
      <span class="legend-item">adv.=副詞</span>
      <span class="legend-item">prep.=前置詞</span>
      <span class="legend-item">conj.=接続詞</span>
      <span class="legend-item">pron.=代名詞</span>
      <span class="legend-item">det.=限定詞</span>
    </div>

    <!-- 単語リスト -->
    <div class="word-list">
      <div v-for="word in words" :key="word.id" class="word-row">
        <div class="word-line1">
          <button class="reveal-btn" @click="toggleReveal(word.id)">
            {{ revealedWords.has(word.id) ? '隠す' : '意味' }}
          </button>
          <span class="field-label">単語</span>
          <span class="word-text">{{ word.word }}</span>
          <span class="field-label">発音</span>
          <span class="word-ipa">{{ word.pronunciationIpa || '-' }}</span>
          <span class="field-label">品詞</span>
          <span class="word-pos-val">{{ word.partOfSpeech || '-' }}</span>
          <div class="word-actions">
            <button
              :class="['known-btn', 'unknown', { active: word.known === 0 }]"
              @click="setKnown(word, 0)"
            >✗</button>
            <button
              :class="['known-btn', 'learning', { active: word.known === 1 }]"
              @click="setKnown(word, 1)"
            >△</button>
            <button
              :class="['known-btn', 'mastered', { active: word.known === 2 }]"
              @click="setKnown(word, 2)"
            >◎</button>
          </div>
        </div>
        <div v-if="revealedWords.has(word.id)" class="word-details">
          <div class="detail-row">
            <span class="detail-label">意味</span>
            <span class="word-meaning">{{ word.meaningGeneral }}</span>
          </div>
          <div v-if="word.meaningIt" class="detail-row">
            <span class="detail-label">IT</span>
            <span class="word-meaning-it">{{ word.meaningIt }}</span>
          </div>
          <template v-if="getRelated(word)">
            <div v-if="getRelated(word).synonyms?.length" class="detail-row">
              <span class="detail-label">同義</span>
              <span class="related-val">{{ getRelated(word).synonyms.join(', ') }}</span>
            </div>
            <div v-if="getRelated(word).antonyms?.length" class="detail-row">
              <span class="detail-label">対義</span>
              <span class="related-val">{{ getRelated(word).antonyms.join(', ') }}</span>
            </div>
            <div v-if="getRelated(word).derivatives?.length" class="detail-row">
              <span class="detail-label">派生</span>
              <span class="related-val">{{ getRelated(word).derivatives.join(', ') }}</span>
            </div>
          </template>
        </div>
      </div>
    </div>

    <!-- ページング -->
    <div class="pagination">
      <button :disabled="page === 0" @click="page--">前</button>
      <span>{{ page * size + 1 }}-{{ Math.min((page + 1) * size, totalElements) }} / {{ totalElements }}語</span>
      <button :disabled="(page + 1) * size >= totalElements" @click="page++">次</button>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive, watch } from 'vue'
import { wordApi } from '../api/client'

const words = ref([])
const revealedWords = ref(new Set())
const searchKeyword = ref('')
let searchTimer = null
const page = ref(0)
const size = 100
const totalElements = ref(0)

// 関連語キャッシュ (word_id -> { synonyms, antonyms, derivatives })
const relationsCache = ref({})

function getRelated(word) {
  const rel = relationsCache.value[word.id]
  if (!rel) return null
  const hasData = (rel.synonyms && rel.synonyms.length) ||
                  (rel.antonyms && rel.antonyms.length) ||
                  (rel.derivatives && rel.derivatives.length)
  return hasData ? rel : null
}

async function fetchRelations(wordList) {
  if (!wordList.length) return
  const ids = wordList.map(w => w.id)
  try {
    const res = await wordApi.getRelationsBatch(ids)
    relationsCache.value = { ...relationsCache.value, ...res.data }
  } catch (e) {
    // silently ignore - relations are supplementary
  }
}

const filters = reactive({
  known: null,
  level: null,
  source: null
})

const knownOptions = [
  { label: '全て', value: null },
  { label: '未学習', value: 0 },
  { label: '学習中', value: 1 },
  { label: '習得済', value: 2 },
]

const levelOptions = [
  { label: '全Level', value: null },
  { label: 'Lv.1', value: 1 },
  { label: 'Lv.2', value: 2 },
]

const sourceOptions = [
  { label: '全ソース', value: null },
  { label: 'NGSL', value: 'NGSL' },
  { label: 'IT', value: 'IT' },
]

async function fetchWords() {
  const params = { page: page.value, size }
  if (filters.known !== null) params.known = filters.known
  if (filters.level !== null) params.level = filters.level
  if (filters.source !== null) params.source = filters.source
  if (searchKeyword.value.trim()) params.keyword = searchKeyword.value.trim()
  const res = await wordApi.getWords(params)
  words.value = res.data.content
  totalElements.value = res.data.totalElements
  fetchRelations(res.data.content)
}

function onSearchInput() {
  clearTimeout(searchTimer)
  searchTimer = setTimeout(() => {
    page.value = 0
    fetchWords()
  }, 300)
}

function toggleReveal(wordId) {
  const next = new Set(revealedWords.value)
  if (next.has(wordId)) {
    next.delete(wordId)
  } else {
    next.add(wordId)
  }
  revealedWords.value = next
}

async function setKnown(word, value) {
  await wordApi.updateKnown(word.id, value)
  word.known = value
}

watch([() => filters.known, () => filters.level, () => filters.source], () => {
  page.value = 0
  fetchWords()
})

watch(page, fetchWords)

fetchWords()
</script>

<style scoped>
.search-bar {
  margin-bottom: 12px;
}

.search-input {
  width: 100%;
  padding: 8px 12px;
  background: #2a2a4a;
  color: #fff;
  border: 1px solid #3a3a5a;
  border-radius: 6px;
  font-size: 14px;
  outline: none;
  box-sizing: border-box;
}
.search-input:focus { border-color: #64b5f6; }
.search-input::placeholder { color: #666; }

.pos-legend {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  margin-bottom: 12px;
  padding: 6px 10px;
  background: #1a1a2e;
  border-radius: 4px;
}

.legend-item {
  color: #888;
  font-size: 11px;
}

.filter-bar {
  display: flex;
  gap: 12px;
  flex-wrap: wrap;
  margin-bottom: 16px;
}

.filter-group {
  display: flex;
  gap: 4px;
}

.filter-btn {
  padding: 4px 12px;
  background: #2a2a4a;
  color: #aaa;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 13px;
}

.filter-btn:hover { color: #fff; }
.filter-btn.active { background: #81c784; color: #1a1a2e; }

.word-list {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4px;
}

.word-row {
  display: flex;
  flex-direction: column;
  padding: 8px 12px;
  background: #2a2a4a;
  border-radius: 4px;
  height: 160px;
  overflow: hidden;
}

.word-line1 {
  display: flex;
  align-items: center;
  gap: 8px;
}

.reveal-btn {
  padding: 4px 8px;
  background: #3a3a5a;
  color: #aaa;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  font-size: 11px;
  flex-shrink: 0;
  width: 48px;
  text-align: center;
}
.reveal-btn:hover { color: #fff; }

.field-label {
  color: #666;
  font-size: 10px;
}

.word-text { font-weight: bold; color: #fff; font-size: 14px; }
.word-ipa { color: #888; font-size: 12px; font-style: italic; }
.word-pos-val { color: #888; font-size: 11px; background: #1a1a2e; padding: 1px 6px; border-radius: 3px; }

.word-actions {
  display: flex;
  gap: 4px;
  margin-left: auto;
  flex-shrink: 0;
}

.word-details {
  display: flex;
  flex-direction: column;
  gap: 1px;
  margin-top: 4px;
  padding-left: 56px;
}

.detail-row {
  display: flex;
  align-items: baseline;
  gap: 8px;
}

.detail-label {
  color: #666;
  font-size: 10px;
  width: 24px;
  flex-shrink: 0;
}

.word-meaning { color: #ccc; font-size: 13px; }
.word-meaning-it { color: #64b5f6; font-size: 12px; }

.related-val {
  color: #888;
  font-size: 12px;
}

.known-btn {
  padding: 4px 8px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  font-size: 12px;
  opacity: 0.5;
}

.known-btn.active { opacity: 1; }
.known-btn.unknown { background: #ef5350; color: #fff; }
.known-btn.learning { background: #ffb74d; color: #1a1a2e; }
.known-btn.mastered { background: #81c784; color: #1a1a2e; }

.pagination {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 16px;
  margin-top: 16px;
  color: #aaa;
  font-size: 14px;
}

.pagination button {
  padding: 6px 16px;
  background: #2a2a4a;
  color: #ccc;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.pagination button:disabled { opacity: 0.3; cursor: default; }
</style>
