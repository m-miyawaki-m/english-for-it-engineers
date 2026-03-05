# IT用語収集システム 設計書

## 概要
現在の english-for-it-engineers プロジェクトをベースに、IT系の単語収集用システムを新規作成する。
英語学習要素を取り除き、IT用語の辞書ツールとして再構成する。

## アプローチ
アプローチ A（最小変更コピー）を採用。既存の Vue 3 + Vite アプリをコピーし、不要部分を削除・調整する。

## プロジェクト構造

```
~/dev/it-vocabulary/
├── CLAUDE.md
├── .github/
│   └── workflows/
│       └── deploy.yml        # GitHub Pages デプロイ
├── app/
│   ├── index.html
│   ├── package.json
│   ├── vite.config.js
│   └── src/
│       ├── main.js
│       ├── App.vue           # 1ページ構成（サイドバー不要）
│       ├── assets/
│       │   └── style.css
│       └── components/
│           ├── VocabularyList.vue
│           ├── VocabularyCard.vue
│           └── SearchFilter.vue
└── data/
    └── vocabulary.json       # 用語データ
```

### 変更点（現プロジェクトとの差分）
- `docs/` → `data/`（学習プラン・カリキュラム不要）
- Sidebar.vue、GrammarGuide.vue、PartsOfSpeechGuide.vue を削除
- 1ページ構成のシンプルな用語ビューア

## データスキーマ

### vocabulary.json

```json
{
  "terms": [
    {
      "id": "api-1",
      "term": "API",
      "type": "abbreviation",
      "meaning": "Application Programming Interface の略。ソフトウェア間の通信インターフェース",
      "example": "The REST API returns JSON responses.",
      "category": "general",
      "domain": "Web開発",
      "source": "MDN Web Docs",
      "tags": ["REST", "HTTP"],
      "createdAt": "2026-02-20"
    }
  ]
}
```

### フィールド定義

| フィールド | 必須 | 型 | 説明 |
|-----------|------|------|------|
| `id` | Yes | string | ケバブケース + 連番（例: `api-1`） |
| `term` | Yes | string | 用語（英語） |
| `type` | Yes | string | `term` / `abbreviation` / `concept` |
| `meaning` | Yes | string | 日本語の説明 |
| `example` | No | string | 用例（英語） |
| `category` | Yes | string | `general` / `frontend` / `backend` / `infra` / `security` / `data` |
| `domain` | No | string | 技術ドメイン（自由テキスト） |
| `source` | No | string | 出典 |
| `tags` | No | string[] | タグ（文字列配列） |
| `createdAt` | Yes | string | 作成日（YYYY-MM-DD） |

### 現プロジェクトからの変更
- `vocabulary` + `patterns` の2配列 → `terms` の1配列に統合
- 削除フィールド: `partOfSpeech`, `grammar`, `structure`, `session`, `exampleJa`
- 追加フィールド: `tags`（柔軟な分類用）
- `type`: `word` / `pattern` → `term` / `abbreviation` / `concept`
- `category`: 英語学習カテゴリ → IT分野カテゴリ

## UI変更

- **Sidebar削除** → ヘッダーにプロジェクト名のみ表示
- **SearchFilter**: テキスト検索 + category ドロップダウン + type ドロップダウン
- **VocabularyCard**: term, type バッジ, domain バッジ, meaning, example, tags, source を表示
- **フッター**: 用語数の統計表示

## 技術スタック
- Vue 3 + Vite（現プロジェクトと同一）
- GitHub Pages デプロイ
- JSON ベースのデータ管理
