package com.metrica.formacion.apiusuariosmetrica.error;

import org.springframework.dao.DataAccessException;

public class BuscarApellidoNotFoundException extends DataAccessException {

	public BuscarApellidoNotFoundException(String apellido) {
		super("Este apellido no existe o esta mal escrito " + apellido);
	}

}
