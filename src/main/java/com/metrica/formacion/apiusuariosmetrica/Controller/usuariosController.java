package com.metrica.formacion.apiusuariosmetrica.Controller;

import java.util.List;
import com.metrica.formacion.apiusuariosmetrica.Service.usuariosService;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.metrica.formacion.apiusuariosmetrica.Service.usuariosService;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@Log4j2
@RestController
@RequestMapping("/clientes")
public class usuariosController {

	@Autowired
	private usuariosService usuariosService;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    //

    @GetMapping("/lista-clientes")
    public List<usuarios> listaUsuarios() {
        log.info("Mostrando lista de usuarios");
        return usuariosService.listarUsuarios();
    }

    /* GET */

    @GetMapping("/buscarPorID/{id}")
    public usuarios buscarPorId(@PathVariable("id") Integer id) {
      return usuariosService.buscarPorId(id);
  }

    @GetMapping("/buscarPorNombre/{nombre}")
    public List<usuarios> buscarPorNombre(@PathVariable("nombre") String nombre) {
        return usuariosService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscarPorApellido/{apellido}")
    public List<usuarios> buscarPorApelllido(@PathVariable("apellido") String apellido) {
        return usuariosService.buscarPorApellido(apellido);
    }

    @GetMapping("/buscarPorGrupo/{key}")
    public List<usuarios> buscarPorGrupo(@PathVariable("key") Integer id){
        return usuariosService.buscarPorGrupo(id);
    }

    /* POST */

    @PostMapping("/guardarUsuario")
    public usuarios guardarusuario(@RequestBody usuarios usuarios) {
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

    //Test eureka client

    @GetMapping("/service-instances/{applicationName}")
    public List<InstanceInfo> serviceInstancesByApplicationName(@PathVariable String applicationName) {
      return this.eurekaClient.getApplication(applicationName).getInstancesAsIsFromEureka();
    }
}
