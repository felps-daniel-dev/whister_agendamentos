package br.com.whister.whisteragendamentosapi.exception.custom;

public class PlanoNaoEncontrado extends RuntimeException {
    public PlanoNaoEncontrado(String message) {
        super(message);
    }
}
