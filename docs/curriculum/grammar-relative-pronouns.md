# 関係代名詞（Relative Pronouns: which / that / who）

## 概要

関係代名詞は、IT技術文書において名詞に追加情報を付け加える最も基本的な仕組みです。特にAPIドキュメントでは、戻り値の説明やパラメータの補足で関係代名詞が多用されます。

**制限用法**（カンマなし）と**非制限用法**（カンマあり）の違いを理解できると、技術文書の意味を正確に読み取れるようになります。

---

## 基本ルール

### 制限用法（Restrictive / Defining）

カンマなしで、名詞を「限定」する。「どの〜か」を特定する役割。

```
The parameter that specifies the timeout is optional.
（タイムアウトを指定するパラメータは任意です）
```

that 以下が「どのパラメータか」を限定しています。

### 非制限用法（Non-restrictive / Non-defining）

カンマ付きで、名詞に「補足情報」を追加する。すでに特定されている名詞への説明。

```
The function returns a Promise, which resolves to a Response object.
（この関数はPromiseを返します。そしてそれはResponseオブジェクトに解決されます）
```

which 以下は Promise の補足説明であり、「どの Promise か」を限定しているわけではありません。

### which / that / who の使い分け

| 関係代名詞 | 用途 | 制限用法 | 非制限用法 |
|-----------|------|---------|-----------|
| **that** | モノ・コト | 使える | 使えない |
| **which** | モノ・コト | 使える（※） | 使える |
| **who** | 人 | 使える | 使える |

※ 制限用法では that が好まれるが、which も使われる（特にIT文書では混在する）。

---

## IT技術文書での頻出パターン

### パターン 1: 戻り値の補足説明（, which...）

APIドキュメントで最も多いパターンです。メソッドの戻り値に補足情報を付けます。

```
The function returns a Promise, which resolves to a Response object.
```

「〜を返す。それは〜に解決される」と読みます。

### パターン 2: パラメータやオプションの限定（that / which）

どのパラメータか、どのオプションかを特定するパターンです。

```
The parameter that specifies the timeout value is optional.
```

「タイムアウト値を指定するパラメータ」と、名詞を限定しています。

### パターン 3: エラーや例外の説明（, which...）

エラーの内容を補足するパターンです。

```
The method throws a TypeError, which indicates that the argument is invalid.
```

「TypeErrorをスローする。それは引数が無効であることを示す」と読みます。

### パターン 4: 要素・オブジェクトの特定（that / which）

DOM操作やデータ処理で、対象を特定するパターンです。

```
Returns the element which matches the selector.
```

「セレクタに一致する要素を返す」。which 以下が element を限定しています。

### パターン 5: 人物の説明（who）

コントリビューターやユーザーへの言及で使います。

```
Contributors who submit a pull request must sign the CLA.
```

「プルリクエストを提出するコントリビューターはCLAに署名しなければならない」。

---

## 実例（IT文書風の例文）

### 例文 1
> The function returns a Promise, which resolves to a Response object.

**和訳:** この関数はPromiseを返します。そのPromiseはResponseオブジェクトに解決されます。

**解説:** 非制限用法（カンマ + which）。Promise への補足説明。

---

### 例文 2
> The parameter that specifies the timeout value is optional.

**和訳:** タイムアウト値を指定するパラメータは任意です。

**解説:** 制限用法（that）。「どのパラメータか」を限定している。

---

### 例文 3
> Returns the element which matches the selector.

**和訳:** セレクタに一致する要素を返します。

**解説:** 制限用法（which）。カンマがないので限定。IT文書では制限用法でも which が使われることがある。

---

### 例文 4
> The hook returns a state variable and a setter function, which can be used to update the state.

**和訳:** このフックは状態変数とセッター関数を返します。セッター関数は状態を更新するために使えます。

**解説:** 非制限用法。which はカンマの直前の「setter function」を指す（場合によっては両方を指す）。

---

### 例文 5
> Errors that occur during the build process are logged to stderr.

**和訳:** ビルドプロセス中に発生するエラーはstderrに記録されます。

**解説:** 制限用法（that）。「ビルド中に発生する」エラーに限定している。

---

### 例文 6
> The API uses JWT tokens, which must be included in the Authorization header.

**和訳:** このAPIはJWTトークンを使用します。JWTトークンはAuthorizationヘッダーに含める必要があります。

**解説:** 非制限用法。JWTトークン全般に対する補足情報。

---

### 例文 7
> Users who have admin privileges can access the dashboard.

**和訳:** 管理者権限を持つユーザーはダッシュボードにアクセスできます。

**解説:** 制限用法（who）。「管理者権限を持つ」ユーザーに限定。

---

### 例文 8
> The middleware checks the request body, which should be a valid JSON string.

**和訳:** ミドルウェアはリクエストボディを検査します。リクエストボディは有効なJSON文字列である必要があります。

**解説:** 非制限用法。request body への補足情報を追加している。

---

## よくある誤読パターン

### 1. 非制限用法のカンマを見落とす

```
The method returns an object which contains the result.    （制限用法）
The method returns an object, which contains the result.   （非制限用法）
```

- **カンマなし:** 「結果を含むオブジェクト」を返す（他のオブジェクトもありうる中で、特定のものを指す）
- **カンマあり:** 「オブジェクトを返す。そしてそれは結果を含む」（返すオブジェクトは一つで、その補足）

技術文書では、カンマ一つで意味が変わるため注意が必要です。

### 2. which の先行詞を間違える

```
The function validates the input and returns an error, which is logged to the console.
```

which は「error」を指します（直前の名詞）。「input」や「function」を指しているのではありません。ただし文脈によっては文全体を指す場合もあるため、注意が必要です。

### 3. that の省略を見落とす

```
The value you pass to the function must be a string.
```

実はこれは以下の省略形です:

```
The value that you pass to the function must be a string.
```

that が省略されると、関係代名詞節が見えにくくなります。「名詞 + 主語 + 動詞」の並びが出てきたら、that の省略を疑いましょう。

---

## 練習: 次の英文を読んで意味を取ってみよう

### 問題 1

> The component accepts a `className` prop, which is applied to the root element.

<details>
<summary>解答を見る</summary>

**和訳:** このコンポーネントは `className` プロパティを受け取ります。それはルート要素に適用されます。

**ポイント:** 非制限用法（カンマ + which）。className プロパティの補足説明。
</details>

---

### 問題 2

> Files that exceed the maximum upload size are automatically rejected.

<details>
<summary>解答を見る</summary>

**和訳:** 最大アップロードサイズを超えるファイルは自動的に拒否されます。

**ポイント:** 制限用法（that）。「サイズを超える」ファイルに限定している。すべてのファイルではない。
</details>

---

### 問題 3

> The library exports a default function, which initializes the application with the provided options.

<details>
<summary>解答を見る</summary>

**和訳:** このライブラリはデフォルト関数をエクスポートします。その関数は、提供されたオプションでアプリケーションを初期化します。

**ポイント:** 非制限用法。エクスポートされる関数は一つであり、その動作を補足説明している。
</details>
