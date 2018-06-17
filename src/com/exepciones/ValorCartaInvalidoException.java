package com.exepciones;

public class ValorCartaInvalidoException extends Exception{

	public ValorCartaInvalidoException() {
		super();
	}
	
	public ValorCartaInvalidoException(String message) {
		super(message+" es un valor de carta invalido");
	}
}
