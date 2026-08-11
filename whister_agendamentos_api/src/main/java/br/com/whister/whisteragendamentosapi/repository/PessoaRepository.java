package br.com.whister.whisteragendamentosapi.repository;

import br.com.whister.whisteragendamentosapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
