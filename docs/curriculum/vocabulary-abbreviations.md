# IT略語・頭字語

## 概要

IT技術文書を読むうえで最大の障壁の一つが**略語（abbreviation）**と**頭字語（acronym）**です。技術文書の1ページに10個以上の略語が登場することも珍しくなく、これらを知らなければ文章の意味をまったく掴めません。

例えば、次の一文を見てください。

> Configure CORS headers for the REST API endpoint to allow JWT-based authentication over HTTPS.

この短い文に CORS、REST、API、JWT、HTTPS の5つの略語が含まれています。一つでも知らなければ、何の話をしているのか理解できません。

本ページでは、IT文書で頻出する略語を6つのカテゴリに分けて、正式名称・意味・使用例とともに解説します。

---

## 1. Web・API（Web & API）

Webアプリケーション開発やAPI設計でほぼ毎日目にする略語です。

---

### REST

**正式名称:** Representational State Transfer

**意味:** リソースをURLで表現し、HTTPメソッド（GET/POST/PUT/DELETE）で操作するAPIの設計スタイル

> The server exposes a REST API for managing user accounts.
>
> サーバーはユーザーアカウントを管理するためのREST APIを公開しています。

---

### GraphQL

**正式名称:** Graph Query Language

**意味:** クライアントが必要なデータの構造を指定してリクエストできるクエリ言語・API仕様

> Use GraphQL to fetch only the fields you need in a single request.
>
> 単一のリクエストで必要なフィールドだけを取得するために、GraphQLを使用してください。

**注意:** 略語ではなく固有名称だが、IT文書では REST と対比して頻出するため掲載。

---

### HTTP / HTTPS

**正式名称:** HyperText Transfer Protocol / HyperText Transfer Protocol Secure

**意味:** Webにおけるデータ通信の基本プロトコル / その暗号化版

> All API requests must be made over HTTPS to ensure data security.
>
> データの安全性を確保するために、すべてのAPIリクエストはHTTPS経由で行う必要があります。

---

### URL / URI

**正式名称:** Uniform Resource Locator / Uniform Resource Identifier

**意味:** URL はリソースの場所（アドレス）を示す文字列 / URI はリソースを一意に識別する文字列（URLを包含する広い概念）

> Pass the base URL as a configuration parameter when initializing the client.
>
> クライアントの初期化時に、ベースURLを設定パラメータとして渡してください。

---

### DNS

**正式名称:** Domain Name System

**意味:** ドメイン名（例: example.com）をIPアドレスに変換する仕組み

> Update the DNS records to point the custom domain to the new server.
>
> カスタムドメインを新しいサーバーに向けるために、DNSレコードを更新してください。

---

### CDN

**正式名称:** Content Delivery Network

**意味:** 世界各地のサーバーにコンテンツをキャッシュし、ユーザーに最も近い場所から配信するネットワーク

> Serve static assets through a CDN to reduce latency for global users.
>
> グローバルユーザーのレイテンシを削減するために、静的アセットをCDN経由で配信してください。

---

### SSL / TLS

**正式名称:** Secure Sockets Layer / Transport Layer Security

**意味:** 通信を暗号化するプロトコル。SSLは古い版で、現在はTLSが後継だが、慣習的に「SSL証明書」と呼ぶことが多い

> Install an SSL/TLS certificate to enable HTTPS on your domain.
>
> ドメインでHTTPSを有効にするために、SSL/TLS証明書をインストールしてください。

---

### CORS

**正式名称:** Cross-Origin Resource Sharing

**意味:** 異なるオリジン（ドメイン）間でのリソース共有を制御するブラウザのセキュリティ機構

> Configure CORS headers to allow requests from the frontend domain.
>
> フロントエンドのドメインからのリクエストを許可するために、CORSヘッダーを設定してください。

---

### CSRF

**正式名称:** Cross-Site Request Forgery

**意味:** ユーザーの意図しないリクエストを送信させる攻撃手法（クロスサイトリクエストフォージェリ）

> Include a CSRF token in all form submissions to prevent forgery attacks.
>
> フォージェリ攻撃を防ぐために、すべてのフォーム送信にCSRFトークンを含めてください。

---

### XSS

**正式名称:** Cross-Site Scripting

**意味:** 悪意のあるスクリプトをWebページに注入する攻撃手法

> Sanitize user input to mitigate XSS vulnerabilities.
>
> XSS脆弱性を軽減するために、ユーザー入力をサニタイズしてください。

**注意:** CSS（Cascading Style Sheets）との混同を避けるため、Cross-Site Scripting は XSS と略される。

---

### JWT

**正式名称:** JSON Web Token

**意味:** JSONベースのトークン形式で、認証情報を安全にやりとりするために使われる

> The server issues a JWT after successful authentication.
>
> サーバーは認証成功後にJWTを発行します。

**発音:** 「ジョット」と読むことが多い。

---

### OAuth

**正式名称:** Open Authorization

**意味:** サードパーティアプリケーションに限定的なアクセス権を付与するための認可フレームワーク

> Implement OAuth 2.0 to allow users to sign in with their Google account.
>
> ユーザーがGoogleアカウントでサインインできるようにするために、OAuth 2.0を実装してください。

---

### SAML

**正式名称:** Security Assertion Markup Language

**意味:** 企業向けのシングルサインオン（SSO）で使われるXMLベースの認証・認可規格

> The enterprise plan supports SAML-based single sign-on.
>
> エンタープライズプランはSAMLベースのシングルサインオンをサポートしています。

---

### API

**正式名称:** Application Programming Interface

**意味:** ソフトウェア同士がやりとりするためのインターフェース仕様

> The API documentation describes all available endpoints and their parameters.
>
> APIドキュメントには、利用可能なすべてのエンドポイントとそのパラメータが記載されています。

---

### SDK

**正式名称:** Software Development Kit

**意味:** 特定のプラットフォームやサービス向けの開発ツールキット

> Install the SDK to integrate the payment service into your application.
>
> 決済サービスをアプリケーションに統合するために、SDKをインストールしてください。

---

## 2. 開発プロセス（Development Process）

開発手法やプロジェクト管理で使われる略語です。

---

### CI/CD

**正式名称:** Continuous Integration / Continuous Delivery（または Continuous Deployment）

**意味:** コードの変更を自動的にテスト・ビルド・デプロイするプロセス

> Set up a CI/CD pipeline to automate testing and deployment.
>
> テストとデプロイを自動化するために、CI/CDパイプラインをセットアップしてください。

---

### TDD

**正式名称:** Test-Driven Development

**意味:** テストを先に書き、そのテストを通すようにコードを実装する開発手法

> Following TDD, write the test case before implementing the feature.
>
> TDDに従い、機能を実装する前にテストケースを書いてください。

---

### BDD

**正式名称:** Behavior-Driven Development

**意味:** ユーザーの振る舞い（シナリオ）をベースにテストと開発を進める手法

> BDD scenarios are written in a Given-When-Then format.
>
> BDDシナリオはGiven-When-Then形式で記述されます。

---

### DDD

**正式名称:** Domain-Driven Design

**意味:** ビジネスドメイン（業務領域）を中心にソフトウェアの設計を行う手法

> DDD encourages modeling the software around the business domain.
>
> DDDはビジネスドメインを中心にソフトウェアをモデリングすることを推奨します。

---

### SDLC

**正式名称:** Software Development Life Cycle

**意味:** ソフトウェア開発の計画から保守までの一連の工程

> The SDLC defines the phases from requirements gathering to deployment.
>
> SDLCは要件収集からデプロイまでのフェーズを定義します。

---

### MVP

**正式名称:** Minimum Viable Product

**意味:** 最小限の実用的な製品。市場に出して検証できる最小の機能セット

> Launch the MVP first and iterate based on user feedback.
>
> まずMVPをリリースし、ユーザーのフィードバックに基づいてイテレーションしてください。

---

### POC

**正式名称:** Proof of Concept

**意味:** 概念実証。アイデアや技術の実現可能性を検証するための試作

> Build a POC to validate the feasibility of the new architecture.
>
> 新しいアーキテクチャの実現可能性を検証するためにPOCを作成してください。

---

### SLA

**正式名称:** Service Level Agreement

**意味:** サービス提供者と利用者の間で合意されるサービス品質の保証水準

> The SLA guarantees 99.9% uptime for the production environment.
>
> SLAは本番環境に対して99.9%の稼働率を保証します。

---

### SLO

**正式名称:** Service Level Objective

**意味:** サービスレベル目標。SLAの内部目標として設定される具体的な数値

> Our SLO for API response time is under 200 milliseconds at the 95th percentile.
>
> APIレスポンス時間のSLOは、95パーセンタイルで200ミリ秒未満です。

---

### SLI

**正式名称:** Service Level Indicator

**意味:** サービスレベル指標。SLOの達成度を測る実際の計測値

> Track SLIs such as error rate and latency to monitor service health.
>
> サービスの健全性を監視するために、エラー率やレイテンシなどのSLIを追跡してください。

---

### KPI

**正式名称:** Key Performance Indicator

**意味:** 重要業績評価指標。目標の達成度を測る定量的な指標

> Define KPIs to measure the success of the migration project.
>
> マイグレーションプロジェクトの成功を測定するためにKPIを定義してください。

---

## 3. アーキテクチャ（Architecture）

アプリケーションの構造や設計パターンに関する略語です。

---

### ORM

**正式名称:** Object-Relational Mapping

**意味:** オブジェクト（プログラム内のデータ構造）とリレーショナルデータベースのテーブルを対応付ける仕組み

> Use an ORM like Prisma to interact with the database without writing raw SQL.
>
> 生のSQLを書かずにデータベースとやりとりするために、PrismaのようなORMを使用してください。

---

### MVC

**正式名称:** Model-View-Controller

**意味:** アプリケーションをデータ（Model）・表示（View）・制御（Controller）の3層に分離する設計パターン

> The MVC pattern separates business logic from the presentation layer.
>
> MVCパターンはビジネスロジックをプレゼンテーション層から分離します。

---

### MVVM

**正式名称:** Model-View-ViewModel

**意味:** MVCの派生。View と Model の間に ViewModel を置いてデータバインディングを実現する設計パターン

> MVVM is commonly used in frontend frameworks with two-way data binding.
>
> MVVMは双方向データバインディングを持つフロントエンドフレームワークで一般的に使われます。

---

### SOA

**正式名称:** Service-Oriented Architecture

**意味:** 独立したサービスの組み合わせでシステムを構築するアーキテクチャスタイル

> SOA promotes loose coupling between services through well-defined interfaces.
>
> SOAは明確に定義されたインターフェースを通じて、サービス間の疎結合を促進します。

---

### SPA

**正式名称:** Single Page Application

**意味:** ページ遷移なしに、JavaScriptで動的にコンテンツを書き換えるWebアプリケーション

> React is commonly used to build SPAs with client-side routing.
>
> Reactはクライアントサイドルーティングを持つSPAの構築に一般的に使われます。

---

### SSR

**正式名称:** Server-Side Rendering

**意味:** サーバー側でHTMLを生成してからクライアントに送信するレンダリング方式

> SSR improves initial page load time and SEO for dynamic content.
>
> SSRは動的コンテンツの初回ページ読み込み時間とSEOを改善します。

---

### SSG

**正式名称:** Static Site Generation

**意味:** ビルド時にHTMLを事前生成する方式。変更の少ないページに適している

> Use SSG for documentation sites where content does not change frequently.
>
> コンテンツが頻繁に変更されないドキュメントサイトにはSSGを使用してください。

---

### ISR

**正式名称:** Incremental Static Regeneration

**意味:** 静的ページを一定間隔で再生成し、最新のデータを反映する方式（Next.js が導入）

> ISR allows you to update static pages without rebuilding the entire site.
>
> ISRにより、サイト全体を再ビルドせずに静的ページを更新できます。

---

### CSR

**正式名称:** Client-Side Rendering

**意味:** ブラウザ（クライアント側）でJavaScriptを実行してHTMLを生成するレンダリング方式

> CSR shifts the rendering workload from the server to the browser.
>
> CSRはレンダリングの負荷をサーバーからブラウザに移します。

---

### PWA

**正式名称:** Progressive Web App

**意味:** Webアプリケーションにネイティブアプリのような機能（オフライン対応、プッシュ通知等）を追加したもの

> Convert the web application into a PWA to enable offline access.
>
> オフラインアクセスを可能にするために、WebアプリケーションをPWAに変換してください。

---

### RBAC

**正式名称:** Role-Based Access Control

**意味:** ユーザーの役割（ロール）に基づいてアクセス権限を制御する仕組み

> Implement RBAC to restrict access based on user roles such as admin, editor, and viewer.
>
> admin、editor、viewerなどのユーザーロールに基づいてアクセスを制限するために、RBACを実装してください。

---

### ACL

**正式名称:** Access Control List

**意味:** リソースごとにアクセスを許可するユーザーや操作を定義したリスト

> Define an ACL to specify which users can read or write to the resource.
>
> リソースの読み取りや書き込みが可能なユーザーを指定するために、ACLを定義してください。

---

## 4. インフラ（Infrastructure）

クラウド、仮想化、ネットワークインフラに関する略語です。AWSをはじめとするクラウドサービスのドキュメントで頻出します。

---

### VM

**正式名称:** Virtual Machine

**意味:** 仮想マシン。物理ハードウェア上に仮想的に作られたコンピュータ環境

> Provision a VM with 4 vCPUs and 16 GB of memory for the staging environment.
>
> ステージング環境用に、4 vCPUと16 GBメモリのVMをプロビジョニングしてください。

---

### VPC

**正式名称:** Virtual Private Cloud

**意味:** クラウド上に構築する論理的に隔離されたネットワーク環境

> Deploy the database inside a VPC to restrict public access.
>
> パブリックアクセスを制限するために、データベースをVPC内にデプロイしてください。

---

### VPN

**正式名称:** Virtual Private Network

**意味:** 暗号化されたトンネルを通じてプライベートネットワークに安全に接続する技術

> Use a VPN to securely access the internal development environment.
>
> 内部の開発環境に安全にアクセスするために、VPNを使用してください。

---

### LB

**正式名称:** Load Balancer

**意味:** ロードバランサー。複数のサーバーにトラフィックを分散する仕組み

> Place an LB in front of the application servers to distribute incoming traffic.
>
> 受信トラフィックを分散するために、アプリケーションサーバーの前にLBを配置してください。

---

### WAF

**正式名称:** Web Application Firewall

**意味:** Webアプリケーションへの悪意あるリクエスト（SQLインジェクション、XSS等）を検知・ブロックするファイアウォール

> Enable the WAF to protect the application from common web attacks.
>
> 一般的なWeb攻撃からアプリケーションを保護するために、WAFを有効にしてください。

---

### IAM

**正式名称:** Identity and Access Management

**意味:** ユーザーの認証とアクセス権限の管理を行うサービス・仕組み（特にAWSで頻出）

> Create an IAM role with the minimum required permissions for the Lambda function.
>
> Lambda関数に必要な最小限の権限を持つIAMロールを作成してください。

---

### S3

**正式名称:** Amazon Simple Storage Service

**意味:** AWSのオブジェクトストレージサービス。ファイルの保存・配信に使われる

> Upload the static assets to an S3 bucket and serve them through CloudFront.
>
> 静的アセットをS3バケットにアップロードし、CloudFront経由で配信してください。

---

### EC2

**正式名称:** Amazon Elastic Compute Cloud

**意味:** AWSの仮想サーバーサービス。スケーラブルなコンピューティングリソースを提供する

> Launch an EC2 instance to host the application server.
>
> アプリケーションサーバーをホストするためにEC2インスタンスを起動してください。

---

### ECS

**正式名称:** Amazon Elastic Container Service

**意味:** AWSのコンテナオーケストレーションサービス。Dockerコンテナの実行と管理を行う

> Deploy the containerized application to ECS using Fargate launch type.
>
> Fargateの起動タイプを使用して、コンテナ化されたアプリケーションをECSにデプロイしてください。

---

### EKS

**正式名称:** Amazon Elastic Kubernetes Service

**意味:** AWSのマネージドKubernetesサービス

> Migrate the workloads from ECS to EKS for more advanced orchestration capabilities.
>
> より高度なオーケストレーション機能を利用するために、ワークロードをECSからEKSに移行してください。

---

### RDS

**正式名称:** Amazon Relational Database Service

**意味:** AWSのマネージドリレーショナルデータベースサービス（MySQL、PostgreSQL等に対応）

> Provision an RDS instance with Multi-AZ deployment for high availability.
>
> 高可用性のために、マルチAZデプロイメントのRDSインスタンスをプロビジョニングしてください。

---

## 5. データ（Data）

データベース、データ形式、データ処理に関する略語です。

---

### SQL

**正式名称:** Structured Query Language

**意味:** リレーショナルデータベースを操作するための標準的なクエリ言語

> Write a SQL query to retrieve all active users created in the last 30 days.
>
> 過去30日以内に作成されたすべてのアクティブユーザーを取得するSQLクエリを書いてください。

---

### NoSQL

**正式名称:** Not Only SQL

**意味:** リレーショナルモデル以外のデータベースの総称（ドキュメント型、キーバリュー型、グラフ型など）

> Use a NoSQL database like MongoDB for flexible schema design.
>
> 柔軟なスキーマ設計のために、MongoDBのようなNoSQLデータベースを使用してください。

---

### ACID

**正式名称:** Atomicity, Consistency, Isolation, Durability

**意味:** トランザクションが満たすべき4つの性質（原子性、一貫性、分離性、永続性）

> The database engine guarantees ACID compliance for all transactions.
>
> データベースエンジンはすべてのトランザクションに対してACID準拠を保証します。

---

### BASE

**正式名称:** Basically Available, Soft state, Eventually consistent

**意味:** ACID の対極にある、分散システム向けのデータ整合性モデル（基本的に利用可能、柔軟な状態、結果整合性）

> NoSQL databases often follow the BASE model instead of strict ACID compliance.
>
> NoSQLデータベースは厳密なACID準拠の代わりに、BASEモデルに従うことが多いです。

---

### CAP

**正式名称:** Consistency, Availability, Partition tolerance

**意味:** 分散システムにおいて、一貫性・可用性・分断耐性の3つを同時に完全には満たせないという定理

> According to the CAP theorem, a distributed system must sacrifice one of the three guarantees.
>
> CAP定理によれば、分散システムは3つの保証のうち1つを犠牲にしなければなりません。

---

### ETL

**正式名称:** Extract, Transform, Load

**意味:** データを抽出・変換・格納するプロセス。データウェアハウスやデータパイプラインで使われる

> Build an ETL pipeline to migrate data from the legacy system to the new database.
>
> レガシーシステムから新しいデータベースにデータを移行するためのETLパイプラインを構築してください。

---

### OLTP

**正式名称:** Online Transaction Processing

**意味:** リアルタイムのトランザクション処理（注文処理、在庫更新など）に最適化されたシステム

> Use an OLTP database for handling real-time user transactions.
>
> リアルタイムのユーザートランザクションを処理するために、OLTPデータベースを使用してください。

---

### OLAP

**正式名称:** Online Analytical Processing

**意味:** 大量のデータを集計・分析するための処理に最適化されたシステム

> OLAP databases are optimized for complex analytical queries across large datasets.
>
> OLAPデータベースは大規模データセットに対する複雑な分析クエリに最適化されています。

---

### JSON

**正式名称:** JavaScript Object Notation

**意味:** 軽量なデータ交換フォーマット。Web APIのリクエスト・レスポンスで最も一般的に使われる

> The API returns data in JSON format by default.
>
> APIはデフォルトでJSON形式でデータを返します。

**発音:** 「ジェイソン」。

---

### XML

**正式名称:** Extensible Markup Language

**意味:** タグベースの汎用的なデータ記述言語。設定ファイルやSOAP APIで使われる

> Parse the XML response and extract the relevant data elements.
>
> XMLレスポンスをパースして、関連するデータ要素を抽出してください。

---

### YAML

**正式名称:** YAML Ain't Markup Language

**意味:** 人間が読みやすいデータ直列化フォーマット。設定ファイルで広く使われる

> Define the CI/CD pipeline configuration in a YAML file.
>
> CI/CDパイプラインの設定をYAMLファイルで定義してください。

**注意:** 元は "Yet Another Markup Language" の略だったが、現在は再帰的略語として定義されている。

---

### CSV

**正式名称:** Comma-Separated Values

**意味:** カンマ区切りのテキストデータ形式。表形式のデータのエクスポート・インポートに使われる

> Export the report data as a CSV file for further analysis in a spreadsheet.
>
> スプレッドシートでの追加分析のために、レポートデータをCSVファイルとしてエクスポートしてください。

---

## 6. 一般・標準化団体（General & Standards）

IT業界全体で使われる一般的な略語と、標準化団体の名称です。

---

### RFC

**正式名称:** Request for Comments

**意味:** インターネット技術の仕様書。IETF が発行する技術標準文書

> The implementation follows RFC 7519 for JSON Web Token handling.
>
> この実装はJSON Web Tokenの処理についてRFC 7519に準拠しています。

---

### IETF

**正式名称:** Internet Engineering Task Force

**意味:** インターネット技術の標準化を推進する団体。RFCを発行する

> The IETF published a new RFC defining the HTTP/3 protocol.
>
> IETFはHTTP/3プロトコルを定義する新しいRFCを公開しました。

---

### W3C

**正式名称:** World Wide Web Consortium

**意味:** Web技術の標準化団体。HTML、CSS、Accessibility などの仕様を策定する

> The component follows W3C accessibility guidelines for screen reader compatibility.
>
> コンポーネントはスクリーンリーダーとの互換性のためにW3Cアクセシビリティガイドラインに準拠しています。

---

### ECMA

**正式名称:** European Computer Manufacturers Association（現在は Ecma International）

**意味:** 情報通信技術の標準化団体。JavaScript の仕様（ECMAScript）で知られる

> JavaScript is standardized as ECMAScript by Ecma International.
>
> JavaScriptはEcma InternationalによってECMAScriptとして標準化されています。

---

### IEEE

**正式名称:** Institute of Electrical and Electronics Engineers

**意味:** 電気電子工学の学術・標準化団体。IEEE 802.11（Wi-Fi）などの規格で知られる

> The network protocol complies with IEEE 802.1X for port-based authentication.
>
> ネットワークプロトコルはポートベース認証のIEEE 802.1Xに準拠しています。

**発音:** 「アイ・トリプル・イー」。

---

### POSIX

**正式名称:** Portable Operating System Interface

**意味:** Unix系OSの互換性を保つためのAPI仕様

> The file path handling follows POSIX conventions for cross-platform compatibility.
>
> ファイルパスの扱いは、クロスプラットフォーム互換性のためにPOSIX規約に従います。

---

### ASCII

**正式名称:** American Standard Code for Information Interchange

**意味:** 英数字と制御文字を7ビットで表現する文字コード規格

> The input must contain only ASCII characters.
>
> 入力にはASCII文字のみを含める必要があります。

---

### UTF-8

**正式名称:** Unicode Transformation Format - 8-bit

**意味:** Unicodeの文字エンコーディング方式。Webの標準文字コード

> Set the file encoding to UTF-8 to support multilingual content.
>
> 多言語コンテンツをサポートするために、ファイルエンコーディングをUTF-8に設定してください。

---

### MIME

**正式名称:** Multipurpose Internet Mail Extensions

**意味:** ファイルの種類を示す識別子（例: `text/html`、`application/json`）

> Set the `Content-Type` header to the appropriate MIME type for the response.
>
> レスポンスに適切なMIMEタイプを `Content-Type` ヘッダーに設定してください。

---

### UUID

**正式名称:** Universally Unique Identifier

**意味:** 世界中で一意であることが保証される128ビットの識別子

> Generate a UUID for each new record to avoid ID collisions.
>
> ID衝突を避けるために、各新規レコードにUUIDを生成してください。

---

### GUID

**正式名称:** Globally Unique Identifier

**意味:** UUIDと実質的に同じ概念。Microsoft の技術文書で使われることが多い

> The API returns a GUID as the unique identifier for each resource.
>
> APIは各リソースの一意識別子としてGUIDを返します。

**注意:** UUID と GUID はほぼ同義。UUID がより一般的な用語。

---

### CLI

**正式名称:** Command-Line Interface

**意味:** コマンドラインで操作するインターフェース。GUIの対義語

> Use the CLI tool to scaffold a new project.
>
> CLIツールを使って新しいプロジェクトをスキャフォールドしてください。

---

### GUI

**正式名称:** Graphical User Interface

**意味:** グラフィカル（視覚的）なユーザーインターフェース

> The application provides both a GUI and a CLI for managing configurations.
>
> アプリケーションは設定管理のためにGUIとCLIの両方を提供しています。

**発音:** 「グーイ」。

---

### IDE

**正式名称:** Integrated Development Environment

**意味:** コードエディタ、デバッガ、ビルドツールなどを統合した開発環境

> Configure your IDE to use the project's ESLint configuration.
>
> プロジェクトのESLint設定を使用するようにIDEを設定してください。

---

### PR

**正式名称:** Pull Request

**意味:** コードの変更をレビュー・マージするためのリクエスト（GitHub用語）

> Submit a PR with the bug fix and assign it to the reviewer.
>
> バグ修正を含むPRを提出し、レビュアーに割り当ててください。

**注意:** GitLab では Merge Request (MR) と呼ばれる。

---

## 略語の読み方のコツ

### 1. 略語の種類を見分ける

IT略語には大きく3つの種類があります。

| 種類 | 説明 | 例 |
|------|------|-----|
| 頭字語（Acronym） | 各単語の頭文字を並べたもの。単語として読む | REST（レスト）、SAML（サムル） |
| イニシャリズム | 各文字をアルファベットとして読む | API（エー・ピー・アイ）、HTTP（エイチ・ティー・ティー・ピー） |
| 混合型 | 一部だけ単語として読む | YAML（ヤムル）、SQL（エス・キュー・エル or シークェル） |

### 2. 文脈から意味を推測する

知らない略語に出会ったとき、以下の手がかりから推測できることがあります。

**手がかり1: 初出で正式名称が添えられている**
```
Configure RBAC (Role-Based Access Control) for the API.
```
技術文書では、略語の初出時にカッコで正式名称を記載するのが一般的です。

**手がかり2: 周辺の単語から推測する**
```
The ETL pipeline extracts data from the source, transforms it, and loads it into the warehouse.
```
「extract」「transform」「load」という動詞がそのまま ETL の各文字に対応しています。

**手がかり3: カテゴリを意識する**
- セキュリティの文脈 → CORS, CSRF, XSS, JWT, RBAC 等
- データベースの文脈 → SQL, ORM, ACID, OLTP 等
- クラウドの文脈 → EC2, S3, VPC, IAM 等

### 3. 混同しやすい略語を区別する

| 略語 | 意味 | 混同しやすい略語 |
|------|------|----------------|
| SSR | Server-Side Rendering | SSG（Static Site Generation） |
| SSL | Secure Sockets Layer | SLA（Service Level Agreement） |
| SLA | Service Level Agreement | SLO（Service Level Objective） |
| ACL | Access Control List | ACL（Anterior Cruciate Ligament、医学用語） |
| CSR | Client-Side Rendering | CSRF（Cross-Site Request Forgery） |
| ORM | Object-Relational Mapping | ORM は他の分野では使われない |

### 4. AWS固有の略語に慣れる

AWSのドキュメントでは独自の略語が大量に使われます。代表的なものを把握しておくと、AWSの技術文書が読みやすくなります。

```
コンピューティング: EC2, ECS, EKS, Lambda
ストレージ: S3, EBS, EFS
データベース: RDS, DynamoDB, ElastiCache
ネットワーク: VPC, ALB/NLB, Route 53, CloudFront
セキュリティ: IAM, KMS, WAF
```

他のクラウド（GCP、Azure）にも同様のサービスと略語がありますが、まずAWSの略語を覚えておくと、他のクラウドの類似サービスも理解しやすくなります。
