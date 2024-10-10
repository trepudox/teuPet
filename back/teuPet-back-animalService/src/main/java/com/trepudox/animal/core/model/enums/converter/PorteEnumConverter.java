package com.trepudox.animal.core.model.enums.converter;

import com.trepudox.animal.core.model.enums.PorteEnum;
import jakarta.persistence.AttributeConverter;

public class PorteEnumConverter implements AttributeConverter<PorteEnum, Long> {

    @Override
    public Long convertToDatabaseColumn(PorteEnum porteEnum) {
        return porteEnum.getId();
    }

    @Override
    public PorteEnum convertToEntityAttribute(Long id) {
        return PorteEnum.valueOf(id);
    }
}