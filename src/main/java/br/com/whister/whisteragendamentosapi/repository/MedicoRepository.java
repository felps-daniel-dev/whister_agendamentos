package br.com.whister.whisteragendamentosapi.repository;

import br.com.whister.whisteragendamentosapi.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
