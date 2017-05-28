package com.grupo15.easyflete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Fletero extends Usuario {

    public Fletero() {
    }

    public Fletero(String username) {
        super(username);
    }

    public Fletero(String username, String nombre, short enabled, String telefono, String dtype) {
        super(username, nombre, enabled, telefono, dtype);
    }
    
    public Fletero(String username, String nombre, String telefono, String password){
        super(username, nombre, telefono, password);
        this.setDtype("Fletero");
    }
    
    public Fletero(String nombre, String email, String password, String telefono, String vehiculoNombre, Integer vehiculoCarga) {
        super(nombre, email, password, telefono, vehiculoNombre, vehiculoCarga);
        this.setDtype("Fletero");
    }
}
