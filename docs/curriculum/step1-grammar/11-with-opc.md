# 12. with + O + C 構文（付帯状況）

## 概要

`with + 名詞（O）+ 補語（C）` は、「〜が…の状態で」という付帯状況を表す構文である。IT技術文書では、設定の状態やオプションの ON/OFF を説明する際に非常に多く使われる。

この構文を読めると、公式リファレンスの設定説明・手順書・CLI のオプション解説がスムーズに読めるようになる。

---

## 基本ルール

### 構文の形

```
with + 名詞（O） + 補語（C）
```

補語（C）の部分には以下のものが来る:

| 補語の種類 | 例 | 意味 |
|---|---|---|
| 過去分詞 | with logging **enabled** | ロギングが**有効にされた**状態で |
| 現在分詞 | with the server **running** | サーバーが**動いている**状態で |
| 形容詞 | with this flag **active** | このフラグが**アクティブな**状態で |
| 前置詞句 | with the cursor **at the end** | カーソルが**末尾にある**状態で |

### 文中での位置

- **文頭:** With logging enabled, the application outputs debug information.
- **文末:** Run the tests with coverage reporting turned on.
- **文中（カンマで区切り）:** The server, with TLS enabled, listens on port 443.

---

## IT技術文書での頻出パターン

### パターン 1: with + 名詞 + 過去分詞（設定が有効/無効の状態で）

技術文書で最も多いパターン。設定やオプションの有効化・無効化を表す。

> With logging **enabled**, the application outputs debug information.
> （ロギングが有効な状態で、アプリケーションはデバッグ情報を出力する）

> Run the tests with verbose mode **disabled**.
> （verbose モードを無効にしてテストを実行する）

### パターン 2: with + 名詞 + 現在分詞（〜が動作中の状態で）

プロセスやサービスが稼働中であることを前提条件として述べる。

> With the server **running**, you can access the API at localhost:3000.
> （サーバーが動いている状態で、localhost:3000 の API にアクセスできる）

### パターン 3: with + 名詞 + 形容詞 / set to 〜（値が設定された状態で）

設定値の指定を説明する。`set to` は過去分詞だが、実質的に「〜に設定して」という意味で使われる。

> With this option **set to true**, the compiler skips type checking.
> （このオプションを true に設定すると、コンパイラは型チェックをスキップする）

### パターン 4: with + 名詞 + turned on / turned off

UI の設定やフラグの切り替えを説明する口語寄りの表現。

> Run the tests with coverage reporting **turned on**.
> （カバレッジレポートをオンにしてテストを実行する）

### パターン 5: with + 名詞 + 前置詞句（位置・状態の描写）

UI やエディタの状態描写で使われる。

> With the focus **on the input field**, press Enter to submit.
> （入力フィールドにフォーカスがある状態で、Enter を押して送信する）

---

## 実例（IT技術文書風の例文）

### 例文 1

> With logging enabled, the application outputs debug information.

**和訳:** ロギングが有効な状態で、アプリケーションはデバッグ情報を出力する。

**構造:** With logging(O) enabled(C) ← 付帯状況 / the application ← 主語 / outputs ← 動詞

---

### 例文 2

> With the server running, you can access the API at localhost:3000.

**和訳:** サーバーが動いている状態で、localhost:3000 の API にアクセスできる。

**構造:** With the server(O) running(C) ← 付帯状況 / you ← 主語 / can access ← 動詞

---

### 例文 3

> With this option set to true, the compiler skips type checking.

**和訳:** このオプションを true に設定すると、コンパイラは型チェックをスキップする。

**構造:** With this option(O) set to true(C) ← 付帯状況 / the compiler ← 主語 / skips ← 動詞

---

### 例文 4

> Run the tests with coverage reporting turned on.

**和訳:** カバレッジレポートをオンにしてテストを実行してください。

**構造:** Run ← 動詞（命令文） / the tests ← 目的語 / with coverage reporting(O) turned on(C) ← 付帯状況

---

### 例文 5

> With strict mode enabled, the linter reports additional warnings.

**和訳:** strict モードが有効な状態で、リンターは追加の警告を報告する。

**構造:** With strict mode(O) enabled(C) ← 付帯状況 / the linter ← 主語 / reports ← 動詞

---

### 例文 6

> You can preview the changes with hot reloading active.

**和訳:** ホットリロードが有効な状態で変更をプレビューできる。

**構造:** You ← 主語 / can preview ← 動詞 / the changes ← 目的語 / with hot reloading(O) active(C) ← 付帯状況

---

### 例文 7

> With the database migrated to the latest schema, restart the application.

**和訳:** データベースを最新のスキーマに移行した状態で、アプリケーションを再起動してください。

**構造:** With the database(O) migrated to the latest schema(C) ← 付帯状況 / restart ← 動詞（命令文）

---

### 例文 8

> Deploy the application with the environment variables configured in the `.env` file.

**和訳:** `.env` ファイルで環境変数を設定した状態でアプリケーションをデプロイしてください。

**構造:** Deploy ← 動詞（命令文） / the application ← 目的語 / with the environment variables(O) configured in the `.env` file(C) ← 付帯状況

---

## よくある誤読パターン

### 誤読 1: with を「〜と一緒に」と訳してしまう

> **誤読:** With logging enabled → 「ロギング有効と一緒に」

> **正しい読み方:** 「ロギングが有効な状態で」

`with + O + C` は「OがCの状態で」と読む。`with` を単純に「〜と一緒に」と訳すと意味が通じない場合は、この構文を疑うこと。

### 誤読 2: with 句の範囲を見誤る

> **誤読:** "With this option set" + "to true, the compiler skips type checking."

> **正しい読み方:** "With this option set to true" までが付帯状況。`set to true` 全体が補語。

`set to true` はセットで「true に設定された」という意味。`to true` を切り離さないこと。

### 誤読 3: 文頭の With を条件の If と完全に同一視する

> With logging enabled, the application outputs debug information.

これは「もしロギングが有効なら」（条件）に近い意味になることもあるが、本来は「ロギングが有効な状態で」（状況描写）。技術文書では手順の前提条件を示すのに使われることが多く、If よりもやや「すでにそうなっている」ニュアンスがある。

### 誤読 4: 命令文の末尾にある with 句を見落とす

> Run the tests with coverage reporting turned on.

命令文（Run ...）に集中するあまり、末尾の `with ...` 句を読み飛ばしやすい。技術文書では手順の条件や設定が `with` 句で末尾に付くことが多い。

---

## 練習：次の英文を読んで意味を取ってみよう

### 問題 1

> With TypeScript configured, you can use type annotations in your `.ts` files.

<details>
<summary>解答を見る</summary>

**和訳:** TypeScript が設定された状態で、`.ts` ファイルで型注釈を使うことができる。

**構造:**
- 付帯状況: With TypeScript(O) configured(C)
- 主語: you
- 動詞: can use
- 目的語: type annotations

`configured` は過去分詞で「設定された」の意味。

</details>

---

### 問題 2

> Start the development server with the `--watch` flag passed as an argument.

<details>
<summary>解答を見る</summary>

**和訳:** `--watch` フラグを引数として渡した状態で、開発サーバーを起動してください。

**構造:**
- 動詞: Start（命令文）
- 目的語: the development server
- 付帯状況: with the `--watch` flag(O) passed as an argument(C)

`passed` は過去分詞で「渡された」の意味。

</details>

---

### 問題 3

> With the cache cleared and the dependencies reinstalled, the build should succeed.

<details>
<summary>解答を見る</summary>

**和訳:** キャッシュをクリアし依存関係を再インストールした状態であれば、ビルドは成功するはずだ。

**構造:**
- 付帯状況: With the cache(O) cleared(C) **and** the dependencies(O) reinstalled(C)
  - ※ `with` の中に O+C が2組並列している
- 主語: the build
- 動詞: should succeed

`and` で2つの付帯状況がつながっている点に注意。

</details>
