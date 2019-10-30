package com.metrica.formacion.apiusuariosmetrica.dao;

import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface usuariosRepository extends JpaRepository<usuarios, Integer> {

    List<usuarios> findByNombreContainingIgnoreCase(String nombre);

    List<usuarios> findByApellidoContainingIgnoreCase(String apellido);

    List<usuarios> findByNombreOrApellidoContainingIgnoreCase(String nombre, String apellido);

    List<usuarios> findByGrupo (Integer idgrupo);

    List<usuarios> findByCreatedATBetween (LocalDateTime fecha1, LocalDateTime fecha2);

    @Modifying
    @Query(value = "select * from usuarios where DATEDIFF(usuarios.createdAT, ?) = 0", nativeQuery = true)
    List<usuarios> findByCreatedAT(LocalDate fecha);

    usuarios findByEmailContainingIgnoreCase (String email);
}
