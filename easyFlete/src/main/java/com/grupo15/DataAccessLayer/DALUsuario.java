package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import com.grupo15.handlers.EMHandler;
import java.util.List;
import javax.persistence.EntityManager;

public class DALUsuario implements IUsuario{

    public DALUsuario() {
        
    }

    @Override
    public boolean addUsuario(Cliente c) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean addUsuario(Fletero f) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean updateUsuario(Cliente c) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.refresh(c);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean updateUsuario(Fletero f) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.refresh(f);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteCliente(int id) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        Cliente c = em.find(Cliente.class, id);
        em.remove(c);
        em.getTransaction().commit();
        return true;
    }
    
    @Override
    public boolean deleteFletero(int id) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        Fletero f = em.find(Fletero.class, id);
        em.remove(f);
        em.getTransaction().commit();
        return true;
    }


    @Override
    public Fletero getFletero(int id) {
        EntityManager em = new EMHandler().entityManager();
        Fletero F =  em.find(Fletero.class, id);
        em.close();
        return F;
    }

    @Override
    public Cliente getCliente(int id) {
        EntityManager em = new EMHandler().entityManager();
        Cliente C =  em.find(Cliente.class, id);
        em.close();
        return C;
    }

    @Override
    public List<Fletero> getAllFleteros() {
        EntityManager em = new EMHandler().entityManager();
        List<Fletero> F =  em.createQuery("SELECT f FROM Fletero f",Fletero.class).getResultList();
        em.close();
        return F;
    }

    @Override
    public List<Cliente> getAllClientes() {
        EntityManager em = new EMHandler().entityManager();
        List<Cliente> C =  em.createQuery("SELECT c FROM Cliente c",Cliente.class).getResultList();
        em.close();
        return C;
    }

}
