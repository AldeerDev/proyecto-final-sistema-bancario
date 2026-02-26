package com.aldeerdev.sistemabancario.domain.model.valueobject;

import java.math.BigDecimal;

import com.aldeerdev.sistemabancario.domain.model.enums.TipoMoneda;

public class Money {

	private final BigDecimal cantidad;
	private final TipoMoneda moneda;

	public Money(BigDecimal cantidad, TipoMoneda moneda) {
		if (cantidad.equals(null)) {
			throw new RuntimeException("Cantidad no puede ser nula");
		}
		
		if(moneda.equals(null)) {
			throw new RuntimeException("moneda no puede ser nula");
		}
		this.cantidad = cantidad;
		this.moneda = moneda;
	}
	
}
