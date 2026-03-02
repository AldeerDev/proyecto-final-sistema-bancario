package com.aldeerdev.sistemabancario.domain.model.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TipoMonedaTest {

	@Test
	void MonedasIguales() {
		assertEquals(TipoMoneda.ARS, TipoMoneda.ARS);
	}
}
