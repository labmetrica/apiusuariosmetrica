package com.metrica.formacion.apiusuariosmetrica.error;

public class BuscarFechaAntesNotFoundException extends RuntimeException {
	public BuscarFechaAntesNotFoundException() {
		super("No existe o no se encuentra esa fecha");
	}
}
