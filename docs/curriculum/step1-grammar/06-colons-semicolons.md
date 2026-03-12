# 14. コロンとセミコロンの読み方（Colons, Semicolons, and Other Punctuation）

## 概要

コロン（`:`）とセミコロン（`;`）は、日本語の文章ではほとんど使われないが、英語の技術文書では極めて頻出する句読点である。これらの読み方を知らないと、文の区切りや情報の構造を正しく捉えられない。

また、技術文書ではダッシュ（`—`）やパレンティカルカンマ（`... , ... , ...`）も補足情報の挿入に使われる。これらの句読点の役割を理解することで、公式リファレンスや README の読解力が大きく向上する。

---

## 基本ルール

### コロン（:）の役割

コロンは **「すなわち」「以下の通り」** という意味。前の文を後ろで具体的に説明する。

```
一般的な説明 : 具体的な内容
```

| 用法 | 意味 | 例 |
|---|---|---|
| 定義・説明 | 「すなわち」 | Default value: `null` |
| リスト導入 | 「以下の通り」 | The function accepts two parameters: name and age. |
| ラベル | 「注:」「例:」 | Note: This method is asynchronous. |

### セミコロン（;）の役割

セミコロンは **「そして」「しかし」** という意味。独立した2つの文をピリオドより緩く、カンマより強くつなぐ。

```
独立した文A ; 独立した文B
```

| 用法 | 意味 | 例 |
|---|---|---|
| 対比 | 「一方」「しかし」 | The first argument is required; the second is optional. |
| 並列 | 「そして」「また」 | The server handles routing; the client manages state. |
| 複雑なリスト項目の区切り | 項目内にカンマがある場合 | Supports: React, v18+; Vue, v3+; Angular, v15+. |

### コロンとセミコロンの違い（まとめ）

| 句読点 | 記号 | 前後の関係 | 読み方 |
|---|---|---|---|
| コロン | `:` | 前 = 一般、後 = 具体 | 「すなわち」「以下の通り」 |
| セミコロン | `;` | 前 = 文A、後 = 文B | 「そして」「しかし」（2文をつなぐ） |

---

## IT技術文書での頻出パターン

### パターン 1: コロンによるパラメータ・値の説明

API ドキュメントで最も多い使い方。パラメータ名の後にコロンを置いて説明する。

> The function accepts two parameters **:** name and age.
> （この関数は2つのパラメータを受け取る。**すなわち** name と age である）

### パターン 2: コロンによるラベル表記（Note: / Warning: / Example:）

注意書きや例示のラベルとして使われる。

> **Note:** This method is asynchronous.
> （**注:** このメソッドは非同期である）

### パターン 3: セミコロンによる対比

2つの対照的な事実を1文でつなげる。

> The first argument is required **;** the second is optional.
> （第1引数は必須である。**一方、**第2引数は任意である）

### パターン 4: セミコロンによる役割分担の説明

システムのアーキテクチャ説明で、コンポーネントの役割を対比的に述べる。

> The server handles routing **;** the client manages state.
> （サーバーがルーティングを担当し、**そして**クライアントが状態を管理する）

### パターン 5: コロンによるコード例の導入

「以下のように書く」「以下のコマンドを実行する」のパターン。

> To install the package, run the following command **:**
> （パッケージをインストールするには、以下のコマンドを実行してください **：** ）

---

## ダッシュ（—）とパレンティカルカンマとの比較

技術文書では、コロン・セミコロン以外にもダッシュ（em dash: `—`）やパレンティカルカンマ（挿入のカンマ）が補足情報を加えるのに使われる。

### ダッシュ（—）

カッコやコロンの代わりに使われ、補足説明や言い換えを挿入する。コロンよりカジュアルで強調的。

> The default behavior **—** which can be overridden **—** is to retry three times.
> （デフォルトの動作 **——** 上書き可能だが **——** は3回リトライすることである）

> Use the latest stable version **—** not the nightly build.
> （最新の安定版を使ってください **——** nightly ビルドではなく）

### パレンティカルカンマ（挿入のカンマ）

2つのカンマで挟んで補足情報を挿入する。関係代名詞の非制限用法と同じ役割。

> The `useState` hook **,** which is the most commonly used hook **,** returns a stateful value.
> （`useState` フック **——** 最もよく使われるフックだが **——** は状態を持つ値を返す）

### 比較まとめ

| 記号 | 用途 | ニュアンス | 例 |
|---|---|---|---|
| `:` コロン | 具体説明・リスト導入 | 正式・構造的 | Returns: a Promise |
| `;` セミコロン | 2文の接続 | 対比・並列 | A is X; B is Y |
| `—` ダッシュ | 補足・言い換え | 強調的・カジュアル | Use A — not B |
| `, ... ,` カンマ | 挿入句 | 控えめな補足 | A, which is B, does C |
| `( )` カッコ | 補足情報 | 最も控えめ | A (also known as B) |

---

## 実例（IT技術文書風の例文）

### 例文 1

> The function accepts two parameters: name and age.

**和訳:** この関数は2つのパラメータを受け取る。すなわち name と age である。

**コロンの役割:** 「two parameters」を具体的に説明している。

---

### 例文 2

> Note: This method is asynchronous.

**和訳:** 注：このメソッドは非同期である。

**コロンの役割:** ラベル（Note）の区切り。

---

### 例文 3

> The first argument is required; the second is optional.

**和訳:** 第1引数は必須である。一方、第2引数は任意である。

**セミコロンの役割:** 2つの独立した文を対比的につないでいる。

---

### 例文 4

> The server handles routing; the client manages state.

**和訳:** サーバーがルーティングを担当し、クライアントが状態を管理する。

**セミコロンの役割:** 2つの役割分担を並列的につないでいる。

---

### 例文 5

> Returns: a `Promise` that resolves to the response body.

**和訳:** 戻り値：レスポンスボディに解決される `Promise`。

**コロンの役割:** 「Returns」（戻り値）のラベルの後に具体的な値を説明。

---

### 例文 6

> This feature is experimental; it may change in future releases.

**和訳:** この機能は実験的である。今後のリリースで変更される可能性がある。

**セミコロンの役割:** 前の文に関連する補足的な情報を追加している。

---

### 例文 7

> The configuration file supports three formats: JSON, YAML, and TOML.

**和訳:** 設定ファイルは3つのフォーマットをサポートする。すなわち JSON、YAML、TOML である。

**コロンの役割:** 「three formats」を具体的にリストしている。

---

### 例文 8

> The library is framework-agnostic — it works with React, Vue, and Angular alike.

**和訳:** このライブラリはフレームワークに依存しない——React、Vue、Angular のいずれでも動作する。

**ダッシュの役割:** 前の文を言い換え・補足している。コロンに近い使い方。

---

## よくある誤読パターン

### 誤読 1: コロンの後をリストだと思い込む

> **誤読:** "Default: `null`" → 「デフォルト、null、…（他にもある？）」

> **正しい読み方:** 「デフォルト値は null である」

コロンの後がリストとは限らない。1つの値や1文の場合もある。

### 誤読 2: セミコロンをコロンと混同する

> **誤読:** "The first argument is required; the second is optional."
> → 「第1引数は必須：第2引数は任意」（前が後を説明している？）

> **正しい読み方:** 2つの独立した文。第1引数の話と第2引数の話は対等な関係。

セミコロンは「前 → 後」の説明関係ではなく、「前 = 後」の対等関係。

### 誤読 3: ラベルのコロンを文構造の一部と読む

> **誤読:** "Note: This method is asynchronous."
> → 「このメソッドが非同期であることに注意して：…（何を？）」

> **正しい読み方:** 「Note:」はラベル。本文は「This method is asynchronous.」

`Note:`, `Warning:`, `Tip:`, `Example:` はラベルであり、コロンの後が本文。

### 誤読 4: ダッシュで囲まれた補足を読み飛ばしてしまう

> **誤読:** "The default behavior — which can be overridden — is to retry three times."
> → 「デフォルトの動作は3回リトライ」（補足を完全に無視）

ダッシュやカンマで囲まれた補足には重要な情報（上書き可能かどうか等）が含まれることが多い。読み飛ばさないこと。

---

## 練習：次の英文を読んで意味を取ってみよう

### 問題 1

> The `fetch` API returns a `Promise`; you must handle both the success and error cases.

<details>
<summary>解答を見る</summary>

**和訳:** `fetch` API は `Promise` を返す。したがって、成功ケースとエラーケースの両方を処理しなければならない。

**構造:**
- 文1: The `fetch` API returns a `Promise`
- セミコロン: 2つの独立した文を接続（結果・帰結の関係）
- 文2: you must handle both the success and error cases

セミコロンの後の文は、前の文から導かれる結論を述べている。

</details>

---

### 問題 2

> The middleware accepts three arguments: the request object, the response object, and the next function.

<details>
<summary>解答を見る</summary>

**和訳:** このミドルウェアは3つの引数を受け取る。すなわち、リクエストオブジェクト、レスポンスオブジェクト、そして next 関数である。

**構造:**
- 主文: The middleware accepts three arguments
- コロン: 「three arguments」の具体的な内容を説明
- リスト: the request object, the response object, and the next function

コロンの後に「three」に対応する3つの項目がリストされている。

</details>

---

### 問題 3

> The API supports two authentication methods: API keys and OAuth tokens. API keys are simpler to implement; OAuth tokens provide finer-grained access control.

<details>
<summary>解答を見る</summary>

**和訳:** この API は2つの認証方式をサポートする。すなわち、APIキーと OAuthトークンである。APIキーは実装がより簡単である。一方、OAuthトークンはより細かいアクセス制御を提供する。

**構造:**
- 第1文: The API supports two authentication methods（主文）
- コロン: 「two authentication methods」の具体化 → API keys and OAuth tokens
- 第2文: API keys are simpler to implement
- セミコロン: 対比（API keys と OAuth tokens の比較）
- 第3文: OAuth tokens provide finer-grained access control

コロンで具体化し、セミコロンで対比するという、技術文書の典型的な構成。

</details>
