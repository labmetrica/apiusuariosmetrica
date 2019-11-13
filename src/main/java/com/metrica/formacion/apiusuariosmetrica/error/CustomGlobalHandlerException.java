package com.metrica.formacion.apiusuariosmetrica.error;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomGlobalHandlerException extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CustomErrorResponse.class)
	public ResponseEntity<String> customError(final CustomErrorResponse ex) {
		final String error = new JSONObject()
				.put("error", new JSONObject().put("code", ex.getError()).put("Descripcion", ex.getMessage()))
				.toString();
		return new ResponseEntity<>(error, ex.getStatus());

	}
}
