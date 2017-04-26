package com.grupo15.BusinessLogic;

import com.grupo15.DataAccessLayer.IUsuario;
import com.grupo15.DataAccessLayer.DALUsuario;
import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import com.grupo15.easyflete.TipoUsuario;
import java.util.List;

public class BLUsuario implements IBLUsuario {

    private static IUsuario DLusu = null;

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
    public boolean updateFletero(String nombre, String password, String email, String telefono) {
        Fletero f = new Fletero(email, nombre, password, telefono);
        return DLusu.updateUsuario(f);
    }

    @Override
    public boolean updateCliente(String nombre, String password, String email, String telefono) {
        Cliente c = new Cliente(email, nombre, telefono, password);
        return DLusu.updateUsuario(c);
    }

    @Override
    public boolean deleteFletero(String email) {
        return DLusu.deleteFletero(email);
    }

    @Override
    public boolean deleteCliente(String email) {
        return DLusu.deleteCliente(email);
    }

    @Override
    public Fletero getFletero(String email) {
        return DLusu.getFletero(email);
    }

    @Override
    public Cliente getCliente(String email) {
        return DLusu.getCliente(email);
    }

    @Override
    public List<Fletero> getAllFleteros() {
        return DLusu.getAllFleteros();
    }

    @Override
    public List<Cliente> getAllClientes() {
        return DLusu.getAllClientes();
    }

    @Override
    public TipoUsuario login(String email, String pass) {
        return DLusu.login(email, pass);
    }

}
