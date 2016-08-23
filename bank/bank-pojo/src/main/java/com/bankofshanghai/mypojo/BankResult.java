package com.bankofshanghai.mypojo;

public class BankResult {

    /**
     * 0: 1: 2:
     */
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static BankResult build(Integer status, String msg, Object data) {
        return new BankResult(status, msg, data);
    }

    public static BankResult ok(Object data) {
        return new BankResult(data);
    }

    public static BankResult ok() {
        return new BankResult(null);
    }

    public BankResult() {  }

    public static BankResult build(Integer status, String msg) {
        return new BankResult(status, msg, null);
    }

    public BankResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public BankResult(Object data) {
        this.status = 1;
        this.msg = null;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
