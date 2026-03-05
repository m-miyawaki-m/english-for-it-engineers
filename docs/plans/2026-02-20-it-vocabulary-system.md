# IT用語収集システム 実装プラン

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** english-for-it-engineers プロジェクトをコピーし、IT用語の収集・検索・参照ができる独立した用語集アプリを作成する。

**Architecture:** 既存の Vue 3 + Vite アプリをベースに、英語学習固有の要素（文法ガイド、品詞ガイド、サイドバー、セッション管理等）を削除し、IT用語辞書に特化したスキーマとUIに再構成する。データは `data/vocabulary.json` の単一JSON。

**Tech Stack:** Vue 3, Vite 7, GitHub Pages

---

### Task 1: プロジェクトディレクトリ作成と Git 初期化

**Files:**
- Create: `~/dev/it-vocabulary/`

**Step 1: ディレクトリ作成と Git 初期化**

```bash
mkdir -p ~/dev/it-vocabulary
cd ~/dev/it-vocabulary
git init
```

**Step 2: コミット**

```bash
# (初期コミットは Task 2 以降でまとめて行う)
```

---

### Task 2: app ディレクトリのコピーと不要ファイル削除

**Files:**
- Copy: `english-for-it-engineers/app/` → `it-vocabulary/app/`
- Delete: `app/src/components/Sidebar.vue`
- Delete: `app/src/components/GrammarGuide.vue`
- Delete: `app/src/components/PartsOfSpeechGuide.vue`

**Step 1: app ディレクトリをコピー（node_modules と dist 除外）**

```bash
rsync -av --exclude='node_modules' --exclude='dist' \
  ~/dev/english-for-it-engineers/app/ ~/dev/it-vocabulary/app/
```

**Step 2: 不要コンポーネントを削除**

```bash
rm ~/dev/it-vocabulary/app/src/components/Sidebar.vue
rm ~/dev/it-vocabulary/app/src/components/GrammarGuide.vue
rm ~/dev/it-vocabulary/app/src/components/PartsOfSpeechGuide.vue
```

**Step 3: npm install で動作確認**

```bash
cd ~/dev/it-vocabulary/app && npm install
```

---

### Task 3: vocabulary.json の新スキーマ作成

**Files:**
- Create: `~/dev/it-vocabulary/data/vocabulary.json`

**Step 1: data ディレクトリと vocabulary.json を作成**

```json
{
  "terms": [
    {
      "id": "api-1",
      "term": "API",
      "type": "abbreviation",
      "meaning": "Application Programming Interface の略。ソフトウェア間の通信インターフェース",
      "example": "The REST **API** returns JSON responses for each endpoint.",
      "category": "general",
      "domain": "Web開発",
      "source": "MDN Web Docs",
      "tags": ["REST", "HTTP"],
      "createdAt": "2026-02-20"
    },
    {
      "id": "repository-1",
      "term": "repository",
      "type": "term",
      "meaning": "リポジトリ。ソースコードやファイルのバージョン管理を行う保管場所",
      "example": "Clone the **repository** and install the dependencies.",
      "category": "general",
      "domain": "Git",
      "source": "GitHub Docs",
      "tags": ["Git", "VCS"],
      "createdAt": "2026-02-20"
    },
    {
      "id": "middleware-1",
      "term": "middleware",
      "type": "concept",
      "meaning": "ミドルウェア。リクエストとレスポンスの間で処理を行うソフトウェア層",
      "example": "Add authentication **middleware** to protect the route.",
      "category": "backend",
      "domain": "Web開発",
      "source": "Express.js Docs",
      "tags": ["Express", "HTTP"],
      "createdAt": "2026-02-20"
    }
  ]
}
```

---

### Task 4: vite.config.js の修正

**Files:**
- Modify: `~/dev/it-vocabulary/app/vite.config.js`

**Step 1: base パスと @data エイリアスを変更**

```javascript
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'

export default defineConfig({
  base: '/it-vocabulary/',
  plugins: [vue()],
  resolve: {
    alias: {
      '@data': resolve(__dirname, '../data')
    }
  }
})
```

変更点:
- `base`: `/english-for-it-engineers/` → `/it-vocabulary/`
- `@data`: `../docs/references` → `../data`

---

### Task 5: index.html の修正

**Files:**
- Modify: `~/dev/it-vocabulary/app/index.html`

**Step 1: タイトルを変更**

```html
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" type="image/svg+xml" href="/vite.svg" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>IT Vocabulary</title>
  </head>
  <body>
    <div id="app"></div>
    <script type="module" src="/src/main.js"></script>
  </body>
</html>
```

変更点:
- `lang="en"` → `lang="ja"`
- `<title>app</title>` → `<title>IT Vocabulary</title>`

---

### Task 6: App.vue の修正

**Files:**
- Modify: `~/dev/it-vocabulary/app/src/App.vue`

**Step 1: サイドバーとガイドページを削除、1ページ構成に変更**

```vue
<script setup>
import { ref } from 'vue'
import SearchFilter from './components/SearchFilter.vue'
import VocabularyList from './components/VocabularyList.vue'
import data from '@data/vocabulary.json'

const searchQuery = ref('')
const selectedCategory = ref('all')
const selectedType = ref('all')
</script>

<template>
  <div class="app">
    <header class="app-header">
      <h1>IT Vocabulary</h1>
    </header>
    <main class="main-content">
      <SearchFilter
        v-model:searchQuery="searchQuery"
        v-model:selectedCategory="selectedCategory"
        v-model:selectedType="selectedType"
      />
      <VocabularyList
        :items="data.terms"
        :searchQuery="searchQuery"
        :selectedCategory="selectedCategory"
        :selectedType="selectedType"
      />
    </main>
  </div>
</template>

<style scoped>
.app-header {
  padding: 24px 16px;
  max-width: 720px;
  margin: 0 auto;
}

.app-header h1 {
  font-size: 1.5rem;
  color: #1a1a1a;
}

.main-content {
  max-width: 720px;
  margin: 0 auto;
  padding: 0 16px 32px;
}
</style>
```

変更点:
- Sidebar, GrammarGuide, PartsOfSpeechGuide の import 削除
- `currentPage` の状態管理を削除
- `allItems` の computed を削除（`data.terms` を直接渡す）
- サイドバー分の `margin-left: 200px` を削除、中央寄せレイアウトに変更

---

### Task 7: SearchFilter.vue の修正

**Files:**
- Modify: `~/dev/it-vocabulary/app/src/components/SearchFilter.vue`

**Step 1: カテゴリとタイプの選択肢をIT用語向けに変更**

```vue
<script setup>
defineProps({
  searchQuery: { type: String, default: '' },
  selectedCategory: { type: String, default: 'all' },
  selectedType: { type: String, default: 'all' }
})

const emit = defineEmits(['update:searchQuery', 'update:selectedCategory', 'update:selectedType'])

const categories = [
  { value: 'all', label: 'すべて' },
  { value: 'general', label: '全般' },
  { value: 'frontend', label: 'フロントエンド' },
  { value: 'backend', label: 'バックエンド' },
  { value: 'infra', label: 'インフラ' },
  { value: 'security', label: 'セキュリティ' },
  { value: 'data', label: 'データ' }
]

const types = [
  { value: 'all', label: 'すべて' },
  { value: 'term', label: '用語' },
  { value: 'abbreviation', label: '略語' },
  { value: 'concept', label: '概念' }
]
</script>

<template>
  <div class="filter-bar">
    <input
      type="text"
      class="search-input"
      placeholder="用語を検索..."
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
```

変更点:
- `categories`: 英語学習カテゴリ → IT分野カテゴリ
- `types`: `word`/`pattern` → `term`/`abbreviation`/`concept`
- placeholder: `検索...` → `用語を検索...`

---

### Task 8: VocabularyList.vue の修正

**Files:**
- Modify: `~/dev/it-vocabulary/app/src/components/VocabularyList.vue`

**Step 1: 統計表示を用語種別ごとに変更**

```vue
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

const termCount = computed(() => filteredItems.value.filter(i => i.type === 'term').length)
const abbreviationCount = computed(() => filteredItems.value.filter(i => i.type === 'abbreviation').length)
const conceptCount = computed(() => filteredItems.value.filter(i => i.type === 'concept').length)
</script>

<template>
  <div>
    <div class="list">
      <VocabularyCard v-for="item in filteredItems" :key="item.id" :item="item" />
      <p v-if="filteredItems.length === 0" class="empty">該当する用語がありません</p>
    </div>
    <div class="stats">
      用語: {{ termCount }}件 / 略語: {{ abbreviationCount }}件 / 概念: {{ conceptCount }}件
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
```

変更点:
- `wordCount` / `patternCount` → `termCount` / `abbreviationCount` / `conceptCount`
- 空メッセージ: `該当する語彙がありません` → `該当する用語がありません`
- 統計表示: 3種類の用語タイプ別カウント

---

### Task 9: VocabularyCard.vue の修正

**Files:**
- Modify: `~/dev/it-vocabulary/app/src/components/VocabularyCard.vue`

**Step 1: 英語学習固有の要素を削除し、タグ表示を追加**

```vue
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

const renderedExample = computed(() =>
  props.item.example ? renderBold(props.item.example) : ''
)
</script>

<template>
  <div class="card">
    <div class="card-header">
      <span class="term">{{ item.term }}</span>
      <div class="badges">
        <span class="badge" :class="item.type">{{ item.type }}</span>
        <span v-if="item.domain" class="badge domain">{{ item.domain }}</span>
      </div>
    </div>
    <p class="meaning">{{ item.meaning }}</p>
    <p v-if="renderedExample" class="example" v-html="renderedExample"></p>
    <div v-if="item.tags && item.tags.length" class="tags">
      <span v-for="tag in item.tags" :key="tag" class="tag">{{ tag }}</span>
    </div>
    <div class="card-footer">
      <span v-if="item.source" class="source">{{ item.source }}</span>
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

.badge.term {
  background: #e3f2fd;
  color: #1565c0;
}

.badge.abbreviation {
  background: #f3e5f5;
  color: #7b1fa2;
}

.badge.concept {
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

.tags {
  display: flex;
  flex-wrap: wrap;
  gap: 4px;
  margin-top: 6px;
}

.tag {
  font-size: 0.7rem;
  padding: 2px 8px;
  border-radius: 4px;
  background: #f0f0f0;
  color: #555;
}

.card-footer {
  font-size: 0.8rem;
  color: #999;
  margin-top: 8px;
}
</style>
```

変更点:
- `partOfSpeech` バッジ削除
- `exampleJa` 表示削除
- `grammar-info`（structure, grammar）表示削除
- `session` 表示削除
- `tags` 表示を追加
- バッジの CSS クラス: `word`/`pattern` → `term`/`abbreviation`/`concept`

---

### Task 10: CLAUDE.md の作成

**Files:**
- Create: `~/dev/it-vocabulary/CLAUDE.md`

**Step 1: 新プロジェクト用の CLAUDE.md を作成**

```markdown
# Project: it-vocabulary

## Overview
IT用語収集・参照システム。技術ドキュメントで出会った用語を蓄積し、検索・参照できるツール。

## Directory Structure
- `app/` - 用語ビューア（Vue 3 + Vite）
- `data/` - 用語データ（vocabulary.json）
- `docs/plans/` - 設計書

## Tech Stack
- Vue 3 + Vite
- GitHub Pages デプロイ
- JSON ベースのデータ管理

## Workflow
1. Read existing docs before making changes
2. Use Conventional Commits format
3. ドキュメントは日本語で記述
```

---

### Task 11: GitHub Actions デプロイ設定のコピーと修正

**Files:**
- Create: `~/dev/it-vocabulary/.github/workflows/deploy.yml`

**Step 1: デプロイ設定を作成**

```yaml
name: Deploy to GitHub Pages

on:
  push:
    branches: [main]

permissions:
  contents: read
  pages: write
  id-token: write

concurrency:
  group: pages
  cancel-in-progress: true

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4

      - uses: actions/setup-node@v4
        with:
          node-version: 20

      - name: Install dependencies
        working-directory: app
        run: npm ci

      - name: Build
        working-directory: app
        run: npm run build

      - uses: actions/upload-pages-artifact@v3
        with:
          path: app/dist

  deploy:
    needs: build
    runs-on: ubuntu-latest
    environment:
      name: github-pages
      url: ${{ steps.deployment.outputs.page_url }}
    steps:
      - id: deployment
        uses: actions/deploy-pages@v4
```

---

### Task 12: 動作確認と初回コミット

**Step 1: dev サーバーで動作確認**

```bash
cd ~/dev/it-vocabulary/app && npm run dev
```

ブラウザで確認: 3件のサンプル用語が表示され、検索・フィルタが動作すること。

**Step 2: 初回コミット**

```bash
cd ~/dev/it-vocabulary
git add -A
git commit -m "feat: init IT vocabulary system based on english-for-it-engineers"
```
