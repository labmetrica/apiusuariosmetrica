package com.metrica.formacion.apiusuariosmetrica.dao;

import com.metrica.formacion.apiusuariosmetrica.entity.roles;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface rolesRepository extends JpaRepository<roles, Integer> {
}
