package com.metrica.formacion.apiusuariosmetrica.Service;

import java.time.LocalDate;
import java.util.List;

import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import com.metrica.formacion.apiusuariosmetrica.error.BuscarIdNotFoundException;

public interface usuariosService {

	List<usuarios> listarUsuarios();

	boolean isExiste(usuarios usuarios);

	boolean isExiste(int id);

	usuarios buscarPorId(Integer id) throws BuscarIdNotFoundException;

	usuarios buscarPorIdEntity(Integer id) throws BuscarIdNotFoundException;

	usuarios guardarUsuario(usuarios usuarios);

	// delete

	void borrarPorId(Integer id);

	void borrarUsuario(usuarios usuario);

	void borrarTodo();

	// select - Nombre

	List<usuarios> buscarPorNombre(String nombre);

	List<usuarios> buscarPorApellido(String apellido);

	List<usuarios> buscarPorNombreyApellido(String nombre, String apellido);

	// select - Fecha

	List<usuarios> buscarPorCreatedAT(LocalDate fecha);

	List<usuarios> buscarPorCreatedAT(LocalDate fecha1, LocalDate fecha2);

	List<usuarios> buscarPorCreatedATBefore(LocalDate fecha);

	/**/

	List<usuarios> buscarPorUlimaModificacion(LocalDate fecha);

	List<usuarios> buscarPorUlimaModificacion(LocalDate fecha1, LocalDate fecha2);

}
