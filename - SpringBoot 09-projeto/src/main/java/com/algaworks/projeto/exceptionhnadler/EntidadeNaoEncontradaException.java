package com.algaworks.projeto.exceptionhnadler;

public class EntidadeNaoEncontradaException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException (String message) {
	super(message);
    }
}