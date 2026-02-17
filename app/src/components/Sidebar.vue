<script setup>
defineProps({
  currentPage: { type: String, required: true }
})

const emit = defineEmits(['navigate'])

const pages = [
  { id: 'vocabulary', label: '語彙一覧' },
  { id: 'english-grammar', label: '英文法ガイド' },
  { id: 'grammar', label: '文法解説（技術英語）' },
  { id: 'parts-of-speech', label: '品詞解説' }
]
</script>

<template>
  <nav class="sidebar">
    <div class="sidebar-title">Menu</div>
    <ul class="nav-list">
      <li
        v-for="page in pages"
        :key="page.id"
        class="nav-item"
        :class="{ active: currentPage === page.id }"
        @click="emit('navigate', page.id)"
      >
        {{ page.label }}
      </li>
    </ul>
  </nav>
</template>

<style scoped>
.sidebar {
  width: 200px;
  min-height: 100vh;
  background: #fff;
  border-right: 1px solid #e0e0e0;
  padding: 20px 0;
  position: fixed;
  left: 0;
  top: 0;
}

.sidebar-title {
  font-size: 0.85rem;
  font-weight: 600;
  color: #999;
  text-transform: uppercase;
  letter-spacing: 0.05em;
  padding: 0 20px;
  margin-bottom: 12px;
}

.nav-list {
  list-style: none;
  padding: 0;
  margin: 0;
}

.nav-item {
  padding: 10px 20px;
  cursor: pointer;
  color: #555;
  font-size: 0.95rem;
  transition: background 0.15s, color 0.15s;
}

.nav-item:hover {
  background: #f5f5f5;
  color: #333;
}

.nav-item.active {
  background: #e3f2fd;
  color: #1565c0;
  font-weight: 600;
  border-right: 3px solid #1565c0;
}
</style>
