package com.metrica.formacion.apiusuariosmetrica.error;

public class UsuarioSaveNotFoundException extends RuntimeException {
	public UsuarioSaveNotFoundException() {
		super("Este grupo ya existe");
	}
}
