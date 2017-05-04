package com.grupo15.easyflete;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Fletero extends Usuario {

    
    public Fletero(){
        setTipo();
    }

    public final void setTipo() {
        super.setTipo("FLETERO");
    }

    public Fletero(String nombre, String email, String password, String telefono, String vehiculoNombre, Integer vehiculoCarga) {
        super(nombre, email, password, telefono, vehiculoNombre, vehiculoCarga);
        setTipo();
    }
    
}
