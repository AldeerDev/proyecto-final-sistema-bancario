package com.aldeerdev.sistemabancario.domain.model.valueobject;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.aldeerdev.sistemabancario.domain.model.enums.TipoMoneda;

class MoneyTest {

	@Test
	void testCantidadNull() {
		assertThrows(RuntimeException.class, () -> new Money(null, TipoMoneda.ARS));
	}
	
	@Test
	void testMonedaNull() {
		assertThrows(RuntimeException.class, () -> new Money(new BigDecimal("300"), null));
	}
	
	@Test
	void testCreacionValida() {
		
	}
}
