package com.example.agendamento_consultas_app.application.DTO.request;

import com.example.agendamento_consultas_app.domain.enums.Sexo;

import java.util.Date;
import java.util.List;

public record PacienteRequest(String nome, String cpf, Date nascimento, Sexo sexo, Long telefone, String convenioMedico, List<String> alergias, List<String> medicamentos) {
}
