package com.grupo15.easyflete;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "zonas_fleteros")
@XmlRootElement
public class ZonaFletero implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "zona_id")
    private Integer zonaId;
    @JoinColumn(name = "fletero_email", referencedColumnName = "email")
    @ManyToOne(optional = false)
    private Fletero fleteroEmail;
    @JoinColumn(name = "zona_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
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

    public Fletero getFleteroEmail() {
        return fleteroEmail;
    }

    public void setFleteroEmail(Fletero fleteroEmail) {
        this.fleteroEmail = fleteroEmail;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
}
