package br.com.whister.whisteragendamentosapi.repository;

import br.com.whister.whisteragendamentosapi.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByPacienteId(Long pacienteId);

    List<Consulta> findByMedicoId(Long medicoId);

     List<Consulta> findByDataHora(LocalDateTime dataHora);
}
