package com.grupo15.ServiceLayer;

import com.grupo15.easyflete.Fletero;
import java.util.List;

public interface ISLFletero {
    public boolean addFletero(String nombre, String email, String password, String telefono);
    public boolean updateFletero(int id, String nombre, String email, String password, String telefono);
    public boolean deleteFletero(int id);
    public Fletero getFletero(int id);
    public List<Fletero> getAllFleteros();
}
