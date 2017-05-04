package com.grupo15.easyflete;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

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
    @Size(max = 30)
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
    @Column(name = "vehiculo_carga")
    private Integer vehiculoCarga;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fleteroEmail", fetch = FetchType.EAGER)
    private List<FleteroSolicitudCliente> fleteroSolicitudClienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fleteroEmail", fetch = FetchType.EAGER)
    private List<ZonaFletero> zonaFleteroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteEmail", fetch = FetchType.EAGER)
    private List<SolicitudCliente> solicitudClienteList;

    public Usuario() {
    }

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String nombre, String telefono, String password) {
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.password = password;
    }

    public Usuario(String nombre, String email, String password, String telefono, String vehiculoNombre, Integer vehiculoCarga) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.vehiculoNombre = vehiculoNombre;
        this.vehiculoCarga = vehiculoCarga;
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

    public Integer getVehiculoCarga() {
        return vehiculoCarga;
    }

    public void setVehiculoCarga(Integer vehiculoCarga) {
        this.vehiculoCarga = vehiculoCarga;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<FleteroSolicitudCliente> getFleteroSolicitudClienteList() {
        return fleteroSolicitudClienteList;
    }

    public void setFleteroSolicitudClienteList(List<FleteroSolicitudCliente> fleteroSolicitudClienteList) {
        this.fleteroSolicitudClienteList = fleteroSolicitudClienteList;
    }

    public List<ZonaFletero> getZonaFleteroList() {
        return zonaFleteroList;
    }

    public void setZonaFleteroList(List<ZonaFletero> zonaFleteroList) {
        this.zonaFleteroList = zonaFleteroList;
    }

    public List<SolicitudCliente> getSolicitudClienteList() {
        return solicitudClienteList;
    }

    public void setSolicitudClienteList(List<SolicitudCliente> solicitudClienteList) {
        this.solicitudClienteList = solicitudClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupo15.easyflete.Usuario[ email=" + email + " ]";
    }
    
}
