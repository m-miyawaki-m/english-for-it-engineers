# 倒置・強調構文

## 概要

IT技術文書では、特定の条件や効果を強調するために倒置構文や強調構文が使われることがあります。特にフォーマルな技術文書（RFC、設計文書、公式ドキュメント）で登場頻度が高く、通常の語順と異なるために読解で戸惑いやすい構文です。パターンを知っておくことで、文の意味を正確に捉えられるようになります。

## 基本ルール

### 倒置とは

通常の英語は「主語 + 動詞」の語順ですが、倒置では「動詞 + 主語」や「助動詞 + 主語 + 動詞」の語順になります。

**通常の語順:**
> This improves performance.

**倒置:**
> Not only **does** this **improve** performance, but it also reduces memory usage.

### 主な倒置・強調パターン

| パターン | 意味 | 語順 |
|---------|------|------|
| Not only A but also B | AだけでなくBも | Not only + 助動詞 + S + V |
| Only when ... | 〜のときだけ | Only when + 節, 助動詞 + S + V |
| Only after ... | 〜の後にだけ | Only after + 節, 助動詞 + S + V |
| Only by doing ... | 〜することでのみ | Only by + 動名詞, 助動詞 + S + V |
| Neither A nor B | AもBもない | Neither + 助動詞 + S + V, nor + 助動詞 + S + V（もしくは Neither A nor B + V） |
| It is A that B | BなのはAだ（強調） | It is + 強調部分 + that + 残り |
| Not until ... | 〜まで...しない | Not until + 節, 助動詞 + S + V |

## IT技術文書での頻出パターン

### パターン1: Not only ... but also ...（〜だけでなく...も）

機能やアップデートの複数のメリットを強調するときに使います。文頭に `Not only` が来ると、その節で倒置が起きます。

> **Not only does** this improve performance, **but** it **also** reduces memory usage.
>
> （これはパフォーマンスを向上させるだけでなく、メモリ使用量も削減します。）

**倒置の仕組み:** 通常は "This does not only improve..." ですが、`Not only` を文頭に出すと "Not only does this improve..." と助動詞 `does` が主語 `this` の前に来ます。

### パターン2: Only when / Only after / Only if ...（〜のときだけ）

条件を強調するときに使います。メイン節（後半）で倒置が起きます。

> **Only when** the connection is established **can** data be transmitted.
>
> （接続が確立されたときだけ、データを送信できます。）

**倒置の仕組み:** 通常は "Data can be transmitted only when the connection is established." ですが、`Only when` を文頭に出すと、メイン節で `can` が `data` の前に来ます。

### パターン3: It is ... that ...（強調構文）

文の特定の要素を強調するための構文です。「〜なのは...だ」という意味になります。

> **It is** the cache layer **that** causes the latency issue.
>
> （レイテンシの問題を引き起こしているのは、キャッシュレイヤーです。）

**仕組み:** 通常は "The cache layer causes the latency issue." ですが、`the cache layer` を強調するために `It is ... that` で挟んでいます。

### パターン4: Neither ... nor ...（どちらも〜ない）

2つのものがどちらも何かをしない（何かではない）ことを表します。

> **Neither** the client **nor** the server validates the input.
>
> （クライアントもサーバーも、入力をバリデーションしません。）

### パターン5: Not until ...（〜するまで...しない）

ある条件が満たされるまで何かが起きないことを強調します。

> **Not until** all tests pass **should** you merge the pull request.
>
> （すべてのテストが通るまで、プルリクエストをマージすべきではありません。）

## 実例

以下は実際のIT文書で見かける典型的な例文です。

**1. リリースノート（複数のメリットの強調）**

> Not only does this update fix the critical security vulnerability, but it also introduces a new caching mechanism.
>
> （このアップデートは重大なセキュリティ脆弱性を修正するだけでなく、新しいキャッシュ機構も導入します。）

**2. API ドキュメント（条件の強調）**

> Only after the `init()` method has been called can you safely use the SDK's features.
>
> （`init()` メソッドが呼ばれた後にのみ、SDKの機能を安全に使用できます。）

**3. トラブルシューティング（原因の特定）**

> It is the database connection pool, not the application logic, that is causing the timeout errors.
>
> （タイムアウトエラーを引き起こしているのは、アプリケーションロジックではなく、データベースの接続プールです。）

**4. セキュリティ文書（否定の強調）**

> Neither the access token nor the refresh token should be stored in local storage.
>
> （アクセストークンもリフレッシュトークンも、ローカルストレージに保存すべきではありません。）

**5. 設計文書（条件の強調）**

> Only by implementing proper error boundaries can we prevent a single component failure from crashing the entire application.
>
> （適切なエラーバウンダリを実装することでのみ、単一コンポーネントの障害がアプリケーション全体をクラッシュさせることを防げます。）

**6. ベストプラクティス文書**

> Not until the migration is fully tested in staging should it be applied to the production environment.
>
> （マイグレーションがステージングで完全にテストされるまで、本番環境に適用すべきではありません。）

**7. コードレビューコメント**

> It is this particular regex pattern that causes the catastrophic backtracking issue.
>
> （壊滅的なバックトラッキングの問題を引き起こしているのは、この特定の正規表現パターンです。）

**8. 技術ブログ**

> Not only is the new framework faster, but it also requires significantly less boilerplate code.
>
> （新しいフレームワークはより速いだけでなく、必要なボイラープレートコードもはるかに少なくなっています。）

## よくある誤読パターン

### 1. 倒置に気づかず語順を通常通りに読んでしまう

> Only when the lock is released can the next thread proceed.

倒置に気づかないと「Only when the lock is released... can the next thread... proceed?」のように疑問文と混同してしまうことがあります。`Only when` / `Only after` / `Not only` で文が始まったら、倒置が起きることを意識しましょう。

### 2. It is ... that の強調構文を形式主語と混同する

> **It is** the configuration file **that** controls this behavior.

これは強調構文であり、「この振る舞いを制御しているのは設定ファイルだ」という意味です。形式主語構文の「It is important that...」（〜は重要だ）とは異なります。

見分け方: `It is` と `that` の間にある部分を取り出して、`that` 以下と組み合わせて自然な文になるかを確認します。
- "The configuration file controls this behavior." は自然な文 → 強調構文
- "Important controls this behavior." は不自然 → 形式主語構文

### 3. Neither ... nor の動詞の数の一致を見誤る

> Neither the API response nor the error message **provides** enough information.

`Neither A nor B` の場合、動詞は B（= the error message、単数）に一致するのが一般的です。ただし技術文書では、複数扱いになっていることもあります。重要なのは「AもBもない」という否定の意味を捉えることです。

### 4. Not only の but also を見落とす

> Not only does the library support TypeScript, but it also provides comprehensive type definitions.

`Not only` で始まった文は、後半に `but (it) also` が来ることを予測しながら読みましょう。`but also` が省略されて `but it provides...` となることもあります。

## 練習：次の英文を読んで意味を取ってみよう

以下の英文を読み、日本語で意味を書いてみてください。

---

**問題1:**

> Not only does enabling strict mode catch common bugs at compile time, but it also enforces best practices across the entire codebase.

<details>
<summary>解答を見る</summary>

strictモードを有効にすると、コンパイル時に一般的なバグを検出するだけでなく、コードベース全体にベストプラクティスを適用します。

- Not only does ... but it also ... の倒置構文
- enabling strict mode が主語（動名詞句）
- catch と enforces の2つの動作が対比されている

</details>

---

**問題2:**

> It is not the framework itself but the way it is configured that determines the application's performance characteristics.

<details>
<summary>解答を見る</summary>

アプリケーションのパフォーマンス特性を決定するのは、フレームワーク自体ではなく、その設定方法です。

- It is ... that の強調構文
- not A but B（AではなくB）が It is と that の間に入っている
- 強調されているのは「not the framework itself but the way it is configured」

</details>

---

**問題3:**

> Only after verifying that the SSL certificate is valid and the hostname matches should the client proceed with the TLS handshake.

<details>
<summary>解答を見る</summary>

SSL証明書が有効でホスト名が一致することを確認した後にのみ、クライアントはTLSハンドシェイクを続行すべきです。

- Only after ... should ... の倒置構文
- verifying that 以下は同格の that 節（確認する内容）
- the SSL certificate is valid **and** the hostname matches の2つの条件
- should the client proceed: 助動詞 should が主語 the client の前に来ている（倒置）

</details>
