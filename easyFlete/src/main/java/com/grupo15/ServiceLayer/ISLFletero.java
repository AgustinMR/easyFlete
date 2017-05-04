package com.grupo15.ServiceLayer;

import com.grupo15.easyflete.Fletero;
import java.util.List;

public interface ISLFletero {
    public boolean addFletero(String nombre, String email, String password, String telefono,String vehiculoNombre, int vehiculoCarga);
    public boolean updateFletero(String nombre, String email, String password, String telefono, String vehiculoNombre, int vehiculoCarga);
    public boolean deleteFletero(String email);
    public Fletero getFletero(String email);
    public List<Fletero> getAllFleteros();
}
