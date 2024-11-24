package com.example.agendamento_consultas_app.application.DTO.response;

import com.example.agendamento_consultas_app.domain.entites.Consulta;
import com.example.agendamento_consultas_app.domain.enums.TipoConsulta;

import java.time.LocalDateTime;

public class ConsultaResponse {

    private LocalDateTime inicio;
    private LocalDateTime fim;
    private PacienteResponse paciente;
    private MedicoResponse medico;
    private TipoConsulta tipoConsulta;


    public ConsultaResponse(LocalDateTime inicio, LocalDateTime fim, PacienteResponse paciente, MedicoResponse medico, TipoConsulta tipoConsulta) {
        this.inicio = inicio;
        this.fim = fim;
        this.paciente = paciente;
        this.medico = medico;
        this.tipoConsulta = tipoConsulta;
    }


    public static ConsultaResponse transformaEmDTO(Consulta consulta) {
        PacienteResponse pacienteResponse = PacienteResponse.transformaEmDTO(consulta.getPaciente());
        MedicoResponse medicoResponse = MedicoResponse.transformaEmDTO(consulta.getMedico());

        return new ConsultaResponse(
                consulta.getInicio(),
                consulta.getFim(),
                pacienteResponse,
                medicoResponse,
                consulta.getTipoConsulta()
        );
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public PacienteResponse getPaciente() {
        return paciente;
    }

    public MedicoResponse getMedico() {
        return medico;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }
}

