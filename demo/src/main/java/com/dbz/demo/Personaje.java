package com.dbz.demo;

public class Personaje {
    private String name;
    private Data data;
    private String url_scrap;

    public Personaje() {
    }

    public Personaje(String name, Data data, String url_scrap) {
        this.name = name;
        this.data = data;
        this.url_scrap = url_scrap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl_scrap() {
        return url_scrap;
    }

    public void setUrl_scrap(String url_scrap) {
        this.url_scrap = url_scrap;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
