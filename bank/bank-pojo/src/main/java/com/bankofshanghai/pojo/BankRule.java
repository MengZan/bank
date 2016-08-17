package com.bankofshanghai.pojo;

public class BankRule {
    private Long id;

    private String rulename;

    private String ruledesc;

    private Long frequency;

    private String type;

    private Integer safeLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename == null ? null : rulename.trim();
    }

    public String getRuledesc() {
        return ruledesc;
    }

    public void setRuledesc(String ruledesc) {
        this.ruledesc = ruledesc == null ? null : ruledesc.trim();
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getSafeLevel() {
        return safeLevel;
    }

    public void setSafeLevel(Integer safeLevel) {
        this.safeLevel = safeLevel;
    }
}