package br.com.whister.whisteragendamentosapi.dto.sala;

import jakarta.validation.constraints.NotBlank;

public record SalaRequestDTO(
        @NotBlank(message = "O número da sala é obrigatório!")
        String numeroSala,
        Boolean disponivelNoMomento

) {
}
