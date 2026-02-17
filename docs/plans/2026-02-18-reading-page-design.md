# 長文読解ページ設計

## 概要
左右対比で英語原文と日本語訳を並べ、文法・語彙・熟語に色付けと注釈を付けた長文読解ページを追加する。

## アプローチ
JSONデータファイル（readings.json）+ Vueコンポーネント。`/explain` の実行時にデータを蓄積する。

## データ構造（`docs/references/readings.json`）

```json
{
  "readings": [
    {
      "id": "string",
      "title": "教材タイトル",
      "source": "出典URL",
      "category": "official-docs | github | claude-llm | technical-docs",
      "level": "A2-B1",
      "createdAt": "YYYY-MM-DD",
      "paragraphs": [
        {
          "en": "英文",
          "ja": "和訳",
          "annotations": [
            {
              "text": "注釈対象テキスト（英文中の語句）",
              "type": "vocabulary | grammar | idiom",
              "color": "blue | orange | green",
              "note": "日本語の解説"
            }
          ]
        }
      ]
    }
  ]
}
```

## 注釈タイプと色分け

| type | 色 | 表示スタイル | 用途 |
|------|-----|------------|------|
| vocabulary | 青 | 下線 | 重要単語 |
| grammar | オレンジ | 背景色 | 文法ポイント |
| idiom | 緑 | 下線+太字 | 熟語・定型表現 |

## UI レイアウト
- 教材選択ドロップダウン（複数教材対応）
- 段落ごとに左右対比（左: 英語、右: 日本語）
- 注釈付きテキストをクリック/ホバーで解説表示
- 凡例（色の意味）を上部に表示

## 変更ファイル
1. `docs/references/readings.json` - 新規：読解データ
2. `app/src/components/ReadingPage.vue` - 新規：読解ページ
3. `app/src/components/Sidebar.vue` - ナビ項目追加
4. `app/src/App.vue` - import とルーティング追加
5. `.claude/commands/explain.md` - readings.json 蓄積ステップ追加

## サイドバー並び順
- 語彙一覧
- 長文読解（新規）
- 英文法ガイド
- 文法解説（技術英語）
- 品詞解説
