<script setup>
import { ref, computed } from 'vue'
import data from '@data/readings.json'

const readings = data.readings
const selectedId = ref(readings.length > 0 ? readings[0].id : '')
const activeAnnotation = ref(null)

const currentReading = computed(() =>
  readings.find(r => r.id === selectedId.value) || null
)

function annotateText(text, annotations) {
  if (!annotations || annotations.length === 0) return text

  const sorted = [...annotations].sort((a, b) => {
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
</script>

<template>
  <div>
    <h1>長文読解</h1>
    <p class="intro">技術文書の原文と日本語訳を左右対比で表示します。色付きの語句をクリックすると解説を確認できます。</p>

    <div class="legend">
      <span class="legend-item"><span class="legend-dot dot-vocabulary"></span>語彙</span>
      <span class="legend-item"><span class="legend-dot dot-grammar"></span>文法</span>
      <span class="legend-item"><span class="legend-dot dot-idiom"></span>熟語・表現</span>
    </div>

    <div v-if="readings.length > 1" class="selector">
      <label for="reading-select">教材: </label>
      <select id="reading-select" v-model="selectedId">
        <option v-for="r in readings" :key="r.id" :value="r.id">{{ r.title }}</option>
      </select>
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
      >
        <div class="paragraph-en" @click="handleAnnotationClick" v-html="annotateText(para.en, para.annotations)"></div>
        <div class="paragraph-ja">{{ para.ja }}</div>
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

.legend {
  display: flex;
  gap: 16px;
  margin-bottom: 20px;
  font-size: 0.85rem;
  color: #666;
}

.legend-item {
  display: flex;
  align-items: center;
  gap: 4px;
}

.legend-dot {
  width: 12px;
  height: 12px;
  border-radius: 3px;
  display: inline-block;
}

.dot-vocabulary { background: #e3f2fd; border-bottom: 2px solid #1565c0; }
.dot-grammar { background: #fff3e0; }
.dot-idiom { background: #e8f5e9; border-bottom: 2px solid #2e7d32; }

.selector {
  margin-bottom: 20px;
}

.selector label {
  font-size: 0.9rem;
  color: #555;
  font-weight: 600;
}

.selector select {
  padding: 6px 10px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 0.9rem;
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

.paragraph-en {
  padding: 16px;
  line-height: 1.8;
  color: #333;
  border-right: 1px solid #f0f0f0;
  font-size: 0.95rem;
}

.paragraph-ja {
  padding: 16px;
  line-height: 1.8;
  color: #555;
  font-size: 0.95rem;
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

  .paragraph-en {
    border-right: none;
    border-bottom: 1px solid #f0f0f0;
  }
}
</style>
