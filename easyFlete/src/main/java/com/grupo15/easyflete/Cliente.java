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
        this.setDtype("Cliente");
    }
    
    public Cliente(String username, String nombre, String telefono, String password){
        super(username, nombre, telefono, password);
        this.setDtype("Cliente");
    }
    
    public Cliente(String username, String nombre, String telefono){
        super(username, nombre, telefono);
        this.setDtype("Cliente");
    }
    
}
