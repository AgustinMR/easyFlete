package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fletero;
import com.grupo15.easyflete.TipoUsuario;
import com.grupo15.handlers.EMHandler;
import java.util.List;
import javax.persistence.EntityManager;

public class DALUsuario implements IUsuario {

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
        Cliente cli = em.find(Cliente.class, c.getEmail());
        em.getTransaction().begin();
        cli.setNombre(c.getNombre());
        cli.setPassword(c.getPassword());
        cli.setTelefono(c.getTelefono());
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean updateUsuario(Fletero f) {
        EntityManager em = new EMHandler().entityManager();
        Fletero fle = em.find(Fletero.class, f.getEmail());
        fle.setNombre(f.getNombre());
        fle.setPassword(f.getPassword());
        fle.setTelefono(f.getTelefono());
        return true;
    }

    @Override
    public boolean deleteCliente(String email) {
        EntityManager em = new EMHandler().entityManager();
        Cliente c = em.find(Cliente.class, email);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteFletero(String email) {
        EntityManager em = new EMHandler().entityManager();
        Fletero f = em.find(Fletero.class, email);
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public Fletero getFletero(String email) {
        EntityManager em = new EMHandler().entityManager();
        return em.find(Fletero.class, email);

    }

    @Override
    public Cliente getCliente(String email) {
        EntityManager em = new EMHandler().entityManager();
        return em.find(Cliente.class, email);

    }

    @Override
    public List<Fletero> getAllFleteros() {
        EntityManager em = new EMHandler().entityManager();
        List<Fletero> F = em.createQuery("SELECT f FROM Fletero f", Fletero.class).getResultList();
        return F;
    }

    @Override
    public List<Cliente> getAllClientes() {
        EntityManager em = new EMHandler().entityManager();
        List<Cliente> C = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        return C;
    }

    @Override
    public TipoUsuario login(String email, String pass) {
        EntityManager em = new EMHandler().entityManager();
        Cliente cli = em.createQuery("SELECT c FROM Cliente c WHERE c.email = " + email, Cliente.class).getSingleResult();
        if (cli != null && pass.equals(cli.getPassword())) {
            return TipoUsuario.OK_CLIENTE;
        } else {
            Fletero flet = em.createQuery("SELECT f FROM Cliente f WHERE f.email = " + email, Fletero.class).getSingleResult();
            if (flet != null && pass.equals(flet.getPassword())) {
                return TipoUsuario.OK_FLETERO;
            }else{
                return TipoUsuario.ERROR;
            }
        }
    }

}
