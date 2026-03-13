package com.studyenglish.service;

import com.studyenglish.mapper.WordMapper;
import com.studyenglish.mapper.WordRelationMapper;
import com.studyenglish.model.PageResponse;
import com.studyenglish.model.Word;
import com.studyenglish.model.WordRelation;
import com.studyenglish.model.WordRelationsResponse;
import com.studyenglish.model.WordStatsResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WordService {

    private final WordMapper wordMapper;
    private final WordRelationMapper wordRelationMapper;

    public WordService(WordMapper wordMapper, WordRelationMapper wordRelationMapper) {
        this.wordMapper = wordMapper;
        this.wordRelationMapper = wordRelationMapper;
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

    public WordRelationsResponse getRelations(int wordId) {
        List<WordRelation> relations = wordRelationMapper.findByWordId(wordId);
        return toRelationsResponse(relations);
    }

    public Map<Integer, WordRelationsResponse> getRelationsBatch(List<Integer> wordIds) {
        if (wordIds == null || wordIds.isEmpty()) {
            return new HashMap<>();
        }
        List<WordRelation> allRelations = wordRelationMapper.findByWordIds(wordIds);
        Map<Integer, List<WordRelation>> grouped = allRelations.stream()
                .collect(Collectors.groupingBy(WordRelation::getWordId));
        Map<Integer, WordRelationsResponse> result = new HashMap<>();
        for (Integer id : wordIds) {
            List<WordRelation> rels = grouped.getOrDefault(id, new ArrayList<>());
            result.put(id, toRelationsResponse(rels));
        }
        return result;
    }

    private WordRelationsResponse toRelationsResponse(List<WordRelation> relations) {
        List<String> synonyms = new ArrayList<>();
        List<String> antonyms = new ArrayList<>();
        List<String> derivatives = new ArrayList<>();
        for (WordRelation r : relations) {
            switch (r.getRelationType()) {
                case "synonym": synonyms.add(r.getRelatedWord()); break;
                case "antonym": antonyms.add(r.getRelatedWord()); break;
                case "derivative": derivatives.add(r.getRelatedWord()); break;
            }
        }
        return new WordRelationsResponse(synonyms, antonyms, derivatives);
    }

    private int toInt(Object value) {
        if (value == null) return 0;
        if (value instanceof Number) return ((Number) value).intValue();
        return Integer.parseInt(value.toString());
    }
}
