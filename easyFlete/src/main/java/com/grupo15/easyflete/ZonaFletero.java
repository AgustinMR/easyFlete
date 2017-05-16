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
@Table(name = "zonas_fleteros")
@NamedQueries({
    @NamedQuery(name = "ZonaFletero.findAll", query = "SELECT z FROM ZonaFletero z")})
public class ZonaFletero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "zona_id")
    private Integer zonaId;
    @JoinColumn(name = "fletero_email", referencedColumnName = "email")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario fleteroEmail;
    @JoinColumn(name = "zona_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Zona zona;

    public ZonaFletero() {
    }

    public ZonaFletero(Integer zonaId) {
        this.zonaId = zonaId;
    }

    public Integer getZonaId() {
        return zonaId;
    }

    public void setZonaId(Integer zonaId) {
        this.zonaId = zonaId;
    }

    public Usuario getFleteroEmail() {
        return fleteroEmail;
    }

    public void setFleteroEmail(Usuario fleteroEmail) {
        this.fleteroEmail = fleteroEmail;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zonaId != null ? zonaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaFletero)) {
            return false;
        }
        ZonaFletero other = (ZonaFletero) object;
        if ((this.zonaId == null && other.zonaId != null) || (this.zonaId != null && !this.zonaId.equals(other.zonaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo15.easyflete.ZonaFletero[ zonaId=" + zonaId + " ]";
    }
    
}
