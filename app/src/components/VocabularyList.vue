<script setup>
import { computed } from 'vue'
import VocabularyCard from './VocabularyCard.vue'

const props = defineProps({
  items: { type: Array, required: true },
  searchQuery: { type: String, default: '' },
  selectedCategory: { type: String, default: 'all' },
  selectedType: { type: String, default: 'all' }
})

const filteredItems = computed(() => {
  return props.items.filter(item => {
    const matchesSearch = !props.searchQuery ||
      item.term.toLowerCase().includes(props.searchQuery.toLowerCase())

    const matchesCategory = props.selectedCategory === 'all' ||
      item.category === props.selectedCategory

    const matchesType = props.selectedType === 'all' ||
      item.type === props.selectedType

    return matchesSearch && matchesCategory && matchesType
  })
})

const wordCount = computed(() => filteredItems.value.filter(i => i.type === 'word').length)
const patternCount = computed(() => filteredItems.value.filter(i => i.type === 'pattern').length)
</script>

<template>
  <div>
    <div class="list">
      <VocabularyCard v-for="item in filteredItems" :key="item.id" :item="item" />
      <p v-if="filteredItems.length === 0" class="empty">該当する語彙がありません</p>
    </div>
    <div class="stats">
      語彙: {{ wordCount }}件 / 表現パターン: {{ patternCount }}件
    </div>
  </div>
</template>

<style scoped>
.list {
  margin-bottom: 16px;
}

.empty {
  text-align: center;
  color: #999;
  padding: 40px 0;
}

.stats {
  text-align: center;
  color: #888;
  font-size: 0.85rem;
  padding: 12px 0;
  border-top: 1px solid #eee;
}
</style>
