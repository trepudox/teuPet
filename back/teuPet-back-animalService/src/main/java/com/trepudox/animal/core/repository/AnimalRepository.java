package com.trepudox.animal.core.repository;

import com.trepudox.animal.core.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {

    List<AnimalModel> findAllByPessoaId(Long pessoaId);

}
