package com.grupo15.BusinessLogic;

import com.grupo15.DataAccessLayer.DALSolicitud;
import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.SolicitudCliente;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class BLSolicitud implements IBLSolicitud {

    private static DALSolicitud DLsol = null;
    private static BLUsuario BLusu = null;

    public BLSolicitud() {
        DLsol = new DALSolicitud();
        BLusu = new BLUsuario();
    }

    @Override
    public boolean addSolicitud(double latOrigen, double lonOrigen, double latDestino, double lonDestino, int peso, int volumen, String descripcion, String fecha, double precioMax, String email) {
        Solicitud s = new Solicitud(latOrigen, lonOrigen, latDestino, lonDestino, precioMax, peso, volumen, descripcion);  
        boolean ingreso = DLsol.addSolicitud(s);
        if(ingreso){
            Calendar calendar = new GregorianCalendar(2015,5,5);
            Cliente cli = BLusu.getCliente(email);
            System.out.println(calendar.getTime());
            SolicitudCliente solCli = new SolicitudCliente(s.getId(), calendar.getTime(), cli);
            DLsol.addSolicitudCliente(solCli);
        }
        return true;
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
