# 前置詞＋関係代名詞

## 概要

IT技術文書、特にフォーマルな文書（RFC、仕様書、公式リファレンス）では、「in which」「on which」「by which」のように前置詞が関係代名詞の前に置かれる構文がよく使われます。日常英語では "the server that the app runs on" のようにカジュアルに書くところを、技術文書では "the server on which the application runs" とフォーマルに書きます。このパターンを知っておくと、技術文書の読解力が大幅に向上します。

## 基本ルール

### 前置詞＋関係代名詞の構造

「名詞 + 前置詞 + which + 動詞...」の形で、前の名詞を修飾する関係代名詞節を作ります。

**カジュアル（日常英語）:**
> The server **that** the application runs **on**...

**フォーマル（技術文書）:**
> The server **on which** the application runs...

### よく使われる前置詞＋which の組み合わせ

| 前置詞 + which | 元の形 | 意味 |
|---------------|--------|------|
| in which | ... in it | 〜の中で |
| on which | ... on it | 〜の上で |
| to which | ... to it | 〜に対して |
| from which | ... from it | 〜から |
| by which | ... by it | 〜によって |
| with which | ... with it | 〜とともに |
| for which | ... for it | 〜のために |
| through which | ... through it | 〜を通じて |
| at which | ... at it | 〜において |
| upon which | ... upon it | 〜に基づいて（フォーマル） |

### 前置詞の選び方

前置詞は、関係代名詞節の中の動詞やフレーズとの組み合わせで決まります。

- run **on** a server → the server **on which** it runs
- store data **in** a format → the format **in which** data is stored
- authenticate **by** a method → the method **by which** authentication is handled
- call a function **from** a context → the context **from which** the function is called

## IT技術文書での頻出パターン

### パターン1: on which（〜の上で動作する）

サーバー、プラットフォーム、OS など、何かが「上で」動作する環境を説明するときに使います。

> The server **on which** the application runs must have at least 8GB RAM.
>
> （アプリケーションが動作するサーバーには、少なくとも8GBのRAMが必要です。）

### パターン2: in which（〜の中で / 〜の形式で）

データの格納形式、状態、環境など、「中で」「形式で」を表すときに使います。

> The format **in which** the data is stored depends on the configuration.
>
> （データが保存される形式は、設定に依存します。）

### パターン3: by which（〜によって）

方法、手段、メカニズムを説明するときに使います。

> The method **by which** authentication is handled has changed in the latest version.
>
> （認証が処理される方法は、最新バージョンで変更されました。）

### パターン4: from which（〜から）

呼び出し元、データの取得元など、「出所」を説明するときに使います。

> The context **from which** the function is called affects its behavior.
>
> （関数が呼び出されるコンテキストが、その振る舞いに影響します。）

### パターン5: to which（〜に対して）

データの送信先、適用先など、「向かう先」を説明するときに使います。

> The endpoint **to which** the request is sent must support HTTPS.
>
> （リクエストが送信されるエンドポイントは、HTTPSをサポートしている必要があります。）

## 実例

以下は実際のIT文書で見かける典型的な例文です。

**1. インフラ要件（on which）**

> The server on which the application runs must have at least 8GB of RAM and a multi-core processor.
>
> （アプリケーションが動作するサーバーには、少なくとも8GBのRAMとマルチコアプロセッサが必要です。）

**2. データ形式の説明（in which）**

> The format in which the data is stored depends on the serialization library being used.
>
> （データが保存される形式は、使用されているシリアライゼーションライブラリに依存します。）

**3. 認証メカニズム（by which）**

> The mechanism by which tokens are validated has been updated to support JWT.
>
> （トークンが検証されるメカニズムは、JWTをサポートするよう更新されました。）

**4. 実行コンテキスト（from which）**

> The environment from which the script is executed determines the available permissions.
>
> （スクリプトが実行される環境が、利用可能な権限を決定します。）

**5. API エンドポイント（to which）**

> The URL to which the webhook payload is delivered must be publicly accessible.
>
> （webhookペイロードが配信されるURLは、公開アクセス可能でなければなりません。）

**6. 通信経路（through which）**

> The channel through which the microservices communicate uses gRPC by default.
>
> （マイクロサービスが通信するチャネルは、デフォルトでgRPCを使用します。）

**7. 設定ファイル（with which）**

> The configuration file with which the application is initialized can be overridden by environment variables.
>
> （アプリケーションが初期化される設定ファイルは、環境変数で上書きできます。）

**8. 理由・目的（for which）**

> The reason for which this feature was deprecated is explained in the migration guide.
>
> （この機能が非推奨になった理由は、マイグレーションガイドで説明されています。）

## よくある誤読パターン

### 1. 前置詞の意味を取り違える

> The format **in** which the data is stored...

`in which` の `in` は「〜の形式で」「〜の中に」という意味です。前置詞の意味を正確に捉えるには、元のフレーズ（store data **in** a format）を復元して考えましょう。

### 2. which の先行詞を見誤る

> The database on which the service relies was migrated to a new cluster.

`which` が何を指しているか（先行詞）を正確に特定する必要があります。ここでは `which` = `the database` です。`the service` ではありません。「サービスが依存しているデータベース」が正しい読みです。

### 3. 長い修飾句で文の骨格を見失う

> The server on which the application that handles payment processing runs must have high availability.

この文は修飾が入れ子になっています。

- 骨格: **The server** ... **must have** high availability.（サーバーは高可用性が必要だ）
- 修飾1: on which ... runs（〜が動作する）
- 修飾2: that handles payment processing（決済処理を行う）

「決済処理を行うアプリケーションが動作するサーバーは、高可用性が必要です。」

### 4. upon which を見慣れない

> The framework upon which the entire system is built has reached end of life.

`upon which` は `on which` のよりフォーマルな表現です。「システム全体がその上に構築されているフレームワーク」という意味です。RFC や仕様書で見かけることがあります。

### 5. カジュアル形との対応を忘れる

技術文書で `in which` に出会ったとき、カジュアルな言い換えを頭の中で作ると理解しやすくなります。

- **フォーマル:** The format in which data is stored...
- **カジュアル:** The format data is stored in...
- **さらにカジュアル:** The format that data is stored in...

どれも同じ意味です。

## 練習：次の英文を読んで意味を取ってみよう

以下の英文を読み、日本語で意味を書いてみてください。

---

**問題1:**

> The order in which middleware functions are registered determines the order in which they are executed.

<details>
<summary>解答を見る</summary>

ミドルウェア関数が登録される順序が、それらが実行される順序を決定します。

- `in which` が2回使われている
- 1つ目: the order in which middleware functions are registered（登録される順序）
- 2つ目: the order in which they are executed（実行される順序）
- 文の骨格: The order ... determines the order ...

</details>

---

**問題2:**

> The interface through which external systems communicate with our API has been redesigned to support both REST and GraphQL.

<details>
<summary>解答を見る</summary>

外部システムが我々のAPIと通信するインターフェースが、RESTとGraphQLの両方をサポートするよう再設計されました。

- through which: 「〜を通じて」（communicate through an interface）
- 文の骨格: The interface ... has been redesigned ...
- to support ... は目的（〜をサポートするために）

</details>

---

**問題3:**

> The extent to which this change affects existing integrations depends on whether the deprecated fields are currently being used.

<details>
<summary>解答を見る</summary>

この変更が既存のインテグレーションに影響を与える度合いは、非推奨のフィールドが現在使用されているかどうかに依存します。

- to which: the extent to which（〜する度合い/程度）
- depends on whether ...: 「〜かどうかに依存する」
- are currently being used: 現在進行形の受動態（現在使われている）

</details>
