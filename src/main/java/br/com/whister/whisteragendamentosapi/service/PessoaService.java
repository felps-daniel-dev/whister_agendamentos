package br.com.whister.whisteragendamentosapi.service;

import br.com.whister.whisteragendamentosapi.dto.pessoa.PessoaRequestDTO;
import br.com.whister.whisteragendamentosapi.entity.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PessoaService {


    public Pessoa alteraPessoa(Pessoa pessoa,PessoaRequestDTO request){
        if (request.nome() != null){
            pessoa.setNome(request.nome());
        }

        if(request.cpf() != null){
            pessoa.setCpf(request.cpf());
        }

        if(request.email() != null){
            pessoa.setEmail(request.email());
        }

        if(request.sexo() != null){
            pessoa.setSexo(request.sexo());
        }

        if(request.nascimento() != null){
            pessoa.setNascimento(request.nascimento());
        }
        return pessoa;
    }
}
