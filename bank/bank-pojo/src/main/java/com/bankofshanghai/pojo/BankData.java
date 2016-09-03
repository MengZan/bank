package com.bankofshanghai.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BankData {
    private Long id;

    private Long fromuser;

    private Long touser;

    private BigDecimal money;

    private Date datetime;

    private String fromplace;

    private String toplace;

    private String tool;

    private Integer safeLevel;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromuser() {
        return fromuser;
    }

    public void setFromuser(Long fromuser) {
        this.fromuser = fromuser;
    }

    public Long getTouser() {
        return touser;
    }

    public void setTouser(Long touser) {
        this.touser = touser;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getFromplace() {
        return fromplace;
    }

    public void setFromplace(String fromplace) {
        this.fromplace = fromplace == null ? null : fromplace.trim();
    }

    public String getToplace() {
        return toplace;
    }

    public void setToplace(String toplace) {
        this.toplace = toplace == null ? null : toplace.trim();
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool == null ? null : tool.trim();
    }

    public Integer getSafeLevel() {
        return safeLevel;
    }

    public void setSafeLevel(Integer safeLevel) {
        this.safeLevel = safeLevel;
    }
    
}