package br.com.whister.whisteragendamentosapi.dto.consulta;

import br.com.whister.whisteragendamentosapi.entity.enums.StatusConsulta;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConsultaRequestDTO(
        Long medicoId,
        Long pacienteId,
        Long salaId,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime dataHora,
        String motivoPrevio,
        Boolean especial,
        StatusConsulta status,
        String motivoCancelamento,
        BigDecimal valorBruto
) {
}
