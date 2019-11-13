package com.metrica.formacion.apiusuariosmetrica.error;

public enum Error {
	BAD_REQUEST("01", "La consulta requerida no es la adecuada."),
	INTERNAL_SERVER_ERROR("02", "Conexión fallida a la base de datos."),
	NOT_FOUND("03", "La consulta realizada no existe");

	private final String code;
	private final String description;

	private Error(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}