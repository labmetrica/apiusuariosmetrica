package com.metrica.formacion.apiusuariosmetrica.error;

import org.springframework.dao.DataAccessException;

import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;

public class BorrarUsuarioNotFoundException extends DataAccessException {

	public BorrarUsuarioNotFoundException(usuarios usuario) {
		super("Este usuario no existe " + usuario.getId());
	}

}
