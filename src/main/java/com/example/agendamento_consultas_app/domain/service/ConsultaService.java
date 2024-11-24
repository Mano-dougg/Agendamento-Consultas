package com.example.agendamento_consultas_app.domain.service;

import com.example.agendamento_consultas_app.application.DTO.request.ConsultaRequest;
import com.example.agendamento_consultas_app.application.config.SmsSender;
import com.example.agendamento_consultas_app.domain.entites.Consulta;
import com.example.agendamento_consultas_app.domain.entites.Medico;
import com.example.agendamento_consultas_app.domain.entites.Paciente;
import com.example.agendamento_consultas_app.repository.ConsultaRepository;
import com.example.agendamento_consultas_app.repository.MedicoRepository;
import com.example.agendamento_consultas_app.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private SmsSender smsSender;

    public ConsultaService() {
    }

    public Consulta agendarConsulta(ConsultaRequest consultaRequest) throws Error {

        Paciente paciente = pacienteRepository.findByCpf(consultaRequest.cpfPaciente());
        Medico medico = medicoRepository.findByCpf(consultaRequest.cpfMedico());

        Consulta consulta = new Consulta(consultaRequest, medico, paciente);

        if(consultaRepository.findConsultasAgendadas(consulta.getInicio(), consulta.getFim()) != null) {
            throw new RuntimeException("Já existe uma consulta agendada nesse horário");
        }

        consultaRepository.save(consulta);

        smsSender.sendSms(paciente.getTelefone(),"Consulta agendada com sucesso.");

        return consulta;
    }
}