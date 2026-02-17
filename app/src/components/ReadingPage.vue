<script setup>
import { ref, computed } from 'vue'
import data from '@data/readings.json'

const readings = data.readings
const searchQuery = ref('')
const selectedCategory = ref('all')
const selectedId = ref(readings.length > 0 ? readings[0].id : '')
const activeAnnotation = ref(null)
const showStructure = ref(true)
const showVocabulary = ref(true)
const showGrammar = ref(true)
const showIdiom = ref(true)
const showJa = ref(true)
const showEn = ref(true)

const categoryLabels = {
  'official-docs': '公式ドキュメント',
  'github': 'GitHub',
  'claude-llm': 'Claude/LLM',
  'technical-docs': '技術文書'
}

const categories = computed(() => {
  const cats = [...new Set(readings.map(r => r.category))]
  return cats.sort()
})

const filteredReadings = computed(() => {
  return readings.filter(r => {
    const matchCategory = selectedCategory.value === 'all' || r.category === selectedCategory.value
    const query = searchQuery.value.toLowerCase()
    const matchSearch = !query ||
      r.title.toLowerCase().includes(query) ||
      r.source.toLowerCase().includes(query) ||
      r.paragraphs.some(p =>
        p.en.toLowerCase().includes(query) ||
        p.ja.includes(searchQuery.value)
      )
    return matchCategory && matchSearch
  })
})

const currentReading = computed(() =>
  readings.find(r => r.id === selectedId.value) || null
)

function selectReading(id) {
  selectedId.value = id
}

const visibleTypes = computed(() => {
  const types = []
  if (showVocabulary.value) types.push('vocabulary')
  if (showGrammar.value) types.push('grammar')
  if (showIdiom.value) types.push('idiom')
  return types
})

function annotateText(text, annotations) {
  if (!annotations || annotations.length === 0) return text

  const filtered = annotations.filter(a => visibleTypes.value.includes(a.type))
  if (filtered.length === 0) return text

  const sorted = [...filtered].sort((a, b) => {
    const idxA = text.toLowerCase().indexOf(a.text.toLowerCase())
    const idxB = text.toLowerCase().indexOf(b.text.toLowerCase())
    return idxB - idxA
  })

  let result = text
  for (const ann of sorted) {
    const idx = result.toLowerCase().indexOf(ann.text.toLowerCase())
    if (idx === -1) continue
    const original = result.substring(idx, idx + ann.text.length)
    const cls = `ann ann-${ann.type}`
    result =
      result.substring(0, idx) +
      `<span class="${cls}" data-note="${escapeAttr(ann.note)}" data-type="${ann.type}">${original}</span>` +
      result.substring(idx + ann.text.length)
  }
  return result
}

function escapeAttr(str) {
  return str.replace(/&/g, '&amp;').replace(/"/g, '&quot;').replace(/</g, '&lt;').replace(/>/g, '&gt;')
}

function handleAnnotationClick(e) {
  const target = e.target.closest('.ann')
  if (target) {
    activeAnnotation.value = {
      text: target.textContent,
      note: target.getAttribute('data-note'),
      type: target.getAttribute('data-type')
    }
  }
}

function closeAnnotation() {
  activeAnnotation.value = null
}

const typeLabels = {
  vocabulary: '語彙',
  grammar: '文法',
  idiom: '熟語・表現'
}

const roleColors = {
  S: '#1565c0',
  V: '#c62828',
  O: '#2e7d32',
  C: '#6a1b9a',
  M: '#ef6c00',
  '従属節': '#78909c'
}

function getRoleColor(role) {
  return roleColors[role] || '#757575'
}
</script>

<template>
  <div>
    <h1>長文読解</h1>
    <p class="intro">技術文書の原文と日本語訳を左右対比で表示します。色付きの語句をクリックすると解説を確認できます。</p>

    <div class="filter-bar">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="教材を検索..."
        class="search-input"
      />
      <select v-model="selectedCategory" class="category-select">
        <option value="all">すべてのカテゴリ</option>
        <option v-for="cat in categories" :key="cat" :value="cat">
          {{ categoryLabels[cat] || cat }}
        </option>
      </select>
    </div>

    <div class="reading-list">
      <div
        v-for="r in filteredReadings"
        :key="r.id"
        class="reading-list-item"
        :class="{ selected: r.id === selectedId }"
        @click="selectReading(r.id)"
      >
        <div class="reading-list-title">{{ r.title }}</div>
        <div class="reading-list-meta">
          <span class="reading-list-category">{{ categoryLabels[r.category] || r.category }}</span>
          <span class="reading-list-level">{{ r.level }}</span>
          <span class="reading-list-count">{{ r.paragraphs.length }}段落</span>
        </div>
      </div>
      <div v-if="filteredReadings.length === 0" class="no-results">
        該当する教材がありません。
      </div>
    </div>

    <div v-if="currentReading" class="display-toggles">
      <span class="toggles-label">表示切替:</span>
      <label class="toggle" :class="{ 'toggle-active': showVocabulary }">
        <input type="checkbox" v-model="showVocabulary" />
        <span class="toggle-dot dot-vocabulary"></span>語彙
      </label>
      <label class="toggle" :class="{ 'toggle-active': showGrammar }">
        <input type="checkbox" v-model="showGrammar" />
        <span class="toggle-dot dot-grammar"></span>文法
      </label>
      <label class="toggle" :class="{ 'toggle-active': showIdiom }">
        <input type="checkbox" v-model="showIdiom" />
        <span class="toggle-dot dot-idiom"></span>熟語
      </label>
      <label class="toggle" :class="{ 'toggle-active': showStructure }">
        <input type="checkbox" v-model="showStructure" />
        <span class="toggle-dot dot-structure"></span>文構造
      </label>
      <label class="toggle" :class="{ 'toggle-active': showEn }">
        <input type="checkbox" v-model="showEn" />
        <span class="toggle-dot dot-en"></span>英文
      </label>
      <label class="toggle" :class="{ 'toggle-active': showJa }">
        <input type="checkbox" v-model="showJa" />
        <span class="toggle-dot dot-ja"></span>和訳
      </label>
    </div>

    <div v-if="currentReading && showStructure" class="structure-legend">
      <span v-for="(color, role) in roleColors" :key="role" class="structure-legend-item">
        <span class="structure-legend-dot" :style="{ background: color }"></span>{{ role }}
      </span>
    </div>

    <div v-if="currentReading" class="reading-container">
      <div class="reading-header">
        <h2>{{ currentReading.title }}</h2>
        <span class="reading-meta">{{ currentReading.source }} / {{ currentReading.level }}</span>
      </div>

      <div
        v-for="(para, idx) in currentReading.paragraphs"
        :key="idx"
        class="paragraph-row"
        :class="{ 'single-column': !showJa || (!showEn && !showStructure) }"
      >
        <div class="paragraph-en-wrapper" :class="{ 'no-border-right': !showJa }" v-if="showEn || showStructure">
          <div v-if="showEn" class="paragraph-en" @click="handleAnnotationClick" v-html="annotateText(para.en, para.annotations)"></div>
          <div v-if="showStructure && para.structures" class="structure-bar">
            <span
              v-for="(s, si) in para.structures"
              :key="si"
              class="structure-chunk"
              :style="{ borderColor: getRoleColor(s.role) }"
            >
              <span class="structure-text">{{ s.text }}</span>
              <span class="structure-role" :style="{ background: getRoleColor(s.role) }">{{ s.role }}</span>
              <span class="structure-label">{{ s.label }}</span>
            </span>
          </div>
        </div>
        <div v-if="showJa" class="paragraph-ja" :class="{ 'no-border-left': !showEn }">{{ para.ja }}</div>
      </div>
    </div>

    <div v-else class="empty-state">
      教材データがありません。<code>/explain</code> で文章を解析すると自動的に追加されます。
    </div>

    <div v-if="activeAnnotation" class="annotation-overlay" @click.self="closeAnnotation">
      <div class="annotation-panel">
        <button class="close-btn" @click="closeAnnotation">&times;</button>
        <div class="annotation-type" :class="`type-${activeAnnotation.type}`">
          {{ typeLabels[activeAnnotation.type] || activeAnnotation.type }}
        </div>
        <div class="annotation-text">{{ activeAnnotation.text }}</div>
        <div class="annotation-note">{{ activeAnnotation.note }}</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
h1 {
  font-size: 1.5rem;
  margin-bottom: 8px;
  color: #1a1a1a;
}

.intro {
  color: #777;
  font-size: 0.9rem;
  margin-bottom: 16px;
}

.filter-bar {
  display: flex;
  gap: 10px;
  margin-bottom: 16px;
}

.search-input {
  flex: 1;
  padding: 8px 12px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 0.9rem;
  outline: none;
  transition: border-color 0.15s;
}

.search-input:focus {
  border-color: #1565c0;
}

.category-select {
  padding: 8px 12px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 0.9rem;
  background: #fff;
}

.reading-list {
  display: flex;
  flex-direction: column;
  gap: 8px;
  margin-bottom: 20px;
}

.reading-list-item {
  padding: 12px 16px;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  cursor: pointer;
  transition: border-color 0.15s, background 0.15s;
}

.reading-list-item:hover {
  background: #f5f5f5;
}

.reading-list-item.selected {
  border-color: #1565c0;
  background: #e3f2fd;
}

.reading-list-title {
  font-size: 0.95rem;
  font-weight: 600;
  color: #333;
  margin-bottom: 4px;
}

.reading-list-meta {
  display: flex;
  gap: 10px;
  font-size: 0.8rem;
  color: #888;
}

.reading-list-category {
  background: #f0f0f0;
  padding: 1px 8px;
  border-radius: 10px;
}

.reading-list-item.selected .reading-list-category {
  background: #bbdefb;
  color: #1565c0;
}

.reading-list-level,
.reading-list-count {
  color: #aaa;
}

.no-results {
  text-align: center;
  color: #999;
  padding: 20px;
  font-size: 0.9rem;
}

.display-toggles {
  display: flex;
  align-items: center;
  gap: 12px;
  margin-bottom: 16px;
  padding: 10px 14px;
  background: #fafafa;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  flex-wrap: wrap;
}

.toggles-label {
  font-size: 0.8rem;
  font-weight: 600;
  color: #999;
  margin-right: 4px;
}

.toggle {
  font-size: 0.85rem;
  color: #888;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 4px;
  user-select: none;
  padding: 3px 10px;
  border-radius: 14px;
  border: 1px solid transparent;
  transition: all 0.15s;
}

.toggle:hover {
  background: #f0f0f0;
}

.toggle-active {
  background: #fff;
  border-color: #ddd;
  color: #333;
}

.toggle input {
  display: none;
}

.toggle-dot {
  width: 8px;
  height: 8px;
  border-radius: 2px;
  display: inline-block;
}

.dot-vocabulary { background: #1565c0; }
.dot-grammar { background: #e65100; }
.dot-idiom { background: #2e7d32; }
.dot-structure { background: #78909c; }
.dot-en { background: #37474f; }
.dot-ja { background: #8d6e63; }

.structure-legend {
  display: flex;
  gap: 12px;
  margin-bottom: 16px;
  font-size: 0.8rem;
  color: #666;
  flex-wrap: wrap;
}

.structure-legend-item {
  display: flex;
  align-items: center;
  gap: 4px;
}

.structure-legend-dot {
  width: 10px;
  height: 10px;
  border-radius: 2px;
  display: inline-block;
}

.reading-container {
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  overflow: hidden;
}

.reading-header {
  padding: 16px;
  background: #fafafa;
  border-bottom: 1px solid #e0e0e0;
}

.reading-header h2 {
  font-size: 1.1rem;
  color: #333;
  margin-bottom: 4px;
}

.reading-meta {
  font-size: 0.8rem;
  color: #999;
}

.paragraph-row {
  display: grid;
  grid-template-columns: 1fr 1fr;
  border-bottom: 1px solid #f0f0f0;
}

.paragraph-row:last-child {
  border-bottom: none;
}

.paragraph-row.single-column {
  grid-template-columns: 1fr;
}

.paragraph-en-wrapper {
  border-right: 1px solid #f0f0f0;
}

.paragraph-en-wrapper.no-border-right {
  border-right: none;
}

.paragraph-en {
  padding: 16px 16px 8px;
  line-height: 1.8;
  color: #333;
  font-size: 0.95rem;
}

.paragraph-ja {
  padding: 16px;
  line-height: 1.8;
  color: #555;
  font-size: 0.95rem;
}

.structure-bar {
  padding: 4px 16px 16px;
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
}

.structure-chunk {
  display: inline-flex;
  flex-direction: column;
  align-items: flex-start;
  border-top: 3px solid;
  padding: 4px 8px 2px;
  border-radius: 0 0 4px 4px;
  background: #fafafa;
}

.structure-text {
  font-size: 0.8rem;
  color: #555;
  line-height: 1.4;
  word-break: break-word;
}

.structure-role {
  font-size: 0.65rem;
  font-weight: 700;
  color: #fff;
  padding: 1px 6px;
  border-radius: 3px;
  margin-top: 2px;
  letter-spacing: 0.05em;
}

.structure-label {
  font-size: 0.7rem;
  color: #888;
  margin-top: 1px;
}

.paragraph-en :deep(.ann) {
  cursor: pointer;
  border-radius: 2px;
  padding: 1px 2px;
  transition: opacity 0.15s;
}

.paragraph-en :deep(.ann:hover) {
  opacity: 0.8;
}

.paragraph-en :deep(.ann-vocabulary) {
  color: #1565c0;
  border-bottom: 2px solid #1565c0;
}

.paragraph-en :deep(.ann-grammar) {
  background: #fff3e0;
  color: #e65100;
}

.paragraph-en :deep(.ann-idiom) {
  color: #2e7d32;
  font-weight: 600;
  border-bottom: 2px solid #2e7d32;
}

.annotation-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.3);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 100;
}

.annotation-panel {
  background: #fff;
  border-radius: 12px;
  padding: 24px;
  max-width: 400px;
  width: 90%;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.15);
  position: relative;
}

.close-btn {
  position: absolute;
  top: 12px;
  right: 16px;
  background: none;
  border: none;
  font-size: 1.5rem;
  color: #999;
  cursor: pointer;
}

.close-btn:hover {
  color: #333;
}

.annotation-type {
  font-size: 0.75rem;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: 0.05em;
  padding: 3px 10px;
  border-radius: 12px;
  display: inline-block;
  margin-bottom: 10px;
}

.type-vocabulary { background: #e3f2fd; color: #1565c0; }
.type-grammar { background: #fff3e0; color: #e65100; }
.type-idiom { background: #e8f5e9; color: #2e7d32; }

.annotation-text {
  font-size: 1.15rem;
  font-weight: 600;
  color: #333;
  margin-bottom: 10px;
}

.annotation-note {
  color: #555;
  line-height: 1.6;
  font-size: 0.95rem;
}

.empty-state {
  color: #999;
  text-align: center;
  padding: 60px 20px;
  font-size: 0.95rem;
}

.empty-state code {
  background: #f5f5f5;
  padding: 2px 6px;
  border-radius: 4px;
}

@media (max-width: 768px) {
  .paragraph-row {
    grid-template-columns: 1fr;
  }

  .paragraph-en-wrapper {
    border-right: none;
    border-bottom: 1px solid #f0f0f0;
  }

  .display-toggles {
    gap: 8px;
  }
}
</style>
