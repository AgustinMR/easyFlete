package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Fecha;
import com.grupo15.easyflete.Fletero;
import com.grupo15.easyflete.FleteroSolicitudCliente;
import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.SolicitudCliente;
import com.grupo15.easyflete.Zona;
import com.grupo15.easyflete.ZonaFletero;
import com.grupo15.handlers.EMHandler;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
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
    
    public void actualizarSolicitud(int solicitud, double precio, String estado){
        EntityManager em = new EMHandler().entityManager();
        Solicitud s = em.find(Solicitud.class, solicitud);
        if(s != null){
            em.getTransaction().begin();
            s.setPrecio(precio);
            s.setEstado(estado);
            em.getTransaction().commit();
            em.close();
        } else em.close();
    }

    @Override
    public Solicitud getSolicitud(int id) {
        EntityManager em = new EMHandler().entityManager();
        return em.find(Solicitud.class, id);
    }
    @Override
    public List<FleteroSolicitudCliente> getSolicitudFletero(String email) {
        EntityManager em = new EMHandler().entityManager();
        List<FleteroSolicitudCliente> S = em.createQuery("SELECT s FROM FleteroSolicitudCliente s WHERE s.fleteroEmail.username = :D AND s.solicitud.estado = 'Confirmado'", FleteroSolicitudCliente.class).setParameter("D", email).getResultList();
        em.close();
        return S;
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
    public boolean updateZona(Zona z) {
        EntityManager em = new EMHandler().entityManager();
        Zona zz = em.find(Zona.class, z.getId());
        em.getTransaction().begin();
        zz.setPrecio(z.getPrecio());
        zz.setNombre(z.getNombre());
        em.getTransaction().commit();
        return true;
    }
    
    @Override
    public boolean deleteZona(int id) {
        deleteZonaFletero(id);
        EntityManager em = new EMHandler().entityManager();
        Zona zz = em.find(Zona.class, id);
        em.getTransaction().begin();
        em.remove(zz);
        em.getTransaction().commit();
        return true;
    }
    
    @Override
    public boolean deleteZonaFletero(int id) {
        EntityManager em = new EMHandler().entityManager();
        ZonaFletero zf = em.find(ZonaFletero.class, id);
        em.getTransaction().begin();
        em.remove(zf);
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
    public List<Object[]> getAllSolicitudes(String fechaDesde, String fechaHasta, String titulo, String fletero) {
        String query = "SELECT s.id, s.titulo, s.descripcion, s.precioMax, s.distancia, function('to_char', s.solicitudCliente.fecha, 'DD/MM/YYYY'), s.solicitudCliente.hora, s.solicitudCliente.clienteEmail.nombre, s.solicitudCliente.clienteEmail.telefono FROM Solicitud s WHERE s.estado = 'Nuevo' AND s.peso <= :p";
        if(fechaDesde != null && !fechaDesde.isEmpty()) query += " AND s.solicitudCliente.fecha >= :desde";
        if(fechaHasta != null && !fechaHasta.isEmpty()) query += " AND s.solicitudCliente.fecha <= :hasta";
        if(titulo != null && !titulo.isEmpty()) query += " AND s.titulo LIKE :titulo";
        EntityManager em = new EMHandler().entityManager();
        TypedQuery<Object[]> sql = em.createQuery(query, Object[].class);
        sql.setParameter("p", em.find(Fletero.class, fletero).getVehiculoCarga());
        if(fechaDesde != null && !fechaDesde.isEmpty()){
            Fecha f1 = new Fecha(fechaDesde);
            sql.setParameter("desde", new GregorianCalendar(f1.getAnio(), f1.getMes(), f1.getDia()).getTime(), TemporalType.DATE);
        }
        if(fechaHasta != null && !fechaHasta.isEmpty()){
            Fecha f2 = new Fecha(fechaHasta);
            sql.setParameter("hasta", new GregorianCalendar(f2.getAnio(), f2.getMes(), f2.getDia()).getTime(), TemporalType.DATE);
        }
        if(titulo != null && !titulo.isEmpty()) sql.setParameter("titulo", "%" + titulo + "%");
        return sql.getResultList();
    }

    @Override
    public boolean aceptarSolicitud(int solicitud, String fletero, double precio) {
        EntityManager em = new EMHandler().entityManager();
        Solicitud s = getSolicitud(solicitud);
        if(s == null){
            em.close();
            return false;
        }
        Fletero f = em.find(Fletero.class, fletero);
        if(f == null){
            em.close();
            return false;
        }
        FleteroSolicitudCliente fsc = new FleteroSolicitudCliente(solicitud, s, f);
        em.getTransaction().begin();
        em.persist(fsc);
        em.getTransaction().commit();
        em.close();
        actualizarSolicitud(solicitud, precio, "Confirmado");
        return true;
    }

    @Override
    public boolean actualizarRating(int solicitud, int rating) {
        EntityManager em = new EMHandler().entityManager();
        Solicitud s = em.find(Solicitud.class, solicitud);
        if(s == null){
            em.close();
            return false;
        }
        em.getTransaction().begin();
        s.setValoracion(rating);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean actualizarEstado(int solicitud, String estado) {
        EntityManager em = new EMHandler().entityManager();
        Solicitud s = em.find(Solicitud.class, solicitud);
        if(s == null){
            em.close();
            return false;
        }
        em.getTransaction().begin();
        s.setEstado(estado);
        em.getTransaction().commit();
        em.close();
        return true;
    }

}
