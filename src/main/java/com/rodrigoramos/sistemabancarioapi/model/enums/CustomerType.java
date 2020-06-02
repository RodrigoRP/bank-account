package com.rodrigoramos.sistemabancarioapi.model.enums;

public enum CustomerType {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int id;
    private String description;

    private CustomerType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static CustomerType toEnum(Integer id) {
        if (id == null) {
            return null;
        }

        for (CustomerType type : CustomerType.values()) {
            if (id.equals(type.getId())) {
                return type;
            }

        }

        throw new IllegalArgumentException("Invalid code: " + id);
    }


}
