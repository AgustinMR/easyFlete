package com.grupo15.BusinessLogic;

import com.grupo15.DataAccessLayer.DALSolicitud;
import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.SolicitudCliente;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
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
        System.out.println(latOrigen);
        BigInteger latOrigenBI = new BigDecimal(latOrigen).toBigInteger();
        System.out.println(latOrigenBI);
        BigInteger lonOrigenBI = new BigDecimal(lonOrigen).toBigInteger();
        BigInteger latDestinoBI = new BigDecimal(latDestino).toBigInteger();
        BigInteger lonDestinoBI = new BigDecimal(lonDestino).toBigInteger();
        Solicitud s = new Solicitud(latOrigenBI, lonOrigenBI, latDestinoBI, lonDestinoBI, precioMax, peso, volumen, descripcion);
        //Calendar calendar = new GregorianCalendar(2013,01,31);
        //System.out.println(calendar.toString());
        System.out.println(
                "latOri: "+ s.getLatitudDestino() + 
                "\nlonOri: " + s.getLongitudOrigen()+
                "\nlatDes: " + s.getLatitudDestino()+
                "\nlonDes: " + s.getLongitudDestino()+
                "\nprecioMax: " + s.getPrecioMax() +
                "\npeso: " + s.getPeso()+
                "\nvol: " + s.getVolumen()+
                "\ndesc: " + s.getDescripcion());
        boolean ingreso = DLsol.addSolicitud(s);
        /*if(ingreso){
            
            Cliente cli = BLusu.getCliente(cliId);
            SolicitudCliente solCli = new SolicitudCliente(s.getId(), calendar, cli);
        }*/
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
