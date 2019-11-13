package com.metrica.formacion.apiusuariosmetrica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrica.formacion.apiusuariosmetrica.Service.usuariosService;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarIdNotFoundException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/clientes")
public class usuariosController {

	@Autowired
	private usuariosService usuariosService;

	@GetMapping("/lista-clientes")
	public List<usuarios> listaUsuarios() {

		log.info("Mostrando lista de usuarios");
		return usuariosService.listarUsuarios();
	}

	/* GET */

	@GetMapping("/buscarPorID/{id}")
	public usuarios buscarPorId(@PathVariable("id") Integer id) throws BuscarIdNotFoundException {
		return usuariosService.buscarPorId(id);
	}

	@GetMapping("/bucarPorNombre/{nombre}")
	public List<usuarios> buscarPorNombre(@PathVariable("nombre") String nombre) {
		return usuariosService.buscarPorNombre(nombre);
	}

	@GetMapping("/bucarPorApellido/{apellido}")
	public List<usuarios> buscarPorApelllido(@PathVariable("apellido") String apellido) {

		return usuariosService.buscarPorApellido(apellido);
	}

	/* POST */

	@PostMapping("/guardarUsuario")
	public usuarios guardarusuario(@RequestBody usuarios usuarios) {

		if (usuariosService.isExiste(usuarios)) {

			// error si existe

			return null;
		}

		return usuariosService.guardarUsuario(usuarios);
	}

	/* PUT */

	@PutMapping("/actualizarUsuario")
	public usuarios actualizarUsuario(@RequestBody usuarios usuarios) {

		return usuariosService.guardarUsuario(usuarios);
	}

	/* DELETE */

	@DeleteMapping("/borrarUsuario/{id}")
	public void borrarUsuario(@PathVariable("id") Integer id) {

		usuariosService.borrarPorId(id);
	}

	@DeleteMapping("/borrarTODO")
	public void borrarTodo() {

		usuariosService.borrarTodo();
	}
}
