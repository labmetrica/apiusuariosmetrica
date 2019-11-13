package com.metrica.formacion.apiusuariosmetrica.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonTypeIdResolver(LowerCaseClassName.class)
@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
public class Error {

	private HttpStatus httpStatus;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime fecha;
	private String mensaje;
	private String exceptionMessage;

	public Error(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Error(HttpStatus httpStatus, LocalDateTime fecha) {
		this.httpStatus = httpStatus;
		this.fecha = fecha;
	}

	public Error(HttpStatus httpStatus, LocalDateTime fecha, String mensaje) {
		this.httpStatus = httpStatus;
		this.fecha = fecha;
		this.mensaje = mensaje;
	}

	public Error(HttpStatus httpStatus, LocalDateTime fecha, String mensaje, String exceptionMessage) {
		this.httpStatus = httpStatus;
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.exceptionMessage = exceptionMessage;
	}


}