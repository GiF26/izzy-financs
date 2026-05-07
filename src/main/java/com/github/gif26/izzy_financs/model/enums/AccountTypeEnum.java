package com.github.gif26.izzy_financs.model.enums;

public enum AccountTypeEnum {
    VAZIO(1),
    CREDITO(2),
    DEBITO(3),
    CREDITO_DEBITO(4);

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

    public static int fromEnum(AccountTypeEnum type) {
        return type.value;
    }
}
