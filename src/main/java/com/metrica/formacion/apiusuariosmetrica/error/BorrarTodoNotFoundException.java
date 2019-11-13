package com.metrica.formacion.apiusuariosmetrica.error;

public class BorrarTodoNotFoundException extends RuntimeException {
	public BorrarTodoNotFoundException() {
		super("No hay usuarios para borrar");
	}
}
