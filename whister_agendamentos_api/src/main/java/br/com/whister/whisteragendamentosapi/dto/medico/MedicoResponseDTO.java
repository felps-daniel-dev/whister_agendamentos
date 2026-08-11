package br.com.whister.whisteragendamentosapi.dto.medico;

import br.com.whister.whisteragendamentosapi.dto.especialidade.EspecialidadeMedicoResponseDTO;
import br.com.whister.whisteragendamentosapi.dto.pessoa.PessoaResponseDTO;

public record MedicoResponseDTO(
        Long id,
        PessoaResponseDTO dadosPessoais,
        String crm,
        EspecialidadeMedicoResponseDTO especialidade,
        Boolean ativo
) {
}
