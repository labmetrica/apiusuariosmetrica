package com.metrica.formacion.apiusuariosmetrica.dao;

import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "SELECT * FROM usuarios u WHERE DATEDIF",
    nativeQuery = true);
    List<usuarios> findByCreatedAT(LocalDate localDate);

    usuarios findByEmailContainingIgnoreCase (String email);
}
