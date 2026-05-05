package com.github.gif26.izzy_financs.model.enums;

public enum AccountTypeEnum {
    ENTRADA(1),
    SAIDA(2);

    private final int value;

    AccountTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AccountTypeEnum fromValue(int value) {
        for (AccountTypeEnum type : AccountTypeEnum.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo não encontrado: " + value);
    }
}
