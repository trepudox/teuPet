package com.teupet.animal.core.model.enums.converter;

import com.teupet.animal.core.model.enums.PlanoSaudeEnum;
import com.teupet.animal.core.model.enums.SexoEnum;
import jakarta.persistence.AttributeConverter;

public class PlanoSaudeEnumConverter implements AttributeConverter<PlanoSaudeEnum, Long> {

    @Override
    public Long convertToDatabaseColumn(PlanoSaudeEnum planoSaudeEnum) {
        return planoSaudeEnum.getId();
    }

    @Override
    public PlanoSaudeEnum convertToEntityAttribute(Long id) {
        return PlanoSaudeEnum.valueOf(id);
    }
}