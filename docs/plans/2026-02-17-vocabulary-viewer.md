# 語彙ビューア実装計画

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** JSON 形式の語彙データを Vue 3 アプリで見やすく表示する語彙ビューアを構築する

**Architecture:** 既存の Markdown 語彙データを JSON に移行し、Vue 3 + Vite の SPA で読み込んで表示。`/explain` コマンドは JSON に追記する形に変更。

**Tech Stack:** Vue 3, Vite, CSS（ライブラリなし）

---

### Task 1: 既存データを JSON に移行

**Files:**
- Create: `docs/references/vocabulary.json`
- Delete: `docs/references/official-docs-patterns.md`

**Step 1: vocabulary.json を作成**

既存の Markdown データを JSON 形式に変換:

```json
{
  "vocabulary": [
    {
      "id": "lightweight-1",
      "term": "lightweight",
      "type": "word",
      "meaning": "軽量な（少ないリソースで動作する）",
      "example": "JavaScript (JS) is a **lightweight** interpreted programming language.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    },
    {
      "id": "interpreted-1",
      "term": "interpreted",
      "type": "word",
      "meaning": "インタプリタ型の（コードを1行ずつ実行する方式）",
      "example": "JavaScript is a lightweight **interpreted** (or just-in-time compiled) programming language.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    },
    {
      "id": "just-in-time-compiled-1",
      "term": "just-in-time compiled",
      "type": "word",
      "meaning": "JITコンパイルされる（実行時にコンパイルする方式）",
      "example": "JavaScript is a lightweight interpreted (or **just-in-time compiled**) programming language.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    },
    {
      "id": "first-class-functions-1",
      "term": "first-class functions",
      "type": "word",
      "meaning": "第一級関数（関数を変数に代入したり引数に渡したりできること）",
      "example": "...a programming language with **first-class functions**.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    },
    {
      "id": "well-known-1",
      "term": "well-known",
      "type": "word",
      "meaning": "よく知られた",
      "example": "It is most **well-known** as the scripting language for Web pages.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    },
    {
      "id": "non-browser-environments-1",
      "term": "non-browser environments",
      "type": "word",
      "meaning": "ブラウザ以外の環境（\"non-\" は否定の接頭辞）",
      "example": "Many **non-browser environments** also use it.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    }
  ],
  "patterns": [
    {
      "id": "x-is-a-with-1",
      "term": "X is a ... with ...",
      "type": "pattern",
      "meaning": "「Xは〜を備えた...である」技術の定義パターン",
      "example": "JavaScript is a lightweight interpreted programming language **with** first-class functions.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    },
    {
      "id": "while-also-1",
      "term": "While ..., ... also ...",
      "type": "pattern",
      "meaning": "「〜として知られているが、〜でもある」対比表現",
      "example": "**While** it is most well-known as the scripting language, many non-browser environments **also** use it.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    },
    {
      "id": "such-as-a-b-and-c-1",
      "term": "such as A, B and C",
      "type": "pattern",
      "meaning": "「例えばA、B、Cなど」具体例の列挙",
      "example": "...many non-browser environments also use it, **such as** Node.js, Apache CouchDB **and** Adobe Acrobat.",
      "source": "MDN JavaScript トップページ",
      "category": "official-docs",
      "session": 1,
      "createdAt": "2026-02-17"
    }
  ]
}
```

**Step 2: Markdown リファレンスを削除**

```bash
rm docs/references/official-docs-patterns.md
```

**Step 3: コミット**

```bash
git add docs/references/vocabulary.json
git rm docs/references/official-docs-patterns.md
git commit -m "refactor: migrate vocabulary data from Markdown to JSON"
```

---

### Task 2: Vue 3 + Vite プロジェクトをスキャフォールド

**Files:**
- Create: `app/package.json`
- Create: `app/vite.config.js`
- Create: `app/index.html`
- Create: `app/src/main.js`
- Create: `app/src/App.vue`

**Step 1: app ディレクトリで Vite + Vue プロジェクトを作成**

```bash
cd app && npm create vite@latest . -- --template vue
```

※ 既にディレクトリがある場合は `--template vue` で初期化。不要なデフォルトファイル（HelloWorld.vue 等）は削除する。

**Step 2: 依存パッケージをインストール**

```bash
cd app && npm install
```

**Step 3: デフォルトの不要ファイルを削除**

```bash
rm app/src/components/HelloWorld.vue
rm app/src/assets/vue.svg
rm app/public/vite.svg
```

**Step 4: vite.config.js を設定**

vocabulary.json を読み込めるようにする:

```js
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'

export default defineConfig({
  plugins: [vue()],
  resolve: {
    alias: {
      '@data': resolve(__dirname, '../docs/references')
    }
  }
})
```

**Step 5: 動作確認**

```bash
cd app && npm run dev
```

ブラウザで http://localhost:5173 が表示されることを確認。

**Step 6: コミット**

```bash
git add app/
git commit -m "feat: scaffold Vue 3 + Vite app"
```

---

### Task 3: VocabularyCard コンポーネントを作成

**Files:**
- Create: `app/src/components/VocabularyCard.vue`

**Step 1: VocabularyCard.vue を作成**

```vue
<script setup>
defineProps({
  item: {
    type: Object,
    required: true
  }
})
</script>

<template>
  <div class="card">
    <div class="card-header">
      <span class="term">{{ item.term }}</span>
      <span class="badge" :class="item.type">{{ item.type }}</span>
    </div>
    <p class="meaning">{{ item.meaning }}</p>
    <p class="example">{{ item.example }}</p>
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

.card-footer {
  display: flex;
  justify-content: space-between;
  font-size: 0.8rem;
  color: #999;
  margin-top: 8px;
}
</style>
```

**Step 2: コミット**

```bash
git add app/src/components/VocabularyCard.vue
git commit -m "feat: add VocabularyCard component"
```

---

### Task 4: SearchFilter コンポーネントを作成

**Files:**
- Create: `app/src/components/SearchFilter.vue`

**Step 1: SearchFilter.vue を作成**

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
```

**Step 2: コミット**

```bash
git add app/src/components/SearchFilter.vue
git commit -m "feat: add SearchFilter component"
```

---

### Task 5: VocabularyList コンポーネントを作成

**Files:**
- Create: `app/src/components/VocabularyList.vue`

**Step 1: VocabularyList.vue を作成**

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
      item.term.toLowerCase().includes(props.searchQuery.toLowerCase()) ||
      item.meaning.includes(props.searchQuery) ||
      item.example.toLowerCase().includes(props.searchQuery.toLowerCase())

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
```

**Step 2: コミット**

```bash
git add app/src/components/VocabularyList.vue
git commit -m "feat: add VocabularyList component with filtering"
```

---

### Task 6: App.vue を組み立てて完成

**Files:**
- Modify: `app/src/App.vue`
- Modify: `app/src/assets/style.css`（または削除して App.vue にスタイルを含める）

**Step 1: style.css をグローバルスタイルに書き換え**

```css
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
  background: #f5f5f5;
  color: #333;
}
```

**Step 2: App.vue を書き換え**

```vue
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
```

**Step 3: main.js にグローバル CSS を import**

```js
import { createApp } from 'vue'
import App from './App.vue'
import './assets/style.css'

createApp(App).mount('#app')
```

**Step 4: 動作確認**

```bash
cd app && npm run dev
```

ブラウザで http://localhost:5173 を開き:
- 9件のカード（語彙6 + パターン3）が表示される
- 検索窓に「light」と入力すると「lightweight」だけに絞られる
- カテゴリを「公式ドキュメント」に変更しても全件表示される（全て official-docs なので）
- 種別を「表現パターン」に変更すると3件に絞られる

**Step 5: コミット**

```bash
git add app/src/
git commit -m "feat: assemble App.vue with search and filter"
```

---

### Task 7: /explain コマンドを JSON 蓄積に変更

**Files:**
- Modify: `.claude/commands/explain.md`

**Step 1: explain.md を書き換え**

蓄積先を Markdown から JSON に変更:

````markdown
以下の英語の技術文章を解説してください。

対象テキスト: $ARGUMENTS

解説の観点:
1. **構文解析** - 文の構造（主語・動詞・目的語）を明示
2. **語彙** - ITエンジニアとして覚えるべき単語・熟語をピックアップし、意味と用例を説明
3. **表現パターン** - 技術文書で頻出する定型表現を特定し、他の使用場面も紹介
4. **全体の要約** - 文章全体が何を言っているかを日本語で簡潔にまとめる

学習者レベル: CEFR A2〜B1（基礎的な英文法は理解しているが、技術英語の語彙・表現に慣れていない）

## リファレンス蓄積（必須）

解説後、学んだ語彙・表現を `docs/references/vocabulary.json` に蓄積すること。

手順:
1. `docs/references/vocabulary.json` を読み込む
2. 対象テキストのカテゴリを判定（official-docs / github / claude-llm / technical-docs）
3. 新しい語彙を `vocabulary` 配列に、表現パターンを `patterns` 配列に追加
4. 重複チェック: 既存の `term` と同じものはスキップ
5. id は `<termのケバブケース>-<連番>` で生成
6. JSON を書き戻す

各エントリの形式:
```json
{
  "id": "<kebab-case-term>-<number>",
  "term": "単語または表現",
  "type": "word または pattern",
  "meaning": "日本語での意味",
  "example": "実際の使用例（英文）",
  "source": "出典（簡潔に）",
  "category": "official-docs",
  "session": セッション番号,
  "createdAt": "YYYY-MM-DD"
}
```
````

**Step 2: コミット**

```bash
git add .claude/commands/explain.md
git commit -m "refactor: update /explain to accumulate vocabulary in JSON"
```

---

### Task 8: .gitignore と CLAUDE.md を更新

**Files:**
- Modify: `.gitignore`
- Modify: `CLAUDE.md`

**Step 1: .gitignore に app 関連を追加**

```
.DS_Store
*.log
.env
app/node_modules/
app/dist/
```

**Step 2: CLAUDE.md を更新**

プロジェクト方針に追記:
```
- Vue 3 + Vite による語彙ビューア（`app/`）
```

Directory Structure に追記:
```
- `app/` - 語彙ビューア（Vue 3 + Vite）
```

**Step 3: コミット**

```bash
git add .gitignore CLAUDE.md
git commit -m "docs: update gitignore and CLAUDE.md for vocabulary viewer app"
```
