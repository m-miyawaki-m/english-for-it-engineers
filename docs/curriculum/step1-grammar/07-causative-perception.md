# 使役動詞・知覚動詞構文

## 概要

IT技術文書では「あるものが、別のものに何かをさせる/できるようにする」という表現が非常に多く登場します。APIの説明、機能の紹介、設定の効果など、あらゆる場面で使役動詞が使われます。このパターンを正確に読めるようになると、公式リファレンスやGitHubのREADMEの理解度が大幅に上がります。

## 基本ルール

使役動詞は「主語が、目的語に〜させる/させてあげる」という構造を作ります。

| 動詞 | 構文 | ニュアンス |
|------|------|-----------|
| allow | allow + O + to do | 〜が...するのを許可する |
| enable | enable + O + to do | 〜が...できるようにする |
| let | let + O + do（原形） | 〜が...するのを許す |
| make | make + O + do（原形） | 〜に...させる（強制） |
| have | have + O + do（原形） | 〜に...してもらう |
| cause | cause + O + to do | 〜が...する原因となる |
| force | force + O + to do | 〜に...を強制する |
| require | require + O + to do | 〜に...を要求する |
| prevent | prevent + O + from doing | 〜が...するのを防ぐ |

**重要な注意点:**
- `let` / `make` / `have` の後は **to なしの原形**（bare infinitive）
- `allow` / `enable` / `cause` / `force` / `require` の後は **to + 動詞の原形**（to-infinitive）
- `prevent` は **from + doing**（動名詞）

## IT技術文書での頻出パターン

### パターン1: allow + O + to do（許可・可能にする）

技術文書で最も頻出する使役構文です。「ユーザーやデベロッパーが何かをできるようになる」ことを説明するときに使います。

> This feature **allows** users **to** upload files up to 10MB.
>
> （この機能により、ユーザーは最大10MBのファイルをアップロードできます。）

### パターン2: enable + O + to do（機能として可能にする）

`allow` と似ていますが、`enable` は「技術的に可能にする」というニュアンスが強いです。新機能やアップデートの説明でよく使われます。

> The new SDK **enables** developers **to** integrate payment processing in minutes.
>
> （新しいSDKにより、開発者は数分で決済処理を統合できます。）

### パターン3: let + O + do（カジュアルな許可）

`let` はカジュアルな文体で使われます。READMEやチュートリアルで多く見かけます。**to が付かない** 点に注意してください。

> This middleware **lets** you intercept requests before they reach the server.
>
> （このミドルウェアを使うと、リクエストがサーバーに届く前にインターセプトできます。）

### パターン4: make + O + do（強制・自動的にそうなる）

設定やフラグが「何かを強制的にそうさせる」場合に使います。**to が付かない** 点に注意してください。

> Setting `strict: true` **makes** the compiler reject implicit `any` types.
>
> （`strict: true` を設定すると、コンパイラは暗黙の `any` 型を拒否します。）

### パターン5: cause + O + to do / prevent + O + from doing

バグ報告やトラブルシューティングで頻出します。「何かが原因で問題が起きる」「何かが問題を防ぐ」というパターンです。

> A race condition **causes** the application **to** crash on startup.
>
> （競合状態が原因で、アプリケーションは起動時にクラッシュします。）

> This lock **prevents** other threads **from** accessing the shared resource.
>
> （このロックにより、他のスレッドが共有リソースにアクセスするのを防ぎます。）

## 実例

以下は実際のIT文書で見かける典型的な例文です。

**1. 公式リファレンス（API説明）**

> The `useState` hook **allows** components **to** manage local state without writing a class.
>
> （`useState` フックにより、コンポーネントはクラスを書かずにローカル状態を管理できます。）

**2. リリースノート**

> This update **enables** developers **to** use the new streaming API for real-time data processing.
>
> （このアップデートにより、開発者はリアルタイムデータ処理のための新しいストリーミングAPIを使用できます。）

**3. README（カジュアル）**

> The CLI tool **lets** you scaffold a new project in seconds.
>
> （このCLIツールを使えば、数秒で新しいプロジェクトのひな形を作れます。）

**4. コンパイラ設定**

> This flag **makes** the compiler ignore all warnings during the build process.
>
> （このフラグにより、コンパイラはビルドプロセス中のすべての警告を無視します。）

**5. バグレポート**

> The memory leak **causes** the server **to** run out of memory after 24 hours of operation.
>
> （メモリリークが原因で、サーバーは24時間稼働後にメモリ不足になります。）

**6. セキュリティ文書**

> CORS headers **prevent** unauthorized domains **from** making requests to the API.
>
> （CORSヘッダーにより、許可されていないドメインがAPIにリクエストを送るのを防ぎます。）

**7. 設定ガイド**

> Setting the environment variable **forces** the application **to** use the production database.
>
> （環境変数を設定すると、アプリケーションは強制的に本番データベースを使用します。）

**8. 要件定義**

> The specification **requires** all API endpoints **to** return JSON responses.
>
> （仕様では、すべてのAPIエンドポイントがJSONレスポンスを返すことを要求しています。）

## よくある誤読パターン

### 1. to の有無を間違える

`let` と `allow` を同じ構文だと思い込むと、文の構造を見誤ります。

- **正:** This **lets** you **create** a new instance.（to なし）
- **正:** This **allows** you **to create** a new instance.（to あり）
- **誤読:** "This lets you to create..." と読んでしまう（to は不要）

### 2. 主語と目的語の取り違え

長い文では「誰が」「誰に」させるのかを見失いがちです。

> The middleware allows authenticated users to access protected routes.

- 主語: The middleware（ミドルウェア）
- 目的語: authenticated users（認証済みユーザー）
- 行為: access protected routes（保護されたルートにアクセスする）

「ミドルウェアが認証済みユーザーにアクセスを許可する」が正しい読みです。

### 3. cause + to do を「原因」と読めない

> A null pointer causes the function to throw an exception.

`causes` を「引き起こす」と読めず、文全体の因果関係を見失うケースがあります。「nullポインタが原因で、関数が例外をスローする」と読みましょう。

### 4. prevent + from doing の from を見落とす

> The firewall prevents external traffic from reaching internal services.

`from` を見落とすと「ファイアウォールが外部トラフィックを防ぐ」で止まり、「何を防ぐのか」が曖昧になります。`from reaching` まで読んで「到達するのを防ぐ」と理解しましょう。

## 練習：次の英文を読んで意味を取ってみよう

以下の英文を読み、日本語で意味を書いてみてください。

---

**問題1:**

> The `--verbose` flag makes the build tool output detailed logs for each compilation step.

<details>
<summary>解答を見る</summary>

`--verbose` フラグにより、ビルドツールは各コンパイルステップの詳細なログを出力します。

- makes + the build tool（O）+ output（原形動詞）の構造
- 「フラグがビルドツールに出力させる」という使役の意味

</details>

---

**問題2:**

> Enabling two-factor authentication prevents attackers from gaining unauthorized access to your account.

<details>
<summary>解答を見る</summary>

二要素認証を有効にすると、攻撃者がアカウントへ不正アクセスするのを防ぎます。

- prevents + attackers（O）+ from gaining（動名詞）の構造
- 「二要素認証が攻撃者のアクセスを防ぐ」という意味

</details>

---

**問題3:**

> The new plugin system allows third-party developers to extend the editor's functionality without modifying the core codebase.

<details>
<summary>解答を見る</summary>

新しいプラグインシステムにより、サードパーティの開発者はコアコードベースを変更せずにエディタの機能を拡張できます。

- allows + third-party developers（O）+ to extend（to不定詞）の構造
- without modifying は「〜を変更せずに」という付帯状況

</details>
