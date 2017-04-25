package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Solicitud;
import com.grupo15.easyflete.SolicitudCliente;
import com.grupo15.handlers.EMHandler;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

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
    public boolean updateSolicitud(int id, double latitudOrigen, double longitudOrigen, double latitudDestino, double longitudDestino, double precioMax, Integer peso, Integer volumen, String descripcion) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        Solicitud sol = this.getSolicitud(id);
        sol.setLatitudOrigen(latitudOrigen);
        sol.setLongitudOrigen(longitudOrigen);
        sol.setLatitudDestino(latitudDestino);
        sol.setLongitudDestino(longitudDestino);
        sol.setPrecioMax(precioMax);
        sol.setPeso(peso);
        sol.setVolumen(volumen);
        sol.setDescripcion(descripcion);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean updateSolicitudCliente(int id, Date fecha) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        this.getSolicitudCli(id).setFecha(fecha);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteSolicitud(int id) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        Solicitud s = em.find(Solicitud.class, id);
        em.remove(s);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public Solicitud getSolicitud(int id) {
        EntityManager em = new EMHandler().entityManager();
        Solicitud S = em.find(Solicitud.class, id);
        em.close();
        return S;
    }

    @Override
    public SolicitudCliente getSolicitudCli(int id) {
        EntityManager em = new EMHandler().entityManager();
        SolicitudCliente S = em.find(SolicitudCliente.class, id);
        em.close();
        return S;
    }

    @Override
    public List<Solicitud> getAllSolicitudes() {
        EntityManager em = new EMHandler().entityManager();
        List<Solicitud> S = em.createQuery("SELECT s FROM Solicitud s", Solicitud.class).getResultList();
        em.close();
        return S;
    }

}
