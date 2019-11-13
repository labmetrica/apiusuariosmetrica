package com.metrica.formacion.apiusuariosmetrica.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.metrica.formacion.apiusuariosmetrica.Service.usuariosService;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import com.metrica.formacion.apiusuariosmetrica.error.CustomErrorResponse;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
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
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Integer id) {
		try {
			usuariosService.buscarPorId(id);
		} catch (final CustomErrorResponse e) {

			return new ResponseEntity<>(new CustomErrorResponse(e.getStatus(), e.getError(), e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(usuariosService.buscarPorId(id), HttpStatus.OK);
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

	@PutMapping("/actulizarUsuario")
	public usuarios actulizarUsuario(@RequestBody usuarios usuarios) {

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
