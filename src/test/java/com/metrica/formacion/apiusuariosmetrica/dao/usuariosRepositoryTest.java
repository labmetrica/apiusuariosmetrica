package com.metrica.formacion.apiusuariosmetrica.dao;

import com.metrica.formacion.apiusuariosmetrica.Config.SpringConfigurationFile;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = SpringConfigurationFile.class)
@Transactional
//@DataJpaTest
public class usuariosRepositoryTest {

    @Autowired
    private usuariosRepository usuariosRepository;

    @Test
    public void testRepo(){

        Assertions.assertEquals(Optional.empty(),usuariosRepository.findById(000));
    }

    @Test
    public void testBuscarPorFecha(){

        LocalDate fecha = LocalDate.of(2019,10,26);

        List<usuarios> lista = usuariosRepository.findByCreatedAT(fecha.toString());

        Assertions.assertEquals(2,lista.size());

    }

    @Test
    public void testBuscarPorFechaBefore(){

        List<usuarios> list = usuariosRepository.findByCreatedATBefore(LocalDateTime.of(2019,10,1, 00,00,00));

        Assertions.assertEquals(3,list.size());
    }

    @Test
    public void testInsertCliente(){

        usuarios usuarios = new usuarios();
        usuarios.setNombre("aaaa");
        usuarios.setApellido("lalalal");
        usuarios.setCreatedAT(LocalDateTime.now());
        usuarios.setUltima_modificacion(LocalDateTime.now());
        usuarios.setTipo(com.metrica.formacion.apiusuariosmetrica.entity.usuarios.tipos.Empleado);

        Assertions.assertEquals(usuarios, usuariosRepository.save(usuarios));
    }
}