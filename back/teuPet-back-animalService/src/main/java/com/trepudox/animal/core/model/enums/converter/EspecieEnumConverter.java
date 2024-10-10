package com.trepudox.animal.core.model.enums.converter;

import com.trepudox.animal.core.model.enums.EspecieEnum;
import jakarta.persistence.AttributeConverter;

public class EspecieEnumConverter implements AttributeConverter<EspecieEnum, Long> {

    @Override
    public Long convertToDatabaseColumn(EspecieEnum especieEnum) {
        return especieEnum.getId();
    }

    @Override
    public EspecieEnum convertToEntityAttribute(Long id) {
        return EspecieEnum.valueOf(id);
    }
}