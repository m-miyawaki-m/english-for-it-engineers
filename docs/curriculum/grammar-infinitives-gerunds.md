# 不定詞と動名詞（Infinitives and Gerunds）

## 概要

不定詞（to + 動詞）と動名詞（動詞 + -ing）は、IT技術文書で異なる役割を持ちます。

- **不定詞（to do）** → 「〜するために」「〜する方法」: 目的・手順の説明
- **動名詞（doing）** → 「〜すること」: 動作そのものの説明

この使い分けを理解すると、READMEの手順説明やAPIドキュメントの注意書きを正確に読めるようになります。

---

## 基本ルール

### 不定詞（to + 動詞の原形）

主な用法:

| 用法 | 例 | 意味 |
|------|---|------|
| **目的** | To install the package, run npm install. | 〜するために |
| **手順** | Use this method to validate input. | 〜するのに使う |
| **形容詞的** | The function to call is `init()`. | 〜すべき |
| **主語** | To understand this concept is important. | 〜することは |

### 動名詞（動詞 + -ing）

主な用法:

| 用法 | 例 | 意味 |
|------|---|------|
| **主語** | Configuring the database requires credentials. | 〜することは |
| **目的語** | Avoid using synchronous calls. | 〜することを |
| **前置詞の後** | Before deploying, run the tests. | 〜する前に |
| **説明・タイトル** | "Getting Started" / "Installing Dependencies" | 〜すること |

### 不定詞と動名詞の使い分けのポイント

| 場面 | 使う形 | 例 |
|------|-------|---|
| 手順の案内 | 不定詞 | To configure..., do X. |
| 動作の説明（一般論） | 動名詞 | Configuring... requires Y. |
| 推奨・禁止 | 動名詞（avoid / consider 等の後） | Avoid using... |
| 目的の説明 | 不定詞 | Use X to achieve Y. |

---

## IT技術文書での頻出パターン

### パターン 1: 手順の案内（To + 動詞, ...）

READMEやガイドで最も多いパターン。「〜するには」という目的を示します。

```
To install the package, run npm install.
```

「パッケージをインストールするには、npm install を実行してください」。

### パターン 2: 方法・目的の説明（Use X to + 動詞）

メソッドやツールの使い方を説明するパターン。

```
Use this method to validate user input.
```

「ユーザー入力を検証するには、このメソッドを使用してください」。

### パターン 3: 動名詞を主語にした説明（-ing + 動詞）

ある操作について一般的な説明をするパターン。

```
Configuring the database requires setting environment variables.
```

「データベースの設定には、環境変数の設定が必要です」。

### パターン 4: 推奨・禁止（avoid / consider / recommend + -ing）

ベストプラクティスや注意書きで使うパターン。

```
Avoid using synchronous calls in the main thread.
```

「メインスレッドで同期呼び出しを使うのは避けてください」。

### パターン 5: セクション見出し（-ing 形 / 不定詞）

ドキュメントのセクション見出しで両方の形が使われます。

```
Getting Started              （動名詞 → 「始め方」）
Installing Dependencies      （動名詞 → 「依存関係のインストール」）
How to Deploy                （不定詞 → 「デプロイの方法」）
```

---

## 実例（IT文書風の例文）

### 例文 1
> To install the package, run npm install.

**和訳:** パッケージをインストールするには、npm install を実行してください。

**解説:** To + 動詞で目的を示す。READMEの手順説明の定番。

---

### 例文 2
> Configuring the database requires setting environment variables.

**和訳:** データベースを設定するには、環境変数を設定する必要があります。

**解説:** 動名詞が主語（Configuring）と目的語（setting）の両方で使われている。

---

### 例文 3
> Use this method to validate user input.

**和訳:** ユーザー入力を検証するには、このメソッドを使用してください。

**解説:** Use X to Y の構文。「Xを使ってYする」。APIドキュメントで頻出。

---

### 例文 4
> Avoid using synchronous calls in the main thread.

**和訳:** メインスレッドで同期呼び出しを使用するのは避けてください。

**解説:** avoid + 動名詞。avoid の後は必ず -ing 形（to 不定詞は不可）。

---

### 例文 5
> To enable hot reloading, add the following to your configuration file.

**和訳:** ホットリロードを有効にするには、設定ファイルに以下を追加してください。

**解説:** To + 動詞で手順の目的を示す。ガイドや README で頻出。

---

### 例文 6
> Deploying to production requires passing all CI checks.

**和訳:** 本番環境へのデプロイには、すべてのCIチェックに合格する必要があります。

**解説:** 動名詞（Deploying）が主語、動名詞（passing）が目的語。requires + -ing の形。

---

### 例文 7
> Consider using a connection pool to improve database performance.

**和訳:** データベースのパフォーマンスを向上させるために、コネクションプールの使用を検討してください。

**解説:** consider + 動名詞 + to 不定詞（目的）。推奨事項の記述パターン。

---

### 例文 8
> The easiest way to get started is to clone the repository and run the setup script.

**和訳:** 始める最も簡単な方法は、リポジトリをクローンしてセットアップスクリプトを実行することです。

**解説:** way to get started（不定詞で修飾）、is to clone（不定詞で補語）。

---

## よくある誤読パターン

### 1. 「To + 動詞」の目的と結果を混同する

```
To configure SSL, edit the nginx.conf file.
（SSLを設定するには、nginx.confファイルを編集してください）
```

「To configure SSL」は**目的**（〜するために）であって、「SSLを設定して、そしてnginx.confを編集する」（時系列）ではありません。

### 2. 動名詞の主語を見落とす

```
Running tests locally helps catch bugs early.
```

Running tests locally が文全体の**主語**です。「テストをローカルで実行することは、バグを早期に発見するのに役立つ」。-ing で始まる文を見たら、まずそれが主語かどうかを確認しましょう。

分詞構文との違い:
- **動名詞（主語）:** Running tests locally **helps** catch bugs early.（直後に動詞）
- **分詞構文:** Running tests locally**,** you can catch bugs early.（カンマで区切られる）

### 3. 動詞ごとの to / -ing の使い分けを知らない

IT文書で頻出する動詞の使い分け:

| 動詞 | 後に続く形 | 例 |
|------|----------|---|
| avoid | -ing のみ | Avoid using deprecated APIs. |
| consider | -ing のみ | Consider upgrading to the latest version. |
| recommend | -ing / to 両方 | We recommend using TypeScript. |
| allow | to のみ | This allows you to customize the behavior. |
| enable | to / 名詞 | This flag enables you to debug the application. |
| require | -ing / 名詞 | This requires installing Node.js. |
| need | to のみ | You need to restart the server. |
| want | to のみ | If you want to contribute, read CONTRIBUTING.md. |

---

## 練習: 次の英文を読んで意味を取ってみよう

### 問題 1

> To migrate from v2 to v3, update the configuration file and run the migration script.

<details>
<summary>解答を見る</summary>

**和訳:** v2からv3に移行するには、設定ファイルを更新し、マイグレーションスクリプトを実行してください。

**ポイント:** To + 動詞で目的を示す。「移行するために」→「何をするか」の流れ。
</details>

---

### 問題 2

> Enabling strict mode helps prevent common JavaScript errors.

<details>
<summary>解答を見る</summary>

**和訳:** strictモードを有効にすることは、一般的なJavaScriptエラーを防ぐのに役立ちます。

**ポイント:** Enabling strict mode が主語（動名詞）。helps の主語は「有効にすること」。
</details>

---

### 問題 3

> We recommend using environment variables instead of hardcoding sensitive values.

<details>
<summary>解答を見る</summary>

**和訳:** 機密情報をハードコーディングする代わりに、環境変数を使用することを推奨します。

**ポイント:** recommend + -ing。instead of + -ing（hardcoding）も動名詞。前置詞の後は常に -ing 形。
</details>
