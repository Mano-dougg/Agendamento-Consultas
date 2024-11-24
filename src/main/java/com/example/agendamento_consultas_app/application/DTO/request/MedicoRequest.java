package com.example.agendamento_consultas_app.application.DTO.request;


import com.example.agendamento_consultas_app.domain.enums.Sexo;

import java.util.Date;

public record MedicoRequest(String nome, String cpf, Date nascimento, Sexo sexo, Long telefone) {
}