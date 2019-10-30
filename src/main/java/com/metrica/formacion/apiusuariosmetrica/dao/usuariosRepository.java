package com.metrica.formacion.apiusuariosmetrica.dao;

import com.metrica.formacion.apiusuariosmetrica.Converter.LocalDateConvert;
import com.metrica.formacion.apiusuariosmetrica.entity.usuarios;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Convert;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;

@Repository
public interface usuariosRepository extends JpaRepository<usuarios, Integer>,
        JpaSpecificationExecutor<usuarios> {

    List<usuarios> findByNombreContainingIgnoreCase(String nombre);

    List<usuarios> findByApellidoContainingIgnoreCase(String apellido);

    List<usuarios> findByNombreOrApellidoContainingIgnoreCase(String nombre, String apellido);

    List<usuarios> findByGrupo (Integer idgrupo);

    List<usuarios> findByCreatedATBetween (LocalDateTime fecha1, LocalDateTime fecha2);

    //@Modifying
    @Query(value = "SELECT* FROM usuarios WHERE DATE(usuarios.createdAT) = ?1", nativeQuery = true)
    List<usuarios> findByCreatedAT(String date);

    usuarios findByEmailContainingIgnoreCase (String email);
}
