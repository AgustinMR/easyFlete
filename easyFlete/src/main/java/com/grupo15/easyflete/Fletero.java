package com.grupo15.easyflete;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "fleteros")
@XmlRootElement
public class Fletero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 40)
    @Column(name = "vehiculo_nombre")
    private String vehiculoNombre;
    @Size(max = 40)
    @Column(name = "vehiculo_carga")
    private String vehiculoCarga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fleteroEmail")
    private List<FleteroSolicitudCliente> fleteroSolicitudClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fleteroEmail")
    private List<ZonaFletero> zonaFleteroList;

    public Fletero() {
    }

    public Fletero(String email) {
        this.email = email;
    }

    public Fletero(String email, String nombre, String password, String telefono) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVehiculoNombre() {
        return vehiculoNombre;
    }

    public void setVehiculoNombre(String vehiculoNombre) {
        this.vehiculoNombre = vehiculoNombre;
    }

    public String getVehiculoCarga() {
        return vehiculoCarga;
    }

    public void setVehiculoCarga(String vehiculoCarga) {
        this.vehiculoCarga = vehiculoCarga;
    }

    @XmlTransient
    public List<FleteroSolicitudCliente> getFleteroSolicitudClienteList() {
        return fleteroSolicitudClienteList;
    }

    public void setFleteroSolicitudClienteList(List<FleteroSolicitudCliente> fleteroSolicitudClienteList) {
        this.fleteroSolicitudClienteList = fleteroSolicitudClienteList;
    }

    @XmlTransient
    public List<ZonaFletero> getZonaFleteroList() {
        return zonaFleteroList;
    }

    public void setZonaFleteroList(List<ZonaFletero> zonaFleteroList) {
        this.zonaFleteroList = zonaFleteroList;
    }
    
}
