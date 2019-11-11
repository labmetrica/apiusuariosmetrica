package com.metrica.formacion.apiusuariosmetrica.entity;

import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import java.time.LocalDateTime;

@Log4j2
@Entity
@Table(name = "usuarios")
public class usuarios {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "grupo")
    private int grupo;

    @Column(name = "email")
    private String email;

    @Column(name = "createdAT")
    private LocalDateTime createdAT;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "ultimaModificacion")
    private LocalDateTime ultimaModificacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private tipos tipo = tipos.Empleado;

    public enum tipos {Empleado, LAB};

    //Constructor

    public usuarios(){
        log.info("nuevo usuario, con id: " + id);
        createdAT = LocalDateTime.now();
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAT() {
        return createdAT;
    }

    public void setCreatedAT(LocalDateTime createdAT) {
        this.createdAT = createdAT;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public void setUltima_modificacion() {

        this.ultimaModificacion = LocalDateTime.now();
    }

    public tipos getTipo() {
        return tipo;
    }

    public void setTipo(tipos tipo) {
        this.tipo = tipo;
    }
}
