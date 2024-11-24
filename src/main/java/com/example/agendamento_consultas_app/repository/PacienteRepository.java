package com.example.agendamento_consultas_app.repository;

import com.example.agendamento_consultas_app.domain.entites.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByCpf(String cpf);
}
