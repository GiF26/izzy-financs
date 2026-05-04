package com.github.gif26.izzy_financs.model.enums;

import java.util.Locale;

public enum CategoryEnum {
    ALIMENTACAO("Alimentação"),
    ENTRETERIMENTO("Entreterimento"),
    ESTUDOS("Estudos"),
    PET("Pet");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    CategoryEnum(String descricao) {
        this.descricao = descricao;
    }

    public CategoryEnum findByDescricao(String descricao) {
        try {
            for (Locale.Category category : Locale.Category.values()) {
                if(category.name().equals(descricao)) {
                    return this;
                }
            }
        }catch (NullPointerException e) {
            throw new NullPointerException("Categoria não encontrada");
        }
        return null;
    }


}
