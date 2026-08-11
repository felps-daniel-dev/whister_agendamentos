package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.sala.SalaRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.sala.SalaResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Sala;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    Sala toEntity(SalaRequestDTO request);

    SalaResponseDTO toResponse(Sala entity);

    List<SalaResponseDTO> toResponseList(List<Sala> listaSalas);
}
