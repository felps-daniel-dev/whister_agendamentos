package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.medico.MedicoRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.medico.MedicoResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    @Mapping(source = "dadosPessoais", target = "pessoa")
    Medico toEntity(MedicoRequestDTO request);

    @Mapping(source = "pessoa", target = "dadosPessoais")
    MedicoResponseDTO toResponse(Medico entity);

    @Mapping(source = "pessoa", target = "dadosPessoais")
    List<MedicoResponseDTO> toListResponse(List<Medico> medicos);
}
