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

@Entity
@Table(name = "fleteros_solicitudes_clientes")
public class FleteroSolicitudCliente implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "solicitud_id")
    private Integer solicitudId;
    @JoinColumn(name = "solicitud_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Solicitud solicitud;
    @JoinColumn(name = "fletero_email", referencedColumnName = "username")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Fletero fleteroEmail;

    public FleteroSolicitudCliente() {
    }

    public FleteroSolicitudCliente(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public FleteroSolicitudCliente(Integer solicitudId, Solicitud solicitud, Fletero fleteroEmail) {
        this.solicitudId = solicitudId;
        this.solicitud = solicitud;
        this.fleteroEmail = fleteroEmail;
    }
    

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Fletero getFleteroEmail() {
        return fleteroEmail;
    }

    public void setFleteroEmail(Fletero fleteroEmail) {
        this.fleteroEmail = fleteroEmail;
    }
    
}
