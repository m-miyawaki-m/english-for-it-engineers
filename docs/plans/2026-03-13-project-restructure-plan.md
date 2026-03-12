# プロジェクト再構成 実装計画

> **For agentic workers:** REQUIRED: Use superpowers:subagent-driven-development (if subagents available) or superpowers:executing-plans to implement this plan. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** JSON中心のVueアプリを、Spring Boot + MyBatis + SQLite バックエンド + Vue 3 フロントエンドのモノレポ構成に再構成する（Step1: 単語・文法のみ）

**Architecture:** モノレポ内に `backend/`（Spring Boot REST API + SQLite）と `frontend/`（Vue 3 + Vite）を配置。バックエンドがDB操作とMD配信を担当し、フロントエンドはAPI経由でデータ取得。Vite proxy で開発時のAPI転送を行う。

**Tech Stack:** Java 21, Spring Boot 3, MyBatis, SQLite, Gradle / Vue 3, Vite, Vue Router, axios

**Spec:** `docs/plans/2026-03-13-project-restructure-design.md`

---

## Chunk 1: プロジェクト基盤

### Task 1: ドキュメント再配置

既存のカリキュラムMDファイルを新ディレクトリ構成に移動・リネームする。

**Files:**
- Move: `docs/curriculum/grammar-*.md` → `docs/curriculum/step1-grammar/01-*.md`
- Move: `docs/curriculum/vocabulary-*.md` → `docs/curriculum/step1-vocabulary/`

- [ ] **Step 1: step1-grammar ディレクトリ作成・ファイル移動**

```bash
mkdir -p docs/curriculum/step1-grammar
# CurriculumViewer.vue の学習順序に従って番号付きリネーム
mv docs/curriculum/grammar-passive-voice.md docs/curriculum/step1-grammar/01-passive-voice.md
mv docs/curriculum/grammar-conditionals.md docs/curriculum/step1-grammar/02-conditionals.md
mv docs/curriculum/grammar-relative-pronouns.md docs/curriculum/step1-grammar/03-relative-pronouns.md
mv docs/curriculum/grammar-infinitives-gerunds.md docs/curriculum/step1-grammar/04-infinitives-gerunds.md
mv docs/curriculum/grammar-comparatives.md docs/curriculum/step1-grammar/05-comparatives.md
mv docs/curriculum/grammar-colons-semicolons.md docs/curriculum/step1-grammar/06-colons-semicolons.md
mv docs/curriculum/grammar-causative-perception.md docs/curriculum/step1-grammar/07-causative-perception.md
mv docs/curriculum/grammar-inanimate-subject.md docs/curriculum/step1-grammar/08-inanimate-subject.md
mv docs/curriculum/grammar-post-modifying-participles.md docs/curriculum/step1-grammar/09-post-modifying-participles.md
mv docs/curriculum/grammar-appositive-that.md docs/curriculum/step1-grammar/10-appositive-that.md
mv docs/curriculum/grammar-with-opc.md docs/curriculum/step1-grammar/11-with-opc.md
mv docs/curriculum/grammar-participial-constructions.md docs/curriculum/step1-grammar/12-participial-constructions.md
mv docs/curriculum/grammar-preposition-relative.md docs/curriculum/step1-grammar/13-preposition-relative.md
mv docs/curriculum/grammar-inversion-emphasis.md docs/curriculum/step1-grammar/14-inversion-emphasis.md
```

- [ ] **Step 2: step1-vocabulary ディレクトリ作成・ファイル移動**

```bash
mkdir -p docs/curriculum/step1-vocabulary
mv docs/curriculum/vocabulary-it-basic.md docs/curriculum/step1-vocabulary/
mv docs/curriculum/vocabulary-abbreviations.md docs/curriculum/step1-vocabulary/
mv docs/curriculum/vocabulary-general-verbs.md docs/curriculum/step1-vocabulary/
mv docs/curriculum/vocabulary-general-adjectives.md docs/curriculum/step1-vocabulary/
mv docs/curriculum/vocabulary-general-connectors.md docs/curriculum/step1-vocabulary/
mv docs/curriculum/vocabulary-it-expressions.md docs/curriculum/step1-vocabulary/
```

- [ ] **Step 3: 移動後の確認**

```bash
ls docs/curriculum/step1-grammar/   # 14ファイル
ls docs/curriculum/step1-vocabulary/ # 6ファイル
ls docs/curriculum/                  # step1-grammar/, step1-vocabulary/ のみ
```

- [ ] **Step 4: コミット**

```bash
git add docs/curriculum/
git commit -m "refactor: reorganize curriculum files into step1 directories"
```

---

### Task 2: Spring Boot プロジェクト初期化

**Files:**
- Create: `backend/build.gradle`
- Create: `backend/settings.gradle`
- Create: `backend/src/main/java/com/studyenglish/Application.java`
- Create: `backend/src/main/resources/application.yml`
- Create: `backend/src/main/resources/schema.sql`

- [ ] **Step 1: Gradle wrapper を生成**

```bash
mkdir -p backend
cd backend
gradle init --type basic --dsl groovy
# gradle が無い場合は手動で gradlew を配置:
# https://docs.gradle.org/current/userguide/gradle_wrapper.html
```

※ `gradle` コマンドが使えない場合、Spring Initializr（https://start.spring.io/）で生成したプロジェクトを展開してもよい。設定:
- Project: Gradle - Groovy
- Language: Java
- Spring Boot: 3.4.x
- Group: com.studyenglish
- Artifact: backend
- Dependencies: Spring Web, MyBatis Framework, SQLite (手動追加)

- [ ] **Step 2: build.gradle を作成**

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.4.3'
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'com.studyenglish'
version = '0.0.1-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4'
    implementation 'org.xerial:sqlite-jdbc:3.47.2.0'
    implementation 'com.vladmihalcea:hibernate-types-60:2.21.1' // SQLite dialect
    implementation 'com.vladsch.flexmark:flexmark-all:0.64.8' // Markdown→HTML

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.4'
}

tasks.named('test') {
    useJUnitPlatform()
}
```

- [ ] **Step 3: settings.gradle を作成**

```groovy
rootProject.name = 'study-english-backend'
```

- [ ] **Step 4: Application.java を作成**

```java
// backend/src/main/java/com/studyenglish/Application.java
package com.studyenglish;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

- [ ] **Step 5: application.yml を作成**

```yaml
# backend/src/main/resources/application.yml
spring:
  datasource:
    url: jdbc:sqlite:study.db
    driver-class-name: org.sqlite.JDBC
  sql:
    init:
      mode: always
      schema-locations: classpath:schema.sql
      data-locations: classpath:data.sql

mybatis:
  mapper-locations: classpath:mapper/*.xml
  configuration:
    map-underscore-to-camel-case: true

# Markdown配信用: docsディレクトリのパス
app:
  docs-base-path: ../docs/curriculum
```

- [ ] **Step 6: schema.sql を作成**

```sql
-- backend/src/main/resources/schema.sql
CREATE TABLE IF NOT EXISTS words (
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
    known INTEGER DEFAULT 0,
    last_reviewed TEXT,
    created_at TEXT DEFAULT (datetime('now'))
);

CREATE TABLE IF NOT EXISTS grammar_topics (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    sort_order INTEGER NOT NULL,
    title TEXT NOT NULL,
    doc_path TEXT NOT NULL,
    completed INTEGER DEFAULT 0
);
```

- [ ] **Step 7: 空の data.sql を作成（後のTaskで中身を生成）**

```sql
-- backend/src/main/resources/data.sql
-- Data will be generated from JSON files in Task 3
```

- [ ] **Step 8: ビルド確認**

```bash
cd backend
./gradlew build
```

Expected: BUILD SUCCESSFUL

- [ ] **Step 9: コミット**

```bash
cd ..
git add backend/
git commit -m "feat: initialize Spring Boot project with MyBatis + SQLite"
```

---

### Task 3: データ移行スクリプト（JSON → data.sql）

**Files:**
- Create: `scripts/migrate-json-to-sql.py`
- Modify: `backend/src/main/resources/data.sql`

- [ ] **Step 1: 移行スクリプトを作成**

```python
#!/usr/bin/env python3
"""JSON語彙データをdata.sqlに変換する"""
import json
import re

def escape_sql(s):
    """SQLインジェクション防止のためシングルクォートをエスケープ"""
    if s is None:
        return "NULL"
    return "'" + s.replace("'", "''") + "'"

def strip_markdown_bold(s):
    """**word** → word に変換"""
    if s is None:
        return None
    return re.sub(r'\*\*(.+?)\*\*', r'\1', s)

def main():
    lines = []
    lines.append("-- Generated from JSON data files")
    lines.append("-- Do not edit manually\n")

    # --- NGSL words ---
    lines.append("-- NGSL Top 1000 words (level=1)")
    with open("docs/references/ngsl-top1000.json", "r") as f:
        ngsl = json.load(f)

    for w in ngsl["words"]:
        word = escape_sql(w["word"])
        meaning_general = escape_sql(w["meanings"]["general"])
        meaning_it = escape_sql(w["meanings"].get("it"))
        frequency = w.get("rank", "NULL")
        lines.append(
            f"INSERT INTO words (word, meaning_general, meaning_it, source, level, frequency, known) "
            f"VALUES ({word}, {meaning_general}, {meaning_it}, 'NGSL', 1, {frequency}, 0);"
        )

    lines.append("")

    # --- Vocabulary words ---
    lines.append("-- IT vocabulary (level=2)")
    with open("docs/references/vocabulary.json", "r") as f:
        vocab = json.load(f)

    for item in vocab.get("vocabulary", []):
        word = escape_sql(item["term"])
        meaning_general = escape_sql(item.get("meaning"))
        part_of_speech = escape_sql(item.get("partOfSpeech"))
        domain = escape_sql(item.get("domain"))
        source = escape_sql(item.get("source"))
        example_en = escape_sql(strip_markdown_bold(item.get("example")))
        example_ja = escape_sql(strip_markdown_bold(item.get("exampleJa")))
        lines.append(
            f"INSERT INTO words (word, meaning_general, part_of_speech, domain, source, level, example_en, example_ja, known) "
            f"VALUES ({word}, {meaning_general}, {part_of_speech}, {domain}, {source}, 2, {example_en}, {example_ja}, 0);"
        )

    for item in vocab.get("patterns", []):
        word = escape_sql(item["term"])
        meaning_general = escape_sql(item.get("meaning"))
        part_of_speech = escape_sql(item.get("partOfSpeech"))
        domain = escape_sql(item.get("domain"))
        source = escape_sql(item.get("source"))
        example_en = escape_sql(strip_markdown_bold(item.get("example")))
        example_ja = escape_sql(strip_markdown_bold(item.get("exampleJa")))
        lines.append(
            f"INSERT INTO words (word, meaning_general, part_of_speech, domain, source, level, example_en, example_ja, known) "
            f"VALUES ({word}, {meaning_general}, {part_of_speech}, {domain}, {source}, 2, {example_en}, {example_ja}, 0);"
        )

    lines.append("")

    # --- Grammar topics ---
    lines.append("-- Grammar topics (14 topics)")
    grammar_topics = [
        (1, "受動態（Passive Voice）", "step1-grammar/01-passive-voice.md"),
        (2, "条件文（Conditionals）", "step1-grammar/02-conditionals.md"),
        (3, "関係代名詞（Relative Pronouns）", "step1-grammar/03-relative-pronouns.md"),
        (4, "不定詞・動名詞（Infinitives & Gerunds）", "step1-grammar/04-infinitives-gerunds.md"),
        (5, "比較表現（Comparatives）", "step1-grammar/05-comparatives.md"),
        (6, "コロン・セミコロン（Colons & Semicolons）", "step1-grammar/06-colons-semicolons.md"),
        (7, "使役・知覚構文（Causative & Perception）", "step1-grammar/07-causative-perception.md"),
        (8, "無生物主語（Inanimate Subject）", "step1-grammar/08-inanimate-subject.md"),
        (9, "後置修飾分詞（Post-modifying Participles）", "step1-grammar/09-post-modifying-participles.md"),
        (10, "同格のthat（Appositive That）", "step1-grammar/10-appositive-that.md"),
        (11, "with + O + C構文", "step1-grammar/11-with-opc.md"),
        (12, "分詞構文（Participial Constructions）", "step1-grammar/12-participial-constructions.md"),
        (13, "前置詞+関係代名詞", "step1-grammar/13-preposition-relative.md"),
        (14, "倒置・強調（Inversion & Emphasis）", "step1-grammar/14-inversion-emphasis.md"),
    ]
    for sort_order, title, doc_path in grammar_topics:
        lines.append(
            f"INSERT INTO grammar_topics (sort_order, title, doc_path, completed) "
            f"VALUES ({sort_order}, {escape_sql(title)}, {escape_sql(doc_path)}, 0);"
        )

    output = "\n".join(lines) + "\n"
    with open("backend/src/main/resources/data.sql", "w") as f:
        f.write(output)

    print(f"Generated data.sql with {len(ngsl['words'])} NGSL words, "
          f"{len(vocab.get('vocabulary', []))} vocabulary items, "
          f"{len(vocab.get('patterns', []))} patterns, "
          f"{len(grammar_topics)} grammar topics")

if __name__ == "__main__":
    main()
```

- [ ] **Step 2: スクリプトを実行**

```bash
python3 scripts/migrate-json-to-sql.py
```

Expected: `Generated data.sql with 1000 NGSL words, 19 vocabulary items, 6 patterns, 14 grammar topics`

- [ ] **Step 3: data.sql の先頭・末尾を目視確認**

```bash
head -20 backend/src/main/resources/data.sql
tail -20 backend/src/main/resources/data.sql
```

- [ ] **Step 4: Spring Boot で DB 初期化を確認**

```bash
cd backend
./gradlew bootRun
# 起動後 Ctrl+C で停止
# study.db が生成されていることを確認
sqlite3 study.db "SELECT COUNT(*) FROM words;"
# Expected: 1025 (1000 + 19 + 6)
sqlite3 study.db "SELECT COUNT(*) FROM grammar_topics;"
# Expected: 14
```

- [ ] **Step 5: コミット**

```bash
cd ..
git add scripts/migrate-json-to-sql.py backend/src/main/resources/data.sql
git commit -m "feat: generate data.sql from JSON vocabulary data"
```

---

## Chunk 2: バックエンド API（Words）

### Task 4: Word モデル・Mapper

**Files:**
- Create: `backend/src/main/java/com/studyenglish/model/Word.java`
- Create: `backend/src/main/java/com/studyenglish/mapper/WordMapper.java`
- Create: `backend/src/main/resources/mapper/WordMapper.xml`
- Create: `backend/src/test/java/com/studyenglish/mapper/WordMapperTest.java`

- [ ] **Step 1: Word.java（Entity）を作成**

```java
package com.studyenglish.model;

public class Word {
    private Integer id;
    private String word;
    private String meaningGeneral;
    private String meaningIt;
    private String partOfSpeech;
    private String domain;
    private String source;
    private Integer level;
    private Integer frequency;
    private String exampleEn;
    private String exampleJa;
    private Integer known;
    private String lastReviewed;
    private String createdAt;

    // getter/setter 全フィールド分
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getWord() { return word; }
    public void setWord(String word) { this.word = word; }
    public String getMeaningGeneral() { return meaningGeneral; }
    public void setMeaningGeneral(String meaningGeneral) { this.meaningGeneral = meaningGeneral; }
    public String getMeaningIt() { return meaningIt; }
    public void setMeaningIt(String meaningIt) { this.meaningIt = meaningIt; }
    public String getPartOfSpeech() { return partOfSpeech; }
    public void setPartOfSpeech(String partOfSpeech) { this.partOfSpeech = partOfSpeech; }
    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }
    public Integer getFrequency() { return frequency; }
    public void setFrequency(Integer frequency) { this.frequency = frequency; }
    public String getExampleEn() { return exampleEn; }
    public void setExampleEn(String exampleEn) { this.exampleEn = exampleEn; }
    public String getExampleJa() { return exampleJa; }
    public void setExampleJa(String exampleJa) { this.exampleJa = exampleJa; }
    public Integer getKnown() { return known; }
    public void setKnown(Integer known) { this.known = known; }
    public String getLastReviewed() { return lastReviewed; }
    public void setLastReviewed(String lastReviewed) { this.lastReviewed = lastReviewed; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
```

- [ ] **Step 2: WordMapper.java（Mapperインターフェース）を作成**

```java
package com.studyenglish.mapper;

import com.studyenglish.model.Word;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

@Mapper
public interface WordMapper {
    List<Word> findAll(
        @Param("level") Integer level,
        @Param("source") String source,
        @Param("known") Integer known,
        @Param("offset") int offset,
        @Param("limit") int limit
    );

    int countAll(
        @Param("level") Integer level,
        @Param("source") String source,
        @Param("known") Integer known
    );

    Word findById(@Param("id") int id);

    void updateKnown(@Param("id") int id, @Param("known") int known, @Param("lastReviewed") String lastReviewed);

    Map<String, Object> getStats();
}
```

- [ ] **Step 3: WordMapper.xml を作成**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.studyenglish.mapper.WordMapper">

  <select id="findAll" resultType="com.studyenglish.model.Word">
    SELECT * FROM words
    <where>
      <if test="level != null">AND level = #{level}</if>
      <if test="source != null and source == 'NGSL'">AND source = 'NGSL'</if>
      <if test="source != null and source == 'IT'">AND source != 'NGSL'</if>
      <if test="known != null">AND known = #{known}</if>
    </where>
    ORDER BY level ASC, frequency ASC
    LIMIT #{limit} OFFSET #{offset}
  </select>

  <select id="countAll" resultType="int">
    SELECT COUNT(*) FROM words
    <where>
      <if test="level != null">AND level = #{level}</if>
      <if test="source != null and source == 'NGSL'">AND source = 'NGSL'</if>
      <if test="source != null and source == 'IT'">AND source != 'NGSL'</if>
      <if test="known != null">AND known = #{known}</if>
    </where>
  </select>

  <select id="findById" resultType="com.studyenglish.model.Word">
    SELECT * FROM words WHERE id = #{id}
  </select>

  <update id="updateKnown">
    UPDATE words SET known = #{known}, last_reviewed = #{lastReviewed} WHERE id = #{id}
  </update>

  <select id="getStats" resultType="map">
    SELECT
      COUNT(*) as total,
      SUM(CASE WHEN known = 0 THEN 1 ELSE 0 END) as unknown,
      SUM(CASE WHEN known = 1 THEN 1 ELSE 0 END) as learning,
      SUM(CASE WHEN known = 2 THEN 1 ELSE 0 END) as mastered
    FROM words
  </select>

</mapper>
```

- [ ] **Step 4: WordMapperTest.java を作成**

```java
package com.studyenglish.mapper;

import com.studyenglish.model.Word;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class WordMapperTest {

    @Autowired
    private WordMapper wordMapper;

    @Test
    void findAll_noFilter_returnsWords() {
        List<Word> words = wordMapper.findAll(null, null, null, 0, 10);
        assertFalse(words.isEmpty());
        assertTrue(words.size() <= 10);
    }

    @Test
    void findAll_filterByLevel_returnsOnlyMatchingLevel() {
        List<Word> words = wordMapper.findAll(1, null, null, 0, 10);
        words.forEach(w -> assertEquals(1, w.getLevel()));
    }

    @Test
    void findAll_filterBySourceNGSL_returnsOnlyNGSL() {
        List<Word> words = wordMapper.findAll(null, "NGSL", null, 0, 10);
        words.forEach(w -> assertEquals("NGSL", w.getSource()));
    }

    @Test
    void findAll_filterBySourceIT_returnsNonNGSL() {
        List<Word> words = wordMapper.findAll(null, "IT", null, 0, 100);
        words.forEach(w -> assertNotEquals("NGSL", w.getSource()));
    }

    @Test
    void findAll_pagination_returnsCorrectPage() {
        List<Word> page0 = wordMapper.findAll(null, null, null, 0, 5);
        List<Word> page1 = wordMapper.findAll(null, null, null, 5, 5);
        assertNotEquals(page0.get(0).getId(), page1.get(0).getId());
    }

    @Test
    void findById_existingWord_returnsWord() {
        // data.sql inserts start at id=1
        Word word = wordMapper.findById(1);
        assertNotNull(word);
        assertNotNull(word.getWord());
    }

    @Test
    void updateKnown_changesState() {
        wordMapper.updateKnown(1, 2, "2026-03-13");
        Word updated = wordMapper.findById(1);
        assertEquals(2, updated.getKnown());
        assertEquals("2026-03-13", updated.getLastReviewed());
    }

    @Test
    void getStats_returnsCounts() {
        Map<String, Object> stats = wordMapper.getStats();
        assertNotNull(stats.get("total"));
        assertTrue(((Number) stats.get("total")).intValue() > 0);
    }

    @Test
    void countAll_noFilter_returnsTotal() {
        int count = wordMapper.countAll(null, null, null);
        assertTrue(count > 0);
    }
}
```

- [ ] **Step 5: テスト実行**

```bash
cd backend
./gradlew test --tests "com.studyenglish.mapper.WordMapperTest"
```

Expected: All 9 tests PASS

- [ ] **Step 6: コミット**

```bash
cd ..
git add backend/src/
git commit -m "feat: add Word model, MyBatis mapper with tests"
```

---

### Task 5: Words REST API

**Files:**
- Create: `backend/src/main/java/com/studyenglish/service/WordService.java`
- Create: `backend/src/main/java/com/studyenglish/controller/WordController.java`
- Create: `backend/src/main/java/com/studyenglish/model/WordStatsResponse.java`
- Create: `backend/src/main/java/com/studyenglish/model/PageResponse.java`
- Create: `backend/src/test/java/com/studyenglish/controller/WordControllerTest.java`

- [ ] **Step 1: WordStatsResponse.java を作成**

```java
package com.studyenglish.model;

public class WordStatsResponse {
    private int total;
    private int unknown;
    private int learning;
    private int mastered;

    public WordStatsResponse(int total, int unknown, int learning, int mastered) {
        this.total = total;
        this.unknown = unknown;
        this.learning = learning;
        this.mastered = mastered;
    }

    // getters
    public int getTotal() { return total; }
    public int getUnknown() { return unknown; }
    public int getLearning() { return learning; }
    public int getMastered() { return mastered; }
}
```

- [ ] **Step 2: PageResponse.java を作成**

```java
package com.studyenglish.model;

import java.util.List;

public class PageResponse<T> {
    private List<T> content;
    private int page;
    private int size;
    private int totalElements;
    private int totalPages;

    public PageResponse(List<T> content, int page, int size, int totalElements) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / size);
    }

    // getters
    public List<T> getContent() { return content; }
    public int getPage() { return page; }
    public int getSize() { return size; }
    public int getTotalElements() { return totalElements; }
    public int getTotalPages() { return totalPages; }
}
```

- [ ] **Step 3: WordService.java を作成**

```java
package com.studyenglish.service;

import com.studyenglish.mapper.WordMapper;
import com.studyenglish.model.Word;
import com.studyenglish.model.WordStatsResponse;
import com.studyenglish.model.PageResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class WordService {

    private final WordMapper wordMapper;

    public WordService(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    public PageResponse<Word> findAll(Integer level, String source, Integer known, int page, int size) {
        int offset = page * size;
        List<Word> words = wordMapper.findAll(level, source, known, offset, size);
        int total = wordMapper.countAll(level, source, known);
        return new PageResponse<>(words, page, size, total);
    }

    public Word findById(int id) {
        return wordMapper.findById(id);
    }

    public void updateKnown(int id, int known) {
        String today = LocalDate.now().toString();
        wordMapper.updateKnown(id, known, today);
    }

    public WordStatsResponse getStats() {
        Map<String, Object> raw = wordMapper.getStats();
        return new WordStatsResponse(
            ((Number) raw.get("total")).intValue(),
            ((Number) raw.get("unknown")).intValue(),
            ((Number) raw.get("learning")).intValue(),
            ((Number) raw.get("mastered")).intValue()
        );
    }
}
```

- [ ] **Step 4: WordController.java を作成**

```java
package com.studyenglish.controller;

import com.studyenglish.model.Word;
import com.studyenglish.model.WordStatsResponse;
import com.studyenglish.model.PageResponse;
import com.studyenglish.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/words")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public PageResponse<Word> getWords(
            @RequestParam(required = false) Integer level,
            @RequestParam(required = false) String source,
            @RequestParam(required = false) Integer known,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        return wordService.findAll(level, source, known, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getWord(@PathVariable int id) {
        Word word = wordService.findById(id);
        if (word == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(word);
    }

    @PutMapping("/{id}/known")
    public ResponseEntity<Void> updateKnown(@PathVariable int id, @RequestBody Map<String, Integer> body) {
        Integer known = body.get("known");
        if (known == null || known < 0 || known > 2) {
            return ResponseEntity.badRequest().build();
        }
        wordService.updateKnown(id, known);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/stats")
    public WordStatsResponse getStats() {
        return wordService.getStats();
    }
}
```

- [ ] **Step 5: WordControllerTest.java を作成**

```java
package com.studyenglish.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getWords_noFilter_returns200WithContent() throws Exception {
        mockMvc.perform(get("/api/words"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").isArray())
            .andExpect(jsonPath("$.totalElements").isNumber())
            .andExpect(jsonPath("$.page").value(0));
    }

    @Test
    void getWords_withLevelFilter_returns200() throws Exception {
        mockMvc.perform(get("/api/words").param("level", "1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content").isArray());
    }

    @Test
    void getWords_withPagination_returns200() throws Exception {
        mockMvc.perform(get("/api/words").param("page", "0").param("size", "5"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.content.length()").value(5))
            .andExpect(jsonPath("$.size").value(5));
    }

    @Test
    void getWord_existingId_returns200() throws Exception {
        mockMvc.perform(get("/api/words/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.word").isString());
    }

    @Test
    void getWord_nonExistingId_returns404() throws Exception {
        mockMvc.perform(get("/api/words/99999"))
            .andExpect(status().isNotFound());
    }

    @Test
    void updateKnown_validValue_returns200() throws Exception {
        mockMvc.perform(put("/api/words/1/known")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"known\": 2}"))
            .andExpect(status().isOk());
    }

    @Test
    void updateKnown_invalidValue_returns400() throws Exception {
        mockMvc.perform(put("/api/words/1/known")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"known\": 5}"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void getStats_returns200WithCounts() throws Exception {
        mockMvc.perform(get("/api/words/stats"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.total").isNumber())
            .andExpect(jsonPath("$.unknown").isNumber())
            .andExpect(jsonPath("$.learning").isNumber())
            .andExpect(jsonPath("$.mastered").isNumber());
    }
}
```

- [ ] **Step 6: テスト実行**

```bash
cd backend
./gradlew test
```

Expected: All tests PASS

- [ ] **Step 7: 手動確認（curl）**

```bash
cd backend && ./gradlew bootRun &
sleep 5
curl -s http://localhost:8080/api/words?size=3 | python3 -m json.tool
curl -s http://localhost:8080/api/words/stats | python3 -m json.tool
kill %1
```

- [ ] **Step 8: コミット**

```bash
cd ..
git add backend/src/
git commit -m "feat: add Words REST API with service, controller, and tests"
```

---

## Chunk 3: バックエンド API（Grammar）

### Task 6: Grammar モデル・Mapper・API

**Files:**
- Create: `backend/src/main/java/com/studyenglish/model/GrammarTopic.java`
- Create: `backend/src/main/java/com/studyenglish/mapper/GrammarMapper.java`
- Create: `backend/src/main/resources/mapper/GrammarMapper.xml`
- Create: `backend/src/main/java/com/studyenglish/service/GrammarService.java`
- Create: `backend/src/main/java/com/studyenglish/controller/GrammarController.java`
- Create: `backend/src/test/java/com/studyenglish/controller/GrammarControllerTest.java`

- [ ] **Step 1: GrammarTopic.java を作成**

```java
package com.studyenglish.model;

public class GrammarTopic {
    private Integer id;
    private Integer sortOrder;
    private String title;
    private String docPath;
    private Integer completed;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDocPath() { return docPath; }
    public void setDocPath(String docPath) { this.docPath = docPath; }
    public Integer getCompleted() { return completed; }
    public void setCompleted(Integer completed) { this.completed = completed; }
}
```

- [ ] **Step 2: GrammarMapper.java を作成**

```java
package com.studyenglish.mapper;

import com.studyenglish.model.GrammarTopic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface GrammarMapper {
    List<GrammarTopic> findAll();
    GrammarTopic findById(@Param("id") int id);
    void updateCompleted(@Param("id") int id, @Param("completed") int completed);
}
```

- [ ] **Step 3: GrammarMapper.xml を作成**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.studyenglish.mapper.GrammarMapper">

  <select id="findAll" resultType="com.studyenglish.model.GrammarTopic">
    SELECT * FROM grammar_topics ORDER BY sort_order ASC
  </select>

  <select id="findById" resultType="com.studyenglish.model.GrammarTopic">
    SELECT * FROM grammar_topics WHERE id = #{id}
  </select>

  <update id="updateCompleted">
    UPDATE grammar_topics SET completed = #{completed} WHERE id = #{id}
  </update>

</mapper>
```

- [ ] **Step 4: GrammarService.java を作成**

```java
package com.studyenglish.service;

import com.studyenglish.mapper.GrammarMapper;
import com.studyenglish.model.GrammarTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class GrammarService {

    private final GrammarMapper grammarMapper;
    private final String docsBasePath;
    private final Parser parser;
    private final HtmlRenderer renderer;

    public GrammarService(GrammarMapper grammarMapper,
                          @Value("${app.docs-base-path}") String docsBasePath) {
        this.grammarMapper = grammarMapper;
        this.docsBasePath = docsBasePath;
        this.parser = Parser.builder().build();
        this.renderer = HtmlRenderer.builder().build();
    }

    public List<GrammarTopic> findAll() {
        return grammarMapper.findAll();
    }

    public GrammarTopic findById(int id) {
        return grammarMapper.findById(id);
    }

    public void updateCompleted(int id, int completed) {
        grammarMapper.updateCompleted(id, completed);
    }

    public String getContentAsHtml(int id) throws IOException {
        GrammarTopic topic = grammarMapper.findById(id);
        if (topic == null) {
            return null;
        }
        Path filePath = Paths.get(docsBasePath, topic.getDocPath());
        String markdown = Files.readString(filePath);
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }
}
```

- [ ] **Step 5: GrammarController.java を作成**

```java
package com.studyenglish.controller;

import com.studyenglish.model.GrammarTopic;
import com.studyenglish.service.GrammarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/grammar")
public class GrammarController {

    private final GrammarService grammarService;

    public GrammarController(GrammarService grammarService) {
        this.grammarService = grammarService;
    }

    @GetMapping
    public List<GrammarTopic> getAll() {
        return grammarService.findAll();
    }

    @PutMapping("/{id}/completed")
    public ResponseEntity<Void> updateCompleted(@PathVariable int id, @RequestBody Map<String, Integer> body) {
        Integer completed = body.get("completed");
        if (completed == null || (completed != 0 && completed != 1)) {
            return ResponseEntity.badRequest().build();
        }
        grammarService.updateCompleted(id, completed);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}/content", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getContent(@PathVariable int id) throws IOException {
        String html = grammarService.getContentAsHtml(id);
        if (html == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(html);
    }
}
```

- [ ] **Step 6: GrammarControllerTest.java を作成**

```java
package com.studyenglish.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GrammarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll_returns200WithTopics() throws Exception {
        mockMvc.perform(get("/api/grammar"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$[0].sortOrder").value(1))
            .andExpect(jsonPath("$[0].title").isString());
    }

    @Test
    void updateCompleted_validValue_returns200() throws Exception {
        mockMvc.perform(put("/api/grammar/1/completed")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"completed\": 1}"))
            .andExpect(status().isOk());
    }

    @Test
    void updateCompleted_invalidValue_returns400() throws Exception {
        mockMvc.perform(put("/api/grammar/1/completed")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"completed\": 5}"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void getContent_existingTopic_returns200WithHtml() throws Exception {
        mockMvc.perform(get("/api/grammar/1/content"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @Test
    void getContent_nonExistingTopic_returns404() throws Exception {
        mockMvc.perform(get("/api/grammar/99999/content"))
            .andExpect(status().isNotFound());
    }
}
```

- [ ] **Step 7: テスト実行**

```bash
cd backend
./gradlew test
```

Expected: All tests PASS（Word + Grammar 全テスト）

- [ ] **Step 8: コミット**

```bash
cd ..
git add backend/src/
git commit -m "feat: add Grammar REST API with markdown content serving"
```

---

## Chunk 4: フロントエンド再構成

### Task 7: frontend/ ディレクトリ移行・基盤セットアップ

**Files:**
- Move: `app/` → `frontend/`
- Modify: `frontend/vite.config.js`
- Modify: `frontend/package.json`
- Create: `frontend/src/router/index.js`
- Create: `frontend/src/api/client.js`
- Delete: 不要コンポーネント群

- [ ] **Step 1: app/ → frontend/ にリネーム**

```bash
mv app frontend
```

- [ ] **Step 2: 不要な依存・コンポーネントを削除**

```bash
# 不要コンポーネント削除
rm frontend/src/components/EnglishGrammarGuide.vue
rm frontend/src/components/GrammarGuide.vue
rm frontend/src/components/PartsOfSpeechGuide.vue
rm frontend/src/components/NgslChecklist.vue
rm frontend/src/components/ReadingPage.vue
rm frontend/src/components/CurriculumViewer.vue
rm frontend/src/components/Sidebar.vue
rm frontend/src/components/SearchFilter.vue
rm frontend/src/components/VocabularyList.vue
rm frontend/src/components/VocabularyCard.vue
```

- [ ] **Step 3: Vue Router と axios をインストール**

```bash
cd frontend
npm install vue-router@4 axios
```

- [ ] **Step 4: vite.config.js を更新**

```js
// frontend/vite.config.js
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  base: '/english-for-it-engineers/',
  plugins: [vue()],
  server: {
    host: true,
    proxy: {
      '/api': 'http://localhost:8080'
    }
  }
})
```

- [ ] **Step 5: API クライアントを作成**

```js
// frontend/src/api/client.js
import axios from 'axios'

const api = axios.create({
  baseURL: '/api'
})

export const wordApi = {
  getWords(params = {}) {
    return api.get('/words', { params })
  },
  getWord(id) {
    return api.get(`/words/${id}`)
  },
  updateKnown(id, known) {
    return api.put(`/words/${id}/known`, { known })
  },
  getStats() {
    return api.get('/words/stats')
  }
}

export const grammarApi = {
  getTopics() {
    return api.get('/grammar')
  },
  updateCompleted(id, completed) {
    return api.put(`/grammar/${id}/completed`, { completed })
  },
  getContent(id) {
    return api.get(`/grammar/${id}/content`)
  }
}
```

- [ ] **Step 6: Vue Router を作成**

```js
// frontend/src/router/index.js
import { createRouter, createWebHistory } from 'vue-router'
import Dashboard from '../views/Dashboard.vue'
import VocabularyStep from '../views/VocabularyStep.vue'
import GrammarStep from '../views/GrammarStep.vue'
import Settings from '../views/Settings.vue'

const routes = [
  { path: '/', name: 'dashboard', component: Dashboard },
  { path: '/vocabulary', name: 'vocabulary', component: VocabularyStep },
  { path: '/grammar', name: 'grammar', component: GrammarStep },
  { path: '/settings', name: 'settings', component: Settings },
]

const router = createRouter({
  history: createWebHistory('/english-for-it-engineers/'),
  routes
})

export default router
```

- [ ] **Step 7: main.js を更新**

```js
// frontend/src/main.js
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './assets/style.css'

createApp(App).use(router).mount('#app')
```

- [ ] **Step 8: App.vue をルーター対応に書き換え**

```vue
<!-- frontend/src/App.vue -->
<template>
  <div id="app">
    <nav class="top-nav">
      <router-link to="/" class="nav-item" :class="{ active: $route.name === 'dashboard' }">
        Dashboard
      </router-link>
      <router-link to="/vocabulary" class="nav-item" :class="{ active: $route.name === 'vocabulary' }">
        単語
      </router-link>
      <router-link to="/grammar" class="nav-item" :class="{ active: $route.name === 'grammar' }">
        文法
      </router-link>
      <router-link to="/settings" class="nav-item" :class="{ active: $route.name === 'settings' }">
        設定
      </router-link>
    </nav>
    <main class="main-content">
      <router-view />
    </main>
  </div>
</template>

<script setup>
</script>

<style scoped>
.top-nav {
  display: flex;
  gap: 4px;
  padding: 8px 16px;
  background: #1a1a2e;
  border-bottom: 1px solid #333;
}

.nav-item {
  padding: 8px 16px;
  color: #888;
  text-decoration: none;
  border-radius: 4px;
  font-size: 14px;
}

.nav-item:hover {
  color: #ccc;
  background: #2a2a4a;
}

.nav-item.active {
  color: #64b5f6;
  background: #2a2a4a;
}

.main-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 24px;
}
</style>
```

- [ ] **Step 9: 仮の views ファイルを作成（全4ページ）**

```vue
<!-- frontend/src/views/Dashboard.vue -->
<template>
  <div>
    <h1>Dashboard</h1>
    <p>TODO: ミッション駆動型ダッシュボード</p>
  </div>
</template>
```

```vue
<!-- frontend/src/views/VocabularyStep.vue -->
<template>
  <div>
    <h1>単語・熟語</h1>
    <p>TODO: リスト型単語ページ</p>
  </div>
</template>
```

```vue
<!-- frontend/src/views/GrammarStep.vue -->
<template>
  <div>
    <h1>文法</h1>
    <p>TODO: 2カラム文法ページ</p>
  </div>
</template>
```

```vue
<!-- frontend/src/views/Settings.vue -->
<template>
  <div>
    <h1>設定</h1>
    <p>将来用</p>
  </div>
</template>
```

- [ ] **Step 10: ビルド確認**

```bash
cd frontend
npm run dev
# ブラウザで http://100.124.149.51:5173/english-for-it-engineers/ を確認
# 4つのナビタブが表示され、各ページに遷移できることを確認
```

- [ ] **Step 11: コミット**

```bash
cd ..
git add frontend/ app/
git commit -m "refactor: rename app to frontend, add Vue Router and API client"
```

---

### Task 8: 単語ページ（VocabularyStep.vue）

**Files:**
- Modify: `frontend/src/views/VocabularyStep.vue`

- [ ] **Step 1: VocabularyStep.vue を実装**

```vue
<!-- frontend/src/views/VocabularyStep.vue -->
<template>
  <div class="vocabulary-page">
    <!-- フィルタバー -->
    <div class="filter-bar">
      <div class="filter-group">
        <button
          v-for="opt in knownOptions"
          :key="opt.value"
          :class="['filter-btn', { active: filters.known === opt.value }]"
          @click="filters.known = opt.value"
        >
          {{ opt.label }}
        </button>
      </div>
      <div class="filter-group">
        <button
          v-for="opt in levelOptions"
          :key="opt.value"
          :class="['filter-btn', { active: filters.level === opt.value }]"
          @click="filters.level = opt.value"
        >
          {{ opt.label }}
        </button>
      </div>
      <div class="filter-group">
        <button
          v-for="opt in sourceOptions"
          :key="opt.value"
          :class="['filter-btn', { active: filters.source === opt.value }]"
          @click="filters.source = opt.value"
        >
          {{ opt.label }}
        </button>
      </div>
    </div>

    <!-- 単語リスト -->
    <div class="word-list">
      <div v-for="word in words" :key="word.id" class="word-row">
        <div class="word-info">
          <span class="word-text">{{ word.word }}</span>
          <span class="word-meaning">{{ word.meaningGeneral }}</span>
          <span v-if="word.meaningIt" class="word-meaning-it">{{ word.meaningIt }}</span>
        </div>
        <div class="word-actions">
          <button
            :class="['known-btn', 'unknown', { active: word.known === 0 }]"
            @click="setKnown(word, 0)"
          >✗</button>
          <button
            :class="['known-btn', 'learning', { active: word.known === 1 }]"
            @click="setKnown(word, 1)"
          >△</button>
          <button
            :class="['known-btn', 'mastered', { active: word.known === 2 }]"
            @click="setKnown(word, 2)"
          >◎</button>
        </div>
      </div>
    </div>

    <!-- ページング -->
    <div class="pagination">
      <button :disabled="page === 0" @click="page--">前</button>
      <span>{{ page * size + 1 }}-{{ Math.min((page + 1) * size, totalElements) }} / {{ totalElements }}語</span>
      <button :disabled="(page + 1) * size >= totalElements" @click="page++">次</button>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive, watch } from 'vue'
import { wordApi } from '../api/client'

const words = ref([])
const page = ref(0)
const size = 100
const totalElements = ref(0)

const filters = reactive({
  known: null,
  level: null,
  source: null
})

const knownOptions = [
  { label: '全て', value: null },
  { label: '未学習', value: 0 },
  { label: '学習中', value: 1 },
  { label: '習得済', value: 2 },
]

const levelOptions = [
  { label: '全Level', value: null },
  { label: 'Lv.1', value: 1 },
  { label: 'Lv.2', value: 2 },
]

const sourceOptions = [
  { label: '全ソース', value: null },
  { label: 'NGSL', value: 'NGSL' },
  { label: 'IT', value: 'IT' },
]

async function fetchWords() {
  const params = { page: page.value, size }
  if (filters.known !== null) params.known = filters.known
  if (filters.level !== null) params.level = filters.level
  if (filters.source !== null) params.source = filters.source
  const res = await wordApi.getWords(params)
  words.value = res.data.content
  totalElements.value = res.data.totalElements
}

async function setKnown(word, value) {
  await wordApi.updateKnown(word.id, value)
  word.known = value
}

watch([() => filters.known, () => filters.level, () => filters.source], () => {
  page.value = 0
  fetchWords()
})

watch(page, fetchWords)

fetchWords()
</script>

<style scoped>
.filter-bar {
  display: flex;
  gap: 12px;
  flex-wrap: wrap;
  margin-bottom: 16px;
}

.filter-group {
  display: flex;
  gap: 4px;
}

.filter-btn {
  padding: 4px 12px;
  background: #2a2a4a;
  color: #aaa;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 13px;
}

.filter-btn:hover { color: #fff; }
.filter-btn.active { background: #81c784; color: #1a1a2e; }

.word-list {
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.word-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 12px;
  background: #2a2a4a;
  border-radius: 4px;
}

.word-info {
  display: flex;
  align-items: baseline;
  gap: 8px;
  flex-wrap: wrap;
}

.word-text { font-weight: bold; color: #fff; }
.word-meaning { color: #aaa; font-size: 14px; }
.word-meaning-it { color: #64b5f6; font-size: 13px; }

.word-actions { display: flex; gap: 4px; }

.known-btn {
  padding: 4px 8px;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  font-size: 12px;
  opacity: 0.5;
}

.known-btn.active { opacity: 1; }
.known-btn.unknown { background: #ef5350; color: #fff; }
.known-btn.learning { background: #ffb74d; color: #1a1a2e; }
.known-btn.mastered { background: #81c784; color: #1a1a2e; }

.pagination {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 16px;
  margin-top: 16px;
  color: #aaa;
  font-size: 14px;
}

.pagination button {
  padding: 6px 16px;
  background: #2a2a4a;
  color: #ccc;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.pagination button:disabled { opacity: 0.3; cursor: default; }
</style>
```

- [ ] **Step 2: 動作確認**

```bash
# バックエンド起動（別ターミナル）
cd backend && ./gradlew bootRun

# フロントエンド起動
cd frontend && npm run dev
# ブラウザで /vocabulary ページを確認
# - 単語が100件表示される
# - フィルタが動作する
# - ✗△◎ボタンで状態が変わる
# - ページングが動作する
```

- [ ] **Step 3: コミット**

```bash
git add frontend/src/views/VocabularyStep.vue
git commit -m "feat: implement vocabulary list page with filters and pagination"
```

---

### Task 9: 文法ページ（GrammarStep.vue）

**Files:**
- Modify: `frontend/src/views/GrammarStep.vue`

- [ ] **Step 1: GrammarStep.vue を実装**

```vue
<!-- frontend/src/views/GrammarStep.vue -->
<template>
  <div class="grammar-page">
    <div class="grammar-layout">
      <!-- 左: トピック一覧 -->
      <aside class="topic-sidebar">
        <div
          v-for="topic in topics"
          :key="topic.id"
          :class="['topic-item', {
            completed: topic.completed,
            active: selectedId === topic.id,
            next: !topic.completed && !selectedId && isNextTopic(topic)
          }]"
          @click="selectTopic(topic)"
        >
          <span class="topic-icon">
            {{ topic.completed ? '✓' : (isNextTopic(topic) ? '▶' : '○') }}
          </span>
          <span class="topic-title">{{ topic.sortOrder }}. {{ topic.title }}</span>
        </div>
      </aside>

      <!-- 右: コンテンツ -->
      <div class="topic-content">
        <div v-if="!selectedId" class="empty-state">
          左のリストからトピックを選んでください
        </div>
        <div v-else-if="loading" class="loading">読み込み中...</div>
        <div v-else>
          <div class="content-header">
            <label class="complete-check">
              <input
                type="checkbox"
                :checked="selectedTopic?.completed"
                @change="toggleCompleted"
              />
              完了
            </label>
          </div>
          <div class="markdown-body" v-html="content"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { grammarApi } from '../api/client'

const topics = ref([])
const selectedId = ref(null)
const content = ref('')
const loading = ref(false)

const selectedTopic = computed(() =>
  topics.value.find(t => t.id === selectedId.value)
)

function isNextTopic(topic) {
  const incomplete = topics.value.filter(t => !t.completed)
  return incomplete.length > 0 && incomplete[0].id === topic.id
}

async function fetchTopics() {
  const res = await grammarApi.getTopics()
  topics.value = res.data
}

async function selectTopic(topic) {
  selectedId.value = topic.id
  loading.value = true
  const res = await grammarApi.getContent(topic.id)
  content.value = res.data
  loading.value = false
}

async function toggleCompleted() {
  const topic = selectedTopic.value
  const newValue = topic.completed ? 0 : 1
  await grammarApi.updateCompleted(topic.id, newValue)
  topic.completed = newValue
}

fetchTopics()
</script>

<style scoped>
.grammar-layout {
  display: flex;
  gap: 16px;
  min-height: calc(100vh - 120px);
}

.topic-sidebar {
  flex: 0 0 240px;
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.topic-item {
  padding: 8px 10px;
  background: #2a2a4a;
  border-radius: 4px;
  cursor: pointer;
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 13px;
  color: #888;
  border-left: 3px solid #444;
}

.topic-item:hover { color: #ccc; }
.topic-item.completed { color: #81c784; background: #2a3a2a; border-left-color: #81c784; }
.topic-item.active { color: #fff; font-weight: bold; background: #3a3a6a; border-left-color: #64b5f6; }
.topic-item.next { color: #64b5f6; border-left-color: #64b5f6; }

.topic-icon { font-size: 12px; flex-shrink: 0; }

.topic-content {
  flex: 1;
  background: #2a2a4a;
  border-radius: 4px;
  padding: 24px;
  overflow-y: auto;
}

.content-header {
  display: flex;
  justify-content: flex-end;
  margin-bottom: 16px;
}

.complete-check {
  display: flex;
  align-items: center;
  gap: 6px;
  color: #aaa;
  font-size: 14px;
  cursor: pointer;
}

.empty-state, .loading {
  color: #666;
  text-align: center;
  padding: 48px;
}

.markdown-body {
  color: #e0e0e0;
  line-height: 1.8;
}

.markdown-body :deep(h1) { font-size: 24px; color: #fff; margin-bottom: 16px; }
.markdown-body :deep(h2) { font-size: 20px; color: #e0e0e0; margin-top: 24px; margin-bottom: 12px; }
.markdown-body :deep(h3) { font-size: 16px; color: #ccc; margin-top: 16px; margin-bottom: 8px; }
.markdown-body :deep(code) { background: #1a1a2e; padding: 2px 6px; border-radius: 3px; font-size: 13px; }
.markdown-body :deep(pre) { background: #1a1a2e; padding: 16px; border-radius: 4px; overflow-x: auto; }
.markdown-body :deep(table) { width: 100%; border-collapse: collapse; margin: 12px 0; }
.markdown-body :deep(th), .markdown-body :deep(td) { border: 1px solid #444; padding: 8px; text-align: left; }
.markdown-body :deep(th) { background: #1a1a2e; }
</style>
```

- [ ] **Step 2: 動作確認**

```bash
# バックエンド・フロントエンド起動済みの状態で
# ブラウザで /grammar ページを確認
# - 左サイドバーにトピック14件が表示される
# - クリックで右にMD内容がHTML表示される
# - 完了チェックが動作する
```

- [ ] **Step 3: コミット**

```bash
git add frontend/src/views/GrammarStep.vue
git commit -m "feat: implement grammar page with sidebar and markdown rendering"
```

---

### Task 10: ダッシュボード（Dashboard.vue）

**Files:**
- Modify: `frontend/src/views/Dashboard.vue`

- [ ] **Step 1: Dashboard.vue を実装**

```vue
<!-- frontend/src/views/Dashboard.vue -->
<template>
  <div class="dashboard">
    <!-- ミッションエリア -->
    <div class="mission-card">
      <div class="mission-label">今日のミッション</div>
      <div class="mission-text">{{ mission.text }}</div>
      <router-link :to="mission.link" class="mission-btn">学習を始める →</router-link>
    </div>

    <!-- 進捗サマリー -->
    <div class="stats-grid">
      <div class="stat-card">
        <div class="stat-number mastered">{{ stats.mastered }}</div>
        <div class="stat-label">習得済</div>
      </div>
      <div class="stat-card">
        <div class="stat-number learning">{{ stats.learning }}</div>
        <div class="stat-label">学習中</div>
      </div>
      <div class="stat-card">
        <div class="stat-number unknown">{{ stats.unknown }}</div>
        <div class="stat-label">未学習</div>
      </div>
    </div>

    <!-- 文法進捗 -->
    <div class="grammar-progress" v-if="grammarStats.total > 0">
      <span class="grammar-label">文法:</span>
      <span class="grammar-count">{{ grammarStats.completed }}/{{ grammarStats.total }} 完了</span>
      <div class="grammar-bar">
        <div class="grammar-bar-fill" :style="{ width: grammarPercent + '%' }"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { wordApi, grammarApi } from '../api/client'

const stats = ref({ total: 0, unknown: 0, learning: 0, mastered: 0 })
const grammarStats = ref({ total: 0, completed: 0 })

const grammarPercent = computed(() => {
  if (grammarStats.value.total === 0) return 0
  return Math.round((grammarStats.value.completed / grammarStats.value.total) * 100)
})

const mission = computed(() => {
  const s = stats.value
  if (s.total === 0) return { text: 'データを読み込み中...', link: '/' }

  const masteredPercent = s.total > 0 ? (s.mastered / s.total) * 100 : 0
  if (masteredPercent >= 80) {
    return {
      text: '次の文法トピックに進もう',
      link: '/grammar'
    }
  }
  return {
    text: 'Level 1 の単語を20個覚えよう',
    link: '/vocabulary?known=0&level=1'
  }
})

onMounted(async () => {
  const [wordRes, grammarRes] = await Promise.all([
    wordApi.getStats(),
    grammarApi.getTopics()
  ])
  stats.value = wordRes.data
  const topics = grammarRes.data
  grammarStats.value = {
    total: topics.length,
    completed: topics.filter(t => t.completed).length
  }
})
</script>

<style scoped>
.dashboard {
  max-width: 600px;
  margin: 0 auto;
}

.mission-card {
  background: linear-gradient(135deg, #2a2a4a, #1a1a3e);
  padding: 32px;
  border-radius: 12px;
  text-align: center;
  margin-bottom: 24px;
}

.mission-label {
  color: #ffb74d;
  font-size: 14px;
  margin-bottom: 8px;
}

.mission-text {
  color: #fff;
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 16px;
}

.mission-btn {
  display: inline-block;
  background: #81c784;
  color: #1a1a2e;
  padding: 10px 24px;
  border-radius: 6px;
  font-weight: bold;
  text-decoration: none;
  font-size: 14px;
}

.mission-btn:hover { background: #a5d6a7; }

.stats-grid {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 12px;
  margin-bottom: 16px;
}

.stat-card {
  background: #2a2a4a;
  padding: 16px;
  border-radius: 8px;
  text-align: center;
}

.stat-number { font-size: 28px; font-weight: bold; }
.stat-number.mastered { color: #81c784; }
.stat-number.learning { color: #ffb74d; }
.stat-number.unknown { color: #ef5350; }
.stat-label { color: #aaa; font-size: 13px; margin-top: 4px; }

.grammar-progress {
  background: #2a2a4a;
  padding: 12px 16px;
  border-radius: 8px;
  display: flex;
  align-items: center;
  gap: 10px;
}

.grammar-label { color: #64b5f6; font-size: 14px; }
.grammar-count { color: #aaa; font-size: 13px; }

.grammar-bar {
  flex: 1;
  height: 6px;
  background: #333;
  border-radius: 3px;
}

.grammar-bar-fill {
  height: 6px;
  background: #64b5f6;
  border-radius: 3px;
  transition: width 0.3s;
}
</style>
```

- [ ] **Step 2: 動作確認**

```bash
# ブラウザで / (Dashboard) を確認
# - ミッションカードが表示される
# - 進捗数値が表示される（初期状態: 全件未学習）
# - 「学習を始める」で /vocabulary に遷移する
```

- [ ] **Step 3: コミット**

```bash
git add frontend/src/views/Dashboard.vue
git commit -m "feat: implement mission-driven dashboard"
```

---

## Chunk 5: クリーンアップ

### Task 11: 不要ファイル削除・CLAUDE.md 更新

**Files:**
- Delete: `docs/references/ngsl-top1000.json`
- Delete: `docs/references/vocabulary.json`
- Delete: `docs/references/readings.json` → 残す（Step3用）
- Modify: `CLAUDE.md`
- Modify: `.gitignore`

- [ ] **Step 1: 移行済みJSONファイルを削除**

```bash
rm docs/references/ngsl-top1000.json
rm docs/references/vocabulary.json
# readings.json は Step3 スコープのため残す
```

- [ ] **Step 2: .gitignore を更新**

```bash
# 以下を .gitignore に追加
# backend/study.db     (SQLiteファイル)
# .superpowers/        (既に追加済み)
```

既存の `.gitignore` に追加:

```
backend/study.db
```

- [ ] **Step 3: CLAUDE.md を更新**

CLAUDE.md の以下のセクションを更新:
- Directory Structure を新構成に合わせる
- `docs/references/` → `backend/src/main/resources/` のデータ管理に変更
- `app/` → `frontend/` のリネームを反映
- 開発環境の起動手順を追加

```markdown
## Directory Structure
- `frontend/` - フロントエンド（Vue 3 + Vite + Vue Router）
- `backend/` - バックエンド（Spring Boot + MyBatis + SQLite）
- `docs/plans/` - 設計書・学習プラン
- `docs/curriculum/` - カリキュラム・学習教材
  - `step1-grammar/` - 文法解説（番号順）
  - `step1-vocabulary/` - 語彙解説
- `scripts/` - ユーティリティスクリプト

## Development
### バックエンド起動
cd backend && ./gradlew bootRun
# → http://localhost:8080

### フロントエンド起動
cd frontend && npm run dev
# → http://100.124.149.51:5173/english-for-it-engineers/

### DB初期化
SQLiteのDB（backend/study.db）は Spring Boot 起動時に schema.sql + data.sql で自動初期化される。
```

- [ ] **Step 4: style.css をダークテーマに調整**

`frontend/src/assets/style.css` の `body` に以下を設定:

```css
body {
  margin: 0;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif;
  background: #0f0f23;
  color: #e0e0e0;
}
```

- [ ] **Step 5: 全体動作確認**

```bash
# バックエンド起動
cd backend && ./gradlew bootRun &

# フロントエンド起動
cd frontend && npm run dev &

# ブラウザで確認:
# 1. Dashboard: ミッション表示、進捗表示
# 2. 単語: フィルタ、ページング、✗△◎ボタン
# 3. 文法: サイドバー、MD表示、完了チェック
# 4. 設定: 空ページ
```

- [ ] **Step 6: コミット**

```bash
git add -A
git commit -m "chore: cleanup old JSON files, update CLAUDE.md for new structure"
```
