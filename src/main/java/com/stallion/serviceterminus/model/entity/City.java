package com.stallion.serviceterminus.model.entity;

public class City {
    private String title;
    private String uCode;

    public String getTitle() {
        return title;
    }

    public City setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getuCode() {
        return uCode;
    }

    public City setuCode(String uCode) {
        this.uCode = uCode;
        return this;
    }
}
