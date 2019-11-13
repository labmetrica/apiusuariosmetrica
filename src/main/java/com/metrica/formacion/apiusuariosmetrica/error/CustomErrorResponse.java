package com.metrica.formacion.apiusuariosmetrica.error;

import org.springframework.http.HttpStatus;

public class CustomErrorResponse extends RuntimeException {
	private final HttpStatus status;
	private final String error;

	public CustomErrorResponse(HttpStatus status, String error, String message) {
		super(message);
		this.status = status;
		this.error = error;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

}
