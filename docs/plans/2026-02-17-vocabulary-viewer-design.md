# 語彙ビューア設計書

## 背景

`/explain` で学んだ語彙・表現パターンが Markdown ファイルに蓄積されるが、一覧性が低く見づらい。JSON 形式で構造化し、Vue 3 アプリで見やすく表示する。

## 要件

- 語彙・表現パターンを JSON で管理
- Vue 3 + Vite で語彙カード一覧を表示
- テキスト検索、カテゴリ・種別フィルタ
- ローカル実行のみ（デプロイなし）
- `/explain` コマンドは JSON に追記する形に変更

## データ構造

### `docs/references/vocabulary.json`

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
    }
  ]
}
```

フィールド:
- `id`: `<termのケバブケース>-<連番>` で自動生成
- `type`: `"word"` | `"pattern"`
- `category`: `"official-docs"` | `"github"` | `"claude-llm"` | `"technical-docs"`
- `session`: 学習セッション番号
- `createdAt`: 追加日（YYYY-MM-DD）

## アプリ構成

```
app/
├── index.html
├── package.json
├── vite.config.js
├── src/
│   ├── App.vue
│   ├── main.js
│   ├── components/
│   │   ├── VocabularyList.vue
│   │   ├── VocabularyCard.vue
│   │   └── SearchFilter.vue
│   └── assets/
│       └── style.css
```

## 画面構成

1画面のみ: 語彙一覧

- 上部: 検索バー + カテゴリフィルタ + 種別フィルタ
- メイン: 語彙カードの一覧
- 下部: 件数表示（語彙 N件 / パターン N件）

### カード表示内容
- term（単語・表現）
- type バッジ（word / pattern）
- meaning（日本語の意味）
- example（用例、英文）
- source + session 番号

## `/explain` コマンドの変更

- 蓄積先を `docs/references/vocabulary.json` に変更
- 既存の Markdown リファレンスは JSON 移行後に削除
- 重複チェック: `term` が既存なら追加しない

## CLAUDE.md の変更

- Directory Structure に `app/` を追加
- プロジェクト方針に「Vue 3 + Vite による語彙ビューア」を追記
- .gitignore に `app/node_modules/`, `app/dist/` を追加
