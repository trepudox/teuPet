package com.trepudox.animal.core.controller;

import com.trepudox.animal.core.dto.AnimalDTO;
import com.trepudox.animal.core.dto.request.CreateAnimalRequest;
import com.trepudox.animal.core.dto.request.UpdateAnimalRequest;
import com.trepudox.animal.core.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/animal")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/{animalId}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable Long animalId) {
        log.info("INICIO - getAnimalById");
        AnimalDTO animalDTO = animalService.getAnimalById(animalId);
        log.info("FIM - getAnimalById");

        return new ResponseEntity<>(animalDTO, HttpStatus.OK);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<AnimalDTO>> getAnimalsByPessoaId(@PathVariable Long pessoaId) {
        log.info("INICIO - getAnimalsByPessoaId");
        List<AnimalDTO> animals = animalService.getAnimalsByPessoaId(pessoaId);
        log.info("FIM - getAnimalsByPessoaId");

        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @PostMapping("/pessoa/{pessoaId}")
    public ResponseEntity<AnimalDTO> createAnimal(@PathVariable Long pessoaId, @RequestBody CreateAnimalRequest createAnimalRequest) {
        log.info("INICIO - createAnimal");
        AnimalDTO animal = animalService.createAnimal(pessoaId, createAnimalRequest);
        log.info("FIM - createAnimal");

        return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }

    @PutMapping("/{animalId}")
    public ResponseEntity<AnimalDTO> updateAnimal(@PathVariable Long animalId, @RequestBody UpdateAnimalRequest updateAnimalRequest) {
        log.info("INICIO - updateAnimal");
        AnimalDTO animal = animalService.updateAnimal(animalId, updateAnimalRequest);
        log.info("FIM - updateAnimal");

        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<Void> deleteAnimalById(@PathVariable Long animalId) {
        log.info("INICIO - deleteAnimalById");
        animalService.deleteAnimal(animalId);
        log.info("FIM - deleteAnimalById");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
