package com.aldeerdev.sistemabancario.domain.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

import com.aldeerdev.sistemabancario.domain.model.enums.TipoMoneda;
import com.aldeerdev.sistemabancario.domain.model.valueobject.Money;

public abstract class CuentaBancaria {

	private String numeroCuenta;
	private Cliente cliente;
	private Money saldo;
	
	// Constructor
	public CuentaBancaria(Cliente cliente) {
		this.numeroCuenta = "0000";
		this.cliente = cliente;
		this.saldo = new Money(new BigDecimal("0"), TipoMoneda.ARS);
	}

	public abstract Money calcularInteres();

	public void depositar(Money monto) {
		// validar argumento nulo
		Objects.requireNonNull(monto, "Monto no debe ser nulo");

		this.saldo = saldo.sumar(monto);
	}

	public void retirar(Money monto) {
		// validar agumento nulo
		Objects.requireNonNull(monto, "Monto no debe ser nulo");

		// validar que monto no sea mayor al saldo
		if (saldo.getCantidad().compareTo(monto.getCantidad()) < 0)
			throw new RuntimeException("Saldo Insuficiente");

		// operar
		this.saldo = saldo.restar(monto);
	}

	public void mostrarInformacion() {
		System.out.println("Cliente: " + cliente);
		System.out.println("Nro. cuenta: " + numeroCuenta);
		System.out.println("Saldo: " + saldo);
	}

	// Getters

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public Cliente getTitular() {
		return cliente;
	}

	public Money getSaldo() {
		return saldo;
	}

}
