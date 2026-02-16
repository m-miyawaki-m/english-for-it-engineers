<script setup>
const sections = [
  {
    title: '基本品詞',
    items: [
      {
        name: 'adjective（形容詞）',
        description: '名詞を修飾して性質や状態を表す。技術文書では技術の特徴を簡潔に伝えるのに不可欠。',
        examples: ['lightweight', 'interpreted', 'dynamic', 'asynchronous', 'immutable'],
        tip: '技術英語では名詞の前に形容詞が複数連なることが多い。例: "a lightweight interpreted programming language"'
      },
      {
        name: 'noun（名詞）',
        description: '人・物・概念を表す。技術文書では専門用語のほとんどが名詞。',
        examples: ['function', 'variable', 'parameter', 'scope', 'prototype'],
        tip: '技術名詞はそのまま動詞的に使われることも多い。例: "to scope a variable"'
      },
      {
        name: 'verb（動詞）',
        description: '動作や状態を表す。技術文書では操作の説明で頻出。',
        examples: ['return', 'define', 'invoke', 'implement', 'inherit'],
        tip: '命令形（"Use const when..."）は手順説明の基本パターン。'
      },
      {
        name: 'adverb（副詞）',
        description: '動詞・形容詞・文全体を修飾する。程度や頻度を表す。',
        examples: ['also', 'most', 'dynamically', 'implicitly', 'explicitly'],
        tip: '技術文書では "implicitly"（暗黙的に）と "explicitly"（明示的に）の対比が頻出。'
      }
    ]
  },
  {
    title: '複合表現',
    items: [
      {
        name: 'compound adjective（複合形容詞）',
        description: '2語以上をハイフンでつないで1つの形容詞にしたもの。技術英語の最大の特徴。',
        examples: ['well-known', 'just-in-time', 'garbage-collected', 'prototype-based', 'event-driven'],
        tip: '見慣れない長い単語もハイフンで区切れば意味が取れる。"garbage-collected" = "ゴミ（不要メモリ）を回収する"'
      },
      {
        name: 'noun phrase（名詞句）',
        description: '名詞を中心に修飾語を含む2語以上のまとまり。技術概念を1つの単位で表す。',
        examples: ['first-class functions', 'non-browser environments', 'error handling', 'data structure', 'execution context'],
        tip: '技術文書の語彙の大半は名詞句。まとまりで意味を捉えるのが読解のコツ。'
      },
      {
        name: 'phrase（句）',
        description: '定型的な表現のまとまり。文法的な機能を持つ慣用表現。',
        examples: ['such as', 'in order to', 'as well as', 'in contrast to', 'referred to as'],
        tip: '句は丸ごと覚えるのが効率的。"such as" = 「例えば」のように1対1で対応づける。'
      },
      {
        name: 'sentence pattern（文パターン）',
        description: '文全体の定型構造。技術文書には繰り返し現れる文の型がある。',
        examples: ['X is a ... with ...', 'While ..., ... also ...', 'If ..., then ...', 'Note that ...'],
        tip: '文パターンを認識できると、長い文でも構造が瞬時に把握できる。'
      }
    ]
  }
]
</script>

<template>
  <div>
    <h1>品詞解説</h1>
    <p class="intro">語彙カードの緑タグ（品詞）に対応しています。技術英語で特に重要な品詞と複合表現を解説します。</p>

    <div v-for="section in sections" :key="section.title" class="section">
      <h2>{{ section.title }}</h2>
      <div v-for="item in section.items" :key="item.name" class="pos-card">
        <h3>{{ item.name }}</h3>
        <p class="description">{{ item.description }}</p>
        <div class="examples">
          <span v-for="ex in item.examples" :key="ex" class="example-tag">{{ ex }}</span>
        </div>
        <p class="tip"><span class="tip-label">ポイント:</span> {{ item.tip }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
h1 {
  font-size: 1.5rem;
  margin-bottom: 8px;
  color: #1a1a1a;
}

.intro {
  color: #777;
  font-size: 0.9rem;
  margin-bottom: 28px;
}

h2 {
  font-size: 1.15rem;
  color: #333;
  margin-bottom: 16px;
  padding-bottom: 6px;
  border-bottom: 2px solid #e0e0e0;
}

.section {
  margin-bottom: 32px;
}

.pos-card {
  background: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  padding: 16px;
  margin-bottom: 12px;
}

h3 {
  font-size: 1rem;
  color: #2e7d32;
  margin-bottom: 6px;
}

.description {
  color: #444;
  margin-bottom: 10px;
  line-height: 1.6;
}

.examples {
  display: flex;
  flex-wrap: wrap;
  gap: 6px;
  margin-bottom: 10px;
}

.example-tag {
  font-size: 0.8rem;
  padding: 3px 10px;
  border-radius: 12px;
  background: #e8f5e9;
  color: #2e7d32;
  font-weight: 500;
}

.tip {
  font-size: 0.85rem;
  color: #666;
  background: #fafafa;
  padding: 8px 12px;
  border-radius: 6px;
}

.tip-label {
  font-weight: 600;
  color: #555;
}
</style>
