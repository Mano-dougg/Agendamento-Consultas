package com.example.agendamento_consultas_app.application.controllers;

import com.example.agendamento_consultas_app.application.DTO.request.MedicoRequest;
import com.example.agendamento_consultas_app.application.DTO.response.MedicoResponse;
import com.example.agendamento_consultas_app.domain.entites.Medico;
import com.example.agendamento_consultas_app.domain.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;


    @PostMapping
    public ResponseEntity<MedicoResponse> cadastrarMedico(@RequestBody MedicoRequest medicoRequest) {

        Medico medico = medicoService.cadastrarMedico(medicoRequest);

        MedicoResponse response = MedicoResponse.transformaEmDTO(medico);

        return ResponseEntity.ok(response);
    }
}

