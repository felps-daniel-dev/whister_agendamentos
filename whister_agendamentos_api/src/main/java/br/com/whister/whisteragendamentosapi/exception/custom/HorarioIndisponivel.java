package br.com.whister.whisteragendamentosapi.exception.custom;

public class HorarioIndisponivel extends RuntimeException {
    public HorarioIndisponivel(String message) {
        super(message);
    }
}
