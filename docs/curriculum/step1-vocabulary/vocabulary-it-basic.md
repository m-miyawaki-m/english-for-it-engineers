# IT基本語彙（800〜1,000語レベルから厳選）

## 概要

IT技術文書を読むうえで、一般的な英語力だけでは足りない場面がすぐに訪れます。公式リファレンス、GitHub の Issue/PR、設計書には、**IT分野特有の動詞・名詞・形容詞**が大量に登場します。

これらの語彙は日常英語ではほぼ使わないものが多く、知らなければ文脈から推測することも困難です。逆に、ここで紹介する約60語を押さえるだけで、技術文書の「何をしているか」が格段に掴めるようになります。

本ページでは、IT文書で頻出する基本語彙を4つのカテゴリに分類し、それぞれ品詞・意味・例文・関連語を添えて解説します。

---

## 1. 開発プロセス（Development Process）

ソフトウェアの構築・改善・運用に関わる動詞群です。APIドキュメント、README、CHANGELOG で特に多く出現します。

---

### deploy（動詞）

**意味:** デプロイする、本番環境に配置・展開する

> Deploy the application to the production server using the CI/CD pipeline.
>
> CI/CDパイプラインを使用して、アプリケーションを本番サーバーにデプロイしてください。

**関連語:** deployment（名詞: デプロイメント）、redeploy（動詞: 再デプロイする）

---

### implement（動詞）

**意味:** 実装する、機能を具体的にコードとして作成する

> We need to implement the authentication module before the next release.
>
> 次のリリースまでに認証モジュールを実装する必要があります。

**関連語:** implementation（名詞: 実装）

---

### configure（動詞）

**意味:** 設定する、構成を調整する

> Configure the database connection settings in the `.env` file.
>
> `.env` ファイルでデータベース接続の設定を行ってください。

**関連語:** configuration（名詞: 設定・構成）、configurable（形容詞: 設定可能な）

---

### initialize（動詞）

**意味:** 初期化する、初期状態にセットアップする

> The SDK automatically initializes when the application starts.
>
> SDKはアプリケーションの起動時に自動的に初期化されます。

**関連語:** initialization（名詞: 初期化）、init（略語: 初期化の短縮形、CLI でよく使う）

---

### instantiate（動詞）

**意味:** インスタンス化する、クラスからオブジェクトを生成する

> You can instantiate the client by passing the API key to the constructor.
>
> APIキーをコンストラクタに渡すことで、クライアントをインスタンス化できます。

**関連語:** instance（名詞: インスタンス）、instantiation（名詞: インスタンス化）

---

### compile（動詞）

**意味:** コンパイルする、ソースコードを実行可能な形式に変換する

> The TypeScript compiler compiles `.ts` files into JavaScript.
>
> TypeScriptコンパイラは `.ts` ファイルをJavaScriptにコンパイルします。

**関連語:** compiler（名詞: コンパイラ）、compilation（名詞: コンパイル）、compile-time（形容詞: コンパイル時の）

---

### execute（動詞）

**意味:** 実行する、プログラムやコマンドを動作させる

> Execute the following command to install the dependencies.
>
> 以下のコマンドを実行して依存関係をインストールしてください。

**関連語:** execution（名詞: 実行）、executable（名詞/形容詞: 実行可能ファイル/実行可能な）

---

### debug（動詞）

**意味:** デバッグする、バグ（不具合）を見つけて修正する

> Use the browser DevTools to debug the rendering issue.
>
> ブラウザのDevToolsを使って、レンダリングの問題をデバッグしてください。

**関連語:** debugger（名詞: デバッガ）、debugging（名詞: デバッグ作業）

---

### refactor（動詞）

**意味:** リファクタリングする、外部の振る舞いを変えずにコードの内部構造を改善する

> Refactor the handler function to reduce code duplication.
>
> コードの重複を減らすために、ハンドラ関数をリファクタリングしてください。

**関連語:** refactoring（名詞: リファクタリング）

---

### optimize（動詞）

**意味:** 最適化する、パフォーマンスや効率を向上させる

> Optimize the database queries to reduce response time.
>
> レスポンス時間を短縮するために、データベースクエリを最適化してください。

**関連語:** optimization（名詞: 最適化）、optimized（形容詞: 最適化された）

---

### deprecate（動詞）

**意味:** 非推奨にする、将来削除予定として警告する

> This method is deprecated and will be removed in the next major version.
>
> このメソッドは非推奨であり、次のメジャーバージョンで削除される予定です。

**関連語:** deprecated（形容詞: 非推奨の）、deprecation（名詞: 非推奨化）

---

### migrate（動詞）

**意味:** 移行する、あるシステムやバージョンから別のものへ移す

> Migrate the database schema to the latest version by running the migration script.
>
> マイグレーションスクリプトを実行して、データベーススキーマを最新バージョンに移行してください。

**関連語:** migration（名詞: 移行・マイグレーション）

---

### scaffold（動詞）

**意味:** スキャフォールドする、プロジェクトの雛形を自動生成する

> Use the CLI tool to scaffold a new project with the recommended directory structure.
>
> CLIツールを使って、推奨ディレクトリ構造で新しいプロジェクトをスキャフォールドしてください。

**関連語:** scaffolding（名詞: 雛形生成・足場作り）

---

### bootstrap（動詞）

**意味:** ブートストラップする、初期セットアップを行って動作可能な状態にする

> The framework bootstraps the application by loading configuration and registering services.
>
> フレームワークは、設定の読み込みとサービスの登録を行ってアプリケーションをブートストラップします。

**関連語:** bootstrapping（名詞: ブートストラップ処理）

---

### provision（動詞）

**意味:** プロビジョニングする、インフラリソースを準備・配備する

> Use Terraform to provision cloud resources automatically.
>
> Terraformを使用して、クラウドリソースを自動的にプロビジョニングしてください。

**関連語:** provisioning（名詞: プロビジョニング）

---

## 2. データ・状態（Data & State）

データの取得・加工・保存に関わる語彙です。API仕様書やデータベース関連のドキュメントで特に頻出します。

---

### persist（動詞）

**意味:** 永続化する、データをディスクやデータベースに保存して残す

> The session data is persisted to the database so it survives server restarts.
>
> セッションデータはデータベースに永続化されるため、サーバーの再起動後も保持されます。

**関連語:** persistence（名詞: 永続性）、persistent（形容詞: 永続的な）

---

### retrieve（動詞）

**意味:** 取得する、保存されたデータを読み出す

> Retrieve the user record from the database using the unique ID.
>
> 一意のIDを使用して、データベースからユーザーレコードを取得してください。

**関連語:** retrieval（名詞: 取得・検索）

---

### fetch（動詞）

**意味:** フェッチする、外部ソース（APIなど）からデータを取りに行く

> The component fetches the latest data from the REST API on mount.
>
> コンポーネントはマウント時にREST APIから最新データをフェッチします。

**関連語:** Fetch API（名詞: ブラウザの標準API）

---

### parse（動詞）

**意味:** パースする、文字列やデータを構造化された形に解析する

> The JSON response is parsed into a JavaScript object.
>
> JSONレスポンスはJavaScriptオブジェクトにパースされます。

**関連語:** parser（名詞: パーサ）、parsing（名詞: 解析処理）

---

### serialize（動詞）

**意味:** シリアライズする、オブジェクトを文字列やバイト列に変換する

> Serialize the request body to JSON before sending it to the server.
>
> サーバーに送信する前に、リクエストボディをJSONにシリアライズしてください。

**関連語:** serialization（名詞: シリアライズ）、deserialize（動詞: デシリアライズする）

---

### validate（動詞）

**意味:** 検証する、データが正しい形式・値であるか確認する

> Validate the input fields before submitting the form.
>
> フォームを送信する前に、入力フィールドを検証してください。

**関連語:** validation（名詞: 検証・バリデーション）、validator（名詞: バリデータ）、valid（形容詞: 有効な）、invalid（形容詞: 無効な）

---

### sanitize（動詞）

**意味:** サニタイズする、危険な文字列やコードを無害化する

> Always sanitize user input to prevent XSS attacks.
>
> XSS攻撃を防ぐために、ユーザー入力は必ずサニタイズしてください。

**関連語:** sanitization（名詞: サニタイズ処理）、sanitizer（名詞: サニタイザ）

---

### cache（動詞/名詞）

**意味:** キャッシュする / キャッシュ（高速アクセスのための一時保存領域）

> The CDN caches static assets to reduce latency for end users.
>
> CDNは静的アセットをキャッシュして、エンドユーザーのレイテンシを削減します。

**関連語:** cached（形容詞: キャッシュされた）、caching（名詞: キャッシュ処理）、cache invalidation（名詞: キャッシュ無効化）

---

### buffer（名詞/動詞）

**意味:** バッファ（一時的にデータを溜めておく領域）/ バッファリングする

> The stream reads data into a buffer before writing it to disk.
>
> ストリームはディスクに書き込む前に、データをバッファに読み込みます。

**関連語:** buffering（名詞: バッファリング）、buffered（形容詞: バッファリングされた）

---

### queue（名詞/動詞）

**意味:** キュー（先入れ先出しのデータ構造）/ キューに入れる

> Failed jobs are added to a retry queue for later processing.
>
> 失敗したジョブは、後で処理するためにリトライキューに追加されます。

**関連語:** enqueue（動詞: キューに入れる）、dequeue（動詞: キューから取り出す）、message queue（名詞: メッセージキュー）

---

### payload（名詞）

**意味:** ペイロード、通信やリクエストで送受信されるデータ本体

> The webhook sends a JSON payload containing the event details.
>
> Webhookはイベントの詳細を含むJSONペイロードを送信します。

**関連語:** request payload（名詞: リクエストペイロード）、response payload（名詞: レスポンスペイロード）

---

### schema（名詞）

**意味:** スキーマ、データの構造定義

> Define the database schema before running the migration.
>
> マイグレーションを実行する前に、データベーススキーマを定義してください。

**関連語:** schema validation（名詞: スキーマ検証）、JSON Schema（名詞: JSONスキーマ仕様）

---

### entity（名詞）

**意味:** エンティティ、データモデルにおける一つの概念的なまとまり（ユーザー、注文など）

> Each entity in the database corresponds to a table.
>
> データベース内の各エンティティはテーブルに対応します。

**関連語:** entity relationship（名詞: エンティティ関連）

---

### attribute（名詞）

**意味:** 属性、エンティティやオブジェクトが持つ個々のプロパティ

> The `name` attribute is required for all user entities.
>
> `name` 属性はすべてのユーザーエンティティに必須です。

**関連語:** HTML attribute（名詞: HTML属性）、data attribute（名詞: データ属性）

---

### parameter（名詞）

**意味:** パラメータ、関数やAPIに渡す値の定義

> Pass the `limit` parameter to control the number of results returned.
>
> 返される結果の数を制御するために、`limit` パラメータを渡してください。

**関連語:** param（略語）、query parameter（名詞: クエリパラメータ）、path parameter（名詞: パスパラメータ）。argument（引数）と混同しやすいが、parameter は定義側、argument は呼び出し側を指す。

---

## 3. システム・インフラ（System & Infrastructure）

認証、セキュリティ、ネットワーク、インフラに関する語彙です。クラウドサービスのドキュメントやセキュリティ関連の文書で多用されます。

---

### authenticate（動詞）

**意味:** 認証する、ユーザーの身元（本人であること）を確認する

> Users must authenticate with a valid API key before accessing the endpoint.
>
> エンドポイントにアクセスする前に、ユーザーは有効なAPIキーで認証する必要があります。

**関連語:** authentication（名詞: 認証）、authenticated（形容詞: 認証済みの）。authorize（認可する）と区別すること。

---

### authorize（動詞）

**意味:** 認可する、認証済みのユーザーに対して特定の操作を許可する

> The server authorizes the request based on the user's role.
>
> サーバーはユーザーのロールに基づいてリクエストを認可します。

**関連語:** authorization（名詞: 認可）、authorized（形容詞: 認可された）、unauthorized（形容詞: 未認可の、HTTP 401）

---

### encrypt（動詞）

**意味:** 暗号化する、データを第三者が読めない形に変換する

> All sensitive data is encrypted at rest and in transit.
>
> すべての機密データは保存時と転送時に暗号化されます。

**関連語:** encryption（名詞: 暗号化）、encrypted（形容詞: 暗号化された）、decrypt（動詞: 復号する）

---

### middleware（名詞）

**意味:** ミドルウェア、リクエストとレスポンスの間に挟まって処理を行うソフトウェア層

> Add the logging middleware to capture all incoming requests.
>
> すべての受信リクエストを記録するために、ロギングミドルウェアを追加してください。

---

### endpoint（名詞）

**意味:** エンドポイント、APIが公開する特定のURLパス

> The `/api/users` endpoint returns a list of all registered users.
>
> `/api/users` エンドポイントは、登録済みの全ユーザーのリストを返します。

---

### throughput（名詞）

**意味:** スループット、単位時間あたりに処理できるデータ量やリクエスト数

> The new architecture increased the throughput from 1,000 to 10,000 requests per second.
>
> 新しいアーキテクチャにより、スループットは毎秒1,000リクエストから10,000リクエストに向上しました。

---

### latency（名詞）

**意味:** レイテンシ、リクエストを送ってからレスポンスが返るまでの遅延時間

> Using a CDN reduces latency for users in different geographic regions.
>
> CDNを使用すると、異なる地理的リージョンのユーザーに対するレイテンシが削減されます。

**関連語:** low-latency（形容詞: 低レイテンシの）、high-latency（形容詞: 高レイテンシの）

---

### scalability（名詞）

**意味:** スケーラビリティ、負荷の増減に応じてシステムを拡張・縮小できる能力

> The microservices architecture improves the scalability of the system.
>
> マイクロサービスアーキテクチャは、システムのスケーラビリティを向上させます。

**関連語:** scalable（形容詞: スケーラブルな）、scale（動詞: スケールする）、scale up/out（動詞句: スケールアップ/スケールアウトする）

---

### redundancy（名詞）

**意味:** 冗長性、障害に備えて同じ機能を複数用意すること

> The system is designed with redundancy to ensure high availability.
>
> システムは高可用性を確保するために冗長性をもって設計されています。

**関連語:** redundant（形容詞: 冗長な）

---

### failover（名詞）

**意味:** フェイルオーバー、障害発生時に予備のシステムに自動切り替えすること

> Automatic failover ensures that the service remains available during outages.
>
> 自動フェイルオーバーにより、障害発生時もサービスが利用可能な状態を維持します。

---

### load balancer（名詞）

**意味:** ロードバランサー、複数のサーバーにリクエストを分散する仕組み

> Place a load balancer in front of the application servers to distribute traffic evenly.
>
> トラフィックを均等に分散するために、アプリケーションサーバーの前にロードバランサーを配置してください。

**関連語:** load balancing（名詞: 負荷分散）

---

### proxy（名詞/動詞）

**意味:** プロキシ（中継サーバー）/ プロキシ経由で中継する

> The reverse proxy forwards requests to the appropriate backend service.
>
> リバースプロキシは、適切なバックエンドサービスにリクエストを転送します。

**関連語:** reverse proxy（名詞: リバースプロキシ）、proxy server（名詞: プロキシサーバー）

---

### daemon（名詞）

**意味:** デーモン、バックグラウンドで常駐して動作するプロセス

> The Docker daemon manages containers on the host machine.
>
> Dockerデーモンはホストマシン上のコンテナを管理します。

**注意:** 発音は「ディーモン」。

---

### orchestrate（動詞）

**意味:** オーケストレーションする、複数のサービスやコンテナを統合的に管理・制御する

> Kubernetes orchestrates the deployment and scaling of containerized applications.
>
> Kubernetesは、コンテナ化されたアプリケーションのデプロイとスケーリングをオーケストレーションします。

**関連語:** orchestration（名詞: オーケストレーション）、orchestrator（名詞: オーケストレータ）

---

### containerize（動詞）

**意味:** コンテナ化する、アプリケーションをコンテナイメージとしてパッケージングする

> Containerize the application using Docker to ensure consistent environments.
>
> 環境の一貫性を確保するために、Dockerを使ってアプリケーションをコンテナ化してください。

**関連語:** container（名詞: コンテナ）、containerization（名詞: コンテナ化）

---

## 4. 操作・制御（Operations & Control）

プログラムの動作制御、オブジェクト指向、イベント駆動に関わる動詞です。フレームワークのAPIリファレンスやライブラリのドキュメントで頻出します。

---

### invoke（動詞）

**意味:** 呼び出す、関数やメソッドを実行する

> The callback function is invoked when the event is triggered.
>
> イベントがトリガーされると、コールバック関数が呼び出されます。

**関連語:** invocation（名詞: 呼び出し）

---

### trigger（動詞/名詞）

**意味:** トリガーする、イベントや処理のきっかけを発生させる / トリガー（きっかけ）

> Clicking the button triggers a re-render of the component.
>
> ボタンをクリックすると、コンポーネントの再レンダリングがトリガーされます。

---

### emit（動詞）

**意味:** イベントを発行（発火）する

> The server emits a `connection` event when a new client connects.
>
> 新しいクライアントが接続すると、サーバーは `connection` イベントを発行します。

**関連語:** emitter（名詞: エミッタ）、emission（名詞: 発行）

---

### dispatch（動詞）

**意味:** ディスパッチする、アクションやイベントを適切なハンドラに送り出す

> Dispatch the `INCREMENT` action to update the counter state.
>
> カウンターの状態を更新するために、`INCREMENT` アクションをディスパッチしてください。

**関連語:** dispatcher（名詞: ディスパッチャ）

---

### subscribe（動詞）

**意味:** 購読する、イベントやデータの変更を監視・受信する登録をする

> Subscribe to the `onChange` event to receive notifications when the value changes.
>
> 値が変更されたときに通知を受け取るために、`onChange` イベントを購読してください。

**関連語:** subscription（名詞: 購読・サブスクリプション）、subscriber（名詞: 購読者）、unsubscribe（動詞: 購読解除する）

---

### propagate（動詞）

**意味:** 伝播する、イベントや変更を連鎖的に広げる

> The click event propagates from the child element up to the parent.
>
> クリックイベントは子要素から親要素に向かって伝播します。

**関連語:** propagation（名詞: 伝播）、event propagation（名詞: イベント伝播）

---

### delegate（動詞）

**意味:** 委譲する、処理や権限を別のオブジェクトや関数に任せる

> The parent component delegates event handling to its child components.
>
> 親コンポーネントはイベント処理を子コンポーネントに委譲します。

**関連語:** delegation（名詞: 委譲）、event delegation（名詞: イベント委譲）

---

### override（動詞）

**意味:** オーバーライドする、親クラスのメソッドを子クラスで再定義する

> Override the `toString()` method to customize the string representation.
>
> 文字列表現をカスタマイズするために、`toString()` メソッドをオーバーライドしてください。

**関連語:** overriding（名詞: オーバーライド）。overload（オーバーロード: 同名メソッドを異なる引数で定義すること）と区別すること。

---

### inherit（動詞）

**意味:** 継承する、親クラスのプロパティやメソッドを子クラスが引き継ぐ

> The `AdminUser` class inherits all properties from the `User` class.
>
> `AdminUser` クラスは `User` クラスのすべてのプロパティを継承します。

**関連語:** inheritance（名詞: 継承）

---

### extend（動詞）

**意味:** 拡張する、既存のクラスや機能を基に新しい機能を追加する

> Create a custom error class that extends the built-in `Error` class.
>
> 組み込みの `Error` クラスを拡張して、カスタムエラークラスを作成してください。

**関連語:** extension（名詞: 拡張）、extensible（形容詞: 拡張可能な）

---

### encapsulate（動詞）

**意味:** カプセル化する、データと処理をひとまとめにして外部から隠蔽する

> Encapsulate the business logic inside the service layer.
>
> ビジネスロジックをサービス層の中にカプセル化してください。

**関連語:** encapsulation（名詞: カプセル化）

---

### abstract（動詞/形容詞）

**意味:** 抽象化する / 抽象的な、具体的な実装を隠して概念的なインターフェースだけを公開する

> The library abstracts away the complexity of the underlying protocol.
>
> このライブラリは、基盤となるプロトコルの複雑さを抽象化して隠します。

**関連語:** abstraction（名詞: 抽象化）、abstract class（名詞: 抽象クラス）

---

### iterate（動詞）

**意味:** 繰り返す、コレクション内の要素を一つずつ処理する

> Iterate over the array and apply the transformation to each element.
>
> 配列を繰り返し処理し、各要素に変換を適用してください。

**関連語:** iteration（名詞: 繰り返し・イテレーション）、iterator（名詞: イテレータ）、iterable（形容詞/名詞: 反復可能な/反復可能オブジェクト）

---

### traverse（動詞）

**意味:** 走査する、ツリーやグラフなどのデータ構造を順番にたどる

> The algorithm traverses the DOM tree to find matching elements.
>
> アルゴリズムはDOMツリーを走査して、一致する要素を見つけます。

**関連語:** traversal（名詞: 走査）

---

### enumerate（動詞）

**意味:** 列挙する、要素を一つずつ数え上げる・リストアップする

> The function enumerates all available network interfaces.
>
> この関数は利用可能なすべてのネットワークインターフェースを列挙します。

**関連語:** enumeration（名詞: 列挙）、enum（名詞: 列挙型）

---

## 学習のコツ

### 1. 接尾辞（suffix）のパターンを覚える

IT語彙の多くは、動詞に接尾辞を付けて名詞や形容詞に変化します。このパターンを知っておくと、未知の単語でも品詞と意味を推測できます。

| 接尾辞 | 品詞の変化 | 例 |
|--------|-----------|-----|
| -tion / -sion | 動詞 → 名詞（動作・プロセス） | implement → implementation, execute → execution |
| -er / -or | 動詞 → 名詞（実行する人・もの） | compile → compiler, dispatch → dispatcher |
| -able / -ible | 動詞 → 形容詞（〜できる） | configure → configurable, extend → extensible |
| -ed | 動詞 → 形容詞（〜された状態） | cache → cached, encrypt → encrypted |
| -ing | 動詞 → 名詞（プロセス） | buffer → buffering, scaffold → scaffolding |

### 2. 接頭辞（prefix）のパターンを覚える

| 接頭辞 | 意味 | 例 |
|--------|------|-----|
| de- | 逆の動作、分解 | serialize → deserialize, compile → decompile |
| re- | 再び | deploy → redeploy, validate → revalidate |
| un- | 否定、逆 | subscribe → unsubscribe, authorized → unauthorized |
| in- / im- | 否定 | valid → invalid, mutable → immutable |
| pre- | 前に | compile → precompile, process → preprocess |
| post- | 後に | process → postprocess, deploy → postdeploy |

### 3. 動詞 → 名詞のペアで覚える

IT文書では動詞と名詞が交互に出てきます。常にペアで覚えると効率的です。

```
deploy → deployment    「デプロイする → デプロイメント」
implement → implementation    「実装する → 実装」
authenticate → authentication    「認証する → 認証」
serialize → serialization    「シリアライズする → シリアライゼーション」
```

### 4. IT文脈での意味のズレに注意する

一般英語とIT英語で意味が異なる単語があります。

| 単語 | 一般英語の意味 | IT文脈での意味 |
|------|--------------|--------------|
| deploy | 軍隊を展開する | アプリケーションを本番環境に配置する |
| provision | 供給・準備する | インフラリソースを自動で配備する |
| sanitize | 消毒する | 入力データを無害化する |
| daemon | 悪魔（古い綴り） | バックグラウンド常駐プロセス |
| cache | 隠し場所 | 高速アクセス用の一時保存領域 |
| inherit | 遺産を相続する | 親クラスのプロパティを引き継ぐ |
