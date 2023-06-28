package com.dbz.demo;

public class Fusion {

    private String name;
    private String method_used;

    public Fusion() {
    }

    public Fusion(String name, String method_used) {
        this.name = name;
        this.method_used = method_used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod_used() {
        return method_used;
    }

    public void setMethod_used(String method_used) {
        this.method_used = method_used;
    }
}
