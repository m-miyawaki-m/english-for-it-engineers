<script setup>
const sections = [
  {
    title: '時制（Tenses）',
    items: [
      {
        name: '現在形（Present Simple）',
        description: '習慣的な動作、一般的な事実、変わらない状態を表す。技術文書では仕様や機能の説明に使われる。',
        formation: '主語 + 動詞の原形（三人称単数は -s）',
        example: 'This function <strong>returns</strong> a string.',
        exampleJa: 'この関数は文字列を<strong>返す</strong>。',
        tip: '技術文書のほとんどは現在形で書かれる。「〜する」「〜である」の基本。'
      },
      {
        name: '過去形（Past Simple）',
        description: '過去に完了した動作や状態を表す。変更履歴やバグ報告で使われる。',
        formation: '主語 + 動詞の過去形（-ed / 不規則変化）',
        example: 'We <strong>fixed</strong> the bug in version 2.0.',
        exampleJa: 'バージョン2.0でそのバグを<strong>修正した</strong>。',
        tip: 'commit メッセージやchangelogでは過去形が基本。"Fixed", "Added", "Removed" 等。'
      },
      {
        name: '現在完了（Present Perfect）',
        description: '過去から現在まで続く状態や、完了した動作の結果が現在に影響していることを表す。',
        formation: '主語 + have/has + 過去分詞',
        example: 'This feature <strong>has been deprecated</strong> since v3.0.',
        exampleJa: 'この機能はv3.0から<strong>非推奨になっている</strong>。',
        tip: '「すでに〜した」「まだ〜していない」という状態を伝えるのに使う。'
      },
      {
        name: '未来表現（Future）',
        description: '未来の予定・意志・予測を表す。仕様の予告やロードマップで使われる。',
        formation: '主語 + will + 動詞の原形 / 主語 + be going to + 動詞の原形',
        example: 'This API <strong>will be</strong> removed in the next major release.',
        exampleJa: 'このAPIは次のメジャーリリースで<strong>削除される予定</strong>。',
        tip: 'will は確定的な予告、be going to は計画済みの予定というニュアンス。'
      }
    ]
  },
  {
    title: '受動態（Passive Voice）',
    items: [
      {
        name: '基本の受動態',
        description: '動作の対象を主語にして「〜される」を表す。技術文書では動作主が不要な場面で多用される。',
        formation: '主語 + be動詞 + 過去分詞（+ by 動作主）',
        example: 'The data <strong>is stored</strong> in a JSON file.',
        exampleJa: 'データはJSONファイルに<strong>保存される</strong>。',
        tip: '技術文書では「誰が」より「何が・どうされるか」が重要なため、受動態が非常に多い。'
      },
      {
        name: '助動詞 + 受動態',
        description: '可能・推奨・義務などのニュアンスを受動態に加える。',
        formation: '主語 + 助動詞 + be + 過去分詞',
        example: 'This value <strong>can be set</strong> in the config file.',
        exampleJa: 'この値は設定ファイルで<strong>設定できる</strong>。',
        tip: '"can be ~" (〜できる), "must be ~" (〜しなければならない), "should be ~" (〜すべき) は頻出パターン。'
      }
    ]
  },
  {
    title: '助動詞（Modal Verbs）',
    items: [
      {
        name: 'can / could',
        description: '能力・可能性を表す。could はより丁寧、または過去の能力を示す。',
        formation: '主語 + can/could + 動詞の原形',
        example: 'You <strong>can</strong> pass an optional parameter.',
        exampleJa: 'オプションのパラメータを渡す<strong>ことができる</strong>。',
        tip: 'API ドキュメントでは "can" は「〜できる（可能）」を意味する。'
      },
      {
        name: 'must / have to',
        description: '義務・必要性を表す。must はより強い義務感。',
        formation: '主語 + must / have to + 動詞の原形',
        example: 'You <strong>must</strong> provide an API key.',
        exampleJa: 'APIキーを提供<strong>しなければならない</strong>。',
        tip: 'RFC では "MUST" は厳格な要件。一般の技術文書でも強い必須条件を示す。'
      },
      {
        name: 'should',
        description: '推奨・助言を表す。「〜すべき」「〜したほうがよい」。',
        formation: '主語 + should + 動詞の原形',
        example: 'You <strong>should</strong> handle errors gracefully.',
        exampleJa: 'エラーを適切に処理<strong>すべきである</strong>。',
        tip: 'RFC では "SHOULD" は推奨事項。ベストプラクティスの記述でよく使われる。'
      },
      {
        name: 'may / might',
        description: '許可・推量を表す。might はより低い可能性。',
        formation: '主語 + may/might + 動詞の原形',
        example: 'This method <strong>may</strong> throw an exception.',
        exampleJa: 'このメソッドは例外を投げる<strong>可能性がある</strong>。',
        tip: 'RFC では "MAY" は任意（optional）。技術文書では「〜かもしれない」という注意喚起。'
      }
    ]
  },
  {
    title: '関係代名詞（Relative Pronouns）',
    items: [
      {
        name: 'who / which / that',
        description: '先行する名詞を修飾する節を導く。who は人、which は物、that はどちらにも使える。',
        formation: '名詞 + who/which/that + 動詞 ...',
        example: 'The function <strong>that returns</strong> a promise.',
        exampleJa: 'Promiseを<strong>返す</strong>関数。',
        tip: '技術文書では that が最もよく使われる。長い修飾は文を複雑にするので注意。'
      },
      {
        name: '関係代名詞の省略',
        description: '目的格の関係代名詞は省略できる。カジュアルな技術文書でよく見られる。',
        formation: '名詞 + (that) + 主語 + 動詞 ...',
        example: 'The value (that) <strong>you pass</strong> to the function.',
        exampleJa: '関数に<strong>渡す</strong>値。',
        tip: '省略された関係代名詞を補って読むと、文構造が理解しやすくなる。'
      }
    ]
  },
  {
    title: '不定詞・動名詞（Infinitives & Gerunds）',
    items: [
      {
        name: '不定詞（to + 動詞）',
        description: '目的・意図を表す。「〜するために」「〜すること」。',
        formation: 'to + 動詞の原形',
        example: 'Use this method <strong>to convert</strong> a string to a number.',
        exampleJa: '文字列を数値に<strong>変換するために</strong>このメソッドを使う。',
        tip: '技術文書では「目的」の表現として非常に頻出。"to install", "to configure" 等。'
      },
      {
        name: '動名詞（-ing）',
        description: '動詞を名詞化して「〜すること」を表す。主語や前置詞の目的語になる。',
        formation: '動詞 + -ing',
        example: '<strong>Deploying</strong> to production requires approval.',
        exampleJa: '本番環境への<strong>デプロイ</strong>には承認が必要。',
        tip: '前置詞の後は必ず動名詞。"before deploying", "after installing" 等。'
      }
    ]
  },
  {
    title: '比較（Comparisons）',
    items: [
      {
        name: '比較級',
        description: '2つのものを比べて「より〜」を表す。',
        formation: '形容詞 + -er + than / more + 形容詞 + than',
        example: 'This approach is <strong>faster than</strong> the previous one.',
        exampleJa: 'このアプローチは前のものより<strong>速い</strong>。',
        tip: '短い形容詞は -er、長い形容詞は more を使う。"simpler", "more efficient" 等。'
      },
      {
        name: '最上級',
        description: '3つ以上の中で「最も〜」を表す。',
        formation: 'the + 形容詞 + -est / the most + 形容詞',
        example: 'This is <strong>the most common</strong> pattern.',
        exampleJa: 'これは<strong>最も一般的な</strong>パターンである。',
        tip: '技術文書では "the most popular", "the fastest", "the simplest" 等がよく使われる。'
      }
    ]
  },
  {
    title: '冠詞（Articles）',
    items: [
      {
        name: '不定冠詞 a / an',
        description: '不特定の1つを指す。初めて言及するものに使う。',
        formation: 'a + 子音で始まる名詞 / an + 母音で始まる名詞',
        example: 'Create <strong>a</strong> new file. Pass <strong>an</strong> object.',
        exampleJa: '新しいファイルを作る。オブジェクトを渡す。',
        tip: '「ある1つの」というニュアンス。a string, an array, an error 等。'
      },
      {
        name: '定冠詞 the',
        description: '特定のものを指す。すでに言及済み、または文脈から特定できるものに使う。',
        formation: 'the + 名詞',
        example: 'Call <strong>the</strong> function with <strong>the</strong> given parameters.',
        exampleJa: '与えられたパラメータでその関数を呼び出す。',
        tip: '「その」「例の」というニュアンス。前に出てきた名詞や唯一のものに使う。'
      },
      {
        name: '無冠詞（冠詞なし）',
        description: '一般論や不可算名詞には冠詞を付けない。',
        formation: '冠詞なし + 名詞（複数形 or 不可算名詞）',
        example: '<strong>Functions</strong> are first-class citizens in JavaScript.',
        exampleJa: '<strong>関数</strong>はJavaScriptにおいて第一級オブジェクトである。',
        tip: '一般論（「関数というものは」）は無冠詞複数形。software, data, information は不可算名詞。'
      }
    ]
  },
  {
    title: '前置詞（Prepositions）',
    items: [
      {
        name: 'in / on / at（場所・時）',
        description: '場所や時間の位置関係を表す基本的な前置詞。',
        formation: 'in（広い空間・期間）/ on（面・日付）/ at（地点・時刻）',
        example: 'The error occurs <strong>in</strong> the main function <strong>on</strong> line 42.',
        exampleJa: 'そのエラーはmain関数の42行目<strong>で</strong>発生する。',
        tip: '技術文書では "in the array", "on the server", "at index 0" のように使い分ける。'
      },
      {
        name: 'for / with / by',
        description: '目的・手段・動作主を表す。',
        formation: 'for（目的・対象）/ with（手段・付帯）/ by（動作主・方法）',
        example: 'A library <strong>for</strong> state management <strong>with</strong> minimal boilerplate.',
        exampleJa: '最小限のボイラープレート<strong>で</strong>状態管理<strong>するための</strong>ライブラリ。',
        tip: '"for" は目的（〜のための）、"with" は手段・特徴（〜を使って/〜付きの）、"by" は方法（〜によって）。'
      }
    ]
  },
  {
    title: '接続詞（Conjunctions）',
    items: [
      {
        name: '等位接続詞（and, but, or）',
        description: '同じ文法要素を対等に結ぶ。',
        formation: 'A + and/but/or + B',
        example: 'Read <strong>and</strong> parse the JSON file, <strong>or</strong> throw an error.',
        exampleJa: 'JSONファイルを読み込み<strong>そして</strong>解析する、<strong>または</strong>エラーを投げる。',
        tip: '技術文書では手順の並列（and）、例外（but）、選択肢（or）を示す。'
      },
      {
        name: '従属接続詞（if, when, because, although）',
        description: '条件・時・理由・譲歩などの関係で従属節を主節につなぐ。',
        formation: 'if/when/because/although + 主語 + 動詞, 主節',
        example: '<strong>If</strong> the value is null, the function returns undefined.',
        exampleJa: '値がnull<strong>なら</strong>、関数はundefinedを返す。',
        tip: '条件分岐の説明は if、タイミングは when、理由は because が基本。'
      }
    ]
  },
  {
    title: '仮定法（Subjunctive / Conditional）',
    items: [
      {
        name: '仮定法過去（現在の仮定）',
        description: '現在の事実に反する仮定を表す。「もし〜なら、〜するのに」。',
        formation: 'If + 主語 + 動詞の過去形, 主語 + would + 動詞の原形',
        example: '<strong>If</strong> we <strong>had</strong> more memory, the app <strong>would run</strong> faster.',
        exampleJa: 'もっとメモリが<strong>あれば</strong>、アプリはもっと速く<strong>動くのに</strong>。',
        tip: '技術的な議論で「こうだったら」という仮定の話をする場面で使う。'
      },
      {
        name: '条件文（現実の条件）',
        description: '実現可能な条件を表す。「もし〜なら、〜する」。仮定法とは異なり現在形を使う。',
        formation: 'If + 主語 + 現在形, 主語 + will/can + 動詞の原形',
        example: '<strong>If</strong> you <strong>set</strong> debug to true, the app <strong>will log</strong> all requests.',
        exampleJa: 'debugをtrueに<strong>設定すれば</strong>、アプリはすべてのリクエストを<strong>ログ出力する</strong>。',
        tip: '技術文書の条件説明はほぼすべてこの形。仮定法（過去形）とは区別すること。'
      }
    ]
  }
]
</script>

<template>
  <div>
    <h1>英文法ガイド</h1>
    <p class="intro">英語の基礎文法を体系的に解説します。各項目には技術文書での用例を含めています。</p>

    <div v-for="section in sections" :key="section.title" class="section">
      <h2>{{ section.title }}</h2>
      <div v-for="item in section.items" :key="item.name" class="grammar-card">
        <h3>{{ item.name }}</h3>
        <p class="description">{{ item.description }}</p>
        <div class="formation">
          <span class="formation-label">形:</span> {{ item.formation }}
        </div>
        <div class="example-block">
          <p class="example" v-html="item.example"></p>
          <p class="example-ja" v-html="item.exampleJa"></p>
        </div>
        <p class="tip"><span class="tip-label">ポイント:</span> {{ item.tip }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
h1 {
  font-size: 1.5rem;
  margin-bottom: 8px;
  color: #1a1a1a;
}

.intro {
  color: #777;
  font-size: 0.9rem;
  margin-bottom: 28px;
}

h2 {
  font-size: 1.15rem;
  color: #333;
  margin-bottom: 16px;
  padding-bottom: 6px;
  border-bottom: 2px solid #e0e0e0;
}

.section {
  margin-bottom: 32px;
}

.grammar-card {
  background: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  padding: 16px;
  margin-bottom: 12px;
}

h3 {
  font-size: 1rem;
  color: #e65100;
  margin-bottom: 6px;
}

.description {
  color: #444;
  margin-bottom: 10px;
  line-height: 1.6;
}

.formation {
  background: #fff3e0;
  border-radius: 6px;
  padding: 8px 12px;
  margin-bottom: 10px;
  font-size: 0.9rem;
  color: #555;
}

.formation-label {
  font-weight: 600;
  color: #e65100;
}

.example-block {
  background: #f9f9f9;
  border-left: 3px solid #e65100;
  padding: 10px 14px;
  border-radius: 0 6px 6px 0;
  margin-bottom: 10px;
}

.example {
  color: #555;
  font-style: italic;
  margin: 0 0 4px 0;
}

.example-ja {
  color: #888;
  font-size: 0.9rem;
  margin: 0;
}

.tip {
  font-size: 0.85rem;
  color: #666;
  background: #fafafa;
  padding: 8px 12px;
  border-radius: 6px;
}

.tip-label {
  font-weight: 600;
  color: #555;
}
</style>
