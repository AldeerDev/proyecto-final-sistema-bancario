package com.aldeerdev.sistemabancario.domain.model.valueobject;

import java.math.BigDecimal;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, moneda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		return Objects.equals(cantidad, other.cantidad) && moneda == other.moneda;
	}

}
