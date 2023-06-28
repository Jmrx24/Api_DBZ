package com.dbz.demo;

import java.util.ArrayList;

public class Data {
    private String birthday;
    private String origin;
    private String species;

    private String method_used;

    public Data() {
    }

    public Data(String birthday, String origin, String species) {
        this.birthday = birthday;
        this.origin = origin;
        this.species = species;
    }

    public Data(String method_used) {
        this.method_used = method_used;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getMethod_used() {
        return method_used;
    }

    public void setMethod_used(String method_used) {
        this.method_used = method_used;
    }
}
