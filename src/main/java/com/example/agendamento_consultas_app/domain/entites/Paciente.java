package com.example.agendamento_consultas_app.domain.entites;

import com.example.agendamento_consultas_app.application.DTO.request.PacienteRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    private String convenioMedico;

    @ElementCollection
    private List<String> alergias;

    @ElementCollection
    private List<String> medicamentos;

    public Paciente() {
    }

    public Paciente(PacienteRequest pacienteRequest) {
        super(pacienteRequest.nome(), pacienteRequest.cpf(), pacienteRequest.nascimento(), pacienteRequest.sexo(), pacienteRequest.telefone());
        this.convenioMedico = pacienteRequest.convenioMedico();
        this.alergias = pacienteRequest.alergias();
        this.medicamentos = pacienteRequest.medicamentos();
    }

    @Override
    public String toString() {
        return "Paciente{idPaciente=" + idPaciente +
                ", nome=" + getNome() +
                ", cpf=" + getCpf() +
                ", nascimento=" + getNascimento() +
                ", sexo=" + getSexo() +
                ", telefone=" + getTelefone() +
                ", convenioMedico=" + convenioMedico +
                ", alergias=" + alergias +
                ", medicamentos=" + medicamentos +
                "}";
    }
}

