package com.grupo15.easyflete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Fletero extends Usuario{

    public Fletero() {
    }

    public Fletero(String email) {
        super(email);
    }

    public Fletero(String nombre, String email, String password, String telefono) {
        super(nombre, email, password, telefono);
        this.setTipo("Fletero");
    }

    public Fletero(String nombre, String email, String password, String telefono, String vehiculoNombre, Integer vehiculoCarga) {
        super(nombre, email, password, telefono, vehiculoNombre, vehiculoCarga);
        this.setTipo("Fletero");
    }

    
}
