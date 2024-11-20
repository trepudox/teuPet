package com.teupet.animal.core.model.enums;

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

    public static EspecieEnum valueOf(Long id) {
        if (id == null)
            return null;

        for (EspecieEnum value : EspecieEnum.values())
            if (value.getId().equals(id))
                return value;

        return null;
    }

}
