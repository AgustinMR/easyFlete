package com.grupo15.ServiceLayer;

import com.grupo15.easyflete.Solicitud;
import java.util.List;

public abstract interface ISLSolicitud {
    
    public boolean addSolicitud(String origen, String destino, String titulo, int peso, int volumen, String descripcion, String fecha, double precioMax, String email);
    public boolean updateSolicitud(int id, String origen, String destino, String titulo, int peso, String descripcion, String fecha, double precioMax);
    public boolean deleteSolicitud(int id);
    public Solicitud getSolicitud(int id);
    public List<Solicitud> getAllSolicitudes();
    
}
