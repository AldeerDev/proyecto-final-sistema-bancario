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

	public Money sumar(Money otro) {

		if (otro == null) {
			throw new InvalidMoneyException("otro no puede ser nulo");
		}

		if (moneda != otro.moneda) {
			throw new InvalidMoneyException("No se pueden sumar monedas distintas.");
		}

		return new Money(this.cantidad.add(otro.cantidad), otro.moneda);
	}

}
