package com.trepudox.animal.core.model.enums.converter;

import com.trepudox.animal.core.model.enums.SexoEnum;
import jakarta.persistence.AttributeConverter;

public class SexoEnumConverter implements AttributeConverter<SexoEnum, Long> {

    @Override
    public Long convertToDatabaseColumn(SexoEnum sexoEnum) {
        return sexoEnum.getId();
    }

    @Override
    public SexoEnum convertToEntityAttribute(Long id) {
        return SexoEnum.valueOf(id);
    }
}