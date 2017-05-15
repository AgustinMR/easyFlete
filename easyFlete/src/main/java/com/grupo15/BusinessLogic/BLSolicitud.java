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
    public boolean addSolicitud(String origen, String destino, int peso, String descripcion, String fecha, double precioMax, String email) {
        Solicitud s = new Solicitud(peso, precioMax, email, descripcion);
        boolean ingreso = DLsol.addSolicitud(s);
        if (ingreso) {
            String fech[] = fecha.split("/");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(fech[2]), Integer.parseInt(fech[1]) - 1, Integer.parseInt(fech[0]));
            Cliente cli = BLusu.getCliente(email);

            SolicitudCliente solCli = new SolicitudCliente(s.getId(), calendar.getTime(), cli);
            return DLsol.addSolicitudCliente(solCli);
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

}
