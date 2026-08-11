package br.com.whister.whisteragendamentosapi.entity;

import br.com.whister.whisteragendamentosapi.entity.enums.StatusConsulta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LogConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_anterior", nullable = false)
    private StatusConsulta statusAnterior = StatusConsulta.NENHUM;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_novo", nullable = false)
    private StatusConsulta statusNovo = StatusConsulta.AGUARDANDO;

    @Column(name = "data_hora_alteracao", nullable = false)
    private LocalDateTime dataHoraAlteracao;

    @Column(name = "alterado_por", nullable = false)
    private String alteradoPor = "DESCONHECIDO";
}
