package com.aldeerdev.sistemabancario.domain.model.entity;


import java.math.BigDecimal;

import com.aldeerdev.sistemabancario.domain.model.valueobject.Money;

public class CuentaAhorro extends CuentaBancaria {

	public CuentaAhorro(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public Money calcularInteres() {
		Money saldo = this.getSaldo();
		return saldo.multiplicar(new BigDecimal("1.7"));
	}

}
