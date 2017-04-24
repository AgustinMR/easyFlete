package com.grupo15.ServiceLayer;

import com.grupo15.easyflete.Cliente;
import java.util.List;

public interface ISLCliente {
    public boolean addCliente(String nombre, String email, String password, String telefono);
    public boolean updateCliente(int id, String nombre, String email, String password, String telefono);
    public boolean deleteCliente(int id);
    public Cliente getCliente(int id);
    public List<Cliente> getAllSolicitudes();
}
