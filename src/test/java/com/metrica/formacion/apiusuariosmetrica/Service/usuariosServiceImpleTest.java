package com.metrica.formacion.apiusuariosmetrica.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.metrica.formacion.apiusuariosmetrica.Config.SpringConfigurationFile;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarIdNotFoundException;

@SpringBootTest(classes = SpringConfigurationFile.class)
@Transactional
public class usuariosServiceImpleTest {

	@Autowired
	private usuariosService usuariosService;

	@Test
	void buscarPorId() throws BuscarIdNotFoundException {

		Assertions.assertEquals(null, usuariosService.buscarPorId(96123));
	}

	@Test
	void buscarPorIdEntity() throws BuscarIdNotFoundException {

		final usuarios usuarios = null;

		Assertions.assertEquals(usuarios, usuariosService.buscarPorIdEntity(96123));
	}
}