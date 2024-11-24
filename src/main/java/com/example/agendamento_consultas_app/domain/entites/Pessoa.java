package com.example.agendamento_consultas_app.domain.entites;

import com.example.agendamento_consultas_app.domain.enums.Sexo;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class Pessoa {

    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;
    private Date nascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(nullable = false, unique = true)
    private Long telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, Date nascimento, Sexo sexo, Long telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.telefone = telefone;
    }

}
