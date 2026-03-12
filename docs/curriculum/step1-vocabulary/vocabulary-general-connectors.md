# 一般英語 接続語・副詞（2,000〜3,000語レベル）

## 概要

IT技術文書を読む際、専門用語（deploy、configure など）を知っているだけでは文章全体の意味を正確に掴むことはできません。文と文、節と節をつなぐ**接続語（前置詞・接続詞）と副詞**こそが、技術文書の論理構造を形作る「糊（のり）」の役割を果たしています。

たとえば、公式ドキュメントでは「AだがBである（対比）」「Aの結果Bとなる（因果）」「Aに加えてBもある（追加）」といった論理関係が頻繁に表現されます。これらの接続語・副詞を知らなければ、個々の単語がわかっても**文と文のつながりが見えず、段落の論旨を見失う**ことになります。

本ページでは、IT文書で頻出する接続語・副詞を2つのカテゴリに分類し、それぞれの論理的な役割とともに解説します。例文はすべて、実際のIT公式ドキュメントに登場するスタイルで記載しています。

---

## 1. 前置詞・接続詞（Prepositions & Conjunctions）

前置詞と接続詞は、文の中で**条件・対比・原因・結果**といった論理関係を明示する語です。IT文書では、仕様の違いを説明したり、注意事項を提示したりする場面で欠かせません。日常会話では but、so、about で済むところを、技術文書ではより正確で形式的な語（whereas、hence、regarding）が使われます。

---

### whereas（接続詞）

**意味:** 〜であるのに対して、一方では（対比を表す）

> `let` declarations are block-scoped, whereas `var` declarations are function-scoped.
>
> `let` 宣言はブロックスコープであるのに対して、`var` 宣言は関数スコープです。

**関連語:** while（接続詞: 〜する一方で、whereas より口語的）、in contrast（副詞句: 対照的に）

---

### although（接続詞）

**意味:** 〜であるけれども、〜にもかかわらず（譲歩を表す）

> Although this approach works for simple cases, it does not scale well for large applications.
>
> このアプローチは単純なケースでは機能するけれども、大規模なアプリケーションにはうまくスケールしません。

**関連語:** though（接続詞/副詞: 〜だけれども、although よりカジュアル）、even though（接続詞: たとえ〜であっても、強調形）

---

### despite（前置詞）

**意味:** 〜にもかかわらず（名詞句を伴って譲歩を表す）

> Despite the breaking changes, the migration path is straightforward.
>
> 破壊的変更にもかかわらず、移行パスは簡単です。

**関連語:** in spite of（前置詞句: 〜にもかかわらず、despite と同義）、despite the fact that（接続詞句: 〜という事実にもかかわらず、節を伴う形）

---

### regarding（前置詞）

**意味:** 〜に関して、〜について（話題を導入する）

> For more information regarding browser compatibility, see the compatibility table below.
>
> ブラウザの互換性に関する詳細については、下の互換性テーブルを参照してください。

**関連語:** concerning（前置詞: 〜に関して、regarding と同義）、with regard to（前置詞句: 〜に関して、よりフォーマル）、about（前置詞: 〜について、カジュアル）

---

### concerning（前置詞）

**意味:** 〜に関して、〜について（regarding とほぼ同義）

> There are several known issues concerning memory leaks in earlier versions.
>
> 以前のバージョンにおけるメモリリークに関して、いくつかの既知の問題があります。

**関連語:** regarding（前置詞: 〜に関して）、with respect to（前置詞句: 〜に関して）

---

### throughout（前置詞/副詞）

**意味:** 〜の全体を通じて、〜の間ずっと（範囲の全体を表す）

> This convention is used consistently throughout the codebase.
>
> この規約はコードベース全体を通じて一貫して使われています。

**関連語:** across（前置詞: 〜にわたって）、all through（副詞句: 〜の全体を通じて、throughout のカジュアル形）

---

### upon（前置詞）

**意味:** 〜した時に、〜するとすぐに（タイミングを表す、on のフォーマル形）

> Upon receiving the response, the client parses the JSON body.
>
> レスポンスを受信すると、クライアントはJSONボディをパースします。

**関連語:** on（前置詞: 〜した時に、upon のカジュアル形）、once（接続詞: 一度〜すると）

---

### via（前置詞）

**意味:** 〜を経由して、〜を通じて（手段・経路を表す）

> You can configure the application via environment variables or a configuration file.
>
> 環境変数または設定ファイルを通じて、アプリケーションを設定できます。

**関連語:** through（前置詞: 〜を通じて、via よりカジュアル）、by means of（前置詞句: 〜によって、フォーマル）

---

### hence（副詞）

**意味:** したがって、それゆえに（前述の内容から結果を導く）

> The function is pure and has no side effects; hence, it is safe to call multiple times.
>
> この関数は純粋で副作用がありません。したがって、複数回呼び出しても安全です。

**関連語:** therefore（副詞: したがって）、thus（副詞: このように、したがって）、so（接続詞: だから、カジュアル）

---

### thus（副詞）

**意味:** このように、したがって（方法または結果を表す）

> The component re-renders only when its props change, thus avoiding unnecessary DOM updates.
>
> コンポーネントはプロパティが変更された時のみ再レンダリングされ、このようにして不要なDOM更新を回避します。

**関連語:** therefore（副詞: したがって）、hence（副詞: それゆえに）、in this way（副詞句: このようにして）

---

### therefore（副詞）

**意味:** したがって、そのため（原因から結果への論理的帰結を示す）

> The API key is sensitive information and should therefore not be committed to version control.
>
> APIキーは機密情報であり、したがってバージョン管理にコミットすべきではありません。

**関連語:** hence（副詞: それゆえに）、thus（副詞: このように）、consequently（副詞: 結果として）、so（接続詞: だから、カジュアル）

---

### furthermore（副詞）

**意味:** さらに、その上（追加情報を導入する）

> This method is more efficient. Furthermore, it is easier to maintain.
>
> この方法はより効率的です。さらに、保守も容易です。

**関連語:** moreover（副詞: さらに、その上）、in addition（副詞句: 加えて）、also（副詞: また、カジュアル）

---

### moreover（副詞）

**意味:** さらに、その上（前の情報をさらに強化する追加情報）

> The library is lightweight and fast. Moreover, it has zero dependencies.
>
> このライブラリは軽量で高速です。さらに、依存関係がゼロです。

**関連語:** furthermore（副詞: さらに）、additionally（副詞: 加えて）、besides（副詞: その上）

---

### nevertheless（副詞）

**意味:** それにもかかわらず、それでもなお（前述と矛盾する事実を導入）

> The feature is experimental and may change in future releases. Nevertheless, it is already widely used in production.
>
> この機能は実験的であり、将来のリリースで変更される可能性があります。それにもかかわらず、すでに本番環境で広く使われています。

**関連語:** nonetheless（副詞: それにもかかわらず、nevertheless と同義）、however（副詞: しかしながら）、still（副詞: それでも、カジュアル）

---

### accordingly（副詞）

**意味:** それに応じて、したがって（前述の状況に合わせた対応を示す）

> The API response format has changed in v3. Please update your client code accordingly.
>
> v3でAPIレスポンスの形式が変更されました。それに応じてクライアントコードを更新してください。

**関連語:** correspondingly（副詞: それに対応して）、as a result（副詞句: 結果として）

---

## 2. 副詞（Adverbs）

副詞は、動詞・形容詞・文全体を修飾して**程度・頻度・方法・確実性**を伝えます。IT文書では、仕様の正確な説明に不可欠です。「通常はこう動作する」「明示的に指定する必要がある」「以前のバージョンでは」など、副詞一つで文の意味が大きく変わるため、見逃すと仕様を誤解するリスクがあります。

---

### typically（副詞）

**意味:** 通常は、一般的に（標準的なケースを説明する）

> This value is typically set to `true` in production environments.
>
> この値は本番環境では通常 `true` に設定されます。

**文中の位置:** 文頭（Typically, ...）または動詞の前（is typically set）に置かれることが多い。

**関連語:** usually（副詞: 普通は、typically よりカジュアル）、generally（副詞: 一般的に）、normally（副詞: 通常は）

---

### essentially（副詞）

**意味:** 本質的に、要するに（核心的な説明を導入する）

> A closure is essentially a function that retains access to its outer scope.
>
> クロージャとは、本質的に外側のスコープへのアクセスを保持する関数です。

**文中の位置:** be動詞の後（is essentially ...）または文頭（Essentially, ...）が一般的。

**関連語:** fundamentally（副詞: 根本的に）、basically（副詞: 基本的に、essentially よりカジュアル）、in essence（副詞句: 本質的に）

---

### explicitly（副詞）

**意味:** 明示的に、はっきりと（意図的に指定することを表す）

> You must explicitly enable this feature by setting the flag to `true`.
>
> このフラグを `true` に設定して、この機能を明示的に有効にする必要があります。

**文中の位置:** 動詞の前（explicitly enable）に置かれることが多い。

**関連語:** implicitly（副詞: 暗黙的に、反義語）、explicit（形容詞: 明示的な）

---

### implicitly（副詞）

**意味:** 暗黙的に、明示しなくても自動的に（明確な指定なしに行われることを表す）

> When you use `async/await`, the function implicitly returns a Promise.
>
> `async/await` を使うと、関数は暗黙的に Promise を返します。

**文中の位置:** 動詞の前（implicitly returns）に置かれることが多い。

**関連語:** explicitly（副詞: 明示的に、反義語）、implicit（形容詞: 暗黙の）

---

### respectively（副詞）

**意味:** それぞれ（複数の項目を対応させて説明する）

> The `width` and `height` properties are set to `100` and `200`, respectively.
>
> `width` と `height` プロパティはそれぞれ `100` と `200` に設定されます。

**文中の位置:** ほぼ常に文末に置かれる。

**関連語:** each（副詞: それぞれ、respectively より汎用的）

---

### approximately（副詞）

**意味:** およそ、約（正確ではない数値を示す）

> The build process takes approximately 30 seconds on a standard machine.
>
> ビルドプロセスは標準的なマシンでおよそ30秒かかります。

**文中の位置:** 数値の直前（approximately 30 seconds）に置かれることが多い。

**関連語:** roughly（副詞: おおよそ、approximately よりカジュアル）、about（副詞: 約、最もカジュアル）、approx.（略語）

---

### previously（副詞）

**意味:** 以前は、前に（過去の状態や旧バージョンを参照する）

> This method was previously called `getInitialProps` but has been renamed in v13.
>
> このメソッドは以前 `getInitialProps` と呼ばれていましたが、v13で名前が変更されました。

**文中の位置:** 文頭（Previously, ...）または動詞の前（was previously called）が一般的。

**関連語:** formerly（副詞: かつては、previously よりフォーマル）、before（副詞: 前に、カジュアル）

---

### subsequently（副詞）

**意味:** その後、続いて（時間的な順序を示す）

> The data is fetched on the server and subsequently passed to the client component as props.
>
> データはサーバー上でフェッチされ、その後プロパティとしてクライアントコンポーネントに渡されます。

**文中の位置:** 文頭（Subsequently, ...）または動詞の前（subsequently passed）に置かれる。

**関連語:** afterward(s)（副詞: その後）、then（副詞: それから、カジュアル）、later（副詞: 後で）

---

### alternatively（副詞）

**意味:** あるいは、別の方法として（代替手段を提示する）

> You can install the package using npm. Alternatively, you can use yarn or pnpm.
>
> npm を使ってパッケージをインストールできます。あるいは、yarn や pnpm を使うこともできます。

**文中の位置:** ほぼ常に文頭（Alternatively, ...）に置かれる。

**関連語:** alternatively（形容詞形: alternative = 代替の）、or（接続詞: または、カジュアル）、instead（副詞: 代わりに）

---

### potentially（副詞）

**意味:** 潜在的に、〜する可能性がある（リスクや可能性を示す）

> This operation is potentially destructive and cannot be undone.
>
> この操作は潜在的に破壊的であり、元に戻すことができません。

**文中の位置:** 形容詞の前（potentially destructive）または動詞の前に置かれる。

**関連語:** possibly（副詞: もしかすると）、potential（形容詞: 潜在的な、名詞: 可能性）

---

### significantly（副詞）

**意味:** 大幅に、著しく（顕著な変化や差異を示す）

> Enabling caching can significantly reduce the response time.
>
> キャッシュを有効にすると、レスポンス時間を大幅に短縮できます。

**文中の位置:** 動詞の前（significantly reduce）または形容詞の前に置かれることが多い。

**関連語:** considerably（副詞: かなり）、substantially（副詞: 相当に）、significant（形容詞: 重要な、著しい）

---

### occasionally（副詞）

**意味:** 時々、まれに（頻度が低いことを示す）

> The connection may occasionally time out due to network instability.
>
> ネットワークの不安定さにより、接続が時々タイムアウトすることがあります。

**文中の位置:** 動詞の前（may occasionally time out）または文頭（Occasionally, ...）に置かれる。

**関連語:** sometimes（副詞: 時々、occasionally よりカジュアル）、intermittently（副詞: 断続的に）、occasional（形容詞: 時折の）

---

## 学習のコツ

### 1. フォーマル度を意識する（Formal vs Informal）

IT技術文書は一般的にフォーマルな文体で書かれます。日常会話で使うカジュアルな語と、ドキュメントで使われるフォーマルな語の対応を知っておくと、読解速度が上がります。

| フォーマル（文書向け） | カジュアル（会話向け） | 意味 |
|----------------------|---------------------|------|
| therefore | so | したがって |
| although | though | 〜だけれども |
| furthermore | also | さらに |
| nevertheless | still / but | それにもかかわらず |
| hence | so / that's why | それゆえに |
| via | through | 〜を経由して |
| upon | on / when | 〜した時に |
| regarding | about | 〜に関して |
| approximately | about / around | およそ |
| previously | before | 以前は |
| subsequently | then / after that | その後 |
| typically | usually | 通常は |

### 2. ペアで覚える対義語・対比語

接続語と副詞の多くは対になって使われます。片方を覚えたら、もう片方もセットで覚えましょう。

| 語A | 語B | 関係 |
|-----|-----|------|
| explicitly | implicitly | 明示 vs 暗黙 |
| previously | subsequently | 以前 vs その後 |
| furthermore / moreover | nevertheless / however | 追加 vs 逆接 |
| although / despite | therefore / hence | 譲歩 vs 帰結 |
| whereas | similarly | 対比 vs 類似 |

### 3. 句読点パターンを覚える

接続語は句読点との組み合わせで使い方が決まります。これを知っていると、文構造の解析が速くなります。

```
セミコロン + 副詞 + コンマ:
  The API is stable; however, breaking changes may occur in major versions.
  The function is pure; therefore, it can be safely memoized.

コンマ + 接続詞:
  The feature is useful, although it has some limitations.

文頭 + コンマ:
  Nevertheless, this approach is recommended for most use cases.
  Alternatively, you can use the CLI to configure the settings.

文中挿入（コンマで挟む）:
  The API key should, therefore, be stored in environment variables.
```

### 4. 論理関係のグループで整理する

接続語を「どんな論理関係を表すか」でグループ化して覚えると、文章の流れが読みやすくなります。

| 論理関係 | 接続語・副詞 |
|---------|------------|
| 対比（AとBは違う） | whereas, although, despite, nevertheless |
| 追加（AだけでなくBも） | furthermore, moreover, additionally |
| 結果（Aだから B） | therefore, hence, thus, accordingly |
| 手段（〜を通じて） | via, through, upon |
| 話題（〜について） | regarding, concerning |
| 代替（AでなくてもBで可） | alternatively, instead |
| 時間（前→後） | previously, subsequently |
