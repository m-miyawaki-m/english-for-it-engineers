package com.studyenglish.model;

public class Word {
    private Integer id;
    private String word;
    private String meaningGeneral;
    private String meaningIt;
    private String partOfSpeech;
    private String pronunciationIpa;
    private String domain;
    private String source;
    private Integer level;
    private Integer frequency;
    private String exampleEn;
    private String exampleJa;
    private Integer known;
    private String lastReviewed;
    private String createdAt;

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

    public String getPronunciationIpa() { return pronunciationIpa; }
    public void setPronunciationIpa(String pronunciationIpa) { this.pronunciationIpa = pronunciationIpa; }

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
