package br.com.whister.whisteragendamentosapi.dto.consulta;

import br.com.whister.whisteragendamentosapi.entity.enums.StatusConsulta;

public record ConsultaCancelamentoDTO(
        String motivoCancelamento
) {
}
