package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Fecha;
import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.SolicitudCliente;
import com.grupo15.easyflete.Zona;
import com.grupo15.easyflete.ZonaFletero;
import com.grupo15.handlers.EMHandler;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DALSolicitud implements ISolicitud {

    @Override
    public boolean addSolicitud(Solicitud s) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean addSolicitudCliente(SolicitudCliente sCli) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.persist(sCli);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean updateSolicitud(int id, double precioMax, Integer peso, String descripcion) {
        EntityManager em = new EMHandler().entityManager();
        Solicitud sol = em.find(Solicitud.class, id);
        em.getTransaction().begin();
        sol.setPrecioMax(precioMax);
        sol.setPeso(peso);
        sol.setDescripcion(descripcion);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean updateSolicitudCliente(int id, Date fecha) {
        EntityManager em = new EMHandler().entityManager();
        SolicitudCliente solCli = em.find(SolicitudCliente.class, id);
        em.getTransaction().begin();
        solCli.setFecha(fecha);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteSolicitud(int id) {
        EntityManager em = new EMHandler().entityManager();
        Solicitud s = em.find(Solicitud.class, id);
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        return true;
    }
    
    @Override
    public boolean deleteSolicitudCliente(int id) {
        EntityManager em = new EMHandler().entityManager();
        SolicitudCliente s = em.find(SolicitudCliente.class, id);
        em.getTransaction().begin();
        em.remove(s);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public Solicitud getSolicitud(int id) {
        EntityManager em = new EMHandler().entityManager();
        return em.find(Solicitud.class, id);
    }

    @Override
    public SolicitudCliente getSolicitudCli(int id) {
        EntityManager em = new EMHandler().entityManager();
        return em.find(SolicitudCliente.class, id);
    }

    @Override
    public List<Solicitud> getAllSolicitudes() {
        EntityManager em = new EMHandler().entityManager();
        List<Solicitud> S = em.createQuery("SELECT s FROM Solicitud s", Solicitud.class).getResultList();
        em.close();
        return S;
    }
    
    @Override
    public boolean addZona(Zona z) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.persist(z);
        em.getTransaction().commit();
        return true;
    }
    
    @Override
    public boolean addZonaFletero(ZonaFletero zf) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.persist(zf);
        em.getTransaction().commit();
        return true;
    }
    
    @Override
    public List<Zona> getZonasByFletero(String email) {
        EntityManager em = new EMHandler().entityManager();
        List<Zona> ret = em.createQuery("SELECT z FROM Zona z WHERE z.zonaFletero.fleteroEmail.username = :D", Zona.class).setParameter("D", email).getResultList();
        return ret;
    }

    @Override
    public List<Object[]> getAllSolicitudes(String fechaDesde, String fechaHasta, String titulo) {
        String query = "SELECT s.id, s.titulo, s.descripcion, s.precioMax, s.distancia, s.solicitudCliente.fecha, s.solicitudCliente.hora, s.solicitudCliente.clienteEmail.nombre, s.solicitudCliente.clienteEmail.telefono "
                + "FROM Solicitud s "
                + "WHERE s.estado = 'Nuevo'";
        if(fechaDesde != null && !fechaDesde.isEmpty()) query += " AND s.solicitudCliente.fecha >= :desde";
        if(fechaHasta != null && !fechaHasta.isEmpty()) query += " AND s.solicitudCliente.fecha <= :hasta";
        if(titulo != null && !titulo.isEmpty()) query += " AND s.titulo LIKE :titulo";
        TypedQuery<Object[]> sql = new EMHandler().entityManager().createQuery(query, Object[].class);
        if(fechaDesde != null && !fechaDesde.isEmpty()){
            Fecha f1 = new Fecha(fechaDesde);
            sql.setParameter("desde", new GregorianCalendar(f1.getAnio(), f1.getMes(), f1.getDia()).getTime());
        }
        if(fechaHasta != null && !fechaHasta.isEmpty()){
            Fecha f2 = new Fecha(fechaHasta);
            sql.setParameter("hasta", new GregorianCalendar(f2.getAnio(), f2.getMes(), f2.getDia()).getTime());
        }
        if(titulo != null && !titulo.isEmpty()) sql.setParameter("titulo", "%" + titulo + "%");
        return sql.getResultList();
    }

}
