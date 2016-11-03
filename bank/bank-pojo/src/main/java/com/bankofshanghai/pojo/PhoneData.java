package com.bankofshanghai.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PhoneData {
    private Long id;

    private Integer phoneNumber;

    private Integer safety;

    private Date datetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSafety() {
        return safety;
    }

    public void setSafety(Integer safety) {
        this.safety = safety;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}