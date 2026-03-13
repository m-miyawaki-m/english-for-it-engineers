package com.studyenglish.service;

import com.studyenglish.mapper.WordMapper;
import com.studyenglish.model.PageResponse;
import com.studyenglish.model.Word;
import com.studyenglish.model.WordStatsResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class WordService {

    private final WordMapper wordMapper;

    public WordService(WordMapper wordMapper) {
        this.wordMapper = wordMapper;
    }

    public PageResponse<Word> getWords(Integer level, String source, Integer known, String keyword, int page, int size) {
        int offset = page * size;
        List<Word> words = wordMapper.findAll(level, source, known, keyword, offset, size);
        int total = wordMapper.countAll(level, source, known, keyword);
        return new PageResponse<>(words, page, size, total);
    }

    public Word getWord(int id) {
        return wordMapper.findById(id);
    }

    public void updateKnown(int id, int known) {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        wordMapper.updateKnown(id, known, now);
    }

    public WordStatsResponse getStats() {
        Map<String, Object> row = wordMapper.getStats();
        return new WordStatsResponse(
                toInt(row.get("total")),
                toInt(row.get("unknown")),
                toInt(row.get("learning")),
                toInt(row.get("mastered"))
        );
    }

    private int toInt(Object value) {
        if (value == null) return 0;
        if (value instanceof Number) return ((Number) value).intValue();
        return Integer.parseInt(value.toString());
    }
}
