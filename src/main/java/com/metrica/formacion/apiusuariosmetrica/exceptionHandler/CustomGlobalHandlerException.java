package com.metrica.formacion.apiusuariosmetrica.exceptionHandler;

import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Log4j2
@ControllerAdvice
public class CustomGlobalHandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomErrorResponse.class)
	public ResponseEntity<Object> customError(CustomErrorResponse ex) {

		Error error = new Error(HttpStatus.NOT_FOUND);
		error.setMensaje(ex.getMessage());

		log.error(ex.getMessage());

		return buildResponseEntity(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		Error error = new Error(status);
		error.setMensaje("error");

		return buildResponseEntity(error);
	}

	private ResponseEntity<Object> buildResponseEntity(Error apiError) {
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}
}
