package com.example.agendamento_consultas_app.repository;

import com.example.agendamento_consultas_app.domain.entites.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico findByCpf(String cpf);
}
