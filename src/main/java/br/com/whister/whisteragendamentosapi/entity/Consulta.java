package br.com.whister.whisteragendamentosapi.entity;

import br.com.whister.whisteragendamentosapi.entity.enums.StatusConsulta;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    @Column(name = "data_hora", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHora;

    @Column(name = "valor_bruto",  precision = 10, scale = 2)
    private BigDecimal valorBruto = new BigDecimal(00.01);

    @Column(name = "valor_descontos", precision = 10, scale = 2)
    private BigDecimal valorDescontos = new BigDecimal(00.01);

    @Column(name = "valor_final",  precision = 10, scale = 2)
    private BigDecimal valorFinal = new BigDecimal(00.01);

    @Column(name = "motivo_previo")
    private String motivoPrevio;

    @Column(name = "resultado_consulta")
    private String resultadoConsulta;

    @Column(nullable = false)
    private Boolean especial = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta status = StatusConsulta.AGUARDANDO;

    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;

    @Column(name = "criado_em", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate criadoEm = LocalDate.now();

    @Column(name = "atualizado_em", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate atualizadoEm = LocalDate.now();
}