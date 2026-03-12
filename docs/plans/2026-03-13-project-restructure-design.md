# プロジェクト再構成設計書

## 背景

- 既存のJSON中心の構成はファイルが大きく、Claudeとの対話でトークンを大量消費する
- 学習の順序・進捗管理の仕組みがない
- 武田塾メソッド「①単語・熟語・文法 → ②英文解釈 → ③長文読解」の段階的学習を取り入れる
- 実務スタック（Java Spring + MyBatis）のスキルアップも兼ねる

## 決定事項

| 項目 | 決定 |
|------|------|
| 構成 | モノレポ: `frontend/` (Vue 3 + Vite) + `backend/` (Spring Boot + MyBatis + SQLite) |
| ビルド | Gradle |
| DB | SQLite、`schema.sql` + `data.sql` で初期化（Flyway は後から導入） |
| 初期スコープ | Step1（単語・文法）のみ。Step2（英文解釈）/ Step3（長文読解）は後で |
| フロント | 4ページ（Dashboard / Vocabulary / Grammar / Settings） |
| データ移行 | 既存JSON → `data.sql` に変換。localStorage 進捗はリセット |
| ハードコードガイド | EnglishGrammarGuide / GrammarGuide / PartsOfSpeechGuide を廃止 |

## ディレクトリ構成

```
study-english-it/
├── frontend/                # Vue 3 + Vite
│   ├── src/
│   │   ├── views/           # ページコンポーネント
│   │   │   ├── Dashboard.vue
│   │   │   ├── VocabularyStep.vue
│   │   │   ├── GrammarStep.vue
│   │   │   └── Settings.vue
│   │   ├── components/      # 共通UI部品
│   │   ├── router/          # Vue Router
│   │   └── api/             # API呼び出し
│   ├── package.json
│   └── vite.config.js
│
├── backend/                 # Spring Boot + MyBatis
│   ├── src/main/java/com/studyenglish/
│   │   ├── controller/      # REST API
│   │   ├── service/         # ビジネスロジック
│   │   ├── mapper/          # MyBatis Mapper
│   │   └── model/           # Entity / DTO
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   ├── schema.sql
│   │   ├── data.sql
│   │   └── mapper/          # MyBatis XML
│   └── build.gradle
│
├── docs/
│   ├── curriculum/
│   │   ├── step1-grammar/   # 番号付き文法解説MD
│   │   └── step1-vocabulary/ # 語彙解説MD
│   └── plans/
│
└── CLAUDE.md
```

## DBスキーマ

```sql
CREATE TABLE words (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    word TEXT NOT NULL,
    meaning_general TEXT,
    meaning_it TEXT,
    part_of_speech TEXT,
    domain TEXT,
    source TEXT,
    level INTEGER NOT NULL DEFAULT 1,
    frequency INTEGER,
    example_en TEXT,
    example_ja TEXT,
    known INTEGER DEFAULT 0,       -- 0=未学習, 1=学習中, 2=習得済
    last_reviewed TEXT,
    created_at TEXT DEFAULT (datetime('now'))
);

CREATE TABLE grammar_topics (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    sort_order INTEGER NOT NULL,
    title TEXT NOT NULL,
    doc_path TEXT NOT NULL,
    completed INTEGER DEFAULT 0
);
```

## API設計

```
GET  /api/words                  # 語彙一覧（フィルタ・ページング）
     ?level=1&source=NGSL&known=0&page=0&size=100
GET  /api/words/{id}             # 語彙詳細
PUT  /api/words/{id}/known       # 学習状態更新 { "known": 2 }
GET  /api/words/stats            # 進捗サマリー

GET  /api/grammar                  # 文法トピック一覧
PUT  /api/grammar/{id}/completed   # 文法トピック完了更新 { "completed": 1 }
GET  /api/grammar/{id}/content     # 文法MDファイルの内容をHTML変換して返す
```

### 文法MDファイルの配信
- `grammar_topics.doc_path` には `docs/curriculum/` からの相対パス（例: `step1-grammar/01-passive-voice.md`）を格納
- `GET /api/grammar/{id}/content` でバックエンドがファイルを読み取り、Markdown→HTML変換して返す
- フロントはHTMLをそのままレンダリング（marked.js不要になる）

## フロントエンド ページ構成

### / (Dashboard)
- 進捗サマリー（単語: 120/1070習得、文法: 3/14完了）
- 今日のおすすめ（未学習単語から20語ピックアップ）
- 次のステップ表示

### /vocabulary (Step1: 単語・熟語)
- フィルタ（level, source, known状態）
- 単語カード一覧
- 「知ってる / 曖昧 / 知らない」ボタンで状態更新
- ページング（100語ずつ）

### /grammar (Step1: 文法)
- トピック一覧（sort_order順、完了チェック付き）
- 選択するとカリキュラムMDをレンダリング表示

### /settings
- 将来用（初期実装では空）

## データ移行

### レコード数と変換先

| 元データ | レコード数 | 変換先 |
|---------|-----------|--------|
| ngsl-top1000.json | 1,000語 | words (level=1, source='NGSL') |
| vocabulary.json vocabulary配列 | 19語 | words (level=2, source=元データのsourceフィールド値) |
| vocabulary.json patterns配列 | 6表現 | words (level=2, source=元データのsourceフィールド値) |

### フィールドマッピング

#### NGSL → words

| JSON | DB | 変換ルール |
|------|----|-----------|
| `word` | `word` | そのまま |
| `meanings.general` | `meaning_general` | そのまま |
| `meanings.it` | `meaning_it` | そのまま（nullの場合はNULL） |
| `rank` | `frequency` | rank値をそのまま格納（頻度順位として使用） |
| - | `part_of_speech` | NULL（NGSL元データに品詞情報なし） |
| - | `domain` | NULL |
| - | `source` | 固定値 `'NGSL'` |
| - | `level` | 固定値 `1` |
| - | `example_en` | NULL |
| - | `example_ja` | NULL |
| - | `known` | 固定値 `0`（全件リセット） |

#### vocabulary.json → words

| JSON | DB | 変換ルール |
|------|----|-----------|
| `term` | `word` | そのまま |
| `meaning` | `meaning_general` | そのまま |
| - | `meaning_it` | NULL（一般意味のみ） |
| `partOfSpeech` | `part_of_speech` | そのまま |
| `domain` | `domain` | そのまま |
| `source` | `source` | そのまま（例: `'MDN JavaScript トップページ'`） |
| `example` | `example_en` | Markdown太字記法(**word**)を除去して格納 |
| `exampleJa` | `example_ja` | 同上 |
| - | `level` | 固定値 `2` |
| - | `frequency` | NULL |
| - | `known` | 固定値 `0` |

※ vocabulary.json の `structure`, `grammar`, `category`, `session`, `createdAt` フィールドは移行しない（破棄）

### フロントのフィルタにおける source の扱い
- フィルタUIでは `NGSL` / `IT` の2択で表示
- `source = 'NGSL'` の語彙 → NGSL
- `source != 'NGSL'` の語彙 → IT（source値が個別の出典名でも、フィルタ上はIT扱い）

### 移行しないもの
- readings.json → Step3スコープ。ファイルは残すが使わない
- localStorage の NGSL 進捗 → リセット

### 既存ファイルの扱い
- docs/references/*.json → data.sql 生成後に削除
- docs/curriculum/*.md → step1-grammar/, step1-vocabulary/ に移動・リネーム
- vocabulary-*.md 6ファイル → step1-vocabulary/ に移動。現時点ではアプリから参照しない（将来用）

## 開発環境

- JDK 17+, Node.js 18+, Gradle
- バックエンド: `cd backend && ./gradlew bootRun` → localhost:8080
- フロントエンド: `cd frontend && npm run dev` → Tailscale IP:5173
- Vite proxy で `/api` → localhost:8080 に転送
- Gradle wrapper (`gradlew`, `gradle/wrapper/`) をリポジトリにコミットする
- Javaパッケージ: `com.studyenglish`

### 単語一覧のデフォルトソート・フィルタ
- デフォルトソート: `level ASC, frequency ASC`（Level 1のNGSL頻度順 → Level 2）
- フィルタパラメータはすべてオプショナル（省略時は全件）
- ページングのデフォルト: `page=0, size=100`

### ダッシュボードのミッション算出ロジック
- `GET /api/words/stats` の結果から自動算出
- 未学習語が多い場合: 「Level 1 の単語を20個覚えよう」→ `/vocabulary?known=0&level=1` に遷移
- 単語が80%以上習得済: 「次の文法トピックに進もう」→ `/grammar` に遷移
- おすすめ20語: `GET /api/words?known=0&size=20`（未学習からデフォルトソート順で20件）

## 画面構成

### ナビゲーション
- 上部にタブ型ナビ: Dashboard / 単語 / 文法 / 設定
- Vue Router でページ遷移

### / (Dashboard) — ミッション駆動型
- **メインエリア:** 「今日のミッション」を大きく1つ表示（例: 「Level 1 の単語を20個覚えよう」）
- **学習開始ボタン:** 1クリックで該当ページに遷移
- **下部:** 進捗数値をコンパクトに3列表示（習得済 / 学習中 / 未学習）
- **文法進捗** も小さく表示
- ミッションは進捗状態から自動算出（API: GET /api/words/stats）

### /vocabulary (Step1: 単語) — リスト型
- **フィルタバー:** known状態（全て/未学習/学習中/習得済）+ level + source（NGSL/IT）
- **単語リスト:** 縦に並べた行ごとに:
  - 左: 単語 + 一般意味（+ IT意味があれば青字で表示）
  - 右: ✗(未学習) / △(学習中) / ◎(習得済) ボタン
- **ページング:** 100語ずつ（1-100 / 1070語）
- 一覧性重視。100語を一気に回す武田塾式に適した構成

### /grammar (Step1: 文法) — サイドバー + コンテンツ（2カラム）
- **左サイドバー:** トピック一覧（sort_order順）
  - 完了: ✓ 緑表示
  - 次: ▶ 青ハイライト
  - 未着手: ○ グレー
- **右コンテンツ:** 選択したトピックのカリキュラムMDをHTMLレンダリング
- ページ遷移なしでトピック間を切替可能
- 完了チェックボタン付き

### /settings
- 将来用（初期実装では空ページ）
