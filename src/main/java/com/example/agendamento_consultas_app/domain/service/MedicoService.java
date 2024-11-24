package com.example.agendamento_consultas_app.domain.service;

import com.example.agendamento_consultas_app.application.DTO.request.MedicoRequest;
import com.example.agendamento_consultas_app.domain.entites.Medico;
import com.example.agendamento_consultas_app.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    public Medico cadastrarMedico(MedicoRequest medicoRequest) {
        Medico medico = new Medico(medicoRequest);

        medicoRepository.save(medico);

        return medico;
    }
}
