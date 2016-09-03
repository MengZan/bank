package com.bankofshanghai.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BankUser {
    private Long id;

    private String username;

    private String password;

    private Integer usertype;

    private Date datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}