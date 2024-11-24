package com.example.agendamento_consultas_app.application.controllers;

import com.example.agendamento_consultas_app.application.DTO.request.PacienteRequest;
import com.example.agendamento_consultas_app.application.DTO.response.PacienteResponse;
import com.example.agendamento_consultas_app.domain.entites.Paciente;
import com.example.agendamento_consultas_app.domain.service.PacienteService;
import com.example.agendamento_consultas_app.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;


    @PostMapping
    public ResponseEntity<PacienteResponse> cadastrarPaciente(@RequestBody PacienteRequest pacienteRequest) {
        Paciente paciente = pacienteService.cadastrarPaciente(pacienteRequest);

        PacienteResponse pacienteResponse = PacienteResponse.transformaEmDTO(paciente);

        return ResponseEntity.ok(pacienteResponse);

    }

}

