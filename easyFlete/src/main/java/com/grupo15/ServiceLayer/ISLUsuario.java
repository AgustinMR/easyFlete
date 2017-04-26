package com.grupo15.ServiceLayer;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import com.grupo15.easyflete.TipoUsuario;
import java.util.List;

public abstract interface ISLUsuario {
    
    public abstract boolean addUsuario(String nombre, String password, String email, String telefono);
    public abstract boolean updateUsuario(String nombre, String password, String email, String telefono);
    public abstract boolean deleteUsuario(String email);
    public abstract Fletero getFletero(String email);
    public abstract Cliente getCliente(String email);
    public abstract List<Fletero> getAllFleteros();
    public abstract List<Cliente> getAllClientes();
    public TipoUsuario login(String email, String pass);
}
