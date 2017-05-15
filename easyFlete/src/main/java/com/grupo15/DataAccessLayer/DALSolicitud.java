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

}
