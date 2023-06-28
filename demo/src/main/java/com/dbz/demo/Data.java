package com.dbz.demo;

import java.util.ArrayList;

public class Data {
    private String birthday;
    private String origin;
    private String species;

    public Data() {
    }

    public Data(String birthday, String origin, String species) {
        this.birthday = birthday;
        this.origin = origin;
        this.species = species;
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
}
