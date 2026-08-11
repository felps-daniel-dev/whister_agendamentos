package br.com.whister.whisteragendamentosapi.dto.paciente;

import br.com.whister.whisteragendamentosapi.dto.pessoa.PessoaRequestDTO;
import jakarta.validation.Valid;


public record PacienteRequestDTO(

        @Valid
        PessoaRequestDTO dadosPessoais,

        //@NotNull(message = "É necessário o plano o id do plano")
        Long planoId
) {
}
