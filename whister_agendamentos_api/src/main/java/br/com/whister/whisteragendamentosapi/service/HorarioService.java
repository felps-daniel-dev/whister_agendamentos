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

    Boolean isEspecial(LocalDateTime dataHora) {
        LocalTime horario = dataHora.toLocalTime();
        if (horario.isBefore(INICIO_EXPEDIENTE) || horario.isAfter(FINAL_EXPEDIENTE)) {
            return true;
            // falta verificar a questão de feriados e finais de semana
        }
        return false;
    }

    // retorna todos os horario ds dia
    List<LocalTime> listaHorariosDiario(Especialidade especialidade) {

        // usar esse metodo pra receber uma lista de consultas e retorna os horarios livres e ocupado
        // pode ser ate uma lista com horarios ocupados e uma com horarios vazios
        LocalTime duracao = especialidade.getDuracao();
        LocalTime intervalo = especialidade.getIntervalo();
        List<LocalTime> listaDeHorarios = new ArrayList<>();

        LocalTime novoHorario = INICIO_EXPEDIENTE;

        while (novoHorario.isBefore(FINAL_EXPEDIENTE)) {
            listaDeHorarios.add(novoHorario);
            novoHorario =  novoHorario.plusHours(duracao.getHour())
                    .plusMinutes(duracao.getMinute())
                    .plusHours(intervalo.getHour())
                    .plusMinutes(intervalo.getMinute());
        }
        return listaDeHorarios;
    }


}