package com.trepudox.animal.core.model;

import lombok.Getter;

@Getter
public enum EspecieEnum {

    CACHORRO(1L, "Cachorro"), GATO(2L, "Gato");

    private final Long id;
    private final String label;

    EspecieEnum(Long id, String label) {
        this.id = id;
        this.label = label;
    }


}
