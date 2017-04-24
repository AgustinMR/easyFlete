package com.grupo15.ServiceLayer;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import java.util.List;

public abstract interface ISLUsuario {
    
    public abstract boolean addUsuario(String nombre, String password, String email, String telefono);
    public abstract boolean updateUsuario(int id, String nombre, String password, String email, String telefono);
    public abstract boolean deleteUsuario(int id);
    public abstract Fletero getFletero(int id);
    public abstract Cliente getCliente(int id);
    public abstract List<Fletero> getAllFleteros();
    public abstract List<Cliente> getAllClientes();
}
