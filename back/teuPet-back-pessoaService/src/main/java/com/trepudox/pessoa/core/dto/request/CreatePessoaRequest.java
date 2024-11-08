package com.trepudox.pessoa.core.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePessoaRequest {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;

}