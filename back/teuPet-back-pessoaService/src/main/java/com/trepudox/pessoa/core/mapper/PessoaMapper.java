package com.trepudox.pessoa.core.mapper;

import com.trepudox.pessoa.core.dto.PessoaDTO;
import com.trepudox.pessoa.core.dto.request.CreateAnimalRequest;
import com.trepudox.pessoa.core.model.PessoaModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO pessoaModelToPessoaDTO(PessoaModel pessoaModel);

    @Mapping(target = "id", ignore = true)
    PessoaModel createPessoaRequestToPessoaModel(CreateAnimalRequest createAnimalRequest);
}
