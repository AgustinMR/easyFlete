package com.grupo15.easyflete;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "solicitudes")
@XmlRootElement
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud_origen")
    private BigInteger latitudOrigen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud_origen")
    private BigInteger longitudOrigen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitud_destino")
    private BigInteger latitudDestino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitud_destino")
    private BigInteger longitudDestino;
    @Column(name = "peso")
    private Integer peso;
    @Column(name = "volumen")
    private Integer volumen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_max")
    private double precioMax;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;

    public Solicitud() {
    }

    public Solicitud(Integer id) {
        this.id = id;
    }

    public Solicitud(BigInteger latitudOrigen, BigInteger longitudOrigen, BigInteger latitudDestino, BigInteger longitudDestino, double precioMax) {
        this.latitudOrigen = latitudOrigen;
        this.longitudOrigen = longitudOrigen;
        this.latitudDestino = latitudDestino;
        this.longitudDestino = longitudDestino;
        this.precioMax = precioMax;
    }

    public Solicitud(BigInteger latitudOrigen, BigInteger longitudOrigen, BigInteger latitudDestino, BigInteger longitudDestino, double precioMax, Integer peso, Integer volumen, String descripcion) {
        this.latitudOrigen = latitudOrigen;
        this.longitudOrigen = longitudOrigen;
        this.latitudDestino = latitudDestino;
        this.longitudDestino = longitudDestino;
        this.precioMax = precioMax;
        this.peso = peso;
        this.volumen = volumen;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getLatitudOrigen() {
        return latitudOrigen;
    }

    public void setLatitudOrigen(BigInteger latitudOrigen) {
        this.latitudOrigen = latitudOrigen;
    }

    public BigInteger getLongitudOrigen() {
        return longitudOrigen;
    }

    public void setLongitudOrigen(BigInteger longitudOrigen) {
        this.longitudOrigen = longitudOrigen;
    }

    public BigInteger getLatitudDestino() {
        return latitudDestino;
    }

    public void setLatitudDestino(BigInteger latitudDestino) {
        this.latitudDestino = latitudDestino;
    }

    public BigInteger getLongitudDestino() {
        return longitudDestino;
    }

    public void setLongitudDestino(BigInteger longitudDestino) {
        this.longitudDestino = longitudDestino;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public double getPrecioMax() {
        return precioMax;
    }

    public void setPrecioMax(double precioMax) {
        this.precioMax = precioMax;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
