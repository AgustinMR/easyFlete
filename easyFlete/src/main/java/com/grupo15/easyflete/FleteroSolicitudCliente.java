package com.grupo15.easyflete;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fleteros_solicitudes_clientes")
public class FleteroSolicitudCliente implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "solicitud_id")
    private Integer solicitudId;
    @Column(name = "valoracion")
    private Integer valoracion;
    @Size(max = 300)
    @Column(name = "comentario")
    private String comentario;
    @Size(max = 30)
    @Column(name = "estado")
    private String estado;
    @Column(name = "precio")
    private Double precio;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Solicitud solicitud;
    @JoinColumn(name = "fletero_email", referencedColumnName = "username")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario fleteroEmail;

    public FleteroSolicitudCliente() {
    }

    public FleteroSolicitudCliente(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Usuario getFleteroEmail() {
        return fleteroEmail;
    }

    public void setFleteroEmail(Usuario fleteroEmail) {
        this.fleteroEmail = fleteroEmail;
    }
    
}
