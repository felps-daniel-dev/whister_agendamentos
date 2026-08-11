package br.com.whister.whisteragendamentosapi.repository;

import br.com.whister.whisteragendamentosapi.entity.Consulta;
import br.com.whister.whisteragendamentosapi.entity.LogConsulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogConsultaRepository extends JpaRepository<LogConsulta, Long> {
    LogConsulta findByConsulta(Consulta consulta);
}
