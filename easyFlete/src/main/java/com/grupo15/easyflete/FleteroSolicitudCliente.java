/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo15.easyflete;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Agustin
 */
@Entity
@Table(name = "fleteros_solicitudes_clientes")
@NamedQueries({
    @NamedQuery(name = "FleteroSolicitudCliente.findAll", query = "SELECT f FROM FleteroSolicitudCliente f")})
public class FleteroSolicitudCliente implements Serializable {

    private static final long serialVersionUID = 1L;
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
    private Cliente fleteroEmail;

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

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Cliente getFleteroEmail() {
        return fleteroEmail;
    }

    public void setFleteroEmail(Cliente fleteroEmail) {
        this.fleteroEmail = fleteroEmail;
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
        if (!(object instanceof FleteroSolicitudCliente)) {
            return false;
        }
        FleteroSolicitudCliente other = (FleteroSolicitudCliente) object;
        if ((this.solicitudId == null && other.solicitudId != null) || (this.solicitudId != null && !this.solicitudId.equals(other.solicitudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo15.easyflete.FleteroSolicitudCliente[ solicitudId=" + solicitudId + " ]";
    }
    
}
