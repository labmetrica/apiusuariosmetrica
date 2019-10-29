package com.metrica.formacion.apiusuariosmetrica.Service;

import com.metrica.formacion.apiusuariosmetrica.dao.usuariosRepository;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Log4j2
@Service
public class usuariosServiceImple implements usuariosService {

    @Autowired
    private usuariosRepository usuariosRepository;

    @Override
    public List<usuarios> listarUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public usuarios buscarPorId(Integer id) {
        log.info("buscar usuario con id: " + id);
        return usuariosRepository.findById(id).isPresent() ? usuariosRepository.findById(id).get() : null;
    }

    @Override
    public List<usuarios> buscarPorNombre(String nombre) {
        return usuariosRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<usuarios> buscarPorApellido(String apellido) {
        return usuariosRepository.findByApellidoContainingIgnoreCase(apellido);
    }

    @Override
    public List<usuarios> buscarPorNombreyApellido(String nombre, String apellido) {
        return usuariosRepository.findByNombreOrApellidoContainingIgnoreCase(nombre, apellido);
    }
}
