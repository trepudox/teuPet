package com.teupet.animal.core.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAnimalRequest {

    private String nome;
    private Long especieId;
    private Long sexoId;
    private Long porteId;
    private Long planoSaudeId = 1L;
    private Double peso;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

}
