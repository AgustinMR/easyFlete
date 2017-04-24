package com.grupo15.easyflete;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "solicitudes_clientes")
@XmlRootElement
public class SolicitudCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "solicitud_id")
    private Integer solicitudId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Calendar fecha;
    @JoinColumn(name = "cliente_email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Cliente clienteEmail;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Solicitud solicitud;

    public SolicitudCliente() {
    }

    public SolicitudCliente(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public SolicitudCliente(Integer solicitudId, java.util.Calendar fecha) {
        this.solicitudId = solicitudId;
        this.fecha = fecha;
    }
    
    public SolicitudCliente(Integer solicitudId, java.util.Calendar fecha, Cliente email) {
        this.solicitudId = solicitudId;
        this.fecha = fecha;
        this.clienteEmail = email;
    }

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public java.util.Calendar getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }

    public Cliente getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(Cliente clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
}
