package com.example.agendamento_consultas_app.application.controllers;


import com.example.agendamento_consultas_app.application.DTO.request.ConsultaRequest;
import com.example.agendamento_consultas_app.application.DTO.response.ConsultaResponse;
import com.example.agendamento_consultas_app.domain.entites.Consulta;
import com.example.agendamento_consultas_app.domain.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponse> agendarConsulta(@RequestBody ConsultaRequest consultaRequest) {
        Consulta consulta = consultaService.agendarConsulta(consultaRequest);

        ConsultaResponse response = ConsultaResponse.transformaEmDTO(consulta);

        return ResponseEntity.ok(response);
    }

}
