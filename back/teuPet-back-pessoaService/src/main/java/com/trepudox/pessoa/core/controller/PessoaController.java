package com.trepudox.pessoa.core.controller;

import com.trepudox.pessoa.core.dto.PessoaDTO;
import com.trepudox.pessoa.core.dto.request.CreatePessoaRequest;
import com.trepudox.pessoa.core.dto.request.UpdatePessoaRequest;
import com.trepudox.pessoa.core.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping("/{pessoaId}")
    public ResponseEntity<PessoaDTO> getPessoaById(@PathVariable Long pessoaId) {
        PessoaDTO pessoaDTO = pessoaService.getPessoaById(pessoaId);

        return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PessoaDTO> createPessoa(@RequestBody CreatePessoaRequest createPessoaRequest) {
        PessoaDTO pessoa = pessoaService.createPessoa(createPessoaRequest);

        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<PessoaDTO> updatePessoa(@PathVariable Long pessoaId, @RequestBody UpdatePessoaRequest updatePessoaRequest) {
        PessoaDTO pessoa = pessoaService.updatePessoa(pessoaId, updatePessoaRequest);

        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Void> deletePessoaById(@PathVariable Long pessoaId) {
        pessoaService.deletePessoa(pessoaId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
