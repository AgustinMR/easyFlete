package com.grupo15.easyflete;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username")
    private String username;
    @Size(max = 30)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private short enabled;
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
    @Column(name = "dtype")
    private String dtype;
 /*   @OneToMany(cascade = CascadeType.ALL, mappedBy = "fleteroEmail", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<FleteroSolicitudCliente> fleteroSolicitudesCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Rol> roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fleteroEmail", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<ZonaFletero> zonasFletero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteEmail", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<SolicitudCliente> solicitudesCliente;*/

    public Usuario() {
    }

    public Usuario(String username) {
        this.username = username;
    }

    public Usuario(String username, String nombre, short enabled, String telefono, String dtype) {
        this.username = username;
        this.nombre = nombre;
        this.enabled = enabled;
        this.telefono = telefono;
        this.dtype = dtype;
    }
    
    public Usuario(String email, String nombre, String telefono){
        this.nombre = nombre;
        this.username = email;
        this.telefono = telefono;
        this.enabled = 0;
    }
    
    public Usuario(String nombre, String username, String password, String telefono, String vehiculoNombre, Integer vehiculoCarga) {
        this.username = username;
        this.nombre = nombre;
        this.telefono = telefono;
        this.password = password;
        this.vehiculoNombre = vehiculoNombre;
        this.vehiculoCarga = vehiculoCarga;
        this.enabled = 1;
    }
    
    public Usuario(String nombre, String username, String telefono, String password){
        this.username = username;
        this.nombre = nombre;
        this.telefono = telefono;
        this.password = password;
        this.enabled = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public short getEnabled() {
        return enabled;
    }

    public void setEnabled(short enabled) {
        this.enabled = enabled;
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

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    /*public List<FleteroSolicitudCliente> getFleteroSolicitudesCliente() {
        return fleteroSolicitudesCliente;
    }

    public void setFleteroSolicitudesCliente(List<FleteroSolicitudCliente> fleteroSolicitudesCliente) {
        this.fleteroSolicitudesCliente = fleteroSolicitudesCliente;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public List<ZonaFletero> getZonasFletero() {
        return zonasFletero;
    }

    public void setZonasFletero(List<ZonaFletero> zonasFletero) {
        this.zonasFletero = zonasFletero;
    }

    public List<SolicitudCliente> getSolicitudesCliente() {
        return solicitudesCliente;
    }

    public void setSolicitudesCliente(List<SolicitudCliente> solicitudesCliente) {
        this.solicitudesCliente = solicitudesCliente;
    }*/
    
}
