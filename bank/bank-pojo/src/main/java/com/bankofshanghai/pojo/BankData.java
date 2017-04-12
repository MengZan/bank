package com.bankofshanghai.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BankData implements Serializable  {
	private Long id;

    private Long fromuser;

    private Long touser;

    private BigDecimal money;

    private Date datetime;

    private String fromplace;

    private String toplace;

    private Date fromuserOpendate;

    private Integer touserCredit;

    private String tool;

    private Integer safeLevel;
    
    private Boolean isFraud;

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

    public Date getFromuserOpendate() {
        return fromuserOpendate;
    }

    public void setFromuserOpendate(Date fromuserOpendate) {
        this.fromuserOpendate = fromuserOpendate;
    }

    public Integer getTouserCredit() {
        return touserCredit;
    }

    public void setTouserCredit(Integer touserCredit) {
        this.touserCredit = touserCredit;
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
    
    public Boolean getIsFraud() {
        return isFraud;
    }

    public void setIsFraud(Boolean isFraud) {
        this.isFraud = isFraud;
    }

	@Override
	public String toString() {
		return "BankData [id=" + id + ", fromuser=" + fromuser + ", touser=" + touser + ", money=" + money
				+ ", datetime=" + datetime + ", fromplace=" + fromplace + ", toplace=" + toplace + ", fromuserOpendate="
				+ fromuserOpendate + ", touserCredit=" + touserCredit + ", tool=" + tool + ", safeLevel=" + safeLevel
				+ ", isFraud=" + isFraud + "]";
	}

}