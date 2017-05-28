package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import com.grupo15.easyflete.Rol;
import java.util.List;

public abstract interface IUsuario {
    
    public abstract boolean addUsuario(Cliente c);
    public abstract boolean addUsuario(Fletero f);
    public abstract boolean updateUsuario(Cliente c);
    public abstract boolean updateUsuario(Fletero f);
    public abstract boolean deleteCliente(String email);
    public abstract boolean deleteFletero(String email);
    public abstract Fletero getFletero(String email);
    public abstract Cliente getCliente(String email);
    public abstract List<Fletero> getAllFleteros();
    public abstract List<Cliente> getAllClientes();
    public boolean addRol(Rol r);
    public List<Object[]> getSolicitudesByCliente(String email);
}
