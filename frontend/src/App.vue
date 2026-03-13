<template>
  <div id="app">
    <nav class="top-nav">
      <router-link to="/" class="nav-item" :class="{ active: $route.name === 'dashboard' }">
        Dashboard
      </router-link>
      <router-link to="/curriculum" class="nav-item" :class="{ active: $route.name === 'curriculum' }">
        カリキュラム
      </router-link>
      <router-link to="/vocabulary" class="nav-item" :class="{ active: $route.name === 'vocabulary' }">
        単語
      </router-link>
      <router-link to="/grammar" class="nav-item" :class="{ active: $route.name === 'grammar' }">
        文法
      </router-link>
      <router-link to="/settings" class="nav-item" :class="{ active: $route.name === 'settings' }">
        設定
      </router-link>
    </nav>
    <main class="main-content">
      <router-view />
    </main>
  </div>
</template>

<script setup>
</script>

<style scoped>
.top-nav {
  display: flex;
  gap: 4px;
  padding: 8px 16px;
  background: #1a1a2e;
  border-bottom: 1px solid #333;
}

.nav-item {
  padding: 8px 16px;
  color: #888;
  text-decoration: none;
  border-radius: 4px;
  font-size: 14px;
}

.nav-item:hover {
  color: #ccc;
  background: #2a2a4a;
}

.nav-item.active {
  color: #64b5f6;
  background: #2a2a4a;
}

.main-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 24px;
}
</style>
