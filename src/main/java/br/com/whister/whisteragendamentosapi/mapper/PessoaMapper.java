package br.com.whister.whisteragendamentosapi.mapper;

import br.com.whister.whisteragendamentosapi.dto.pessoa.PessoaRequestDTO;
import br.com.whister.whisteragendamentosapi.dto.pessoa.PessoaResponseDTO;
import br.com.whister.whisteragendamentosapi.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

//libera a injeção de dependência             ignora os warnings
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE )
public interface PessoaMapper {

    Pessoa toEntity(PessoaRequestDTO request);

    PessoaResponseDTO toResponse(Pessoa entity);
}
