package com.aldeerdev.sistemabancario.domain.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

	private String nombre;
	private String documento;
	private List<CuentaBancaria> cuentas;

	public Cliente(String nombre, String documento) {
		// validar argumentos nulos
		Objects.requireNonNull(nombre, "nombre no puede ser nulo.");
		Objects.requireNonNull(documento, "documento no puede ser nulo.");

		this.nombre = nombre;
		this.documento = documento;
		this.cuentas = new ArrayList<>();
	}
	
	public void agregarCuenta(CuentaBancaria nuevaCuenta) {
		this.cuentas.add(nuevaCuenta);
	}
	
	// Getters

	public String getNombre() {
		return nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public List<CuentaBancaria> getCuentas() {
		return cuentas;
	}

}
