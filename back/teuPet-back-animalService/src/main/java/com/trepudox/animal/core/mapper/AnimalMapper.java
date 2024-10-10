package com.trepudox.animal.core.mapper;

import com.trepudox.animal.core.dto.AnimalDTO;
import com.trepudox.animal.core.dto.request.CreateAnimalRequest;
import com.trepudox.animal.core.model.AnimalModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    @Mapping(target = "especie", expression = "java(animalModel.getEspecie().getId())")
    @Mapping(target = "sexo", expression = "java(animalModel.getSexo().getId())")
    @Mapping(target = "porte", expression = "java(animalModel.getPorte().getId())")
    AnimalDTO animalModelToAnimalDTO(AnimalModel animalModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "especie", expression = "java(com.trepudox.animal.core.model.enums.EspecieEnum.valueOf(createAnimalRequest.getEspecie()))")
    @Mapping(target = "sexo", expression = "java(com.trepudox.animal.core.model.enums.SexoEnum.valueOf(createAnimalRequest.getSexo()))")
    @Mapping(target = "porte", expression = "java(com.trepudox.animal.core.model.enums.PorteEnum.valueOf(createAnimalRequest.getPorte()))")
    AnimalModel createAnimalRequestToAnimalModel(CreateAnimalRequest createAnimalRequest);
}
