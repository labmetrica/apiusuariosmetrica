package com.metrica.formacion.apiusuariosmetrica.error;

import org.springframework.dao.DataAccessException;

public class BorrarIdNotFoundException extends DataAccessException {

	public BorrarIdNotFoundException(final long id) {
		super("Este id de usuario no existe" + id);
	}

}
