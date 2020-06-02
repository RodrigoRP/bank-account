package com.rodrigoramos.sistemabancarioapi.model.enums;

public enum AccountType {
    CORRENTE(1, "Conta Corrente"),
    EMPRESARIAL(2, "Conta Empresarial"),
    INDEFINIDA(3,"Conta Indefinada");

    private int id;
    private String description;

    AccountType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
