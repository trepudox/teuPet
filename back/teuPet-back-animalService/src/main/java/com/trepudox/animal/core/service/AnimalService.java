package com.trepudox.animal.core.service;

import com.trepudox.animal.core.dto.AnimalDTO;
import com.trepudox.animal.core.dto.request.CreateAnimalRequest;
import com.trepudox.animal.core.dto.request.UpdateAnimalRequest;
import com.trepudox.animal.core.exception.EntityNotFoundException;
import com.trepudox.animal.core.mapper.AnimalMapper;
import com.trepudox.animal.core.model.AnimalModel;
import com.trepudox.animal.core.model.enums.EspecieEnum;
import com.trepudox.animal.core.model.enums.PorteEnum;
import com.trepudox.animal.core.model.enums.SexoEnum;
import com.trepudox.animal.core.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalDTO getAnimalById(Long animalId) {
        AnimalModel animalModel = animalRepository.findById(animalId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Animal com ID '%s' não encontrado", animalId)));

        return AnimalMapper.INSTANCE.animalModelToAnimalDTO(animalModel);
    }

    public List<AnimalDTO> getAnimalsByPessoaId(Long pessoaId) {
        List<AnimalModel> animals = animalRepository.findAllByPessoaId(pessoaId);

        return animals.stream().map(AnimalMapper.INSTANCE::animalModelToAnimalDTO).toList();
    }

    public AnimalDTO createAnimal(Long pessoaId, CreateAnimalRequest createAnimalRequest) {
        AnimalModel animalModel = AnimalMapper.INSTANCE.createAnimalRequestToAnimalModel(createAnimalRequest);
        animalModel.setPessoaId(pessoaId);

        animalModel = animalRepository.save(animalModel);

        return AnimalMapper.INSTANCE.animalModelToAnimalDTO(animalModel);
    }

    public AnimalDTO updateAnimal(Long animalId, UpdateAnimalRequest updateAnimalRequest) {
        AnimalModel animalModel = animalRepository.findById(animalId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Animal com ID '%s' não encontrado", animalId)));

        animalModel.setNome(updateAnimalRequest.getNome());
        animalModel.setEspecie(EspecieEnum.valueOf(updateAnimalRequest.getEspecie()));
        animalModel.setSexo(SexoEnum.valueOf(updateAnimalRequest.getSexo()));
        animalModel.setPorte(PorteEnum.valueOf(updateAnimalRequest.getPorte()));
        animalModel.setPeso(updateAnimalRequest.getPeso());
        animalModel.setDataNascimento(updateAnimalRequest.getDataNascimento());

        animalModel = animalRepository.save(animalModel);

        return AnimalMapper.INSTANCE.animalModelToAnimalDTO(animalModel);
    }

    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }
}
