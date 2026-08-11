package br.com.whister.whisteragendamentosapi.dto.pessoa;

import br.com.whister.whisteragendamentosapi.entity.enums.Sexo;

import java.time.LocalDate;

public record PessoaResponseDTO(
        Long id,
        String nome,
        String cpf,
        Sexo sexo,
        String email,
        String telefone,
        LocalDate nascimento,
        LocalDate dataCadastro
) {
}
