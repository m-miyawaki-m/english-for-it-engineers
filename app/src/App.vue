<script setup>
import { ref, computed } from 'vue'
import SearchFilter from './components/SearchFilter.vue'
import VocabularyList from './components/VocabularyList.vue'
import data from '@data/vocabulary.json'

const searchQuery = ref('')
const selectedCategory = ref('all')
const selectedType = ref('all')

const allItems = computed(() => [...data.vocabulary, ...data.patterns])
</script>

<template>
  <div class="container">
    <h1>IT Engineer English Vocabulary</h1>
    <SearchFilter
      v-model:searchQuery="searchQuery"
      v-model:selectedCategory="selectedCategory"
      v-model:selectedType="selectedType"
    />
    <VocabularyList
      :items="allItems"
      :searchQuery="searchQuery"
      :selectedCategory="selectedCategory"
      :selectedType="selectedType"
    />
  </div>
</template>

<style scoped>
.container {
  max-width: 720px;
  margin: 0 auto;
  padding: 32px 16px;
}

h1 {
  font-size: 1.5rem;
  margin-bottom: 24px;
  color: #1a1a1a;
}
</style>
