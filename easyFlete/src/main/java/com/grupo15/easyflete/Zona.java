package com.grupo15.easyflete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "zonas")
public class Zona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "zona", fetch = FetchType.EAGER)
    private ZonaFletero zonaFletero;

    public Zona() {
    }

    public Zona(Integer id) {
        this.id = id;
    }

    public Zona(Integer id, double precio) {
        this.id = id;
        this.precio = precio;
    }
    
    public Zona(double precio,String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }
    
    public Zona(Integer id, double precio,String nombre) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ZonaFletero getZonaFletero() {
        return zonaFletero;
    }

    public void setZonaFletero(ZonaFletero zonaFletero) {
        this.zonaFletero = zonaFletero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
