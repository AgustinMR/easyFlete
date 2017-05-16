package com.grupo15.easyflete;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "solicitudes_clientes")
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
    private Date fecha;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Solicitud solicitud;
    @JoinColumn(name = "cliente_email", referencedColumnName = "email")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario clienteEmail;

    public SolicitudCliente() {
    }

    public SolicitudCliente(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public SolicitudCliente(Integer solicitudId, Date fecha) {
        this.solicitudId = solicitudId;
        this.fecha = fecha;
    }

    public SolicitudCliente(Date fecha, Solicitud solicitud, Usuario clienteEmail) {
        this.fecha = fecha;
        this.solicitud = solicitud;
        this.clienteEmail = clienteEmail;
    }

    public SolicitudCliente(Integer solicitudId, Date fecha, Usuario clienteEmail) {
        this.solicitudId = solicitudId;
        this.fecha = fecha;
        this.clienteEmail = clienteEmail;
    }
    
    

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Usuario getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(Usuario clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solicitudId != null ? solicitudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudCliente)) {
            return false;
        }
        SolicitudCliente other = (SolicitudCliente) object;
        if ((this.solicitudId == null && other.solicitudId != null) || (this.solicitudId != null && !this.solicitudId.equals(other.solicitudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo15.easyflete.SolicitudCliente[ solicitudId=" + solicitudId + " ]";
    }
    
}
