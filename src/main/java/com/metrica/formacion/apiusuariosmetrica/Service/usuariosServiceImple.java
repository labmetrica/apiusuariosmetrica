package com.metrica.formacion.apiusuariosmetrica.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrica.formacion.apiusuariosmetrica.dao.usuariosRepository;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import com.metrica.formacion.apiusuariosmetrica.error.BorrarIdNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BorrarTodoNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BorrarUsuarioNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarApellidoNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarFechaAntesNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarFechaDosNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarFechaUnoNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarIdNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarModificacionEntreNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarModificacionNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarNomApeNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarNombreNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.ListarUsuariosNotFoundException;
import com.metrica.formacion.apiusuariosmetrica.error.UsuarioSaveNotFoundException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class usuariosServiceImple implements usuariosService {

	@Autowired
	private usuariosRepository usuariosRepository;

	@Override
	public List<usuarios> listarUsuarios() {
		if (usuariosRepository.findAll() != null) {
			return usuariosRepository.findAll();
		} else {
			throw new ListarUsuariosNotFoundException();
		}
	}

	@Override
	public boolean isExiste(int id) {
		return usuariosRepository.existsById(id);
	}

	@Override
	public boolean isExiste(usuarios usuarios) {
		return usuariosRepository.existsById(usuarios.getId());
	}

	@Override
	public usuarios buscarPorId(Integer id) throws BuscarIdNotFoundException {
		log.info("buscar usuario con id: " + id);

		if (usuariosRepository.existsById(id)) {

			return usuariosRepository.findById(id).get();
		} else {
			throw new BuscarIdNotFoundException();
		}
	}

	@Override
	public usuarios buscarPorIdEntity(Integer id) throws BuscarIdNotFoundException {

		log.info("Buscando usuario con id" + id);
		if (usuariosRepository.getOne(id) != null) {
			return usuariosRepository.getOne(id);
		} else {
			throw new BuscarIdNotFoundException();
		}
	}

	// save

	@Override
	public usuarios guardarUsuario(usuarios usuarios) {
		if (usuariosRepository.existsById(usuarios.getId()) || usuariosRepository.exists(usuarios.getEmail())) {
			throw new UsuarioSaveNotFoundException();
		} else {
			return usuariosRepository.save(usuarios);
		}
	}

	// delete

	@Override
	public void borrarPorId(Integer id) {
		if (usuariosRepository.existsById(id)) {
			usuariosRepository.deleteById(id);
		} else {
			throw new BorrarIdNotFoundException(id);
		}
	}

	@Override
	public void borrarUsuario(usuarios usuario) {
		if (usuariosRepository.existsById(usuario.getId())) {
			usuariosRepository.delete(usuario);
		} else {
			throw new BorrarUsuarioNotFoundException(usuario);
		}
	}

	@Override
	public void borrarTodo() {
		if (usuariosRepository.findAll() != null) {
			usuariosRepository.deleteAll();
		} else {
			throw new BorrarTodoNotFoundException();
		}
	}

	// select

	/* Nombre y apellido */

	@Override
	public List<usuarios> buscarPorNombre(String nombre) {
		log.info("Buscando usuario con nombre" + nombre);
		if (usuariosRepository.findByNombreContainingIgnoreCase(nombre) != null) {
			return usuariosRepository.findByNombreContainingIgnoreCase(nombre);
		} else {
			throw new BuscarNombreNotFoundException(nombre);
		}
	}

	@Override
	public List<usuarios> buscarPorApellido(String apellido) {
		if (usuariosRepository.findByApellidoContainingIgnoreCase(apellido) != null) {
			return usuariosRepository.findByApellidoContainingIgnoreCase(apellido);
		} else {
			throw new BuscarApellidoNotFoundException(apellido);
		}
	}

	@Override
	public List<usuarios> buscarPorNombreyApellido(String nombre, String apellido) {
		if (usuariosRepository.findByNombreOrApellidoContainingIgnoreCase(nombre, apellido) != null) {
			return usuariosRepository.findByNombreOrApellidoContainingIgnoreCase(nombre, apellido);
		} else {
			throw new BuscarNomApeNotFoundException(nombre, apellido);
		}
	}

	// select

	/* Por fecha - createdAt y ultima modificacion */

	// cretedAT

	@Override
	public List<usuarios> buscarPorCreatedAT(LocalDate localDate) {
		if (usuariosRepository.findByCreatedAT(localDate.toString()) != null) {
			return usuariosRepository.findByCreatedAT(localDate.toString());
		} else {
			throw new BuscarFechaUnoNotFoundException(localDate);
		}
	}

	@Override
	public List<usuarios> buscarPorCreatedAT(LocalDate fecha1, LocalDate fecha2) {
		if (usuariosRepository.findByCreatedATBetween(fecha1.atTime(23, 59, 59), fecha2.atTime(23, 59, 59)) != null) {
			return usuariosRepository.findByCreatedATBetween(fecha1.atTime(23, 59, 59), fecha2.atTime(23, 59, 59));
		} else {
			throw new BuscarFechaDosNotFoundException(fecha1, fecha2);
		}
	}

	@Override
	public List<usuarios> buscarPorCreatedATBefore(LocalDate fecha) {
		if (usuariosRepository.findByCreatedATBefore(fecha.atTime(23, 59, 59)) != null) {
			return usuariosRepository.findByCreatedATBefore(fecha.atTime(23, 59, 59));
		} else {
			throw new BuscarFechaAntesNotFoundException();
		}
	}

	// Ultima Modificacion

	@Override
	public List<usuarios> buscarPorUlimaModificacion(LocalDate fecha) {
		if (usuariosRepository.findByUltimaModificacion(fecha.toString()) != null) {
			return usuariosRepository.findByUltimaModificacion(fecha.toString());
		} else {
			throw new BuscarModificacionNotFoundException(fecha);
		}
	}

	@Override
	public List<usuarios> buscarPorUlimaModificacion(LocalDate fecha1, LocalDate fecha2) {
		if (usuariosRepository.findByUltimaModificacionBetween(fecha1.atTime(23, 59, 59),
				fecha2.atTime(23, 59, 59)) != null) {
			return usuariosRepository.findByUltimaModificacionBetween(fecha1.atTime(23, 59, 59),
					fecha2.atTime(23, 59, 59));
		} else {
			throw new BuscarModificacionEntreNotFoundException(fecha1, fecha2);
		}
	}
}
