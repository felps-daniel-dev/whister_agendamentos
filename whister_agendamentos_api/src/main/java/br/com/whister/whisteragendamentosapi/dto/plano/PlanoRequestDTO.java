package br.com.whister.whisteragendamentosapi.dto.plano;

import java.time.LocalDate;

public record PlanoRequestDTO(
        String nome,
        Integer qtd_consultas_gratis_trimestral,
        Double desconto,
        LocalDate dataUltimoReset
) {
}