package com.trepudox.animal.core.model.enums;

import lombok.Getter;

@Getter
public enum PorteEnum {

    PEQUENO(1L, "Pequeno"), MEDIO(2L, "Médio"), GRANDE(3L, "Grande"), NA(4L, "Não se aplica");

    private final Long id;
    private final String label;

    PorteEnum(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public static PorteEnum valueOf(Long id) {
        for (PorteEnum value : PorteEnum.values())
            if (value.getId().equals(id))
                return value;

        return null;
    }

}
