package com.example.agendamento_consultas_app.domain.entites;

import com.example.agendamento_consultas_app.application.DTO.request.MedicoRequest;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;

@Entity
@Getter
public class Medico extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    public Medico() {
    }

    public Medico(MedicoRequest medicoRequest) {
        super(medicoRequest.nome(), medicoRequest.cpf(), medicoRequest.nascimento(), medicoRequest.sexo(), medicoRequest.telefone());
    }

    @Override
    public String toString() {
        return "Medico{" +
                "idMedico=" + idMedico +
                ", nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", nascimento=" + getNascimento() +
                ", sexo=" + getSexo() +
                ", telefone=" + getTelefone() +
                '}';
    }
}

