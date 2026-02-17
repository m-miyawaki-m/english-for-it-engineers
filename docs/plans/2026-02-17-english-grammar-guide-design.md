# 英文法ガイドページ設計

## 概要
サイドバーに「英文法ガイド」ページを追加し、一般的な英語の基礎文法を網羅的に解説する。

## アプローチ
既存の GrammarGuide.vue / PartsOfSpeechGuide.vue と同じパターンで、カテゴリ分けした単一ページとして実装。

## ページ構成

| セクション | 内容 |
|-----------|------|
| 時制（Tenses） | 現在形、過去形、現在完了、未来表現 |
| 受動態（Passive Voice） | be + 過去分詞 |
| 助動詞（Modal Verbs） | can, must, should, may, might |
| 関係代名詞（Relative Pronouns） | who, which, that |
| 不定詞・動名詞（Infinitives & Gerunds） | to do / doing の使い分け |
| 比較（Comparisons） | 比較級・最上級 |
| 冠詞（Articles） | a/an, the |
| 前置詞（Prepositions） | in, on, at, for, with 等 |
| 接続詞（Conjunctions） | and, but, because, if, when 等 |
| 仮定法（Subjunctive） | if + 過去形 |

## 各項目のデータ構造
```js
{
  name: string,        // 文法項目名
  description: string, // 説明
  formation: string,   // 文法の形
  example: string,     // 英語例文（HTML可）
  exampleJa: string,   // 日本語訳（HTML可）
  tip: string          // 学習のポイント
}
```

## 変更ファイル
1. `app/src/components/EnglishGrammarGuide.vue` - 新規作成
2. `app/src/components/Sidebar.vue` - ナビ項目追加
3. `app/src/App.vue` - import とルーティング追加

## サイドバー並び順
- 語彙一覧
- 英文法ガイド（新規）
- 文法解説 → 「文法解説（技術英語）」にラベル変更
- 品詞解説
