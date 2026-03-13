#!/usr/bin/env python3
"""Add IPA pronunciation data to existing NGSL words in data.sql.

Reads ipa-data.json and rewrites NGSL INSERT statements in data.sql
to include the pronunciation_ipa column.
"""

import json
import re
from pathlib import Path

SCRIPT_DIR = Path(__file__).resolve().parent
PROJECT_ROOT = SCRIPT_DIR.parent

IPA_PATH = SCRIPT_DIR / "ipa-data.json"
DATA_PATH = PROJECT_ROOT / "backend" / "src" / "main" / "resources" / "data.sql"


def escape_sql(value):
    if value is None:
        return "NULL"
    return "'" + str(value).replace("'", "''") + "'"


def main():
    with open(IPA_PATH, encoding="utf-8") as f:
        ipa_data = json.load(f)

    with open(DATA_PATH, encoding="utf-8") as f:
        lines = f.readlines()

    # Pattern for NGSL INSERT lines
    ngsl_pattern = re.compile(
        r"^INSERT INTO words \(word, meaning_general, meaning_it, frequency, source, level, known\) "
        r"VALUES \('([^']*)',"
    )

    new_lines = []
    updated = 0
    missing = 0

    for line in lines:
        m = ngsl_pattern.match(line)
        if m:
            word = m.group(1)
            ipa = ipa_data.get(word)
            if ipa:
                # Rewrite to include pronunciation_ipa
                line = line.replace(
                    "INSERT INTO words (word, meaning_general, meaning_it, frequency, source, level, known) VALUES (",
                    "INSERT INTO words (word, meaning_general, meaning_it, pronunciation_ipa, frequency, source, level, known) VALUES ("
                )
                # Insert IPA value after meaning_it value
                # Find the pattern: meaning_it_value, frequency
                # meaning_it is either NULL or 'some text'
                parts = line.split(", ", 3)  # Split into first 3 comma-separated parts + rest
                # Actually, let's use a more robust approach
                # Find the third value (meaning_it) and insert IPA after it
                insert_prefix = "VALUES ("
                values_start = line.index(insert_prefix) + len(insert_prefix)
                values_str = line[values_start:]

                # Parse values carefully - handle quoted strings with commas
                values = []
                i = 0
                while i < len(values_str):
                    if values_str[i] == "'":
                        # Find matching closing quote (handle escaped quotes)
                        j = i + 1
                        while j < len(values_str):
                            if values_str[j] == "'" and (j + 1 >= len(values_str) or values_str[j + 1] != "'"):
                                break
                            if values_str[j] == "'" and j + 1 < len(values_str) and values_str[j + 1] == "'":
                                j += 2
                                continue
                            j += 1
                        values.append(values_str[i:j + 1])
                        i = j + 1
                        # Skip ", "
                        while i < len(values_str) and values_str[i] in (',',' '):
                            i += 1
                    elif values_str[i:i+4] == 'NULL':
                        values.append('NULL')
                        i += 4
                        while i < len(values_str) and values_str[i] in (',',' '):
                            i += 1
                    elif values_str[i].isdigit():
                        j = i
                        while j < len(values_str) and values_str[j].isdigit():
                            j += 1
                        values.append(values_str[i:j])
                        i = j
                        while i < len(values_str) and values_str[i] in (',',' '):
                            i += 1
                    else:
                        i += 1

                # values should be: [word, meaning_general, meaning_it, frequency, source, level, known]
                # Insert IPA after meaning_it (index 2)
                if len(values) >= 7:
                    values.insert(3, escape_sql(ipa))
                    line = f"INSERT INTO words (word, meaning_general, meaning_it, pronunciation_ipa, frequency, source, level, known) VALUES ({', '.join(values)});\n"
                    updated += 1
                else:
                    missing += 1
            else:
                missing += 1

        new_lines.append(line)

    with open(DATA_PATH, "w", encoding="utf-8") as f:
        f.writelines(new_lines)

    print(f"Updated: {updated} words with IPA")
    print(f"Missing IPA: {missing} words")


if __name__ == "__main__":
    main()
