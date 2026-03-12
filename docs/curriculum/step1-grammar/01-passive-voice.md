# 受動態（Passive Voice）

## 概要

IT技術文書は受動態が非常に多い文書ジャンルです。これは「誰がやるか」よりも「何が起こるか」を重視するためです。APIドキュメントでは「リクエストが処理される」「ファイルが保存される」のように、動作の対象を主語にした文が大半を占めます。

受動態のパターンを把握すると、技術文書の大部分をスムーズに読めるようになります。

---

## 基本ルール

### 受動態の構造

```
主語 + be動詞 + 過去分詞（+ by 動作主）
```

| 時制 | 能動態 | 受動態 |
|------|-------|-------|
| 現在形 | The server processes the request. | The request **is processed** by the server. |
| 過去形 | The team fixed the bug. | The bug **was fixed** by the team. |
| 現在完了 | We have deprecated this method. | This method **has been deprecated**. |
| 助動詞 | You must save the file. | The file **must be saved**. |
| 助動詞 + 完了 | They should have updated it. | It **should have been updated**. |

### IT文書で受動態が好まれる理由

1. **客観性** - 「私」「あなた」を使わず、事実を述べられる
2. **動作の対象に焦点** - 「リクエストが」「ファイルが」「設定が」のように、対象物を主語にできる
3. **行為者が不明・不要** - 「（システムによって）処理される」のように、誰がやるか不要な場合

---

## IT技術文書での頻出パターン

### パターン 1: 現在形の受動態（is/are + 過去分詞）

仕様や動作の説明で最も基本的なパターンです。

```
The request is processed asynchronously.
```

「リクエストは非同期で処理される」。現在の仕様・仕組みを述べる。

### パターン 2: 現在完了の受動態（has/have been + 過去分詞）

バージョン変更や状態変化の説明で頻出します。

```
This feature has been deprecated since v2.0.
```

「この機能はv2.0以降、非推奨になっている」。過去から現在まで続く状態。

### パターン 3: 助動詞 + 受動態（must/can/should/will be + 過去分詞）

要件、制約、将来の動作の説明で使います。

```
The file must be saved before the build can be triggered.
```

「ビルドが開始される前に、ファイルが保存されなければならない」。

### パターン 4: 条件節内の受動態（if... is + 過去分詞）

条件分岐での受動態。APIドキュメントで非常に多い。

```
If no value is provided, the default will be used.
```

「値が提供されない場合、デフォルトが使用される」。

### パターン 5: 受動態 + 前置詞句（is + 過去分詞 + by/with/to/from）

動作主や手段を示す受動態。

```
The configuration is loaded from the environment variables.
```

「設定は環境変数から読み込まれる」。from, by, with などの前置詞に注目。

---

## 実例（IT文書風の例文）

### 例文 1
> The request is processed asynchronously.

**和訳:** リクエストは非同期で処理されます。

**解説:** 最も基本的な受動態。「誰が処理するか」ではなく「リクエストがどう処理されるか」に焦点。

---

### 例文 2
> This feature has been deprecated since v2.0.

**和訳:** この機能はv2.0以降、非推奨になっています。

**解説:** 現在完了の受動態。has been + 過去分詞。since v2.0 で「いつから」を示す。

---

### 例文 3
> The file must be saved before the build can be triggered.

**和訳:** ビルドが開始される前に、ファイルを保存しなければなりません。

**解説:** 助動詞 must + be + 過去分詞。1文に受動態が2つ（must be saved / can be triggered）。

---

### 例文 4
> If no value is provided, the default will be used.

**和訳:** 値が提供されない場合、デフォルト値が使用されます。

**解説:** 条件節と主節の両方が受動態。APIドキュメントの定番パターン。

---

### 例文 5
> The event listeners are automatically removed when the component is unmounted.

**和訳:** コンポーネントがアンマウントされると、イベントリスナーは自動的に削除されます。

**解説:** 副詞 automatically が be と過去分詞の間に入るパターン。

---

### 例文 6
> All API responses are returned in JSON format.

**和訳:** すべてのAPIレスポンスはJSON形式で返されます。

**解説:** 受動態 + 前置詞句（in JSON format）。レスポンス仕様の説明。

---

### 例文 7
> The database connection is established when the application starts.

**和訳:** アプリケーションが起動すると、データベース接続が確立されます。

**解説:** when 節と組み合わせた受動態。起動時の動作説明。

---

### 例文 8
> Environment variables should be defined in a `.env` file and must not be committed to the repository.

**和訳:** 環境変数は `.env` ファイルで定義するべきであり、リポジトリにコミットしてはいけません。

**解説:** should be + 過去分詞と must not be + 過去分詞の並列。セキュリティ上の注意書き。

---

## よくある誤読パターン

### 1. be動詞のない受動態（過去分詞の形容詞的用法）を見落とす

```
The returned value is a string.
```

returned は「返された」で、value を修飾する過去分詞。be + 過去分詞の形ではないが、受動の意味を持つ。同様に以下のような表現もよく出現します:

- the **provided** options（提供されたオプション）
- the **specified** path（指定されたパス）
- the **expected** output（期待される出力）

### 2. 現在完了の受動態を現在形と混同する

```
The method has been removed.     （現在完了の受動態：削除された＝今はもう存在しない）
The method is removed.           （現在形の受動態：削除される＝仕様としてそう動く）
```

has been removed は「すでに削除された」という完了の意味を持ちます。is removed は「（条件に合うと）削除される」という現在の仕様を述べます。

### 3. 受動態の by 以下が省略されていることに気づかない

```
The request is validated.
```

「誰に/何に」検証されるかは書かれていません。IT文書では by 以下が省略されることが大半です。文脈から「サーバーが」「ミドルウェアが」「フレームワークが」検証すると判断する必要があります。

---

## 練習: 次の英文を読んで意味を取ってみよう

### 問題 1

> The cache is invalidated whenever the source data is updated.

<details>
<summary>解答を見る</summary>

**和訳:** ソースデータが更新されるたびに、キャッシュは無効化されます。

**ポイント:** 主節・副詞節ともに受動態。whenever は「〜するたびに」。
</details>

---

### 問題 2

> This endpoint has been deprecated and will be removed in the next major release.

<details>
<summary>解答を見る</summary>

**和訳:** このエンドポイントは非推奨になっており、次のメジャーリリースで削除される予定です。

**ポイント:** 現在完了の受動態（has been deprecated）と未来の受動態（will be removed）が並列。
</details>

---

### 問題 3

> Access tokens must be stored securely and should not be exposed in client-side code.

<details>
<summary>解答を見る</summary>

**和訳:** アクセストークンは安全に保管しなければならず、クライアントサイドのコードに公開してはいけません。

**ポイント:** must be stored と should not be exposed の2つの助動詞 + 受動態。セキュリティ要件の記述。
</details>
