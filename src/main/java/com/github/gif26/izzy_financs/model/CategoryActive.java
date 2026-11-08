package com.github.gif26.izzy_financs.model;

public enum CategoryActive {
    INACTIVE(0),
    ACTIVE(1);

    private final int value;

    CategoryActive(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
