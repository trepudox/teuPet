package com.trepudox.animal.core.mapper;

import com.trepudox.animal.core.dto.AnimalDTO;
import com.trepudox.animal.core.model.AnimalModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    AnimalDTO animalModelToAnimalDTO(AnimalModel animalModel);

}
