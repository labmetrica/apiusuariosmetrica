package com.metrica.formacion.apiusuariosmetrica.Controller;

import com.metrica.formacion.apiusuariosmetrica.Service.usuariosService;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class usuariosController {

    @Autowired
    private usuariosService usuariosService;

    @GetMapping("/lista-clientes")
    public List<usuarios> listaUsuarios(){

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


}
