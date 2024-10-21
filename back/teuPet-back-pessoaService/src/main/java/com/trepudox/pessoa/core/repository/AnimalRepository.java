package com.trepudox.pessoa.core.repository;

import com.trepudox.pessoa.core.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<PessoaModel, Long> {

    List<PessoaModel> findAllByPessoaId(Long pessoaId);

}
