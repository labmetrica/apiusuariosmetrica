package com.metrica.formacion.apiusuariosmetrica.error;

public class ListarUsuariosNotFoundException extends RuntimeException {
	public ListarUsuariosNotFoundException() {
		super("No hay usuarios registrados ahora mismo");
	}
}
