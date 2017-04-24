package com.grupo15.ServiceLayer;

import com.grupo15.easyflete.Cliente;
import java.util.List;

public interface ISLCliente {
    public boolean addCliente(String nombre, String email, String password, String telefono);
    public boolean updateCliente(String nombre, String email, String password, String telefono);
    public boolean deleteCliente(String email);
    public Cliente getCliente(String email);
    public List<Cliente> getAllClientes();
}
