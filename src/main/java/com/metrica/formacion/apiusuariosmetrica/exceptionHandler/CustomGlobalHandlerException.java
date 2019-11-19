package com.metrica.formacion.apiusuariosmetrica.exceptionHandler;

import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
public class CustomGlobalHandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomErrorResponse.class)
	public ResponseEntity<Object> customError(CustomErrorResponse ex) {

		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
		apiError.setMensaje(ex.getMessage());
		apiError.setExceptionMessage(ex.getExMessage());

		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<Object> globalError(HttpClientErrorException ex){

		ApiError apiError = new ApiError(HttpStatus.FORBIDDEN);
		apiError.setMensaje(ex.getMessage());
		apiError.setExceptionMessage(ex.getResponseBodyAsString());

		log.error(ex.getMessage());
		log.error(ex.getResponseBodyAsString());

		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> EmptyResult (EmptyResultDataAccessException ex){

		ApiError error = new ApiError(HttpStatus.BAD_REQUEST);
		error.setMensaje("No existe id");
		error.setExceptionMessage(ex.getMessage());

		log.error(ex.getMessage());
		log.error(ex.getLocalizedMessage());

		return buildResponseEntity(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> SQLconstrainsViolation(DataIntegrityViolationException ex, HttpStatus httpStatus){

		ApiError error = new ApiError(httpStatus);
		error.setMensaje("Clave unique repetida");
		error.setExceptionMessage(ex.getMessage());

		log.error(ex.getMessage());
		log.error(ex.getLocalizedMessage());

		return buildResponseEntity(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ApiError apiError = new ApiError(status);
		apiError.setMensaje("Metodo " + ex.getMethod() + " no sortado, metodos soportados: " + ex.getSupportedHttpMethods());
		apiError.setExceptionMessage(ex.getMessage());

		log.error(ex.getMessage());
		log.error(ex.getMethod());
		log.error(ex.getSupportedHttpMethods());

		return buildResponseEntity(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ApiError apiError = new ApiError(status);
		apiError.setMensaje("JSON parse error, " + request.getContextPath());
		apiError.setExceptionMessage(ex.getMessage());

		return buildResponseEntity(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ApiError apiError = new ApiError(status);
		apiError.setMensaje("apiError");

		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
