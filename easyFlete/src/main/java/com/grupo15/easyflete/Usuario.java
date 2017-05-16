package com.grupo15.easyflete;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username", fetch = FetchType.EAGER)
    private List<Rol> rolList;

    private static final long serialVersionUID = 1L;
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
    private String email;
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
    @Column(name = "tipo")
    private String tipo;

    public Usuario() {
    }

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String nombre, short enabled, String telefono, String tipo) {
        this.email = email;
        this.nombre = nombre;
        this.enabled = enabled;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public Usuario(String nombre, String email, String password, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }
    
}
