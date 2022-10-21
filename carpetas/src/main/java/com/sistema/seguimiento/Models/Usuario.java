package com.sistema.seguimiento.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Table
@Entity(name="usuario")
public class Usuario implements Serializable {
    @Id
    @Column(name="id_usuario")
    private int id_usuario;
    @Column(name="nombre_usuario")
    private String nombre_usuario;
    @Column(name="clave_usuario")
    private String clave_usuario;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getClave_usuario() {
        return clave_usuario;
    }

    public void setClave_usuario(String clave_usuario) {
        this.clave_usuario = clave_usuario;
    }
    
    
    
}
