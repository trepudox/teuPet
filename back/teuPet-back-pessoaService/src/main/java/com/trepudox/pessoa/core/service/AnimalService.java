package com.trepudox.pessoa.core.service;

import com.trepudox.pessoa.core.dto.PessoaDTO;
import com.trepudox.pessoa.core.dto.request.CreateAnimalRequest;
import com.trepudox.pessoa.core.dto.request.UpdateAnimalRequest;
import com.trepudox.pessoa.core.exception.EntityNotFoundException;
import com.trepudox.pessoa.core.mapper.PessoaMapper;
import com.trepudox.pessoa.core.model.PessoaModel;
import com.trepudox.pessoa.core.model.enums.EspecieEnum;
import com.trepudox.pessoa.core.model.enums.PorteEnum;
import com.trepudox.pessoa.core.model.enums.SexoEnum;
import com.trepudox.pessoa.core.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public PessoaDTO getAnimalById(Long animalId) {
        PessoaModel pessoaModel = animalRepository.findById(animalId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Animal com ID '%s' não encontrado", animalId)));

        return PessoaMapper.INSTANCE.animalModelToAnimalDTO(pessoaModel);
    }

    public List<PessoaDTO> getAnimalsByPessoaId(Long pessoaId) {
        List<PessoaModel> animals = animalRepository.findAllByPessoaId(pessoaId);

        return animals.stream().map(PessoaMapper.INSTANCE::animalModelToAnimalDTO).toList();
    }

    public PessoaDTO createAnimal(Long pessoaId, CreateAnimalRequest createAnimalRequest) {
        PessoaModel pessoaModel = PessoaMapper.INSTANCE.createAnimalRequestToAnimalModel(createAnimalRequest);
        pessoaModel.setPessoaId(pessoaId);

        pessoaModel = animalRepository.save(pessoaModel);

        return PessoaMapper.INSTANCE.animalModelToAnimalDTO(pessoaModel);
    }

    public PessoaDTO updateAnimal(Long animalId, UpdateAnimalRequest updateAnimalRequest) {
        PessoaModel pessoaModel = animalRepository.findById(animalId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Animal com ID '%s' não encontrado", animalId)));

        pessoaModel.setNome(updateAnimalRequest.getNome());
        pessoaModel.setEspecie(EspecieEnum.valueOf(updateAnimalRequest.getEspecie()));
        pessoaModel.setSexo(SexoEnum.valueOf(updateAnimalRequest.getSexo()));
        pessoaModel.setPorte(PorteEnum.valueOf(updateAnimalRequest.getPorte()));
        pessoaModel.setPeso(updateAnimalRequest.getPeso());
        pessoaModel.setDataNascimento(updateAnimalRequest.getDataNascimento());

        pessoaModel = animalRepository.save(pessoaModel);

        return PessoaMapper.INSTANCE.animalModelToAnimalDTO(pessoaModel);
    }

    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }
}
