package br.com.whister.whisteragendamentosapi.service;


import br.com.whister.whisteragendamentosapi.entity.Especialidade;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioService {

    private static final LocalTime INICIO_EXPEDIENTE = LocalTime.of(8, 0);
    private static final LocalTime FINAL_EXPEDIENTE = LocalTime.of(19, 0);

    Boolean isEspecial(LocalDateTime dataHora){
        LocalTime horario = dataHora.toLocalTime();
        if (horario.isBefore(INICIO_EXPEDIENTE) ||  horario.isAfter(FINAL_EXPEDIENTE)){
            return true;
            // falta verificar a questão de feriados e finais de semana
        }
        return false;
    }

   List<LocalTime> listaHorariosDiario(Especialidade especialidade){

        List<LocalTime> listaDeHorarios = new ArrayList<>();
        // vai caucular todos os horarios para cada especialidade e retorna
       // pode ou não retornar apenas os diponiveis
        return null;
   }



}
