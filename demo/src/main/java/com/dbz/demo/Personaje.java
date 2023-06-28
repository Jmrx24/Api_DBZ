package com.dbz.demo;

public class Personaje {
    private String name;
    private String birthday;
    private String origin;
    private String species;

    public Personaje() {
    }

    public Personaje(String name, String birthday, String origin, String species) {
        this.name = name;
        this.birthday = birthday;
        this.origin = origin;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
