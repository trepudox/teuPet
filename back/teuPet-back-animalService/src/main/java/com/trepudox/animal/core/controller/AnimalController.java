package com.trepudox.animal.core.controller;

import com.trepudox.animal.core.dto.AnimalDTO;
import com.trepudox.animal.core.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animal")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable Long id) {
        AnimalDTO animalDTO = animalService.getAnimalById(id);

        return new ResponseEntity<>(animalDTO, HttpStatus.OK);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsByPessoaId(@PathVariable Long pessoaId) {
        List<AnimalDTO> animals = animalService.getAnimalsByPessoaId(pessoaId);

        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

}
