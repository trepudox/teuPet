package com.trepudox.animal.core.controller;

import com.trepudox.animal.core.dto.AnimalDTO;
import com.trepudox.animal.core.dto.request.CreateAnimalRequest;
import com.trepudox.animal.core.dto.request.UpdateAnimalRequest;
import com.trepudox.animal.core.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/{animalId}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable Long animalId) {
        AnimalDTO animalDTO = animalService.getAnimalById(animalId);

        return new ResponseEntity<>(animalDTO, HttpStatus.OK);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsByPessoaId(@PathVariable Long pessoaId) {
        List<AnimalDTO> animals = animalService.getAnimalsByPessoaId(pessoaId);

        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @PostMapping("/pessoa/{pessoaId}")
    public ResponseEntity<AnimalDTO> createAnimal(@PathVariable Long pessoaId, @RequestBody CreateAnimalRequest createAnimalRequest) {
        AnimalDTO animal = animalService.createAnimal(pessoaId, createAnimalRequest);

        return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }

    @PutMapping("/{animalId}")
    public ResponseEntity<AnimalDTO> updateAnimal(@PathVariable Long animalId, @RequestBody UpdateAnimalRequest updateAnimalRequest) {
        AnimalDTO animal = animalService.updateAnimal(animalId, updateAnimalRequest);

        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<Void> deleteAnimalById(@PathVariable Long animalId) {
        animalService.deleteAnimal(animalId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
