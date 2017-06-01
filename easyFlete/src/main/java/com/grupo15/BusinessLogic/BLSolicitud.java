package com.grupo15.BusinessLogic;

import com.grupo15.DataAccessLayer.ISolicitud;
import com.grupo15.DataAccessLayer.DALSolicitud;
import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.SolicitudCliente;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class BLSolicitud implements IBLSolicitud {

    private static ISolicitud DLsol = null;
    private static IBLUsuario BLusu = null;

    public BLSolicitud() {
        DLsol = new DALSolicitud();
        BLusu = new BLUsuario();
    }

    @Override
    public boolean addSolicitud(String origen, String destino, String titulo,int peso, String descripcion, String fecha, double precioMax, String email, double distancia, String hora){
        Solicitud s;
        if(peso == 0){
            s = new Solicitud(precioMax, titulo, descripcion, distancia);
        }else{
            s = new Solicitud(precioMax, titulo, descripcion, peso, distancia);
        }
        s.setEstado("Nuevo");
        s.setValoracion(0);
        s.setPrecio(Double.valueOf("0"));
        boolean ingreso = DLsol.addSolicitud(s);
        
        if (ingreso) {
            String fech[] = fecha.split("/");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(fech[2]), Integer.parseInt(fech[1]) - 1, Integer.parseInt(fech[0]));
            Cliente cli = BLusu.getCliente(email);

            SolicitudCliente solCli = new SolicitudCliente(s.getId(), calendar.getTime(), cli, hora);
            DLsol.addSolicitudCliente(solCli);
            return new BLMapa().guardarSolicitud(s.getId(), origen, destino);
        }
        return false;
    }

    @Override
    public boolean updateSolicitud(int id, String origen, String destino, int peso, String descripcion, String fecha, double precioMax) {
        SolicitudCliente solCli = DLsol.getSolicitudCli(id);
        Calendar cal = new GregorianCalendar();
        cal.setTime(solCli.getFecha());

        String fech[] = fecha.split("/");
        Calendar cal2 = new GregorianCalendar(Integer.parseInt(fech[2]), Integer.parseInt(fech[1]) - 1, Integer.parseInt(fech[0]));

        if (!cal.getTime().equals(cal2.getTime())) {
            DLsol.updateSolicitudCliente(id, cal2.getTime());
        }
        return DLsol.updateSolicitud(id, precioMax, peso, descripcion);
    }

    @Override
    public boolean deleteSolicitud(int id) {
        DLsol.deleteSolicitudCliente(id);
        return DLsol.deleteSolicitud(id);
    }

    @Override
    public Solicitud getSolicitud(int id) {
        return DLsol.getSolicitud(id);
    }

    @Override
    public List<Solicitud> getAllSolicitudes() {
        return DLsol.getAllSolicitudes();
    }

    @Override
    public List<Object[]> getAllSolicitudes(String fechaDesde, String fechaHasta, String titulo, String fletero) {
        return DLsol.getAllSolicitudes(fechaDesde, fechaHasta, titulo, fletero);
    }

    @Override
    public String calcularPrecio(String solicitud, String fletero) {
        return DLsol.calcularPrecio(solicitud, fletero);
    }

    @Override
    public boolean aceptarSolicitud(int solicitud, String fletero, int precio) {
        return DLsol.aceptarSolicitud(solicitud, fletero, precio);
    }

}
