package com.teupet.animal.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalDTO {

    private Long id;
    private Long pessoaId;
    private String nome;
    private Long especieId;
    private Long sexoId;
    private Long porteId;
    private Long planoSaudeId;
    private Double peso;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

}
