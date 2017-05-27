package com.grupo15.easyflete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Cliente extends Usuario {

    public Cliente() {
    }

    public Cliente(String email) {
        super(email);
        this.setTipo("Cliente");
    }

    public Cliente(String nombre, String email, String password, String telefono) {
        super(nombre, email, password, telefono);
        this.setTipo("Cliente");
    }
    
    public Cliente(String nombre, String email, String telefono) {
        super(nombre, email, telefono);
        this.setTipo("Cliente");
    }
    
}
