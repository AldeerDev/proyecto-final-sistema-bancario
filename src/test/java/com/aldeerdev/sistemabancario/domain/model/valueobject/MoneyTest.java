package com.aldeerdev.sistemabancario.domain.model.valueobject;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.aldeerdev.sistemabancario.domain.exceptions.InvalidMoneyException;
import com.aldeerdev.sistemabancario.domain.model.enums.TipoMoneda;

class MoneyTest {

	@Test
	void testCantidadNull() {
		assertThrows(InvalidMoneyException.class, () -> new Money(null, TipoMoneda.ARS));
	}
	
	@Test
	void testMonedaNull() {
		assertThrows(InvalidMoneyException.class, () -> new Money(new BigDecimal("300"), null));
	}
	
	@Test
	void testCreacionValida() {
		
	}
	
	@Test
	void testSumarArumentoNull() {
		Money dinero = new Money(new BigDecimal("300"), TipoMoneda.ARS);
		
		assertThrows(InvalidMoneyException.class, () -> dinero.sumar(null));
	}
}
