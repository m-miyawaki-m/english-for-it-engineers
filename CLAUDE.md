# Project: english-for-it-engineers

## Overview
ITエンジニア向け英語学習プロジェクト。
公式リファレンス・GitHub・Claude指示文で使われる英語の読み書きスキルを体系的に習得する。

## 学習スコープ
1. **公式リファレンス英語** - API docs, README, CONTRIBUTING.md 等の読解
2. **GitHub英語** - Issues, PR, コードレビュー、commit message の読み書き
3. **Claude/LLM指示英語** - プロンプト、CLAUDE.md、system instruction の作成
4. **技術文書英語** - 設計書、ADR、RFC の読み書き

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

## プロジェクト方針
- 学習教材・メソッド設計プロジェクト
- ドキュメント中心（Markdown + JSON）
- 実際のOSSリポジトリや公式ドキュメントを教材として活用
- Vue 3 + Vite による語彙ビューア（`app/`）

## Directory Structure
- `app/` - 語彙ビューア（Vue 3 + Vite）
- `docs/plans/` - 設計書・学習プラン
- `docs/curriculum/` - カリキュラム・学習教材
- `docs/references/` - 語彙データ（vocabulary.json）
- `docs/exercises/` - 練習問題・演習

### ファイル命名規則
| ディレクトリ | 命名規則 | 例 |
|-------------|---------|-----|
| `docs/plans/` | `YYYY-MM-DD-<topic>-design.md` | `2026-02-17-customization-design.md` |
| `docs/curriculum/` | `phase<N>-<topic>.md` | `phase1-official-docs-reading.md` |
| `docs/references/` | `vocabulary.json`（単一ファイル） | `vocabulary.json` |
| `docs/exercises/` | `<category>-<topic>.md` | `github-reading-issue-discussion.md` |

## Workflow
1. Read existing docs before making changes
2. Use Conventional Commits format
3. ドキュメントは日本語で記述（学習対象の英語表現はそのまま記載）
4. カスタムコマンド活用:
   - `/explain` - 英語の技術文章の構文・語彙・表現パターンを解説
   - `/exercise` - 指定テーマで練習問題を生成
   - `/plan` - 学習プランを作成
