package br.com.whister.whisteragendamentosapi.dto.especialidade;

import java.time.LocalTime;

public record EspecialidadeResponseDTO(
        Long id,
        String nome,
        LocalTime duracao,
        LocalTime intervalo,
        Double descontoPromocional,
        Double porcentagemEspecial
) {
}
