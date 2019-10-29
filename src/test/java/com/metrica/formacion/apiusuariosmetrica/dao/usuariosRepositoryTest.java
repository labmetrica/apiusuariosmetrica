package com.metrica.formacion.apiusuariosmetrica.dao;

import com.metrica.formacion.apiusuariosmetrica.Config.SpringConfigurationFile;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = SpringConfigurationFile.class)
@Transactional
//@DataJpaTest
public class usuariosRepositoryTest {

    @Autowired
    private usuariosRepository usuariosRepository;

    @Test()
    public void testRepo(){

        Assertions.assertEquals(Optional.empty(),usuariosRepository.findById(000));
    }
}