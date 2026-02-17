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
  "partOfSpeech": "品詞（adjective / noun / verb / noun phrase / compound adjective / phrase / sentence pattern）",
  "domain": "技術分野（言語仕様 / 実行環境 / API / 一般 など）",
  "meaning": "日本語での意味",
  "example": "実際の使用例（英文）",
  "exampleJa": "用例の和訳",
  "structure": "文型（SVC / SVO / 従属節 + SVO など）",
  "grammar": "構文パターン名（受動態 / 分詞構文 / 関係代名詞 など）",
  "source": "出典（簡潔に）",
  "category": "official-docs",
  "session": セッション番号,
  "createdAt": "YYYY-MM-DD"
}
```

## 長文読解データ蓄積（必須）

解説後、長文読解ページ用のデータを `docs/references/readings.json` にも蓄積すること。

手順:
1. `docs/references/readings.json` を読み込む
2. 対象テキストのタイトル（出典名）で重複チェック。既存なら paragraphs に段落を追記
3. 新規の場合は `readings` 配列に新しいエントリを追加
4. 段落ごとに英文・日本語訳・注釈（annotations）を生成
5. JSON を書き戻す

各 reading エントリの形式:
```json
{
  "id": "<kebab-case-title>",
  "title": "教材タイトル",
  "source": "出典（簡潔に）",
  "category": "official-docs / github / claude-llm / technical-docs",
  "level": "A2-B1",
  "createdAt": "YYYY-MM-DD",
  "paragraphs": [
    {
      "en": "英文（原文のまま）",
      "ja": "日本語訳",
      "annotations": [
        {
          "text": "注釈対象テキスト（英文中の語句）",
          "type": "vocabulary / grammar / idiom",
          "color": "blue / orange / green",
          "note": "日本語の解説"
        }
      ]
    }
  ]
}
```

注釈タイプの使い分け:
- `vocabulary`（blue）: 重要単語 - 覚えるべき語彙
- `grammar`（orange）: 文法ポイント - 時制、受動態、関係代名詞など構文に関する注目点
- `idiom`（green）: 熟語・定型表現 - such as, in order to などのフレーズ
