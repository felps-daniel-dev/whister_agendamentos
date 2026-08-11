package br.com.whister.whisteragendamentosapi.repository;

import br.com.whister.whisteragendamentosapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
