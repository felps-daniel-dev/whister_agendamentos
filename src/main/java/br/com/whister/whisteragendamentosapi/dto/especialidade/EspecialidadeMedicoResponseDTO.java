package br.com.whister.whisteragendamentosapi.dto.especialidade;

import java.time.LocalTime;

public record EspecialidadeMedicoResponseDTO(
        Long id,
        String nome,
        LocalTime duracao,
        LocalTime intervalo
) {
}
