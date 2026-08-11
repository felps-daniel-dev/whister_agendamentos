package br.com.whister.whisteragendamentosapi.exception.custom;

public class ConsultaNaoEncontrada extends RuntimeException {
    public ConsultaNaoEncontrada(String message) {
        super(message);
    }
}
