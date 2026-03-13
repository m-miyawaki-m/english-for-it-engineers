package com.studyenglish.controller;

import com.studyenglish.model.PageResponse;
import com.studyenglish.model.Word;
import com.studyenglish.model.WordRelationsResponse;
import com.studyenglish.model.WordStatsResponse;
import com.studyenglish.service.WordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        return wordService.getWords(level, source, known, keyword, page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getWord(@PathVariable int id) {
        Word word = wordService.getWord(id);
        if (word == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(word);
    }

    @PutMapping("/{id}/known")
    public ResponseEntity<Void> updateKnown(@PathVariable int id, @RequestBody Map<String, Object> body) {
        Object knownValue = body.get("known");
        if (knownValue == null) {
            return ResponseEntity.badRequest().build();
        }
        int known;
        try {
            known = ((Number) knownValue).intValue();
        } catch (ClassCastException e) {
            return ResponseEntity.badRequest().build();
        }
        if (known < 0 || known > 2) {
            return ResponseEntity.badRequest().build();
        }
        wordService.updateKnown(id, known);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/relations")
    public WordRelationsResponse getRelations(@PathVariable int id) {
        return wordService.getRelations(id);
    }

    @GetMapping("/relations")
    public Map<Integer, WordRelationsResponse> getRelationsBatch(
            @RequestParam List<Integer> wordIds) {
        return wordService.getRelationsBatch(wordIds);
    }

    @GetMapping("/stats")
    public WordStatsResponse getStats() {
        return wordService.getStats();
    }
}
