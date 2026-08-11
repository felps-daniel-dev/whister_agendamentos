package br.com.whister.whisteragendamentosapi.dto.paciente;

import br.com.whister.whisteragendamentosapi.dto.pessoa.PessoaResponseDTO;

public record PacienteResponseDTO(
        Long id,
        PessoaResponseDTO dadosPessoais,
        Long planoId,
        Boolean ativo
) {
}
