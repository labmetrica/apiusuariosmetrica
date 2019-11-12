package com.metrica.formacion.apiusuariosmetrica.Service;

import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface usuariosService {

    List<usuarios> listarUsuarios();

    boolean isExiste(usuarios usuarios);

    boolean isExiste(int id);

    usuarios buscarPorId(Integer id);

    usuarios buscarPorIdEntity(Integer id);

    usuarios guardarUsuario(usuarios usuarios);

    //delete

    void borrarPorId(Integer id);

    void borrarUsuario(usuarios usuario);

    void borrarTodo();

    //select - grupo

    List<usuarios> buscarPorGrupo(int id);

    //select - Nombre

    List<usuarios> buscarPorNombre(String nombre);

    List<usuarios> buscarPorApellido(String apellido);

    List<usuarios> buscarPorNombreyApellido(String nombre, String apellido);

    //select - Fecha

    List<usuarios> buscarPorCreatedAT(LocalDate fecha);

    List<usuarios> buscarPorCreatedAT(LocalDate fecha1, LocalDate fecha2);

    List<usuarios> buscarPorCreatedATBefore(LocalDate fecha);

    /**/

    List<usuarios> buscarPorUlimaModificacion(LocalDate fecha);

    List<usuarios> buscarPorUlimaModificacion(LocalDate fecha1, LocalDate fecha2);


}
