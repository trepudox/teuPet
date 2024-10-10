package com.trepudox.animal.core.model;

import com.trepudox.animal.core.model.enums.EspecieEnum;
import com.trepudox.animal.core.model.enums.PorteEnum;
import com.trepudox.animal.core.model.enums.SexoEnum;
import com.trepudox.animal.core.model.enums.converter.EspecieEnumConverter;
import com.trepudox.animal.core.model.enums.converter.PorteEnumConverter;
import com.trepudox.animal.core.model.enums.converter.SexoEnumConverter;
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

    @Column(name = "peso")
    private Double peso;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

}
