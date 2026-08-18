package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.consulta.ConsultaResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    @Mapping(source = "medicoId", target = "medico.id")
    @Mapping(source = "pacienteId", target = "paciente.id")
    @Mapping(source = "salaId", target = "sala.id")
    Consulta toEntity(ConsultaRequestDTO request);

    ConsultaResponseDTO toResponse(Consulta entity);

    List<ConsultaResponseDTO> toResponseList(List<Consulta> consultaList);
}
