package com.studyenglish.model;

public class WordRelation {
    private Integer id;
    private Integer wordId;
    private String relatedWord;
    private String relationType;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getWordId() { return wordId; }
    public void setWordId(Integer wordId) { this.wordId = wordId; }

    public String getRelatedWord() { return relatedWord; }
    public void setRelatedWord(String relatedWord) { this.relatedWord = relatedWord; }

    public String getRelationType() { return relationType; }
    public void setRelationType(String relationType) { this.relationType = relationType; }
}
