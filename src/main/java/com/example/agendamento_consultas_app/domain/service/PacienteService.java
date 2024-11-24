package com.example.agendamento_consultas_app.domain.service;

import com.example.agendamento_consultas_app.application.DTO.request.PacienteRequest;
import com.example.agendamento_consultas_app.domain.entites.Paciente;
import com.example.agendamento_consultas_app.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente cadastrarPaciente(PacienteRequest pacienteRequest) {
        try {
            Paciente paciente = new Paciente(pacienteRequest);

            pacienteRepository.save(paciente);

            return paciente;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadrastrar paciente: " + e.getMessage());
        }
    }

}


