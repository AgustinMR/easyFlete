package com.grupo15.BusinessLogic;

import com.grupo15.DataAccessLayer.DALUsuario;
import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import java.util.List;

public class BLUsuario implements IBLUsuario {

    private static DALUsuario DLusu = null;

    public BLUsuario() {
        DLusu = new DALUsuario();
    }

    @Override
    public boolean addFletero(String nombre, String password, String email, String telefono) {
        Fletero f = new Fletero(email, nombre, password, telefono);
        return DLusu.addUsuario(f);
    }

    @Override
    public boolean addCliente(String nombre, String password, String email, String telefono) {
        Cliente c = new Cliente(email, nombre, telefono, password);
        return DLusu.addUsuario(c);
    }

    @Override
    public boolean updateFletero(int id, String nombre, String password, String email, String telefono) {
        Fletero f = new Fletero(email, nombre, password, telefono);
        return DLusu.updateUsuario(f);
    }

    @Override
    public boolean updateCliente(int id, String nombre, String password, String email, String telefono) {
        Cliente c = new Cliente(email, nombre, telefono, password);
        return DLusu.updateUsuario(c);
    }

    @Override
    public boolean deleteFletero(int id) {
        return DLusu.deleteFletero(id);
    }

    @Override
    public boolean deleteCliente(int id) {
        return DLusu.deleteCliente(id);
    }

    @Override
    public Fletero getFletero(int id) {
        return DLusu.getFletero(id);
    }

    @Override
    public Cliente getCliente(int id) {
        return DLusu.getCliente(id);
    }

    @Override
    public List<Fletero> getAllFleteros() {
        return DLusu.getAllFleteros();
    }

    @Override
    public List<Cliente> getAllClientes() {
        return DLusu.getAllClientes();
    }

}
