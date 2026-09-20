package br.com.whister.whisteragendamentosapi.service;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class HorarioService {

    private static final LocalTime INICIO_EXPEDIENTE = LocalTime.of(8, 0);
    private static final LocalTime FINAL_EXPEDIENTE = LocalTime.of(19, 0);

    Boolean isEspecial(LocalDateTime dataHora){
        LocalTime horario = dataHora.toLocalTime();
        if (horario.isBefore(INICIO_EXPEDIENTE) ||  horario.isAfter(FINAL_EXPEDIENTE)){
            return true;
        }
        return false;
    }
}
