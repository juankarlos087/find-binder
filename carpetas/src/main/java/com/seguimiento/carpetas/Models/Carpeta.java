
package com.seguimiento.carpetas.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.GenericGenerator;

@Table
@Entity(name="carpeta")
public class Carpeta implements Serializable {
    @Id
    @Column(name="numero_emp")
    private int numero_emp;
    @Column(name="nombre_emp")
    private String nombre_emp;
    @Column(name="identificacion_emp")
    private String identificacion_emp;
    @ManyToOne
    @JoinColumn(name="codigo_tip")
    private Tipo tipo;

    public Carpeta() {
    }

    public Carpeta(int numero_emp, String nombre_emp, String identificacion_emp, Tipo tipo) {
        this.numero_emp = numero_emp;
        this.nombre_emp = nombre_emp;
        this.identificacion_emp = identificacion_emp;
        this.tipo = tipo;
    }

       public int getNumero_emp() {
        return numero_emp;
    }

    public void setNumero_emp(int numero_emp) {
        this.numero_emp = numero_emp;
    }
    
    
    
    
    public String getNombre_emp() {
        return nombre_emp;
    }

    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
    }

    public String getIdentificacion_emp() {
        return identificacion_emp;
    }

    public void setIdentificacion_emp(String identificacion_emp) {
        this.identificacion_emp = identificacion_emp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
}
