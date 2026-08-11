package br.com.whister.whisteragendamentosapi.exception.custom;

public class PacienteNaoEncontrado extends RuntimeException {
    public PacienteNaoEncontrado(String message) {
        super(message);
    }
}
