package com.studyenglish.model;

import java.util.List;

public class WordRelationsResponse {
    private List<String> synonyms;
    private List<String> antonyms;
    private List<String> derivatives;

    public WordRelationsResponse(List<String> synonyms, List<String> antonyms, List<String> derivatives) {
        this.synonyms = synonyms;
        this.antonyms = antonyms;
        this.derivatives = derivatives;
    }

    public List<String> getSynonyms() { return synonyms; }
    public List<String> getAntonyms() { return antonyms; }
    public List<String> getDerivatives() { return derivatives; }
}
