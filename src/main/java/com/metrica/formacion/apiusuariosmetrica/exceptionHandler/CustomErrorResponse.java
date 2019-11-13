package com.metrica.formacion.apiusuariosmetrica.exceptionHandler;

import org.springframework.http.HttpStatus;

import java.util.NoSuchElementException;

public class CustomErrorResponse extends RuntimeException {

	public CustomErrorResponse(Class cla, String parametros) {
		super(cla.getSimpleName() + generarMensaje(parametros));
	}

	private static String generarMensaje(String id){
		return "No existe cliente con id: " + id;
	}
}
