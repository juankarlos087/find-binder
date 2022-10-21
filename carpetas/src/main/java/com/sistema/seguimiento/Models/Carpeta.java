package com.sistema.seguimiento.Models;

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
    @Column(name="codigo_car")
    private int codigo_car;
    @Column(name="nombre_emp")
    private String nombre_emp;
    @Column(name="identificacion_emp")
    private double identificacion_emp;
    @ManyToOne
    @JoinColumn(name="codigo_tip")
    private Tipo tipo;

    public Carpeta() {
    }

    public Carpeta(int codigo_car, String nombre_emp, double identificacion_emp, Tipo tipo) {
        this.codigo_car = codigo_car;
        this.nombre_emp = nombre_emp;
        this.identificacion_emp = identificacion_emp;
        this.tipo = tipo;
    }

    public int getCodigo_car() {
        return codigo_car;
    }

    public void setCodigo_car(int codigo_car) {
        this.codigo_car = codigo_car;
    }

    public String getNombre_emp() {
        return nombre_emp;
    }

    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
    }

    public double getIdentificacion_emp() {
        return identificacion_emp;
    }

    public void setIdentificacion_emp(double identificacion_emp) {
        this.identificacion_emp = identificacion_emp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
}
