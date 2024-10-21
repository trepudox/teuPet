package com.trepudox.pessoa.core.controller;

import com.trepudox.pessoa.core.dto.PessoaDTO;
import com.trepudox.pessoa.core.dto.request.CreateAnimalRequest;
import com.trepudox.pessoa.core.dto.request.UpdateAnimalRequest;
import com.trepudox.pessoa.core.service.AnimalService;
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
    public ResponseEntity<PessoaDTO> getAnimalById(@PathVariable Long animalId) {
        PessoaDTO pessoaDTO = animalService.getAnimalById(animalId);

        return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
    }

    @GetMapping("/pessoa/{pessoaId}")
    public ResponseEntity<List<PessoaDTO>> getAnimalsByPessoaId(@PathVariable Long pessoaId) {
        List<PessoaDTO> animals = animalService.getAnimalsByPessoaId(pessoaId);

        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @PostMapping("/pessoa/{pessoaId}")
    public ResponseEntity<PessoaDTO> createAnimal(@PathVariable Long pessoaId, @RequestBody CreateAnimalRequest createAnimalRequest) {
        PessoaDTO animal = animalService.createAnimal(pessoaId, createAnimalRequest);

        return new ResponseEntity<>(animal, HttpStatus.CREATED);
    }

    @PutMapping("/{animalId}")
    public ResponseEntity<PessoaDTO> updateAnimal(@PathVariable Long animalId, @RequestBody UpdateAnimalRequest updateAnimalRequest) {
        PessoaDTO animal = animalService.updateAnimal(animalId, updateAnimalRequest);

        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @DeleteMapping("/{animalId}")
    public ResponseEntity<Void> deleteAnimalById(@PathVariable Long animalId) {
        animalService.deleteAnimal(animalId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
