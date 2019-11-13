package com.metrica.formacion.apiusuariosmetrica.error;

import javassist.tools.rmi.ObjectNotFoundException;

public class BuscarIdNotFoundException extends ObjectNotFoundException {

	public BuscarIdNotFoundException(final long id) {
		super("Ese id no existe " + id);
	}

	public BuscarIdNotFoundException() {
		super("No se ha encontrado ese usuario");
	}
}