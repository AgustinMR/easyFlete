package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Solicitud;
import java.util.List;

public abstract interface ISolicitud {
    
    public boolean addSolicitud(Solicitud s);
    public boolean updateSolicitud(Solicitud s);
    public boolean deleteSolicitud(int id);
    public Solicitud getSolicitud(int id);
    public List<Solicitud> getAllSolicitudes();
    
}
