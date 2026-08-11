package br.com.whister.whisteragendamentosapi.dto.pessoa;

import br.com.whister.whisteragendamentosapi.entity.enums.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PessoaRequestDTO(
        @NotEmpty(message = "O campo nome não pode ser nulo")
        String nome,

        @CPF(message = "CPF inválido!")
        @NotEmpty(message = "O campo cpf não pode ser nulo")
        String cpf,

        @NotNull(message = "O campo sexo não pode ser nulo")
        Sexo sexo,

        @Email(message = "endereço de email inválido!")
        @NotEmpty(message = "O campo email não pode ser nulo")
        String email,

        @NotEmpty(message = "O campo telefone não pode ser nulo")
        String telefone,

        @NotNull(message = "O campo nascimento não pode ser nulo")
        @Past(message = "A data de nascimento deve ser no passado")
        LocalDate nascimento
) {
}
