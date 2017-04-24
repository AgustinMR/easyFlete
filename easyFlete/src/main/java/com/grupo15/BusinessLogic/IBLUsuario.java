package com.grupo15.BusinessLogic;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import java.util.List;

public abstract interface IBLUsuario {
    
    public abstract boolean addFletero(String nombre, String password, String email, String telefono);
    public abstract boolean addCliente(String nombre, String password, String email, String telefono);
    public abstract boolean updateFletero(int id, String nombre, String password, String email, String telefono);
    public abstract boolean updateCliente(int id, String nombre, String password, String email, String telefono);
    public abstract boolean deleteFletero(int id);
    public abstract boolean deleteCliente(int id);
    public abstract Fletero getFletero(int id);
    public abstract Cliente getCliente(int id);
    public abstract List<Fletero> getAllFleteros();
    public abstract List<Cliente> getAllClientes();
}
