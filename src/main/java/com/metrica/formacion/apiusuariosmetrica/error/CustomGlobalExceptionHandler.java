package com.metrica.formacion.apiusuariosmetrica.error;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@EnableWebMvc
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(BuscarIdNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleNotFound(final BuscarIdNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ListarUsuariosNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleAllNotFound(final ListarUsuariosNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(BuscarNombreNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleNombreNotFound(final BuscarNombreNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarApellidoNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleApellidoNotFound(final BuscarApellidoNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarNomApeNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleNomApeNotFound(final BuscarNomApeNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarFechaUnoNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleFechaUnoNotFound(final BuscarFechaUnoNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarFechaDosNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleFechaDosNotFound(final BuscarFechaDosNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarFechaAntesNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleFechaAntesNotFound(
			final BuscarFechaAntesNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarModificacionNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleBuscarModificacionNotFound(
			final BuscarModificacionNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BuscarModificacionEntreNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleBuscarModificacionEntreNotFound(
			final BuscarModificacionEntreNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(UsuarioSaveNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleGrupoSaveNotFound(final UsuarioSaveNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BorrarIdNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleBorrarIdNotFound(final BorrarIdNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BorrarUsuarioNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleBorrarUsuarioNotFound(
			final BorrarUsuarioNotFoundException ex) throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BorrarTodoNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> springHandleBorrarTodoNotFound(final BorrarTodoNotFoundException ex)
			throws IOException {
		final CustomErrorResponse errors = new CustomErrorResponse();
		errors.setTimestamp(LocalDateTime.now());
		errors.setError(ex.getMessage());
		errors.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}
}
