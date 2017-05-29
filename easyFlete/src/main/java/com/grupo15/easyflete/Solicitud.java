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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable {

    @Column(name = "distancia")
    private Double distancia;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "peso")
    private Integer peso;
    @Column(name = "volumen")
    private Integer volumen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_max")
    private double precioMax;
    @Size(max = 30)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "valoracion")
    private Integer valoracion;
    @Column(name = "precio")
    private Double precio;
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

    public Solicitud(Integer id, double precioMax, String titulo) {
        this.id = id;
        this.precioMax = precioMax;
        this.titulo = titulo;
    }
    
    public Solicitud(Integer peso, double precioMax, String titulo, String descripcion, double distancia) {
        this.peso = peso;
        this.precioMax = precioMax;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.distancia = distancia;
    }

    public Solicitud(double precioMax, String titulo, String descripcion, Integer volumen, double distancia) {
        this.volumen = volumen;
        this.precioMax = precioMax;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.distancia = distancia;
    }

    public Solicitud(double precioMax, String titulo, String descripcion, Integer volumen, Integer peso, double distancia) {
        this.volumen = volumen;
        this.peso = peso;
        this.precioMax = precioMax;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.distancia = distancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

}
