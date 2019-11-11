package com.metrica.formacion.apiusuariosmetrica.error;

import java.time.LocalDate;

import org.springframework.dao.DataAccessException;

public class BuscarModificacionEntreNotFoundException extends DataAccessException {

	public BuscarModificacionEntreNotFoundException(LocalDate fecha1, LocalDate fecha2) {
		super("La modificacion no existe entre " + fecha1 + " y " + fecha2);
	}

}
