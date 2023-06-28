package com.dbz.demo;

public class Fusion {

    private String name;

    private Data data;

    public Fusion() {
    }

    public Fusion(String name, Data data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
