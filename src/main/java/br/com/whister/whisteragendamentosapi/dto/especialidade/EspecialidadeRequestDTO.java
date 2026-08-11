package br.com.whister.whisteragendamentosapi.dto.especialidade;

import java.time.LocalTime;

public record EspecialidadeRequestDTO(
        String nome,
        LocalTime duracao,
        LocalTime intervalo,
        Double descontoPromocional,
        Double porcentagemEspecial
) {
}
