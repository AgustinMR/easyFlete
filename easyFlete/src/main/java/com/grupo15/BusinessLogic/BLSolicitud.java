package com.grupo15.BusinessLogic;

import com.grupo15.easyflete.Solicitud;
import java.util.List;

public class BLSolicitud implements IBLSolicitud {

    @Override
    public boolean addSolicitud(double latOrigen, double lonOrigen, double latDestino, double lonDestino, int peso, int volumen, String descripcion, String fecha, double precioMax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateSolicitud(int id, double latOrigen, double lonOrigen, double latDestino, double lonDestino, int peso, int volumen, String descripcion, String fecha, double precioMax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSolicitud(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Solicitud getSolicitud(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Solicitud> getAllSolicitudes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
