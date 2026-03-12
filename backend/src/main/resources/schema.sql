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
