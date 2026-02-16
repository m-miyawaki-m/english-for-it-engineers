<script setup>
const sections = [
  {
    title: '文型（Sentence Patterns）',
    items: [
      {
        name: 'SVC（第2文型）',
        description: '主語 + 動詞 + 補語。「XはYである」という定義・説明に使う。技術文書で最も頻出。',
        example: 'JavaScript <strong>is</strong> a lightweight programming language.',
        exampleJa: 'JavaScriptは軽量なプログラミング言語<strong>である</strong>。',
        usage: 'API や ライブラリの定義文、仕様の説明で多用される。'
      },
      {
        name: 'SVO（第3文型）',
        description: '主語 + 動詞 + 目的語。「XがYをする」という動作の記述に使う。',
        example: 'Many environments <strong>use</strong> JavaScript.',
        exampleJa: '多くの環境がJavaScriptを<strong>使う</strong>。',
        usage: '手順説明、機能説明で頻出。'
      },
      {
        name: '従属節 + 主節',
        description: '接続詞（While, If, When 等）で始まる従属節と主節の組み合わせ。条件や対比を表す。',
        example: '<strong>While</strong> it is well-known as a scripting language, many environments <strong>also</strong> use it.',
        exampleJa: 'スクリプト言語として知られている<strong>が</strong>、多くの環境で<strong>も</strong>使われている。',
        usage: '対比説明、条件付きの仕様説明で使われる。'
      }
    ]
  },
  {
    title: '構文パターン（Grammar Points）',
    items: [
      {
        name: '形容詞の連続修飾',
        description: '名詞の前に複数の形容詞を並べて修飾する。技術文書では特徴を列挙するのに使う。',
        example: 'a <strong>lightweight interpreted</strong> programming language',
        exampleJa: '<strong>軽量なインタプリタ型の</strong>プログラミング言語',
        usage: '技術の特徴を簡潔に列挙する際に多用。'
      },
      {
        name: '複合形容詞（ハイフン結合）',
        description: '2語以上をハイフンでつないで1つの形容詞にする。技術用語に非常に多い。',
        example: '<strong>just-in-time</strong> compiled, <strong>well-known</strong>, <strong>prototype-based</strong>',
        exampleJa: '<strong>JIT</strong>コンパイル、<strong>よく知られた</strong>、<strong>プロトタイプベースの</strong>',
        usage: 'non-blocking, garbage-collected, event-driven 等、技術英語の基本。'
      },
      {
        name: '挿入句（カッコによる補足）',
        description: 'カッコ内で補足情報や別名を示す。略称の展開や代替表現の提示に使う。',
        example: 'interpreted <strong>(or just-in-time compiled)</strong>',
        exampleJa: 'インタプリタ型<strong>（またはJITコンパイル型）</strong>',
        usage: '技術用語の別名や略称を説明する場面で頻出。'
      },
      {
        name: '前置詞句（with）による後置修飾',
        description: '名詞の後に「with + 名詞」を付けて特徴を追加する。',
        example: 'a programming language <strong>with first-class functions</strong>',
        exampleJa: '<strong>第一級関数を備えた</strong>プログラミング言語',
        usage: 'ライブラリやフレームワークの特徴説明で多用。'
      },
      {
        name: '否定接頭辞（non-）',
        description: '「non-」を付けて「〜でない」を表す。技術文書では境界条件の説明に頻出。',
        example: '<strong>non-browser</strong> environments, <strong>non-null</strong>, <strong>non-blocking</strong>',
        exampleJa: '<strong>ブラウザ以外の</strong>環境、<strong>非null</strong>、<strong>ノンブロッキング</strong>',
        usage: 'non-empty, non-standard, non-enumerable 等、技術仕様での使用が多い。'
      },
      {
        name: '最上級（most + 形容詞）',
        description: '「最も〜な」を表す。技術文書では代表的な用途や特徴を示すのに使う。',
        example: 'It is <strong>most well-known</strong> as the scripting language.',
        exampleJa: 'スクリプト言語として<strong>最もよく知られている</strong>。',
        usage: '代表的な使用例や特徴を強調する場面。'
      },
      {
        name: '従属接続詞（While）による対比',
        description: '「While A, B」で「AだがBでもある」という対比を表す。',
        example: '<strong>While</strong> it is well-known as X, it is <strong>also</strong> used for Y.',
        exampleJa: 'Xとしてよく知られている<strong>が</strong>、Y<strong>にも</strong>使われている。',
        usage: '一般的な認識と実際の用途の対比に使われる。'
      },
      {
        name: '例示句（such as）',
        description: '「such as A, B and C」で具体例を列挙する。技術文書で最も一般的な例示表現。',
        example: '<strong>such as</strong> Node.js, Apache CouchDB <strong>and</strong> Adobe Acrobat',
        exampleJa: '<strong>例えば</strong> Node.js、Apache CouchDB、<strong>そして</strong> Adobe Acrobat',
        usage: '対応ブラウザ、データ型、メソッド一覧など、列挙の場面で頻出。'
      }
    ]
  }
]
</script>

<template>
  <div>
    <h1>文法解説</h1>
    <p class="intro">学習中に出会った文法パターンの解説です。語彙カードの赤タグ（文型）と灰色ラベル（構文パターン）に対応しています。</p>

    <div v-for="section in sections" :key="section.title" class="section">
      <h2>{{ section.title }}</h2>
      <div v-for="item in section.items" :key="item.name" class="grammar-card">
        <h3>{{ item.name }}</h3>
        <p class="description">{{ item.description }}</p>
        <div class="example-block">
          <p class="example" v-html="item.example"></p>
          <p class="example-ja" v-html="item.exampleJa"></p>
        </div>
        <p class="usage"><span class="usage-label">使われる場面:</span> {{ item.usage }}</p>
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
  color: #1565c0;
  margin-bottom: 6px;
}

.description {
  color: #444;
  margin-bottom: 10px;
  line-height: 1.6;
}

.example-block {
  background: #f9f9f9;
  border-left: 3px solid #1565c0;
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

.usage {
  font-size: 0.85rem;
  color: #666;
}

.usage-label {
  font-weight: 600;
  color: #555;
}
</style>
