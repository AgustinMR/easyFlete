package com.grupo15.BusinessLogic;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import java.util.List;

public abstract interface IBLUsuario {
    
    public boolean addFletero(String nombre, String password, String email, String telefono, String vehiculoNombre, int vehiculoCarga);
    public abstract boolean addCliente(String nombre, String password, String email, String telefono);
    public abstract boolean updateFletero(String nombre, String password, String email, String telefono, String nombreVehiculo, int cargaVehiculo);
    public abstract boolean updateCliente(String nombre, String password, String email, String telefono);
    public abstract boolean deleteFletero(String email);
    public abstract boolean deleteCliente(String email);
    public abstract Fletero getFletero(String email);
    public abstract Cliente getCliente(String email);
    public abstract List<Fletero> getAllFleteros();
    public abstract List<Cliente> getAllClientes();
    public List<Object[]> getSolicitudesByCliente(String email);
    public List<Object[]> getSolicitudesByCliente(String email, String fechaDesde, String fechaHasta, String titulo);
    public List<Object[]> getSolicitudesByFletero(String email, String titulo);
    public Cliente getClienteBySolicitud(int solicitud);
}
