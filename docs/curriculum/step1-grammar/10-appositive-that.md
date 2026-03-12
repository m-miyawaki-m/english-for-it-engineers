# 同格の that 節

## 概要

IT技術文書では、「〜という事実」「〜という要件」「〜という前提」のように、名詞の内容を that 節で具体的に説明するパターンが非常に多く登場します。この「同格の that」は、関係代名詞の that とは異なる構文であり、技術文書を正確に読むために欠かせない知識です。仕様書、設計文書、バグレポートなど、あらゆる場面で使われます。

## 基本ルール

### 同格の that とは

「名詞 + that + 完全な文」の形で、that 節が前の名詞の内容を説明する構文です。

> **The fact** that the server crashed indicates a memory leak.
>
> （サーバーがクラッシュした**という事実**は、メモリリークを示しています。）

### 同格の that をとりやすい名詞

IT技術文書で特に多いものを太字にしています。

| カテゴリ | 名詞 |
|---------|------|
| 事実・状況 | **fact**, evidence, indication, sign |
| 前提・仮定 | **assumption**, premise, hypothesis |
| 要件・条件 | **requirement**, condition, constraint, restriction |
| 可能性・保証 | **guarantee**, possibility, chance, risk, likelihood |
| 主張・提案 | claim, suggestion, proposal, recommendation, **idea** |
| 注意・警告 | **note**, warning, caveat, reminder |
| 結論・結果 | conclusion, result, finding |

### 同格の that と関係代名詞の that の見分け方

| | 同格の that | 関係代名詞の that |
|---|------------|-----------------|
| that 節の構造 | **完全な文**（主語+動詞が揃っている） | **不完全な文**（主語か目的語が欠けている） |
| 名詞との関係 | 名詞の**内容**を説明する | 名詞を**修飾**（限定）する |
| that の省略 | 省略**しにくい** | 省略**できる**（目的格の場合） |

**同格の that:**
> The **fact** that the API returns JSON...
>
> （that 節は完全な文: the API returns JSON）

**関係代名詞の that:**
> The **error** that occurred during deployment...
>
> （that 節は不完全: occurred の主語 = that = the error）

## IT技術文書での頻出パターン

### パターン1: the fact that ...（〜という事実）

事実を述べた上で、その意味や影響を論じるときに使います。

> **The fact that** the server crashed during peak hours indicates a capacity issue.
>
> （ピーク時にサーバーがクラッシュしたという事実は、キャパシティの問題を示しています。）

### パターン2: no guarantee that ...（〜という保証はない）

技術的な注意事項や制約を説明するときに頻出します。API ドキュメントでよく見かけます。

> There is **no guarantee that** the callback will be invoked synchronously.
>
> （コールバックが同期的に呼び出されるという保証はありません。）

### パターン3: the requirement that ...（〜という要件）

仕様書や設計文書で、要件を明確に述べるときに使います。

> **The requirement that** all API endpoints return consistent error formats was introduced in v3.
>
> （すべてのAPIエンドポイントが一貫したエラーフォーマットを返すという要件は、v3で導入されました。）

### パターン4: the assumption that ...（〜という前提）

設計上の前提や仮定を明示するときに使います。

> This design is based on **the assumption that** network latency will remain below 100ms.
>
> （この設計は、ネットワークレイテンシが100ms以下に保たれるという前提に基づいています。）

### パターン5: Note that ...（〜に注意してください）

技術文書の注意書きで極めて頻出するパターンです。厳密には「Note + that 節」で、命令文の中で同格の that が使われています。

> **Note that** this method is deprecated and will be removed in the next major version.
>
> （このメソッドは非推奨であり、次のメジャーバージョンで削除される点に注意してください。）

## 実例

以下は実際のIT文書で見かける典型的な例文です。

**1. API ドキュメント（注意書き）**

> Note that this method is **not** thread-safe and should not be called from multiple threads simultaneously.
>
> （このメソッドはスレッドセーフではなく、複数のスレッドから同時に呼び出すべきではない点に注意してください。）

**2. リリースノート（変更点の背景説明）**

> Due to the fact that the old parser could not handle nested structures, we have rewritten it from scratch.
>
> （旧パーサーがネストされた構造を処理できなかったという事実のため、ゼロから書き直しました。）

**3. 仕様書（要件の記述）**

> The requirement that all fields be validated on the server side was added in v3.
>
> （すべてのフィールドがサーバー側でバリデーションされるという要件が、v3で追加されました。）

**4. 設計文書（前提の明示）**

> We operate under the assumption that users will have a stable internet connection.
>
> （ユーザーが安定したインターネット接続を持っているという前提のもとで運用しています。）

**5. バグレポート（問題の特定）**

> The evidence that the memory leak occurs only under high load suggests a concurrency issue.
>
> （メモリリークが高負荷時にのみ発生するという証拠は、並行処理の問題を示唆しています。）

**6. セキュリティ文書（リスクの指摘）**

> There is a risk that expired tokens may still be accepted if the cache is not properly invalidated.
>
> （キャッシュが適切に無効化されない場合、期限切れのトークンがまだ受け入れられるリスクがあります。）

**7. 技術提案書**

> The idea that we should migrate to a microservices architecture was discussed in last week's meeting.
>
> （マイクロサービスアーキテクチャに移行すべきだというアイデアは、先週のミーティングで議論されました。）

**8. ドキュメント（制約の説明）**

> Be aware of the limitation that this library does not support streaming responses in serverless environments.
>
> （このライブラリがサーバーレス環境でストリーミングレスポンスをサポートしないという制約に注意してください。）

## よくある誤読パターン

### 1. 同格の that を関係代名詞の that と混同する

> The **assumption** that the database is always available is dangerous.

この that は関係代名詞ではなく同格の that です。「データベースが常に利用可能であるという前提」が正しい読み方です。that 以下が完全な文（the database is always available）であることが手がかりです。

もし関係代名詞なら「常に利用可能な前提」ではなく意味が通りません。

### 2. Note that を「ノートする」と読んでしまう

> Note that this feature requires Node.js 18 or higher.

`Note that` は「〜に注意してください」という意味の定型表現です。「ノートしてください」ではありません。技術文書では極めて頻繁に登場するので、セットで覚えましょう。

### 3. the fact that を形式的な表現だと読み飛ばす

> Despite the fact that the tests passed, the deployment failed.

`despite the fact that` は「〜にもかかわらず」という重要な論理関係を示しています。`the fact that` を読み飛ばすと、テストとデプロイメントの関係を見失います。

### 4. 仮定法の that 節を見落とす

> The requirement that all fields **be** validated...

`be validated` の `be` は仮定法現在（subjunctive）です。requirement, suggestion, recommendation などの名詞の後の that 節では、動詞が原形になることがあります。`is validated` ではなく `be validated` となっていても誤りではなく、フォーマルな表現です。

## 練習：次の英文を読んで意味を取ってみよう

以下の英文を読み、日本語で意味を書いてみてください。

---

**問題1:**

> There is no guarantee that the event listeners will be called in the order they were registered.

<details>
<summary>解答を見る</summary>

イベントリスナーが登録された順序で呼び出されるという保証はありません。

- no guarantee that ... の同格構文
- they were registered の they = the event listeners
- in the order (that) they were registered: 「登録された順序で」（order の後の that は関係副詞的用法で省略されている）

</details>

---

**問題2:**

> The team reached the conclusion that the monolithic architecture was no longer sustainable for the growing user base.

<details>
<summary>解答を見る</summary>

チームは、増加するユーザーベースに対してモノリシックアーキテクチャはもはや持続可能ではないという結論に達しました。

- the conclusion that ... の同格構文
- no longer は「もはや〜ない」
- sustainable は「持続可能な」

</details>

---

**問題3:**

> Note that calling this function after the component has been unmounted will result in a warning being logged to the console.

<details>
<summary>解答を見る</summary>

コンポーネントがアンマウントされた後にこの関数を呼び出すと、コンソールに警告がログ出力される点に注意してください。

- Note that ... は「〜に注意してください」
- calling this function は動名詞（主語）
- after the component has been unmounted は時間の条件
- will result in ... は「〜という結果になる」
- a warning being logged は動名詞の受動態

</details>
