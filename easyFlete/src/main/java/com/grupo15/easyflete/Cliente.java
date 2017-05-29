package com.grupo15.easyflete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Cliente extends Usuario {

    public Cliente() {
    }

    public Cliente(String username) {
        super(username);
    }

    public Cliente(String username, String nombre, short enabled, String telefono, String dtype) {
        super(username, nombre, enabled, telefono, dtype);
    }
    
    public Cliente(String username, String nombre, String telefono, String password){
        super(nombre, username, telefono, password);
        this.setDtype("Cliente");
    }
    
    public Cliente(String nombre, String email, String password, String telefono, String vehiculoNombre, Integer vehiculoCarga) {
        super(nombre, email, password, telefono, vehiculoNombre, vehiculoCarga);
        this.setDtype("Cliente");
    }

    public Cliente(String email, String nombre, String telefono) {
        super(nombre, email, telefono);
        this.setDtype("Cliente");
    }
}
