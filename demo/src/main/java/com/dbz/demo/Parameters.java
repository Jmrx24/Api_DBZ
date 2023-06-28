package com.dbz.demo;

public class Parameters {
    private String tipo;
    private String name;

    public Parameters(String tipo, String name) {
        this.tipo = tipo;
        this.name = name;
    }

    public Parameters() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
