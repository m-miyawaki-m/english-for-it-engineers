# NGSL多義語対応 設計書

## 背景

ngsl-top1000.json は単語名のみで意味情報がない。多くの単語は複数の意味を持ち、特にIT文脈では日常と異なる意味で使われる。チェックリストで「知っている」と判断するには、意味が表示されている必要がある。

## 変更内容

### 1. ngsl-top1000.json に meanings フィールド追加

```json
{
  "rank": 50,
  "word": "run",
  "frequency": 3500.0,
  "meanings": {
    "general": "走る、経営する",
    "it": "実行する（run a script / run tests）"
  },
  "known": null
}
```

- 全1000語に `meanings: { general, it }` を追加
- IT固有の意味がない単語は `"it": null`
- Claudeで一括生成

### 2. NgslChecklist.vue をリスト表示に変更

**現状**: グリッド表示（`minmax(180px, 1fr)`）で単語名のみ

**変更後**: 1行1単語のリスト形式

各行の構成:
```
☐ #50  run    走る、経営する    [IT] 実行する（run tests）
```

- チェックボックス / ランク / 単語 / 一般意味 / IT意味
- IT意味ありの単語は `[IT]` バッジで視覚的に区別
- IT意味なしの単語は IT 欄を非表示
- フィルタに「IT意味あり」オプション追加

### レイアウト

```
☐  #rank  word      general意味         [IT] it意味
─────────────────────────────────────────────────────
☐  #8     have      持つ、食べる         ─
☐  #50    run       走る、経営する       [IT] 実行する
☐  #51    set       置く、定める         [IT] 設定する / Set型
```

## 実装ステップ

1. ngsl-top1000.json に meanings を一括追加（Claudeで生成）
2. NgslChecklist.vue のテンプレートをリスト形式に変更
3. スタイルをリスト表示用に調整
4. 「IT意味あり」フィルタを追加
5. 動作確認
