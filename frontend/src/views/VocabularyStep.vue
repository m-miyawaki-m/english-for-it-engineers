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

    <!-- 単語リスト -->
    <div class="word-list">
      <div v-for="word in words" :key="word.id" class="word-row">
        <div class="word-info">
          <button class="reveal-btn" @click="toggleReveal(word.id)">
            {{ revealedWords.has(word.id) ? '隠す' : '意味' }}
          </button>
          <span class="word-text">{{ word.word }}</span>
          <span v-if="word.partOfSpeech" class="word-pos">{{ word.partOfSpeech }}</span>
          <div v-if="revealedWords.has(word.id)" class="word-details">
            <div class="word-meaning">{{ word.meaningGeneral }}</div>
            <div v-if="word.meaningIt" class="word-meaning-it">IT: {{ word.meaningIt }}</div>
            <div v-if="getRelated(word.word)" class="word-related">
              <div v-if="getRelated(word.word).derivatives" class="related-group">
                派生: {{ getRelated(word.word).derivatives.join(', ') }}
              </div>
              <div v-if="getRelated(word.word).synonyms" class="related-group">
                同義: {{ getRelated(word.word).synonyms.join(', ') }}
              </div>
              <div v-if="getRelated(word.word).antonyms" class="related-group">
                対義: {{ getRelated(word.word).antonyms.join(', ') }}
              </div>
            </div>
          </div>
        </div>
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

// モックデータ: 関連語（DB実装後に差し替え）
const mockRelated = {
  change: { derivatives: ['changeable', 'unchanged'], synonyms: ['modify', 'alter'], antonyms: ['keep', 'maintain'] },
  use: { derivatives: ['usage', 'useful', 'usable'], synonyms: ['utilize', 'employ'], antonyms: ['discard'] },
  make: { derivatives: ['maker', 'making'], synonyms: ['create', 'build', 'produce'], antonyms: ['destroy'] },
  work: { derivatives: ['worker', 'working', 'workable'], synonyms: ['function', 'operate'], antonyms: ['fail', 'break'] },
  take: { derivatives: ['taking', 'taken'], synonyms: ['grab', 'acquire'], antonyms: ['give', 'release'] },
  help: { derivatives: ['helper', 'helpful', 'helpless'], synonyms: ['assist', 'support'], antonyms: ['hinder'] },
  start: { derivatives: ['starter', 'starting'], synonyms: ['begin', 'initiate'], antonyms: ['stop', 'end'] },
  call: { derivatives: ['caller', 'callback'], synonyms: ['invoke', 'execute'], antonyms: null },
  move: { derivatives: ['movement', 'movable'], synonyms: ['shift', 'transfer'], antonyms: ['stay', 'remain'] },
  set: { derivatives: ['setting', 'setup'], synonyms: ['configure', 'assign'], antonyms: ['unset', 'clear'] },
  run: { derivatives: ['runner', 'runtime', 'running'], synonyms: ['execute', 'launch'], antonyms: ['stop', 'halt'] },
  find: { derivatives: ['finder', 'finding'], synonyms: ['search', 'locate'], antonyms: ['lose', 'hide'] },
  show: { derivatives: ['showing', 'shown'], synonyms: ['display', 'render'], antonyms: ['hide', 'conceal'] },
  write: { derivatives: ['writer', 'writing', 'writable'], synonyms: ['compose', 'author'], antonyms: ['read'] },
  read: { derivatives: ['reader', 'readable', 'reading'], synonyms: ['parse', 'interpret'], antonyms: ['write'] },
  build: { derivatives: ['builder', 'building', 'built'], synonyms: ['construct', 'compile'], antonyms: ['demolish'] },
  add: { derivatives: ['addition', 'additional'], synonyms: ['append', 'insert'], antonyms: ['remove', 'delete'] },
  create: { derivatives: ['creation', 'creator', 'creative'], synonyms: ['make', 'generate'], antonyms: ['destroy', 'delete'] },
  open: { derivatives: ['opener', 'opening'], synonyms: ['launch', 'access'], antonyms: ['close', 'shut'] },
  close: { derivatives: ['closure', 'closing', 'closed'], synonyms: ['shut', 'terminate'], antonyms: ['open'] },
}

function getRelated(word) {
  return mockRelated[word.toLowerCase()] || null
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
  justify-content: space-between;
  align-items: center;
  padding: 10px 12px;
  background: #2a2a4a;
  border-radius: 4px;
}

.word-info {
  display: flex;
  align-items: baseline;
  gap: 8px;
  flex-wrap: wrap;
  min-width: 0;
}

.word-text { font-weight: bold; color: #fff; }
.word-pos { color: #888; font-size: 11px; background: #1a1a2e; padding: 1px 6px; border-radius: 3px; }

.word-details {
  width: 100%;
  padding-top: 4px;
  display: flex;
  flex-direction: column;
  gap: 2px;
}

.word-meaning { color: #aaa; font-size: 14px; }
.word-meaning-it { color: #64b5f6; font-size: 13px; }

.word-related {
  display: flex;
  flex-direction: column;
  gap: 2px;
  margin-top: 2px;
}

.related-group {
  color: #888;
  font-size: 12px;
}

.reveal-btn {
  padding: 2px 8px;
  background: #3a3a5a;
  color: #aaa;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  font-size: 11px;
  flex-shrink: 0;
  width: 72px;
  text-align: center;
}
.reveal-btn:hover { color: #fff; }

.word-actions { display: flex; gap: 4px; }

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
