package com.grupo15.BusinessLogic;

import com.grupo15.easyflete.Solicitud;
import java.util.List;

public abstract interface IBLSolicitud {

    public boolean addSolicitud(String jsonOrigen, String jsonDestino, String titulo, int peso, String descripcion, String fecha, double precioMax, String email, double distancia, String hora);

    public boolean updateSolicitud(int id, String origen, String destino, int peso, String descripcion, String fecha, double precioMax);

    public boolean deleteSolicitud(int id);

    public Solicitud getSolicitud(int id);

    public List<Solicitud> getAllSolicitudes();

    public List<Object[]> getAllSolicitudes(String fechaDesde, String fechaHasta, String titulo, String fletero);

    public String calcularPrecio(String solicitud, String fletero);

    public String getSolicitudGEO(int id);

    public boolean aceptarSolicitud(int solicitud, String fletero, double precio);

    public boolean actualizarRating(int solicitud, int rating);

    public boolean actualizarEstado(int solicitud, String estado);
    
    public List<Object[]> getSolSercanas(String piont, int distancia ,String fletero);
}
