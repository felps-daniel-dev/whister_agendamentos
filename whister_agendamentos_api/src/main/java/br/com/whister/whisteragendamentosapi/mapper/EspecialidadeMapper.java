package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.especialidade.EspecialidadeRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.especialidade.EspecialidadeResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Especialidade;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EspecialidadeMapper {

    Especialidade toEntity(EspecialidadeRequestDTO request);

    List<EspecialidadeResponseDTO> toResponseList(List<Especialidade> especialidades);

    EspecialidadeResponseDTO toResponse(Especialidade entity);
}
