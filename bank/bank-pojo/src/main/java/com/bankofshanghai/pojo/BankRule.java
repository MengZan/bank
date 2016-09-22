package com.bankofshanghai.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BankRule {
    private String id;

    private String rulename;

    private String ruledesc;

    private String type;

    private Integer safeLevel;

    private Integer version;

    private Long frequency;

    private Long hit;

    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Long getHit() {
        return hit;
    }

    public void setHit(Long hit) {
        this.hit = hit;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}