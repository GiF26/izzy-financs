package com.github.gif26.izzy_financs.model.enums;

public enum TransactionTypeEnum {
    VAZIO(0),
    ENTRADA(1),
    SAIDA(2);

    private int value;
    TransactionTypeEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static TransactionTypeEnum valueOf(int value) {
        for (TransactionTypeEnum type : TransactionTypeEnum.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in table");
    }

    public static int valueOf(TransactionTypeEnum type) {
        return type.value;
    }
}
