package com.aldeerdev.sistemabancario.domain.model.valueobject;

import java.math.BigDecimal;

import com.aldeerdev.sistemabancario.domain.exceptions.InvalidMoneyException;
import com.aldeerdev.sistemabancario.domain.model.enums.TipoMoneda;

public class Money {

	private final BigDecimal cantidad;
	private final TipoMoneda moneda;

	public Money(BigDecimal cantidad, TipoMoneda moneda) {

		if (cantidad == null) {
			throw new InvalidMoneyException("Cantidad no puede ser nula");
		}

		if (moneda == null) {
			throw new InvalidMoneyException("moneda no puede ser nula");
		}
		this.cantidad = cantidad;
		this.moneda = moneda;
	}

}
