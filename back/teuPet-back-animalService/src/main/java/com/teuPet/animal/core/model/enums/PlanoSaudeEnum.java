package com.teupet.animal.core.model.enums;

import lombok.Getter;

@Getter
public enum PlanoSaudeEnum {

    NENHUM(1L, "Nenhum"), BASICO(2L, "Básico"), PREMIUM(3L, "Premium");

    private final Long id;
    private final String label;

    PlanoSaudeEnum(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    public static PlanoSaudeEnum valueOf(Long id) {
        if (id == null)
            return null;

        for (PlanoSaudeEnum value : PlanoSaudeEnum.values())
            if (value.getId().equals(id))
                return value;

        return null;
    }

}
