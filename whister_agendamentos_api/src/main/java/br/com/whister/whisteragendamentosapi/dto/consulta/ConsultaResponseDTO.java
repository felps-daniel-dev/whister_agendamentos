package br.com.whister.whisteragendamentosapi.dto.consulta;

import br.com.whister.whisteragendamentosapi.entity.Medico;
import br.com.whister.whisteragendamentosapi.entity.Paciente;
import br.com.whister.whisteragendamentosapi.entity.Sala;
import br.com.whister.whisteragendamentosapi.entity.enums.StatusConsulta;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConsultaResponseDTO(
        Medico medico,
        Paciente paciente,
        Sala sala,
        LocalDateTime dataHora,
        String motivoPrevio,
        Boolean especial,
        BigDecimal valorBruto,
        BigDecimal valorDescontos,
        BigDecimal valorFinal,
        StatusConsulta status,
        String motivoCancelamento
) {
}
