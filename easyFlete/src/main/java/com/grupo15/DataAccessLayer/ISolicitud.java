package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.FleteroSolicitudCliente;
import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.SolicitudCliente;
import com.grupo15.easyflete.Zona;
import com.grupo15.easyflete.ZonaFletero;
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

    public List<Object[]> getAllSolicitudes(String fechaDesde, String fechaHasta, String titulo, String fletero);

    public boolean addZona(Zona z);

    public boolean addZonaFletero(ZonaFletero zf);

    public List<Zona> getZonasByFletero(String email);

    public boolean updateZona(Zona z);

    public boolean deleteZona(int id);

    public boolean deleteZonaFletero(int id);

    public boolean aceptarSolicitud(int solicitud, String fletero, double precio);

    public boolean actualizarRating(int solicitud, int rating);

    public boolean actualizarEstado(int solicitud, String estado);
    
    public List<Object[]> getSolicitudesById(List<Integer> ids, String fletero);
}
