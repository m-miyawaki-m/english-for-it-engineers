# プロジェクトカスタマイズ設計書

## 背景

初期セットアップがClaude Codeの汎用テンプレートのままであり、ITエンジニア英語学習プロジェクトとしてカスタマイズが必要。

### 現状の課題
- `.gitignore` がNode.jsコーディングプロジェクト向け
- `.claude/commands/` がTDD・コードレビュー等のコーディング向け
- `.claude/settings.json` にpnpm/npm等の不要なパーミッション
- CLAUDE.md に学習目標・ファイル命名規則が未定義

## 学習者プロファイル

- **現在の英語力**: CEFR A2（初級）
- **学習優先**: 読む力（Reading）を先に伸ばす
- **主な動機**: OSSのREADMEやAPIドキュメントをスムーズに読めるようになりたい

## 学習目標レベル（段階的目標設定）

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
| Claude/LLM指示英語 | B2 Writing | CLAUDE.md や プロンプトを英語で設計・記述できる |
| 技術文書英語 | B2 Reading+Writing | ADR/RFCを読み、簡潔な技術文書を英語で書ける |

## 変更内容

### 1. .gitignore

コーディング向けエントリを削除し、ドキュメントプロジェクト向けに簡素化。

```
.DS_Store
*.log
.env
```

### 2. .claude/settings.json

不要なパーミッション（pnpm, npm, npx）を削除。

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
      "Bash(git worktree:*)"
    ]
  }
}
```

### 3. .claude/commands/ の置き換え

既存の3つ（tdd, review, plan）を削除し、英語学習用コマンド3つを新設。

| コマンド | 用途 |
|---------|------|
| `/explain` | 英語の技術文章を貼ると、構文・語彙・表現パターンを解説 |
| `/exercise` | 指定テーマで練習問題を生成し `docs/exercises/` に保存 |
| `/plan` | 学習プラン作成（英語学習向けに書き換え） |

### 4. CLAUDE.md の更新

- 学習目標セクション追加（Phase 1 / Phase 2）
- ファイル命名規則追加
- Workflow更新

#### ファイル命名規則

| ディレクトリ | 命名規則 | 例 |
|-------------|---------|-----|
| `docs/plans/` | `YYYY-MM-DD-<topic>-design.md` | `2026-02-17-customization-design.md` |
| `docs/curriculum/` | `phase<N>-<topic>.md` | `phase1-official-docs-reading.md` |
| `docs/references/` | `<category>-patterns.md` | `github-patterns.md` |
| `docs/exercises/` | `<category>-<topic>.md` | `github-reading-issue-discussion.md` |
