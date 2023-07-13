package com.vti.demorestfulapi.model;

public class ResponseObject {
    private int status; // trả về mã lỗi
    private String message ; // trả vè thông báo
    private Object data; // trả về dữ liệu

    public ResponseObject() {
    }

    public ResponseObject(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
