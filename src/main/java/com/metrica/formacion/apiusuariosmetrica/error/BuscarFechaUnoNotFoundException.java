package com.metrica.formacion.apiusuariosmetrica.error;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarFechaUnoNotFoundException extends DataAccessException {

	public BuscarFechaUnoNotFoundException(LocalDate localDate) {
		super("Esta fecha no existe o no se encuentra " + localDate);
	}

}
