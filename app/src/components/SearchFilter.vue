<script setup>
defineProps({
  searchQuery: { type: String, default: '' },
  selectedCategory: { type: String, default: 'all' },
  selectedType: { type: String, default: 'all' }
})

const emit = defineEmits(['update:searchQuery', 'update:selectedCategory', 'update:selectedType'])

const categories = [
  { value: 'all', label: 'すべて' },
  { value: 'official-docs', label: '公式ドキュメント' },
  { value: 'github', label: 'GitHub' },
  { value: 'claude-llm', label: 'Claude/LLM' },
  { value: 'technical-docs', label: '技術文書' }
]

const types = [
  { value: 'all', label: 'すべて' },
  { value: 'word', label: '語彙' },
  { value: 'pattern', label: '表現パターン' }
]
</script>

<template>
  <div class="filter-bar">
    <input
      type="text"
      class="search-input"
      placeholder="検索..."
      :value="searchQuery"
      @input="emit('update:searchQuery', $event.target.value)"
    />
    <select
      class="filter-select"
      :value="selectedCategory"
      @change="emit('update:selectedCategory', $event.target.value)"
    >
      <option v-for="cat in categories" :key="cat.value" :value="cat.value">
        {{ cat.label }}
      </option>
    </select>
    <select
      class="filter-select"
      :value="selectedType"
      @change="emit('update:selectedType', $event.target.value)"
    >
      <option v-for="t in types" :key="t.value" :value="t.value">
        {{ t.label }}
      </option>
    </select>
  </div>
</template>

<style scoped>
.filter-bar {
  display: flex;
  gap: 12px;
  margin-bottom: 20px;
}

.search-input {
  flex: 1;
  padding: 8px 12px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 0.95rem;
}

.filter-select {
  padding: 8px 12px;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 0.95rem;
  background: #fff;
}
</style>
