# 条件文（Conditionals: if / unless / provided that / when）

## 概要

条件文はAPIドキュメントの根幹をなす文法です。「もし〜なら」「〜でない限り」「〜の場合」という条件分岐は、技術文書のあらゆる場面で登場します。

特に、**if** と **when** の使い分け、**unless** の正確な理解は、仕様書やエラーハンドリングの説明を正しく読むために不可欠です。

---

## 基本ルール

### if（もし〜なら）

最も基本的な条件文。ある条件が成り立つときの動作を述べます。

```
If the request fails, an error is thrown.
```

### unless（〜でない限り）

「if not」と同じ意味。「〜しない限りは」と読みます。

```
Unless otherwise specified, the default timeout is 30 seconds.
```

### when（〜のとき）

if と似ているが、「起こることが前提」のニュアンス。IT文書では「〜する場合」として頻出。

```
When set to true, enables verbose logging.
```

### provided that / as long as（〜である限り）

より強い条件を示す。「〜であるという条件のもとで」。

```
Provided that the token is valid, the endpoint returns 200.
```

### if と when の違い

| 接続詞 | ニュアンス | IT文書での使われ方 |
|-------|----------|------------------|
| **if** | 起こるかどうか不確実 | エラー処理、オプション設定 |
| **when** | 起こることが想定内 | イベント処理、ライフサイクル |

```
If an error occurs, the function returns null.     （エラーが起きるかもしれない）
When the component mounts, the data is fetched.    （マウントは必ず起きる）
```

---

## IT技術文書での頻出パターン

### パターン 1: デフォルト値の説明（if... is not / if no...）

パラメータが省略された場合のデフォルト動作を述べるパターン。

```
If no value is provided, the default will be used.
```

「値が提供されなければ、デフォルトが使われる」。APIドキュメントで最頻出。

### パターン 2: エラー条件の説明（if... fails / if... is invalid）

エラーが起きる条件とその結果を述べるパターン。

```
If the request fails, an error is thrown.
```

「リクエストが失敗した場合、エラーがスローされる」。

### パターン 3: unless による例外・注意書き

「特に指定がない限り」「明示的に変更しない限り」という注意書き。

```
Unless otherwise specified, the default timeout is 30 seconds.
```

「特に指定がない限り」は IT文書の定型表現。

### パターン 4: when によるイベント・タイミングの説明

特定のタイミングでの動作を述べるパターン。

```
When set to true, enables verbose logging.
```

「trueに設定されたとき、冗長ロギングを有効にする」。設定オプションの説明で頻出。

### パターン 5: provided that / as long as による前提条件

より厳密な前提条件を述べるパターン。

```
Provided that the token is valid, the endpoint returns 200.
```

「トークンが有効であるという条件のもとで、エンドポイントは200を返す」。

---

## 実例（IT文書風の例文）

### 例文 1
> If the request fails, an error is thrown.

**和訳:** リクエストが失敗した場合、エラーがスローされます。

**解説:** 最も基本的な if 条件文。エラーハンドリングの説明。

---

### 例文 2
> Unless otherwise specified, the default timeout is 30 seconds.

**和訳:** 特に指定がない限り、デフォルトのタイムアウトは30秒です。

**解説:** 「Unless otherwise specified」はIT文書の定型表現。丸ごと覚えると便利。

---

### 例文 3
> Provided that the token is valid, the endpoint returns 200.

**和訳:** トークンが有効であれば、エンドポイントは200を返します。

**解説:** provided that は「〜という条件が満たされれば」。if より格式高い表現。

---

### 例文 4
> When set to true, enables verbose logging.

**和訳:** trueに設定すると、冗長ロギングが有効になります。

**解説:** When (it is) set to true の省略形。設定項目の説明で頻出。主語が省略されている点にも注意。

---

### 例文 5
> If the environment variable is not set, the application falls back to the default configuration.

**和訳:** 環境変数が設定されていない場合、アプリケーションはデフォルト設定にフォールバックします。

**解説:** if + 否定の受動態。「設定されていなければ」。

---

### 例文 6
> When the user clicks the button, the form data is submitted to the server.

**和訳:** ユーザーがボタンをクリックすると、フォームデータがサーバーに送信されます。

**解説:** when はここでは「〜したとき」。ユーザーがクリックすることは想定内の動作。

---

### 例文 7
> The middleware rejects the request unless the API key is included in the header.

**和訳:** APIキーがヘッダーに含まれていない限り、ミドルウェアはリクエストを拒否します。

**解説:** unless は「〜でない限り」。二重否定にならないよう注意。

---

### 例文 8
> If you pass an invalid argument, a TypeError is thrown with a descriptive message.

**和訳:** 無効な引数を渡した場合、説明的なメッセージを含むTypeErrorがスローされます。

**解説:** If + 能動態（主節）→ 受動態（結果）のパターン。

---

## よくある誤読パターン

### 1. unless を「もし〜なら」と訳してしまう

```
The server rejects the request unless the token is valid.
```

- 誤読: 「トークンが有効なら、サーバーはリクエストを拒否する」
- 正解: 「トークンが有効**でない限り**、サーバーはリクエストを拒否する」

unless = if not です。「〜でない限り」「〜しなければ」と読みましょう。

### 2. when の省略構文を見落とす

```
When set to true, enables verbose logging.
```

これは以下の省略形です:

```
When it is set to true, it enables verbose logging.
```

IT文書では主語と be 動詞が省略されることが多いです。特に設定項目の説明で頻出します:

- When **omitted**, defaults to null.（省略された場合、デフォルトはnull）
- When **called** without arguments, returns undefined.（引数なしで呼ばれた場合、undefinedを返す）

### 3. if 節の時制に惑わされる

```
If the file exists, the function reads its content.
```

英語では条件節に未来形（will）を使いません。「exists」は現在形ですが、未来の話をしている可能性があります。日本語では「ファイルが存在する**なら**」「ファイルが存在**すれば**」と訳します。

---

## 練習: 次の英文を読んで意味を取ってみよう

### 問題 1

> Unless explicitly enabled, server-side rendering is disabled by default.

<details>
<summary>解答を見る</summary>

**和訳:** 明示的に有効化しない限り、サーバーサイドレンダリングはデフォルトで無効です。

**ポイント:** unless は「〜しない限り」。explicitly enabled は「明示的に有効化された」の省略形（Unless it is explicitly enabled）。
</details>

---

### 問題 2

> If the response status code is not 200, the client retries the request up to three times.

<details>
<summary>解答を見る</summary>

**和訳:** レスポンスのステータスコードが200でない場合、クライアントはリクエストを最大3回リトライします。

**ポイント:** if + 否定（is not 200）。up to three times は「最大3回まで」。
</details>

---

### 問題 3

> When invoked without a callback, the function returns a Promise instead.

<details>
<summary>解答を見る</summary>

**和訳:** コールバックなしで呼び出された場合、この関数は代わりにPromiseを返します。

**ポイント:** When (it is) invoked の省略形。instead は「代わりに」。コールバック有無で動作が変わるAPIの説明。
</details>
