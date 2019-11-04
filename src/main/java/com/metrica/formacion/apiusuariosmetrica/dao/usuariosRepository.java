package com.metrica.formacion.apiusuariosmetrica.dao;

import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface usuariosRepository extends JpaRepository<usuarios, Integer>,
        JpaSpecificationExecutor<usuarios> {

    List<usuarios> findByNombreContainingIgnoreCase(String nombre);

    List<usuarios> findByApellidoContainingIgnoreCase(String apellido);

    List<usuarios> findByNombreOrApellidoContainingIgnoreCase(String nombre, String apellido);

    List<usuarios> findByGrupo (Integer idgrupo);

    usuarios findByEmailContainingIgnoreCase (String email);

    List<usuarios> findByCreatedATBetween (LocalDateTime fecha1, LocalDateTime fecha2);

    @Query(value = "SELECT * FROM usuarios WHERE DATE(usuarios.createdAT) = ?1", nativeQuery = true)
    List<usuarios> findByCreatedAT(String date);

    List<usuarios> findByCreatedATBefore(LocalDateTime localDateTime);

    @Query(value = "SELECT * FROM usuarios WHERE DATE(usuarios.ultima_modificacion) = ?1", nativeQuery = true)
    List<usuarios> findByUltima_modificacion(String fecha);

    List<usuarios> findByUltima_modificacionBefore(LocalDateTime localDateTime);

    List<usuarios> findByUltima_modificacionBetween(LocalDateTime fecha1, LocalDateTime fecha2);
}
