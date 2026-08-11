package br.com.whister.whisteragendamentosapi.dto.sala;

public record SalaResponseDTO(
        Long id,
        String numeroSala,
        Boolean disponivelNoMomento
) {
}
