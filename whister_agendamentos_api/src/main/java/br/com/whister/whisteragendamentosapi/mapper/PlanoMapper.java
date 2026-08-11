package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.plano.PlanoRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.plano.PlanoResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Plano;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlanoMapper {

    Plano toEntity(PlanoRequestDTO request);

    PlanoResponseDTO toResponse(Plano entity);

    List<PlanoResponseDTO> toResponseList(List<Plano> listaEntitys);
}
