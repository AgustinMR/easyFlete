/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo15.easyflete;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "solicitudes")
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "destino")
    private String destino;
    @Column(name = "peso")
    private Integer peso;
    @Column(name = "volumen")
    private Integer volumen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_max")
    private double precioMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "solicitud", fetch = FetchType.EAGER)
    private FleteroSolicitudCliente fleteroSolicitudCliente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "solicitud", fetch = FetchType.EAGER)
    private SolicitudCliente solicitudCliente;

    public Solicitud() {
    }

    public Solicitud(Integer id) {
        this.id = id;
    }

    public Solicitud(Integer id, String origen, String destino, double precioMax, String titulo) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.precioMax = precioMax;
        this.titulo = titulo;
    }

    public Solicitud(String origen, String destino, Integer volumen, double precioMax, String titulo, String descripcion) {
        this.origen = origen;
        this.destino = destino;
        this.volumen = volumen;
        this.precioMax = precioMax;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FleteroSolicitudCliente getFleteroSolicitudCliente() {
        return fleteroSolicitudCliente;
    }

    public void setFleteroSolicitudCliente(FleteroSolicitudCliente fleteroSolicitudCliente) {
        this.fleteroSolicitudCliente = fleteroSolicitudCliente;
    }

    public SolicitudCliente getSolicitudCliente() {
        return solicitudCliente;
    }

    public void setSolicitudCliente(SolicitudCliente solicitudCliente) {
        this.solicitudCliente = solicitudCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo15.easyflete.Solicitud[ id=" + id + " ]";
    }
    
}
