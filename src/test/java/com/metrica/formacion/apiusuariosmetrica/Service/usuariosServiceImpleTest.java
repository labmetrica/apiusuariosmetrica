package com.metrica.formacion.apiusuariosmetrica.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.metrica.formacion.apiusuariosmetrica.Config.SpringConfigurationFile;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;

@SpringBootTest(classes = SpringConfigurationFile.class)
@Transactional
public class usuariosServiceImpleTest {

	@Autowired
	private usuariosService usuariosService;

	@Test
	void buscarPorId() {

		Assertions.assertEquals(null, usuariosService.buscarPorId(96123));
	}

	@Test
	void buscarPorIdEntity() {
    
    Assertions.assertEquals(null, (usuariosService.buscarPorId(96123)));
  }

  @Test
  void buscarPorIdEntity() {

    final usuarios usuarios = null;
		Assertions.assertEquals(usuarios, usuariosService.buscarPorIdEntity(96123));
	}
}