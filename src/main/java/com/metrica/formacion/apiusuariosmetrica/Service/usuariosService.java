package com.metrica.formacion.apiusuariosmetrica.Service;

import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;

import java.util.List;

public interface usuariosService {

    List<usuarios> listarUsuarios();

    usuarios buscarPorId(Integer id);

    List<usuarios> buscarPorNombre(String nombre);

    List<usuarios> buscarPorApellido(String apellido);

    List<usuarios> buscarPorNombreyApellido(String nombre, String apellido);
}
