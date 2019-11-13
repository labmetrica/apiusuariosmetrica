package com.metrica.formacion.apiusuariosmetrica.error;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarModificacionNotFoundException extends DataAccessException {

	public BuscarModificacionNotFoundException(LocalDate fecha) {
		super("La fecha " + fecha + " no es una modificación");
	}

}
