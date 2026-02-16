# MDN JavaScript ドキュメント 英語読解プラン

## 概要

MDN の JavaScript ドキュメントを教材に、公式リファレンス英語の読解力を A2 → B1 に引き上げる。

- **教材**: https://developer.mozilla.org/en-US/docs/Web/JavaScript
- **1回の分量**: 3〜5文（100〜200語）
- **ペース**: 自由（1日1セッションでも、まとめてでもOK）

## 学習の進め方

1. 各セッションの「対象テキスト」を MDN から開いて該当箇所を見つける
2. `/explain` に英文を貼って解説を受ける
3. 語彙・表現は `docs/references/official-docs-patterns.md` に自動蓄積される
4. 区切りごとに `/exercise` で復習問題を解く

---

## Unit 1: JavaScript トップページ（導入）

最もベーシックな技術説明文。「〜とは何か」を説明するパターンを学ぶ。

### Session 1: JavaScript とは何か

**URL**: https://developer.mozilla.org/en-US/docs/Web/JavaScript

**対象テキスト**（冒頭段落）:
> JavaScript (JS) is a lightweight interpreted (or just-in-time compiled) programming language with first-class functions. While it is most well-known as the scripting language for Web pages, many non-browser environments also use it, such as Node.js, Apache CouchDB and Adobe Acrobat.

**学習ポイント**:
- 技術用語の定義パターン（"X is a ... language with ..."）
- 対比表現（"While it is ... , ... also ..."）
- 列挙表現（"such as A, B and C"）

### Session 2: JavaScript の特徴

**URL**: 同上

**対象テキスト**（冒頭段落の続き）:
> JavaScript is a prototype-based, garbage-collected, dynamic language, supporting multiple paradigms such as imperative, functional, and object-oriented.

**学習ポイント**:
- 複合形容詞（prototype-based, garbage-collected）
- 分詞構文（supporting ...）
- 技術パラダイムの英語名

### Session 3: JavaScript の標準規格

**URL**: 同上

**対象テキスト**（Standards セクション）:
> The ECMAScript standard is documented in the ECMA-262 specification. JavaScript's syntax and semantics are standardized by this specification, which is updated annually.

**学習ポイント**:
- 受動態（"is documented", "are standardized"）
- 関係代名詞 which の非制限用法

### ✅ Unit 1 復習

`/exercise official-docs-javascript-introduction` で復習問題を解く

---

## Unit 2: JavaScript Guide - Introduction

ガイドの導入部。技術文書の「前置き」でよく使われる表現を学ぶ。

### Session 4: ガイドの概要

**URL**: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Introduction

**対象テキスト**: ページ冒頭の概要段落（"This chapter introduces JavaScript and discusses..." あたり）

**学習ポイント**:
- ガイド文書の導入パターン（"This chapter introduces..."）
- 前提条件の表現（"You should have..."）

### Session 5: JavaScript と Java の違い

**URL**: 同上（"JavaScript and Java" セクション）

**対象テキスト**: JavaScript と Java の比較説明（3〜5文）

**学習ポイント**:
- 比較・対比の表現（"unlike", "in contrast to", "similar to"）
- 技術的な違いを述べるパターン

### ✅ Unit 2 復習

`/exercise official-docs-guide-introduction` で復習問題を解く

---

## Unit 3: Grammar and Types（文法と型）

実際の言語仕様の説明。やや専門的になるが、最も頻繁に読むタイプの文書。

### Session 6: 基本構文とコメント

**URL**: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Grammar_and_types

**対象テキスト**: "Basics" セクション冒頭（構文の説明、3〜5文）

**学習ポイント**:
- 手順・仕様の説明パターン（"JavaScript borrows...", "...is case-sensitive"）
- 技術文書での注意書き表現（"Note:"）

### Session 7: 変数宣言（let, const, var）

**URL**: 同上（"Declarations" セクション）

**対象テキスト**: let / const / var の説明（各1〜2文、計5文程度）

**学習ポイント**:
- 定義と制約の表現（"declares a ...", "cannot be ...", "is limited to ..."）
- 命令形の使用（"Use const when..."）

### Session 8: データ型

**URL**: 同上（"Data structures and types" セクション）

**対象テキスト**: 7つのプリミティブ型の列挙と説明（冒頭3〜5文）

**学習ポイント**:
- 列挙と分類の表現（"The latest ECMAScript standard defines..."）
- 型の説明パターン（"A ... that can be ..."）

### ✅ Unit 3 復習

`/exercise official-docs-grammar-and-types` で復習問題を解く

---

## Unit 4: Control Flow（制御フロー）

条件分岐やエラー処理の説明文。「〜の場合は」という条件表現を集中的に学ぶ。

### Session 9: if...else 文

**URL**: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Control_flow_and_error_handling

**対象テキスト**: if...else セクション冒頭の説明（3〜5文）

**学習ポイント**:
- 条件の表現（"If ... , then ...", "otherwise"）
- コード例を説明する英語（"In this example, ..."）

### Session 10: try...catch 文

**URL**: 同上（"Exception handling statements" セクション）

**対象テキスト**: try...catch の説明（3〜5文）

**学習ポイント**:
- エラー処理の英語表現（"throws an exception", "catches the error"）
- 手順説明（"First, ... Then, ... Finally, ..."）

### ✅ Unit 4 復習

`/exercise official-docs-control-flow` で復習問題を解く

---

## Unit 5: Functions（関数）

関数の説明文。技術文書で最も頻出する「定義→使い方→注意点」パターンを学ぶ。

### Session 11: 関数の定義

**URL**: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Functions

**対象テキスト**: "Defining functions" セクション冒頭（3〜5文）

**学習ポイント**:
- 定義パターン（"A function definition consists of..."）
- 構成要素の列挙（"the name of the function", "a list of parameters"）

### Session 12: スコープとクロージャ

**URL**: 同上（"Closures" セクション）

**対象テキスト**: クロージャの説明冒頭（3〜5文）

**学習ポイント**:
- 抽象概念の説明パターン（"A closure is..."）
- 技術文書での「つまり」表現（"In other words,", "That is,"）

### ✅ Unit 5 復習

`/exercise official-docs-functions` で復習問題を解く

---

## Unit 6 以降の予定

Unit 5 まで完了したら、進捗と語彙の蓄積状況を見て次の Unit を計画する。
候補:

- **Unit 6**: Numbers and Strings
- **Unit 7**: Working with Objects
- **Unit 8**: Using Classes
- **Unit 9**: Promises（非同期）
- **Unit 10**: Modules

---

## 進捗トラッキング

| Session | 対象 | 状態 |
|---------|------|------|
| 1 | JavaScript とは何か | ⬜ |
| 2 | JavaScript の特徴 | ⬜ |
| 3 | JavaScript の標準規格 | ⬜ |
| 4 | ガイドの概要 | ⬜ |
| 5 | JavaScript と Java の違い | ⬜ |
| 6 | 基本構文とコメント | ⬜ |
| 7 | 変数宣言 | ⬜ |
| 8 | データ型 | ⬜ |
| 9 | if...else 文 | ⬜ |
| 10 | try...catch 文 | ⬜ |
| 11 | 関数の定義 | ⬜ |
| 12 | スコープとクロージャ | ⬜ |
