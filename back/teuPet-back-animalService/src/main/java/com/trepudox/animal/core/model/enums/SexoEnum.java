package com.trepudox.animal.core.model.enums;

import lombok.Getter;

@Getter
public enum SexoEnum {

    MACHO(1L, "Macho"), FEMEA(2L, "Fêmea");

    private final Long id;
    private final String label;

    SexoEnum(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public static SexoEnum valueOf(Long id) {
        for (SexoEnum value : SexoEnum.values())
            if (value.getId().equals(id))
                return value;

        return null;
    }

}
