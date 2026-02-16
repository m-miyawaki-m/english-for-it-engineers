# プロジェクトカスタマイズ実装計画

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** ITエンジニア英語学習プロジェクトとして、設定ファイル・コマンド・CLAUDE.md をカスタマイズする

**Architecture:** テンプレート由来のコーディング向け設定を削除し、ドキュメント中心の英語学習プロジェクトに適合する設定・コマンド・目標定義に置き換える

**設計書:** `docs/plans/2026-02-17-project-customization-design.md`

---

### Task 1: .gitignore をドキュメントプロジェクト向けに簡素化

**Files:**
- Modify: `.gitignore`

**Step 1: .gitignore を書き換え**

コーディング向けエントリ（node_modules, dist, coverage, .turbo, .env.local, .env.*.local）を削除し、以下の内容にする:

```
.DS_Store
*.log
.env
```

**Step 2: コミット**

```bash
git add .gitignore
git commit -m "chore: simplify .gitignore for documentation project"
```

---

### Task 2: .claude/settings.json から不要パーミッションを削除

**Files:**
- Modify: `.claude/settings.json`

**Step 1: settings.json を書き換え**

`Bash(pnpm:*)`, `Bash(npm run:*)`, `Bash(npx:*)` を削除。`Bash(gh pr:*)`, `Bash(gh issue:*)` は残す（GitHub操作は学習で使う可能性がある）。

```json
{
  "permissions": {
    "allow": [
      "Edit",
      "Write",
      "Bash(git add:*)",
      "Bash(git commit:*)",
      "Bash(git checkout:*)",
      "Bash(git branch:*)",
      "Bash(git worktree:*)",
      "Bash(gh pr:*)",
      "Bash(gh issue:*)"
    ]
  }
}
```

**Step 2: コミット**

```bash
git add .claude/settings.json
git commit -m "chore: remove Node.js permissions from settings"
```

---

### Task 3: コーディング向けコマンドを削除

**Files:**
- Delete: `.claude/commands/tdd.md`
- Delete: `.claude/commands/review.md`
- Delete: `.claude/commands/plan.md`

**Step 1: 3ファイルを削除**

```bash
rm .claude/commands/tdd.md .claude/commands/review.md .claude/commands/plan.md
```

**Step 2: コミット**

```bash
git add -A .claude/commands/
git commit -m "chore: remove coding-oriented custom commands"
```

---

### Task 4: 英語学習用コマンド `/explain` を作成

**Files:**
- Create: `.claude/commands/explain.md`

**Step 1: explain.md を作成**

```markdown
以下の英語の技術文章を解説してください。

対象テキスト: $ARGUMENTS

解説の観点:
1. **構文解析** - 文の構造（主語・動詞・目的語）を明示
2. **語彙** - ITエンジニアとして覚えるべき単語・熟語をピックアップし、意味と用例を説明
3. **表現パターン** - 技術文書で頻出する定型表現を特定し、他の使用場面も紹介
4. **全体の要約** - 文章全体が何を言っているかを日本語で簡潔にまとめる

学習者レベル: CEFR A2〜B1（基礎的な英文法は理解しているが、技術英語の語彙・表現に慣れていない）
```

**Step 2: コミット**

```bash
git add .claude/commands/explain.md
git commit -m "feat: add /explain command for technical English analysis"
```

---

### Task 5: 英語学習用コマンド `/exercise` を作成

**Files:**
- Create: `.claude/commands/exercise.md`

**Step 1: exercise.md を作成**

```markdown
以下のテーマで英語の練習問題を生成し、`docs/exercises/` に保存してください。

テーマ: $ARGUMENTS

生成する練習問題の要件:
1. **読解問題**（2〜3問） - 実際の技術文書から抜粋または模した英文を提示し、内容理解を問う
2. **語彙問題**（3〜5問） - テーマに関連する頻出単語・表現の意味や用法を問う
3. **穴埋め問題**（2〜3問） - 技術文書の定型表現を穴埋め形式で出題

各問題には解答と解説を含めること。
学習者レベル: CEFR A2〜B1
ファイル名: `docs/exercises/<category>-<topic>.md` の形式で保存
```

**Step 2: コミット**

```bash
git add .claude/commands/exercise.md
git commit -m "feat: add /exercise command for generating practice problems"
```

---

### Task 6: 英語学習用コマンド `/plan` を作成

**Files:**
- Create: `.claude/commands/plan.md`

**Step 1: plan.md を作成**

```markdown
以下のテーマで英語学習プランを作成し、`docs/plans/` に保存してください。

テーマ: $ARGUMENTS

学習プランの要件:
1. **現状分析** - このテーマで必要な英語スキルを洗い出す
2. **学習目標** - CEFR B1（Phase 1）到達に必要な具体的スキルを定義
3. **教材リスト** - 実際のOSSリポジトリ・公式ドキュメントから学習に使える素材を選定
4. **学習ステップ** - 段階的な学習手順を具体的に記述
5. **確認方法** - 各ステップの理解度を測る方法を提案

ファイル名: `docs/plans/YYYY-MM-DD-<topic>-design.md` の形式で保存
```

**Step 2: コミット**

```bash
git add .claude/commands/plan.md
git commit -m "feat: add /plan command for English learning plan creation"
```

---

### Task 7: CLAUDE.md に学習目標・命名規則を追加

**Files:**
- Modify: `CLAUDE.md`

**Step 1: 学習スコープの直後に学習目標セクションを追加**

`## 学習スコープ` セクションの後、`## プロジェクト方針` の前に以下を挿入:

```markdown
## 学習目標

現在の英語力: CEFR A2（初級）

### Phase 1: A2 → B1（読む力中心）

| 領域 | 目標 | 達成イメージ |
|------|------|-------------|
| 公式リファレンス英語 | B1 Reading | Next.js や React のドキュメントを、辞書なしで概要を掴める |
| GitHub英語 | B1 Reading | Issue/PRのやりとりを読んで、論点と結論を理解できる |
| Claude/LLM指示英語 | B1 Reading | CLAUDE.md や system instruction の構造と意図を理解できる |
| 技術文書英語 | ― | Phase 1ではスコープ外 |

### Phase 2: B1 → B2（書く力へ拡張）

| 領域 | 目標 | 達成イメージ |
|------|------|-------------|
| 公式リファレンス英語 | B2 Reading | 複雑なAPIリファレンスの条件分岐や注意書きまで正確に読める |
| GitHub英語 | B2 Reading+Writing | Issue報告やPRレビューコメントを英語で書ける |
| Claude/LLM指示英語 | B2 Writing | CLAUDE.md やプロンプトを英語で設計・記述できる |
| 技術文書英語 | B2 Reading+Writing | ADR/RFCを読み、簡潔な技術文書を英語で書ける |
```

**Step 2: Directory Structure セクションにファイル命名規則を追加**

既存のディレクトリ一覧の後に追加:

```markdown
### ファイル命名規則
| ディレクトリ | 命名規則 | 例 |
|-------------|---------|-----|
| `docs/plans/` | `YYYY-MM-DD-<topic>-design.md` | `2026-02-17-customization-design.md` |
| `docs/curriculum/` | `phase<N>-<topic>.md` | `phase1-official-docs-reading.md` |
| `docs/references/` | `<category>-patterns.md` | `github-patterns.md` |
| `docs/exercises/` | `<category>-<topic>.md` | `github-reading-issue-discussion.md` |
```

**Step 3: Workflow セクションにコマンド説明を追加**

Workflow セクションの末尾に追加:

```markdown
4. カスタムコマンド活用:
   - `/explain` - 英語の技術文章の構文・語彙・表現パターンを解説
   - `/exercise` - 指定テーマで練習問題を生成
   - `/plan` - 学習プランを作成
```

**Step 4: コミット**

```bash
git add CLAUDE.md
git commit -m "docs: add learning goals, naming conventions, and commands to CLAUDE.md"
```
