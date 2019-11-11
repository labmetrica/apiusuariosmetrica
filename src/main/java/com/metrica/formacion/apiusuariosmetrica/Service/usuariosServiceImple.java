package com.metrica.formacion.apiusuariosmetrica.Service;

import com.metrica.formacion.apiusuariosmetrica.dao.usuariosRepository;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public boolean isExiste(int id) {
        return usuariosRepository.existsById(id);
    }

    @Override
    public boolean isExiste(usuarios usuarios) {
        return usuariosRepository.existsById(usuarios.getId());
    }

    /*ID*/

    @Override
    public usuarios buscarPorId(Integer id) {
        log.info("buscar usuario con id: " + id);

        if (usuariosRepository.existsById(id)) {

            return usuariosRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public usuarios buscarPorIdEntity(Integer id) {

        log.info("Buscando usuario con id" + id);
        return usuariosRepository.getOne(id);
    }

    //save

    @Override
    public usuarios guardarUsuario(usuarios usuarios) {
        log.info("guardando nuevo usuario", usuarios);
        return usuariosRepository.save(usuarios);
    }

    //delete

    @Override
    public void borrarPorId(Integer id) {

        usuariosRepository.deleteById(id);
    }

    @Override
    public void borrarUsuario(usuarios usuario) {

        usuariosRepository.delete(usuario);
    }

    @Override
    public void borrarTodo() {

        usuariosRepository.deleteAll();
    }

    @Override
    public List<usuarios> buscarPorGrupo(int id) {
        return usuariosRepository.findByGrupo(id);
    }

    //select

    /*Nombre y apellido*/

    @Override
    public List<usuarios> buscarPorNombre(String nombre) {
        log.info("Buscando usuario con nombre" + nombre);
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

    //select

    /*Por fecha - createdAt y ultima modificacion*/

    //cretedAT

    @Override
    public List<usuarios> buscarPorCreatedAT(LocalDate localDate) {
        return usuariosRepository.findByCreatedAT(localDate.toString());
    }

    @Override
    public List<usuarios> buscarPorCreatedAT(LocalDate fecha1, LocalDate fecha2) {
        return usuariosRepository.findByCreatedATBetween(fecha1.atTime(23, 59, 59),
                fecha2.atTime(23, 59, 59));
    }

    @Override
    public List<usuarios> buscarPorCreatedATBefore(LocalDate fecha) {
        return usuariosRepository.findByCreatedATBefore(fecha.atTime(23, 59, 59));
    }

    //Ultima Modificacion

    @Override
    public List<usuarios> buscarPorUlimaModificacion(LocalDate fecha) {
        return usuariosRepository.findByUltimaModificacion(fecha.toString());
    }

    @Override
    public List<usuarios> buscarPorUlimaModificacion(LocalDate fecha1, LocalDate fecha2) {
        return usuariosRepository.findByUltimaModificacionBetween(fecha1.atTime(23, 59, 59),
                fecha2.atTime(23, 59, 59));
    }
}
