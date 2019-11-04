package com.metrica.formacion.apiusuariosmetrica.Controller;

import com.metrica.formacion.apiusuariosmetrica.Service.usuariosService;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/clientes")
public class usuariosController {

    @Autowired
    private usuariosService usuariosService;

    @GetMapping("/lista-clientes")
    public List<usuarios> listaUsuarios(){

        log.info("Mostrando lista de usuarios");
        return usuariosService.listarUsuarios();
    }

    /*GET*/

    @GetMapping("/buscarPorID/{id}")
    public usuarios buscarPorId(@PathVariable("id") Integer id){
        return usuariosService.buscarPorId(id);
    }

    @GetMapping("/bucarPorNombre/{nombre}")
    public List<usuarios> buscarPorNombre(@PathVariable("nombre") String nombre){
        return usuariosService.buscarPorNombre(nombre);
    }

    @GetMapping("/bucarPorApellido/{apellido}")
    public List<usuarios> buscarPorApelllido(@PathVariable("apellido") String apellido){

        return usuariosService.buscarPorApellido(apellido);
    }

    /*POST*/

    @PostMapping("/guardarUsuario")
    public usuarios guardarusuario(@RequestBody usuarios usuarios){

        if(usuariosService.isExiste(usuarios)){

            //error si existe

            return null;
        }

        return usuariosService.guardarUsuario(usuarios);
    }

    /*PUT*/

    @PutMapping("/actulizarUsuario")
    public usuarios actulizarUsuario(@RequestBody usuarios usuarios){

        return usuariosService.guardarUsuario(usuarios);
    }

    /*DELETE*/

    @DeleteMapping("/borrarUsuario/{id}")
    public void borrarUsuario(@PathVariable("id") Integer id){

        usuariosService.borrarPorId(id);
    }

    @DeleteMapping("/borrarTODO")
    public void borrarTodo(){

        usuariosService.borrarTodo();
    }
}
