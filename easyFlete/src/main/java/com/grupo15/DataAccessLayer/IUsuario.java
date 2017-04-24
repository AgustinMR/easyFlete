package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import java.util.List;

public abstract interface IUsuario {
    
    public abstract boolean addUsuario(Cliente c);
    public abstract boolean addUsuario(Fletero f);
    public abstract boolean updateUsuario(Cliente c);
    public abstract boolean updateUsuario(Fletero f);
    public abstract boolean deleteCliente(int id);
    public abstract boolean deleteFletero(int id);
    public abstract Fletero getFletero(int id);
    public abstract Cliente getCliente(int id);
    public abstract List<Fletero> getAllFleteros();
    public abstract List<Cliente> getAllClientes();
}
