package com.example.agendamento_consultas_app.repository;

import com.example.agendamento_consultas_app.domain.entites.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("select c from Consulta c where c.inicio < ?2 and c.fim > ?1")
    List<Consulta> findConsultasAgendadas(LocalDateTime inicio, LocalDateTime fim);
}