package com.teupet.animal.core.model;

import com.teupet.animal.core.model.enums.EspecieEnum;
import com.teupet.animal.core.model.enums.PlanoSaudeEnum;
import com.teupet.animal.core.model.enums.SexoEnum;
import com.teupet.animal.core.model.enums.converter.EspecieEnumConverter;
import com.teupet.animal.core.model.enums.converter.PlanoSaudeEnumConverter;
import com.teupet.animal.core.model.enums.converter.PorteEnumConverter;
import com.teupet.animal.core.model.enums.converter.SexoEnumConverter;
import com.teupet.animal.core.model.enums.PorteEnum;
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
    @Column(name = "animal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pessoa_id", nullable = false)
    private Long pessoaId;

    @Column(name = "nome")
    private String nome;

    @Convert(converter = EspecieEnumConverter.class)
    @Column(name = "especie_animal_id")
    private EspecieEnum especie;

    @Convert(converter = SexoEnumConverter.class)
    @Column(name = "sexo_animal_id")
    private SexoEnum sexo;

    @Convert(converter = PorteEnumConverter.class)
    @Column(name = "porte_animal_id")
    private PorteEnum porte;

    @Convert(converter = PlanoSaudeEnumConverter.class)
    @Column(name = "plano_saude_id")
    private PlanoSaudeEnum planoSaude;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

}
