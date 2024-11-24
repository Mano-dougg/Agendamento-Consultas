package com.example.agendamento_consultas_app.application.DTO.response;

import com.example.agendamento_consultas_app.domain.entites.Paciente;
import com.example.agendamento_consultas_app.domain.enums.Sexo;
import java.util.Date;
import java.util.List;

public class PacienteResponse {

    private String nome;
    private Date nascimento;
    private Sexo sexo;
    private Long telefone;
    private String convenioMedico;
    private List<String> alergias;
    private List<String> medicamentos;

    public PacienteResponse(String nome, Date nascimento, Sexo sexo, Long telefone, String convenioMedico, List<String> alergias, List<String> medicamentos) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.convenioMedico = convenioMedico;
        this.alergias = alergias;
        this.medicamentos = medicamentos;
    }

    public static PacienteResponse transformaEmDTO(Paciente paciente) {

        return new PacienteResponse(
                paciente.getNome(),
                paciente.getNascimento(),
                paciente.getSexo(),
                paciente.getTelefone(),
                paciente.getConvenioMedico(),
                paciente.getAlergias(),
                paciente.getMedicamentos()
        );
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Long getTelefone() {
        return telefone;
    }

    public String getConvenioMedico() {
        return convenioMedico;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }
}




