package com.trepudox.animal.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pessoa_id", nullable = false)
    private Long pessoaId;

    @Column(name = "nome")
    private String nome;

    // ! TODO: Implementar enum de espécie
    @Column(name = "especie_animal")
    private String especie;

    // ! TODO: Implementar enum de sexo
    @Column(name = "sexo_animal")
    private String sexo;

    // ! TODO: Implementar enum de porte
    @Column(name = "porte_animal")
    private String porte;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

}
