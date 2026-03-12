# 一般英語 基本動詞（2,000〜3,000語レベル）

## 概要

IT技術文書には、IT固有の専門用語だけでなく、**一般英語の中級レベルの動詞**が大量に使われています。これらは日常会話ではあまり使わないものの、公式ドキュメントやAPIリファレンスでは当たり前のように登場する動詞です。

たとえば、MDNのドキュメントには "This method **determines** the type of the value" や "You must **ensure** that the callback is invoked" のような文が頻出しますが、これらの動詞（determine, ensure）を知らなければ、文全体の意味を正確に掴むことができません。

IT専門語彙（`vocabulary-it-basic.md`）がツールや操作の名前を覚えるものだとすれば、本ページで扱う一般動詞は**文の骨格を理解するための語彙**です。この20語を習得することで、技術文書の「何を」「どうする」「なぜ」が格段に読み取りやすくなります。

---

## 1. 基本動詞（Core Actions）

技術文書の中で、**指示・条件・要件を伝える**ために使われる基本動詞です。APIリファレンスでは「何を渡すべきか」「何が返るか」「何に注意すべきか」を説明する際に、これらの動詞が繰り返し登場します。一般英語では堅い文体で使われる単語ですが、IT文書では日常的に出現します。

---

### specify（動詞）

**意味:** 指定する、明示的に定める

> You can specify the port number by setting the `PORT` environment variable.
>
> `PORT` 環境変数を設定することで、ポート番号を指定できます。

**関連語:** specification（名詞: 仕様・仕様書）、specified（形容詞: 指定された）、specifier（名詞: 指定子）

---

### ensure（動詞）

**意味:** 確実にする、〜であることを保証する

> Ensure that the database connection is closed after the query completes.
>
> クエリの完了後にデータベース接続が閉じられることを確実にしてください。

**関連語:** ensured（形容詞: 保証された）。make sure とほぼ同義だが、技術文書では ensure が好まれる。

---

### determine（動詞）

**意味:** 決定する、判定する、〜を特定する

> The runtime determines which module system to use based on the file extension.
>
> ランタイムはファイル拡張子に基づいて、どのモジュールシステムを使用するかを決定します。

**関連語:** determination（名詞: 決定・判定）、predetermined（形容詞: あらかじめ決定された）

---

### indicate（動詞）

**意味:** 示す、表す、〜を意味する

> A status code of 200 indicates that the request was successful.
>
> ステータスコード200は、リクエストが成功したことを示します。

**関連語:** indication（名詞: 指標・兆候）、indicator（名詞: インジケータ・指標）

---

### obtain（動詞）

**意味:** 取得する、入手する

> You can obtain an API key by registering on the developer portal.
>
> 開発者ポータルで登録することで、APIキーを取得できます。

**関連語:** obtainable（形容詞: 取得可能な）。get よりフォーマルな表現で、技術文書では頻繁に使われる。

---

### require（動詞）

**意味:** 必要とする、要求する

> This method requires a non-null argument of type string.
>
> このメソッドは、null でない string 型の引数を必要とします。

**関連語:** requirement（名詞: 要件）、required（形容詞: 必須の）、optional（形容詞: 任意の ― required の対義語として頻出）

---

### provide（動詞）

**意味:** 提供する、与える

> React provides a set of built-in Hooks for managing state and side effects.
>
> Reactは、状態と副作用を管理するための組み込みHookのセットを提供します。

**関連語:** provider（名詞: プロバイダー）、provided（接続詞的用法: 〜という条件で）

---

### consider（動詞）

**意味:** 考慮する、検討する、〜とみなす

> Consider using `useMemo` to avoid unnecessary re-computations on every render.
>
> レンダリングのたびに不要な再計算を避けるために、`useMemo` の使用を検討してください。

**関連語:** consideration（名詞: 考慮・検討事項）、considerable（形容詞: かなりの）

---

### assume（動詞）

**意味:** 仮定する、前提とする、〜と想定する

> This guide assumes that you have Node.js version 18 or later installed.
>
> このガイドは、Node.js バージョン18以降がインストールされていることを前提としています。

**関連語:** assumption（名詞: 仮定・前提）、assumed（形容詞: 仮定された）

---

### maintain（動詞）

**意味:** 維持する、保守する、管理し続ける

> The framework maintains a virtual DOM to efficiently update the actual DOM.
>
> フレームワークは、実際のDOMを効率的に更新するために仮想DOMを維持します。

**関連語:** maintenance（名詞: 保守・メンテナンス）、maintainer（名詞: メンテナー）、maintainable（形容詞: 保守しやすい）

---

## 2. プロセス動詞（Processes & Results）

技術文書の中で、**関係性・構成・成果を説明する**ために使われる動詞です。ドキュメントが「Aは何であるか」「AはBにどう関係するか」「AはBから成り立つ」といった構造的な説明をする際に、これらの動詞が欠かせません。概念やアーキテクチャの説明文で特に多く登場します。

---

### correspond（動詞）

**意味:** 対応する、一致する

> Each route segment corresponds to a directory in the file system.
>
> 各ルートセグメントは、ファイルシステム内のディレクトリに対応します。

**関連語:** correspondence（名詞: 対応関係）、corresponding（形容詞: 対応する・それに相当する）

---

### represent（動詞）

**意味:** 表す、表現する、〜を意味する

> Each node in the AST represents a construct in the source code.
>
> AST内の各ノードは、ソースコード内の構文要素を表します。

**関連語:** representation（名詞: 表現・表記）、representative（形容詞/名詞: 代表的な/代表者）

---

### consist（動詞）

**意味:** 〜から成る、〜で構成される（consist of の形で使う）

> A URL consists of several components, including the protocol, hostname, and path.
>
> URLは、プロトコル、ホスト名、パスなど複数のコンポーネントから成ります。

**関連語:** consistent（形容詞: 一貫した）、consistency（名詞: 一貫性）。consist of（〜から成る）と be consistent with（〜と一致する）は意味が異なるので注意。

---

### involve（動詞）

**意味:** 含む、伴う、関与する

> Server-side rendering involves generating HTML on the server for each request.
>
> サーバーサイドレンダリングは、各リクエストに対してサーバー上でHTMLを生成することを伴います。

**関連語:** involvement（名詞: 関与）、involved（形容詞: 関与した・複雑な）

---

### occur（動詞）

**意味:** 発生する、起こる

> A memory leak occurs when allocated memory is not released after it is no longer needed.
>
> メモリリークは、不要になった後に割り当てられたメモリが解放されない場合に発生します。

**関連語:** occurrence（名詞: 発生・出現）

---

### attempt（動詞/名詞）

**意味:** 試みる、〜しようとする / 試み

> The client attempts to reconnect automatically if the connection is lost.
>
> 接続が失われた場合、クライアントは自動的に再接続を試みます。

**関連語:** attempted（形容詞: 試みられた）。try とほぼ同義だが、attempt はよりフォーマルで、失敗の可能性を含意することが多い。

---

### achieve（動詞）

**意味:** 達成する、実現する

> You can achieve better performance by enabling caching at the CDN level.
>
> CDNレベルでキャッシュを有効にすることで、より良いパフォーマンスを達成できます。

**関連語:** achievement（名詞: 達成・成果）、achievable（形容詞: 達成可能な）

---

### contribute（動詞）

**意味:** 貢献する、寄与する、コントリビュートする

> Please read the CONTRIBUTING.md file before you contribute to this project.
>
> このプロジェクトにコントリビュートする前に、CONTRIBUTING.md ファイルをお読みください。

**関連語:** contribution（名詞: 貢献・コントリビューション）、contributor（名詞: コントリビューター・貢献者）

---

### define（動詞）

**意味:** 定義する、明確に規定する

> Define the component's props using the TypeScript interface.
>
> TypeScriptインターフェースを使用して、コンポーネントのpropsを定義してください。

**関連語:** definition（名詞: 定義）、defined（形容詞: 定義された）、undefined（形容詞: 未定義の）、well-defined（形容詞: 明確に定義された）

---

### establish（動詞）

**意味:** 確立する、設定する、接続を確立する

> The WebSocket protocol establishes a persistent connection between the client and the server.
>
> WebSocketプロトコルは、クライアントとサーバー間の永続的な接続を確立します。

**関連語:** establishment（名詞: 確立）、established（形容詞: 確立された）

---

## 学習のコツ

### 1. IT文書での動詞コロケーション（よく一緒に使われる組み合わせ）

一般動詞は、技術文書の中で特定の名詞と頻繁にセットで使われます。この組み合わせ（コロケーション）をまとめて覚えると、ドキュメントの読解速度が大幅に向上します。

| 動詞 | よくあるコロケーション | 例 |
|------|---------------------|-----|
| specify | specify a value / specify the format | "Specify the output format" |
| ensure | ensure compatibility / ensure that... | "Ensure that the path exists" |
| determine | determine the type / determine whether... | "Determine whether the input is valid" |
| require | require a parameter / require authentication | "This endpoint requires authentication" |
| provide | provide an API / provide a callback | "Provide a fallback value" |
| define | define a function / define the schema | "Define the route handler" |
| establish | establish a connection / establish a session | "Establish a database connection" |
| involve | involve a trade-off / involve multiple steps | "This approach involves a trade-off" |

### 2. 「堅い動詞」と「簡単な動詞」の対応を知る

技術文書で使われる一般動詞の多くは、より簡単な日常動詞に置き換え可能です。この対応を知っておくと、未知の動詞に出会ったときに推測しやすくなります。

| 技術文書でよく使う動詞 | 日常英語の同義語 | 日本語 |
|---------------------|----------------|--------|
| specify | say exactly, tell | 指定する |
| ensure | make sure | 確実にする |
| determine | find out, decide | 決定する |
| obtain | get | 取得する |
| require | need | 必要とする |
| provide | give | 提供する |
| indicate | show, mean | 示す |
| attempt | try | 試みる |
| occur | happen | 発生する |
| establish | set up, create | 確立する |

### 3. 受動態パターンに慣れる

一般動詞は技術文書で**受動態**として非常に多く使われます。能動態と受動態の両方を覚えておくと、読解がスムーズになります。

```
specify → is specified    「〜が指定される」
require → is required     「〜が必要とされる」
define  → is defined      「〜が定義される」
assume  → is assumed      「〜が仮定される」
obtain  → is obtained     「〜が取得される」
```

例: "If no value **is specified**, the default **is used**."（値が指定されていない場合、デフォルトが使用されます。）

### 4. 動詞 + that節の読み方

技術文書では、ensure / determine / indicate / assume などの動詞の後に **that節**（that + 主語 + 動詞）が続くパターンが非常に多く見られます。

```
Ensure that the server is running.
（サーバーが動作していることを確実にしてください。）

Determine whether the value is null.
（値がnullであるかどうかを判定してください。）

This indicates that the operation failed.
（これは操作が失敗したことを示しています。）

Assume that the input is always a string.
（入力は常にstringであると仮定してください。）
```

この「動詞 + that/whether + 文」のパターンを見抜けるようになると、長い文でも構造を素早く掴めるようになります。
