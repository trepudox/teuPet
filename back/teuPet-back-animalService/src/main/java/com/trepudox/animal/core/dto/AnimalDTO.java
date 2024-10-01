package com.trepudox.animal.core.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalDTO {

    private Long id;
    private Long pessoaId;
    private String nome;
    private String especie;
    private String raca;
    private Double peso;
    private LocalDate dataNascimento;

}
