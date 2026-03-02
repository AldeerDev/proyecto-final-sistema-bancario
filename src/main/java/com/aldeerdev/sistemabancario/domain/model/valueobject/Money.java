package com.aldeerdev.sistemabancario.domain.model.valueobject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import com.aldeerdev.sistemabancario.domain.exceptions.InvalidMoneyException;
import com.aldeerdev.sistemabancario.domain.model.enums.TipoMoneda;

public final class Money {

	private final BigDecimal cantidad;
	private final TipoMoneda moneda;

	public Money(BigDecimal cantidad, TipoMoneda moneda) {

		if (cantidad == null) {
			throw new InvalidMoneyException("Cantidad no puede ser nula");
		}

		if (moneda == null) {
			throw new InvalidMoneyException("moneda no puede ser nula");
		}

		if (cantidad.signum() < 0) {
			throw new InvalidMoneyException("cantidad no puede ser negativa");
		}

		// normaliza la escala de cantidad
		this.cantidad = cantidad.setScale(2, RoundingMode.HALF_EVEN);
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

	public Money restar(Money otro) {
		// valida argumento nulo
		if (otro == null)
			throw new InvalidMoneyException("otro no puede ser nulo.");

		// valida que las monedas sean iguales
		if (this.moneda != otro.moneda)
			throw new InvalidMoneyException("No puedes restar monedas distintas.");

		return new Money(this.cantidad.subtract(otro.cantidad), this.moneda);
	}

	// Getters

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public TipoMoneda getMoneda() {
		return moneda;
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
