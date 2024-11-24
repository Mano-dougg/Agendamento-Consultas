package com.example.agendamento_consultas_app.application.DTO.response;

import com.example.agendamento_consultas_app.domain.entites.Medico;
import lombok.Getter;

public class MedicoResponse {

    private String nome;
    private Long telefone;

    public MedicoResponse(String nome, Long telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }


    public static MedicoResponse transformaEmDTO(Medico medico) {
        return new MedicoResponse(
                medico.getNome(),
                medico.getTelefone()
        );
    }

    public String getNome() {
        return nome;
    }

    public Long getTelefone() {
        return telefone;
    }
}

