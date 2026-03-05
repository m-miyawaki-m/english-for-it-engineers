# 一般英語基礎語彙（2,000→3,000語レベル）強化カリキュラム設計書

## 概要

既存カリキュラムはIT専門語彙（60語 + 70表現 + 100略語）と文法（14トピック）を充実させているが、IT文書を読む土台となる**一般英語の基礎〜中級語彙**が欠けている。

A2→B1のギャップを埋めるために、以下の3層構造で語彙を体系的にカバーする:

### 語彙の3層構造

| 層 | 内容 | 語数 | ソース |
|----|------|------|--------|
| **第1層: 基礎語彙** | NGSL上位1,000語（高校英語の98%カバー） | 1,000語 | `docs/references/ngsl-top1000.json` |
| **第2層: IT文書の学術的語彙** | IT文書で頻出する一般英語の中級語彙 | 61語 | `docs/curriculum/vocabulary-general-*.md` |
| **第3層: IT専門語彙** | IT分野固有の用語・表現・略語 | 230項目 | `docs/curriculum/vocabulary-it-*.md`（既存） |

### NGSL と自前カリキュラムの関係

自前カリキュラム61語とNGSLの重複分析結果:

| 区分 | 語数 | 扱い |
|------|------|------|
| NGSL上位1,000に含まれる | 21語 | NGSLで基礎を学び、自前カリキュラムでIT文脈を補強 |
| NGSL 1,001〜2,809に含まれる | 25語 | 自前カリキュラムでIT文脈の例文付きで先取り |
| NGSLに存在しない | 15語 | IT文書特有（mandatory, explicit, compatible等）。自前カリキュラムでのみカバー |

---

## 1. 現状分析

### CEFRレベルと必要語彙数

| CEFR | 必要語彙数 | 現状のカリキュラムカバー範囲 |
|------|-----------|--------------------------|
| A2（現在） | ~2,000語 | 中学英語程度。既知と仮定 |
| **B1（Phase 1目標）** | **~3,000〜4,000語** | IT専門語のみカバー済。一般語彙が未対応 |
| B2（Phase 2目標） | ~5,000〜6,000語 | Phase 2で対応 |

### IT文書読解に必要な語彙の3層構造

1. **第1層: NGSL上位1,000語** — 一般英語の土台。高校英語の98%をカバー。A2学習者でも相当数は既知だが、漏れを埋める
2. **第2層: IT文書の学術的語彙（61語）** — NGSL上位1,000語には含まれないが、IT文書で高頻度の一般語彙
3. **第3層: IT専門語彙（230項目）** — 既存カリキュラムでカバー済

**第1層の学習方法**: `docs/references/ngsl-top1000.json` の `known` フィールドで自己チェック。未知の語をAnki等のSRSで毎日10〜20語ずつ学習。

**第2層で重点的にカバーする語彙**（NGSLに含まれないIT文書特有の語）:
- 形容詞: mandatory, optional, explicit, implicit, compatible, arbitrary 等
- 接続語: regarding, concerning, accordingly 等
- 副詞: essentially, explicitly, implicitly, alternatively 等

---

## 2. 学習目標

### CEFR B1 到達に必要な一般語彙スキル

| スキル | 目標 | 達成イメージ |
|--------|------|-------------|
| 一般動詞の理解 | 20語を文脈で即座に理解 | "This method **determines** whether..." を辞書なしで読める |
| 接続語の理解 | 27語で文の論理構造を把握 | "**Although** X, Y. **Furthermore**, Z" の流れを追える |
| 形容詞の理解 | 14語で条件・性質の記述を理解 | "**optional** but **relevant**" の意味を正確に取れる |
| 派生語の展開 | 各語の名詞・形容詞・副詞形を認識 | specify → specification, specified, specifier を一括で理解 |

---

## 3. 教材リスト

例文の引用元として以下の公式ドキュメントを使用:

| ドキュメント | URL | 使用理由 |
|-------------|-----|---------|
| MDN Web Docs | developer.mozilla.org | JavaScript/Web APIの標準リファレンス。A2-B1向けの平易な文体 |
| React Docs | react.dev | モダンなドキュメント。一般語彙が自然に多い |
| Next.js Docs | nextjs.org/docs | 実務向け。設定・条件記述が豊富 |
| Node.js Docs | nodejs.org/docs | API仕様書形式。フォーマルな語彙が多い |
| TypeScript Docs | typescriptlang.org/docs | 型システムの説明で形容詞・副詞が多用 |

---

## 4. 語彙カテゴリと単語リスト

### Category 1A: 基本動詞（Core Actions）— 10語
specify, ensure, determine, indicate, obtain, require, provide, consider, assume, maintain

### Category 1B: プロセス動詞（Processes & Results）— 10語
correspond, represent, consist, involve, occur, attempt, achieve, contribute, define, establish

### Category 2: 接続語（前置詞・接続詞）— 15語
whereas, although, despite, regarding, concerning, throughout, upon, via, hence, thus, therefore, furthermore, moreover, nevertheless, accordingly

### Category 3: 副詞（Adverbs）— 12語
typically, essentially, explicitly, implicitly, respectively, approximately, previously, subsequently, alternatively, potentially, significantly, occasionally

### Category 4: 形容詞（Adjectives）— 14語
appropriate, sufficient, relevant, subsequent, corresponding, equivalent, mandatory, optional, arbitrary, explicit, implicit, compatible, consistent, available

**合計: 61語**

---

## 5. 学習ステップ — 文法カリキュラムとの並行学習

### Step 0: NGSL自己チェック（学習開始前）

1. `docs/references/ngsl-top1000.json` を開く
2. 各語の `known` フィールドを自己チェック（`true` = 知ってる、`false` = 要学習）
3. `false` の語を抽出し、Anki等のSRSに登録
4. **毎日10〜20語ずつSRSで学習**（文法・IT語彙の学習と並行して継続）

### Step 1〜4: 文法 + IT語彙の統合スケジュール

| 文法 Tier | 文法トピック | 並行する語彙 | 目安期間 |
|-----------|-------------|-------------|---------|
| Tier 1（基礎） | passive-voice, conditionals, infinitives-gerunds, colons-semicolons | Cat 1A（基本動詞）+ vocabulary-it-basic | Week 1-2 |
| Tier 2（読解の核） | relative-pronouns, inanimate-subject, causative-perception, comparatives | Cat 1B（プロセス動詞）+ Cat 4（形容詞）+ vocabulary-it-expressions | Week 3-4 |
| Tier 3（中級） | participial-constructions, post-modifying-participles, appositive-that, with-opc | Cat 2（接続語）+ Cat 3（副詞） | Week 5-6 |
| Tier 4（上級） | preposition-relative, inversion-emphasis | 全体復習 + vocabulary-abbreviations | Week 7+ |

**NGSL SRS学習は Step 0 から全期間を通して毎日継続する。**

### 各カテゴリの学習手順

1. **エントリを読む** — 意味・例文・関連語を確認
2. **実文書で見つける** — MDN学習プランのセッションで同じ単語を探す
3. **派生語を覚える** — specify → specification, specified, specifier のチェーンを意識
4. **練習問題を解く** — `/exercise general-vocab-[category]` で定着確認
5. **文法と統合** — 同Tierの文法パターンの例文中で一般語彙を識別

---

## 6. 確認方法

| 確認方法 | タイミング | 基準 |
|---------|-----------|------|
| `/exercise` 練習問題 | 各カテゴリ完了後 | 正答率80%以上 |
| MDN自己チェック | 各Tier完了後 | MDNの1段落を一般語彙の辞書引きなしで読めるか |
| 文法例文識別 | 文法学習と並行 | 文法カリキュラムの例文中の一般語彙を即座に理解できるか |

---

## 7. 成果物

| ファイル | 内容 | 語数 |
|---------|------|------|
| `docs/references/ngsl-top1000.json` | NGSL上位1,000語（自己チェック用） | 1,000語 |
| `docs/curriculum/vocabulary-general-verbs.md` | 一般動詞（Cat 1A + 1B） | 約20語 |
| `docs/curriculum/vocabulary-general-connectors.md` | 接続語（Cat 2 + Cat 3） | 約27語 |
| `docs/curriculum/vocabulary-general-adjectives.md` | 一般形容詞（Cat 4） | 約14語 |

- NGSL JSONは `known` フィールドで自己チェック → 未知語をSRSで学習
- カリキュラムファイルは既存テンプレート（`vocabulary-it-basic.md`）に準拠し、IT公式ドキュメントからの実例文を添える

---

## 8. 進捗トラッキング

### NGSL基礎語彙

| 項目 | 状態 |
|------|------|
| NGSL 1,000語 自己チェック完了 | ⬜ |
| 未知語のSRS登録 | ⬜ |
| SRS学習（継続中） | ⬜ |

### IT文書の学術的語彙（自前カリキュラム）

| カテゴリ | 語数 | 対応Tier | 状態 |
|---------|------|---------|------|
| 1A: 基本動詞 | 10 | Tier 1 | ⬜ |
| 1B: プロセス動詞 | 10 | Tier 2 | ⬜ |
| 2: 接続語 | 15 | Tier 3 | ⬜ |
| 3: 副詞 | 12 | Tier 3 | ⬜ |
| 4: 形容詞 | 14 | Tier 1-2 | ⬜ |
