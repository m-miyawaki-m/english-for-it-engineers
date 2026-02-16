<script setup>
import { computed } from 'vue'

const props = defineProps({
  item: {
    type: Object,
    required: true
  }
})

function renderBold(text) {
  return text.replace(/\*\*(.+?)\*\*/g, '<strong>$1</strong>')
}

const renderedExample = computed(() => renderBold(props.item.example))
const renderedExampleJa = computed(() => props.item.exampleJa ? renderBold(props.item.exampleJa) : '')
</script>

<template>
  <div class="card">
    <div class="card-header">
      <span class="term">{{ item.term }}</span>
      <div class="badges">
        <span class="badge" :class="item.type">{{ item.type }}</span>
        <span v-if="item.partOfSpeech" class="badge pos">{{ item.partOfSpeech }}</span>
        <span v-if="item.domain" class="badge domain">{{ item.domain }}</span>
      </div>
    </div>
    <p class="meaning">{{ item.meaning }}</p>
    <p class="example" v-html="renderedExample"></p>
    <p v-if="renderedExampleJa" class="example-ja" v-html="renderedExampleJa"></p>
    <div v-if="item.structure || item.grammar" class="grammar-info">
      <span v-if="item.structure" class="grammar-tag">{{ item.structure }}</span>
      <span v-if="item.grammar" class="grammar-label">{{ item.grammar }}</span>
    </div>
    <div class="card-footer">
      <span class="source">{{ item.source }}</span>
      <span class="session">Session {{ item.session }}</span>
    </div>
  </div>
</template>

<style scoped>
.card {
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  padding: 16px;
  margin-bottom: 12px;
  background: #fff;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 8px;
  gap: 8px;
}

.term {
  font-size: 1.1rem;
  font-weight: 700;
}

.badges {
  display: flex;
  gap: 4px;
  flex-wrap: wrap;
}

.badge {
  font-size: 0.7rem;
  padding: 2px 8px;
  border-radius: 12px;
  font-weight: 600;
  white-space: nowrap;
}

.badge.word {
  background: #e3f2fd;
  color: #1565c0;
}

.badge.pattern {
  background: #f3e5f5;
  color: #7b1fa2;
}

.badge.pos {
  background: #e8f5e9;
  color: #2e7d32;
}

.badge.domain {
  background: #fff3e0;
  color: #e65100;
}

.meaning {
  color: #333;
  margin: 4px 0;
}

.example {
  color: #666;
  font-style: italic;
  margin: 4px 0;
}

.example-ja {
  color: #888;
  font-size: 0.9rem;
  margin: 2px 0 4px 0;
}

.grammar-info {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-top: 6px;
}

.grammar-tag {
  font-size: 0.75rem;
  font-weight: 700;
  padding: 2px 8px;
  border-radius: 4px;
  background: #fce4ec;
  color: #c62828;
}

.grammar-label {
  font-size: 0.8rem;
  color: #777;
}

.card-footer {
  display: flex;
  justify-content: space-between;
  font-size: 0.8rem;
  color: #999;
  margin-top: 8px;
}
</style>
