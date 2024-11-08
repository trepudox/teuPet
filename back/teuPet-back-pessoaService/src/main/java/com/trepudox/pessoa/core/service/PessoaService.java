package com.trepudox.pessoa.core.service;

import com.trepudox.pessoa.core.dto.PessoaDTO;
import com.trepudox.pessoa.core.dto.request.CreatePessoaRequest;
import com.trepudox.pessoa.core.dto.request.UpdatePessoaRequest;
import com.trepudox.pessoa.core.exception.EntityNotFoundException;
import com.trepudox.pessoa.core.mapper.PessoaMapper;
import com.trepudox.pessoa.core.model.PessoaModel;
import com.trepudox.pessoa.core.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaDTO getPessoaById(Long pessoaId) {
        PessoaModel pessoaModel = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Pessoa com ID '%s' não encontrado", pessoaId)));

        return PessoaMapper.INSTANCE.pessoaModelToPessoaDTO(pessoaModel);
    }

    public PessoaDTO createPessoa(Long pessoaId, CreatePessoaRequest createPessoaRequest) {
        PessoaModel pessoaModel = PessoaMapper.INSTANCE.createPessoaRequestToPessoaModel(createPessoaRequest);

        pessoaModel = pessoaRepository.save(pessoaModel);

        return PessoaMapper.INSTANCE.pessoaModelToPessoaDTO(pessoaModel);
    }

    public PessoaDTO updatePessoa(Long pessoaId, UpdatePessoaRequest updatePessoaRequest) {
        PessoaModel pessoaModel = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Pessoa com ID '%s' não encontrado", pessoaId)));

        pessoaModel.setNome(updatePessoaRequest.getNome());
        pessoaModel.setEmail(updatePessoaRequest.getEmail());
        pessoaModel.setTelefone(updatePessoaRequest.getTelefone());
        pessoaModel.setCpf(updatePessoaRequest.getCpf());
        pessoaModel.setDataNascimento(updatePessoaRequest.getDataNascimento());

        pessoaModel = pessoaRepository.save(pessoaModel);

        return PessoaMapper.INSTANCE.pessoaModelToPessoaDTO(pessoaModel);
    }

    public void deletePessoa(Long pessoaId) {pessoaRepository.deleteById(pessoaId);
    }
}
