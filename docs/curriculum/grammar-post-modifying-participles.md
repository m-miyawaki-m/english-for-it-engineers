# 11. 分詞の後置修飾（Post-modifying Participles）

## 概要

IT技術文書では、名詞の**直後**に分詞（現在分詞 `-ing` / 過去分詞 `-ed`）を置いて名詞を修飾するパターンが極めて多い。これは関係代名詞節（`which is ...` / `that is ...`）を短縮した形で、公式リファレンスや API ドキュメントでは一文に複数回登場することもある。

このパターンを読めないと、主語がどこで終わるのか・動詞がどれなのかを見失い、文全体の意味を誤読してしまう。

---

## 基本ルール

### 現在分詞（-ing）の後置修飾

名詞 + 現在分詞句 = 「〜している名詞」（能動の意味）

> the component **rendering** the list
> → the component **which renders** the list（リストを描画するコンポーネント）

### 過去分詞（-ed / 不規則変化）の後置修飾

名詞 + 過去分詞句 = 「〜された名詞」（受動の意味）

> the value **returned** by the function
> → the value **which is returned** by the function（関数によって返された値）

### 見分け方のポイント

| 形 | 意味 | キーワード |
|---|---|---|
| 名詞 + -ing ... | 「〜している名詞」（能動） | doing, running, rendering |
| 名詞 + -ed / 不規則 ... | 「〜された名詞」（受動） | returned, defined, given, written |

---

## IT技術文書での頻出パターン

### パターン 1: 過去分詞 + by 〜（〜によって…された名詞）

API ドキュメントでメソッドの返り値や処理結果を説明する際に多用される。

> The value **returned by** the function is always a string.

### パターン 2: 過去分詞 + as 〜（〜として…された名詞）

非推奨マークやフラグの説明でよく見る。

> Methods **marked as** deprecated should not be used.

### パターン 3: 現在分詞 + 目的語（〜を…している名詞）

コンポーネントやモジュールの役割説明で頻出。

> The component **rendering** the list accepts an array prop.

### パターン 4: 過去分詞 + 前置詞句（場所・範囲の限定）

一覧やリストの範囲を限定する。

> The files **listed below** are required for deployment.

### パターン 5: 現在分詞 + 前置詞句（動作の状況説明）

エラーやイベントの発生条件を説明する。

> Any errors **occurring during** the build process are logged.

---

## 実例（IT技術文書風の例文）

### 例文 1

> The value **returned by** the function is always a string.

**和訳:** その関数**によって返される**値は常に文字列である。

**構造:** The value (returned by the function) ← 主語 / is ← 動詞 / a string ← 補語

---

### 例文 2

> Any errors **occurring during** the build process are logged.

**和訳:** ビルドプロセス**中に発生する**すべてのエラーはログに記録される。

**構造:** Any errors (occurring during the build process) ← 主語 / are logged ← 動詞

---

### 例文 3

> The files **listed below** are required for deployment.

**和訳:** **以下に記載された**ファイルはデプロイに必要である。

**構造:** The files (listed below) ← 主語 / are required ← 動詞

---

### 例文 4

> Methods **marked as** deprecated should not be used.

**和訳:** 非推奨**としてマークされた**メソッドは使用すべきでない。

**構造:** Methods (marked as deprecated) ← 主語 / should not be used ← 動詞

---

### 例文 5

> The component **rendering** the list accepts an array prop.

**和訳:** リスト**を描画する**コンポーネントは配列の prop を受け取る。

**構造:** The component (rendering the list) ← 主語 / accepts ← 動詞 / an array prop ← 目的語

---

### 例文 6

> Properties **defined in** the configuration file override the default values.

**和訳:** 設定ファイル**で定義された**プロパティはデフォルト値を上書きする。

**構造:** Properties (defined in the configuration file) ← 主語 / override ← 動詞

---

### 例文 7

> The middleware **handling** authentication runs before any route handler.

**和訳:** 認証**を処理する**ミドルウェアはすべてのルートハンドラの前に実行される。

**構造:** The middleware (handling authentication) ← 主語 / runs ← 動詞

---

### 例文 8

> Data **fetched from** the API is cached for 60 seconds.

**和訳:** API **から取得された**データは60秒間キャッシュされる。

**構造:** Data (fetched from the API) ← 主語 / is cached ← 動詞

---

## よくある誤読パターン

### 誤読 1: 分詞を文の動詞と間違える

> **誤読:** The value returned. By the function is always a string.
> （値が返った。関数によって、常に文字列だ）

> **正しい読み方:** The value (returned by the function) / is / always a string.
> （関数によって返された値は、常に文字列である）

`returned` は文の動詞ではなく `value` を修飾する分詞。文の動詞は `is`。

### 誤読 2: 主語の範囲を見誤る

> **誤読:** "Any errors occurring" が主語で "during the build process are logged" が続く？

> **正しい読み方:** 主語は "Any errors occurring during the build process" 全体。`are logged` が文の動詞。

分詞句は前の名詞にくっついて一つの大きな主語を形成する。動詞（be動詞や一般動詞）が出てくるまでが主語。

### 誤読 3: 現在分詞と動名詞の混同

> The component **rendering** the list accepts an array prop.

`rendering` は「描画すること」（動名詞）ではなく、「描画している」（現在分詞）として `component` を修飾している。直前に名詞があり、その後に目的語が続く場合は後置修飾の分詞。

### 誤読 4: 過去分詞と受動態の混同

> The files listed below **are** required for deployment.

`listed` は受動態の動詞ではなく `files` を修飾する分詞。文の動詞は `are required`。`are` の位置を見つけることが重要。

---

## 練習：次の英文を読んで意味を取ってみよう

### 問題 1

> The modules imported at the top of the file are available throughout the component.

<details>
<summary>解答を見る</summary>

**和訳:** ファイルの先頭でインポートされたモジュールは、コンポーネント全体で利用可能である。

**構造:**
- 主語: The modules (imported at the top of the file)
- 動詞: are
- 補語: available throughout the component

`imported` は過去分詞で `modules` を後置修飾している。

</details>

---

### 問題 2

> Functions accepting a callback should also support Promises.

<details>
<summary>解答を見る</summary>

**和訳:** コールバックを受け取る関数は Promise もサポートすべきである。

**構造:**
- 主語: Functions (accepting a callback)
- 動詞: should support
- 目的語: Promises

`accepting` は現在分詞で `Functions` を後置修飾している。

</details>

---

### 問題 3

> Events emitted by child components can be listened to using the `v-on` directive.

<details>
<summary>解答を見る</summary>

**和訳:** 子コンポーネントによって発行されたイベントは、`v-on` ディレクティブを使ってリッスンできる。

**構造:**
- 主語: Events (emitted by child components)
- 動詞: can be listened to
- 副詞句: using the `v-on` directive

`emitted` は過去分詞で `Events` を後置修飾している。

</details>
