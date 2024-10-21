package com.teupet.animal.core.repository;

import com.teupet.animal.core.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {

    List<AnimalModel> findAllByPessoaId(Long pessoaId);

}
