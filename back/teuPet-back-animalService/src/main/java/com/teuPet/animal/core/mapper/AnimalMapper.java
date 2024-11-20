package com.teupet.animal.core.mapper;

import com.teupet.animal.core.dto.AnimalDTO;
import com.teupet.animal.core.dto.request.CreateAnimalRequest;
import com.teupet.animal.core.dto.request.UpdateAnimalRequest;
import com.teupet.animal.core.model.AnimalModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    @Mapping(target = "especieId", expression = "java(animalModel.getEspecie().getId())")
    @Mapping(target = "sexoId", expression = "java(animalModel.getSexo().getId())")
    @Mapping(target = "porteId", expression = "java(animalModel.getPorte().getId())")
    @Mapping(target = "planoSaudeId", expression = "java(animalModel.getPlanoSaude().getId())")
    AnimalDTO animalModelToAnimalDTO(AnimalModel animalModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "especie", expression = "java(com.teupet.animal.core.model.enums.EspecieEnum.valueOf(createAnimalRequest.getEspecieId()))")
    @Mapping(target = "sexo", expression = "java(com.teupet.animal.core.model.enums.SexoEnum.valueOf(createAnimalRequest.getSexoId()))")
    @Mapping(target = "porte", expression = "java(com.teupet.animal.core.model.enums.PorteEnum.valueOf(createAnimalRequest.getPorteId()))")
    @Mapping(target = "planoSaude", expression = "java(com.teupet.animal.core.model.enums.PlanoSaudeEnum.valueOf(createAnimalRequest.getPlanoSaudeId()))")
    AnimalModel createAnimalRequestToAnimalModel(CreateAnimalRequest createAnimalRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "especie", expression = "java(com.teupet.animal.core.model.enums.EspecieEnum.valueOf(updateAnimalRequest.getEspecieId()))")
    @Mapping(target = "sexo", expression = "java(com.teupet.animal.core.model.enums.SexoEnum.valueOf(updateAnimalRequest.getSexoId()))")
    @Mapping(target = "porte", expression = "java(com.teupet.animal.core.model.enums.PorteEnum.valueOf(updateAnimalRequest.getPorteId()))")
    @Mapping(target = "planoSaude", expression = "java(com.teupet.animal.core.model.enums.PlanoSaudeEnum.valueOf(updateAnimalRequest.getPlanoSaudeId()))")
    AnimalModel updateAnimalRequestToAnimalModel(UpdateAnimalRequest updateAnimalRequest);
}
