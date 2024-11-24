package com.example.agendamento_consultas_app.application.DTO.request;



import com.example.agendamento_consultas_app.domain.enums.TipoConsulta;

import java.time.LocalDateTime;

public record ConsultaRequest(LocalDateTime inicio, String cpfMedico, String cpfPaciente, TipoConsulta tipoConsulta) {
}
