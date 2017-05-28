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
@Table(name = "zonas_fleteros")
public class ZonaFletero implements Serializable {

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "zona_id")
    private Integer zonaId;
    @JoinColumn(name = "fletero_email", referencedColumnName = "username")
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

}
