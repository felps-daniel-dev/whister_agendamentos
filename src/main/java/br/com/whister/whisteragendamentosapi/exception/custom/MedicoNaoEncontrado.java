package br.com.whister.whisteragendamentosapi.exception.custom;

public class MedicoNaoEncontrado extends RuntimeException{
    public MedicoNaoEncontrado(String message){
        super(message);
    }
}
