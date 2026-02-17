<script setup>
import { ref, computed } from 'vue'
import Sidebar from './components/Sidebar.vue'
import SearchFilter from './components/SearchFilter.vue'
import VocabularyList from './components/VocabularyList.vue'
import ReadingPage from './components/ReadingPage.vue'
import EnglishGrammarGuide from './components/EnglishGrammarGuide.vue'
import GrammarGuide from './components/GrammarGuide.vue'
import PartsOfSpeechGuide from './components/PartsOfSpeechGuide.vue'
import data from '@data/vocabulary.json'

const currentPage = ref('vocabulary')

const searchQuery = ref('')
const selectedCategory = ref('all')
const selectedType = ref('all')

const allItems = computed(() => [...data.vocabulary, ...data.patterns])
</script>

<template>
  <Sidebar :currentPage="currentPage" @navigate="currentPage = $event" />
  <div class="main-content">
    <template v-if="currentPage === 'vocabulary'">
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
    </template>
    <ReadingPage v-else-if="currentPage === 'reading'" />
    <EnglishGrammarGuide v-else-if="currentPage === 'english-grammar'" />
    <GrammarGuide v-else-if="currentPage === 'grammar'" />
    <PartsOfSpeechGuide v-else-if="currentPage === 'parts-of-speech'" />
  </div>
</template>

<style scoped>
.main-content {
  margin-left: 200px;
  max-width: 900px;
  padding: 32px 16px;
}

h1 {
  font-size: 1.5rem;
  margin-bottom: 24px;
  color: #1a1a1a;
}
</style>
