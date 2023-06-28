package com.dbz.demo;

public class Personaje {
    private String name;
    private String birthday;
    private String origin;
    private String species;

    private String url_scrap;

    public Personaje() {
    }

    public Personaje(String name, String birthday, String origin, String species, String url_scrap) {
        this.name = name;
        this.birthday = birthday;
        this.origin = origin;
        this.species = species;
        this.url_scrap = url_scrap;
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

    public String getUrl_scrap() {
        return url_scrap;
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

    public void setUrl_scrap(String url_scrap) {
        this.url_scrap = url_scrap;
    }
}
