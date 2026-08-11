package br.com.whister.whisteragendamentosapi.exception.custom;

public class SalaNaoEncontrada extends RuntimeException {
    public SalaNaoEncontrada(String message) {
        super(message);
    }
}
