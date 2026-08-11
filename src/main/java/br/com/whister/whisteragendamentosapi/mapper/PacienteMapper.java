package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.paciente.PacienteRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.paciente.PacienteResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    //source de onde o dado esta para aonde ele vai
    @Mapping(source = "dadosPessoais", target = "pessoa")
    Paciente toEntity(PacienteRequestDTO request);

    @Mapping(source = "pessoa", target = "dadosPessoais")
    PacienteResponseDTO toResponse(Paciente entity);

    @Mapping(source = "pessoa", target = "dadosPessoais" )
    List<PacienteResponseDTO> toResponseList(List<Paciente> list);
}
