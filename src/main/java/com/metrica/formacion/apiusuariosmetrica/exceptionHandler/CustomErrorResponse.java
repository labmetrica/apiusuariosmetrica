package com.metrica.formacion.apiusuariosmetrica.exceptionHandler;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Data
public class CustomErrorResponse extends RuntimeException {

	private String exMessage;

	public CustomErrorResponse(Class cla, String mensaje, String exmensaje) {
		super("Class name: " + cla.getSimpleName()+", "+mensaje);
		this.exMessage = exmensaje;
	}
}
