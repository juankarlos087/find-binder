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
@Entity(name="tipo")
public class Tipo implements Serializable {
    @Id
    @Column(name="codigo_tip")
    private int codigo_tip;
    @Column(name="estado_tip")
    private String estado_tip;
    @Column(name="observacion_tip")
    private String observacion_tip;

    public Tipo() {
    }

    public Tipo(int codigo_tip, String estado_tip, String observacion_tip) {
        this.codigo_tip = codigo_tip;
        this.estado_tip = estado_tip;
        this.observacion_tip = observacion_tip;
    }

    public int getCodigo_tip() {
        return codigo_tip;
    }

    public void setCodigo_tip(int codigo_tip) {
        this.codigo_tip = codigo_tip;
    }

    public String getEstado_tip() {
        return estado_tip;
    }

    public void setEstado_tip(String estado_tip) {
        this.estado_tip = estado_tip;
    }

    public String getObservacion_tip() {
        return observacion_tip;
    }

    public void setObservacion_tip(String observacion_tip) {
        this.observacion_tip = observacion_tip;
    }

}