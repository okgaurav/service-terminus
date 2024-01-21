package com.stallion.serviceterminus.model.entity.config;

public class City {
    private String title;
    private String uCode;

    private String state;

    public String getState() {
        return state;
    }

    public City setState(String state) {
        this.state = state;
        return this;
    }

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
