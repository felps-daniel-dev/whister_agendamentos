package br.com.whister.whisteragendamentosapi.dto.medico;

import br.com.whister.whisteragendamentosapi.dto.pessoa.PessoaRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public record MedicoRequestDTO(

        @NotEmpty(message = "O campo crm não pode ser nulo")
        String crm,

        @Valid
        PessoaRequestDTO dadosPessoais,

        Long especialidadeId
) {
}
