package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.SolicitudCliente;
import java.util.Date;
import java.util.List;

public abstract interface ISolicitud {
    
    public boolean addSolicitud(Solicitud s);
    public boolean addSolicitudCliente(SolicitudCliente sCli);
    public boolean updateSolicitud(int id, double precioMax, Integer peso, String descripcion);
    public boolean updateSolicitudCliente(int id, Date fecha);
    public boolean deleteSolicitud(int id);
    public boolean deleteSolicitudCliente(int id);
    public Solicitud getSolicitud(int id);
    public SolicitudCliente getSolicitudCli(int id);
    public List<Solicitud> getAllSolicitudes();
    
}
