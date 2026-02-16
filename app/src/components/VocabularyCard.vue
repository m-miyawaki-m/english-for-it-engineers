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
      <span class="badge" :class="item.type">{{ item.type }}</span>
    </div>
    <p class="meaning">{{ item.meaning }}</p>
    <p class="example" v-html="renderedExample"></p>
    <p v-if="renderedExampleJa" class="example-ja" v-html="renderedExampleJa"></p>
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
}

.term {
  font-size: 1.1rem;
  font-weight: 700;
}

.badge {
  font-size: 0.75rem;
  padding: 2px 8px;
  border-radius: 12px;
  font-weight: 600;
}

.badge.word {
  background: #e3f2fd;
  color: #1565c0;
}

.badge.pattern {
  background: #f3e5f5;
  color: #7b1fa2;
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

.card-footer {
  display: flex;
  justify-content: space-between;
  font-size: 0.8rem;
  color: #999;
  margin-top: 8px;
}
</style>
