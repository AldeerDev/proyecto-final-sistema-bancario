package com.aldeerdev.sistemabancario.domain.exceptions;

public class InvalidMoneyException extends RuntimeException {

	public InvalidMoneyException(String mensaje) {
		super(mensaje);
	}
	
}
