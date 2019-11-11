package com.metrica.formacion.apiusuariosmetrica.error;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarFechaDosNotFoundException extends DataAccessException {

	public BuscarFechaDosNotFoundException(LocalDate fecha1, LocalDate fecha2) {
		super("No hay usuarios entre " + fecha1 + " y " + fecha2);
	}

}
