package com.example.agendamento_consultas_app.domain.entites;

import com.example.agendamento_consultas_app.application.DTO.request.ConsultaRequest;
import com.example.agendamento_consultas_app.domain.enums.TipoConsulta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime inicio;
    private LocalDateTime fim;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Enumerated(EnumType.STRING)
    private TipoConsulta tipoConsulta;


    public Consulta() {
    }

    public Consulta(ConsultaRequest consulta, Medico medico, Paciente paciente) {
        this.inicio = consulta.inicio();
        this.fim = calcularFim(consulta.inicio(), consulta.tipoConsulta());
        this.tipoConsulta = consulta.tipoConsulta();
        this.medico = medico;
        this.paciente = paciente;
    }

    private LocalDateTime calcularFim(LocalDateTime inicio, TipoConsulta tipoConsulta) {
        int tempo = tempoConsulta(tipoConsulta);
        return inicio.plusMinutes(tempo);
    }

    private int tempoConsulta(TipoConsulta tipoConsulta) {
        return switch (tipoConsulta) {
            case ortopedia -> 40;
            case cardiologia -> 50;
            case pediatria -> 30;
            case oftalmologia -> 35;
            default -> 45;
        };
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", inicio=" + inicio +
                ", fim=" + fim +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", tipoConsulta=" + tipoConsulta +
                '}';
    }
}

