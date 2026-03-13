CREATE TABLE IF NOT EXISTS words (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    word TEXT NOT NULL,
    meaning_general TEXT,
    meaning_it TEXT,
    part_of_speech TEXT,
    pronunciation_ipa TEXT,
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

CREATE TABLE IF NOT EXISTS word_relations (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    word_id INTEGER NOT NULL,
    related_word TEXT NOT NULL,
    relation_type TEXT NOT NULL CHECK(relation_type IN ('derivative', 'synonym', 'antonym')),
    FOREIGN KEY (word_id) REFERENCES words(id)
);

CREATE INDEX IF NOT EXISTS idx_word_relations_word_id ON word_relations(word_id);
