package com.metrica.formacion.apiusuariosmetrica.error;

public class BuscarNombreNotFoundException extends RuntimeException {

	public BuscarNombreNotFoundException(String nombre) {
		super("Este nombre no existe o esta mal escrito " + nombre);

	}

}
