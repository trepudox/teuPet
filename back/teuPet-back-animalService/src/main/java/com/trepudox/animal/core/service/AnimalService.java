package com.trepudox.animal.core.service;

import com.trepudox.animal.core.dto.AnimalDTO;
import com.trepudox.animal.core.exception.EntityNotFoundException;
import com.trepudox.animal.core.mapper.AnimalMapper;
import com.trepudox.animal.core.model.AnimalModel;
import com.trepudox.animal.core.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalDTO getAnimalById(Long id) {
        AnimalModel animalModel = animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Animal com ID '%s' não encontrado", id)));

        return AnimalMapper.INSTANCE.animalModelToAnimalDTO(animalModel);
    }

    public List<AnimalDTO> getAnimalsByPessoaId(Long pessoaId) {
        List<AnimalModel> animals = animalRepository.findAllByPessoaId(pessoaId);

        return animals.stream().map(AnimalMapper.INSTANCE::animalModelToAnimalDTO).toList();
    }

}
