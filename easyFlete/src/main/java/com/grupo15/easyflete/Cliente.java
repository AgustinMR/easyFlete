package com.grupo15.easyflete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Cliente extends Usuario {

    public Cliente() {
        setTipo();
    }

    public final void setTipo() {
        super.setTipo("CLIENTE");
    }
    
    public Cliente(String nombre, String email, String password, String telefono) {
        super(nombre, email, password, telefono);
        setTipo();
    }
    
}
