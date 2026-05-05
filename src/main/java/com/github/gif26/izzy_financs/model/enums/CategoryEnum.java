package com.github.gif26.izzy_financs.model.enums;

public enum CategoryEnum {
    ALIMENTACAO("Alimentação"),
    ENTRETERIMENTO("Entreterimento"),
    ESTUDOS("Estudos"),
    PET("Pet");

    private final String descricao;

    CategoryEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CategoryEnum findByDescricao(String descricao) {
        for (CategoryEnum cat : CategoryEnum.values()) {
            if (cat.getDescricao().equalsIgnoreCase(descricao)) {
                return cat;
            }
        }
        throw new IllegalArgumentException("Categoria não encontrada: " + descricao);
    }
}