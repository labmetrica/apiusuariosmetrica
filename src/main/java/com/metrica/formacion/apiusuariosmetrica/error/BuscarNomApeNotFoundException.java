package com.metrica.formacion.apiusuariosmetrica.error;

import org.springframework.dao.DataAccessException;

public class BuscarNomApeNotFoundException extends DataAccessException {

	public BuscarNomApeNotFoundException(String nombre, String apellido) {
		super("El nombre " + nombre + " y el apellido " + apellido + " no existen o estan mal escritos");
	}

}
