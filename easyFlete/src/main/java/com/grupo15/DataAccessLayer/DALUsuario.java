package com.grupo15.DataAccessLayer;

import com.grupo15.easyflete.Cliente;
import com.grupo15.easyflete.Fecha;
import com.grupo15.easyflete.Fletero;
import com.grupo15.easyflete.Rol;
import com.grupo15.handlers.EMHandler;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

public class DALUsuario implements IUsuario {

    public DALUsuario() {

    }

    @Override
    public boolean addUsuario(Cliente c) {
        EntityManager em = new EMHandler().entityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            return false;
        }
    }

    @Override
    public boolean addUsuario(Fletero f) {
        EntityManager em = new EMHandler().entityManager();
        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.close();
            return false;
        }

    }

    @Override
    public boolean updateUsuario(Cliente c) {
        EntityManager em = new EMHandler().entityManager();
        Cliente cli = em.find(Cliente.class, c.getUsername());
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
        Fletero fle = em.find(Fletero.class, f.getUsername());
        fle.setNombre(f.getNombre());
        fle.setPassword(f.getPassword());
        fle.setTelefono(f.getTelefono());
        return true;
    }

    @Override
    public boolean deleteCliente(String email) {
        EntityManager em = new EMHandler().entityManager();
        Cliente c = em.find(Cliente.class, email);
        if (c == null) {
            em.close();
            return false;
        }
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteFletero(String email) {
        EntityManager em = new EMHandler().entityManager();
        Fletero f = em.find(Fletero.class, email);
        if (f == null) {
            em.close();
            return false;
        }
        em.getTransaction().begin();
        em.remove(f);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public Fletero getFletero(String email) {
        return new EMHandler().entityManager().find(Fletero.class, email);
    }

    @Override
    public Cliente getCliente(String email) {
        return new EMHandler().entityManager().find(Cliente.class, email);
    }

    @Override
    public List<Fletero> getAllFleteros() {
        EntityManager em = new EMHandler().entityManager();
        List<Fletero> F = em.createQuery("SELECT f FROM Fletero f", Fletero.class).getResultList();
        em.close();
        return F;
    }

    @Override
    public List<Cliente> getAllClientes() {
        EntityManager em = new EMHandler().entityManager();
        List<Cliente> C = em.createQuery("SELECT c FROM Usuario c", Cliente.class).getResultList();
        em.close();
        return C;
    }

    @Override
    public boolean addRol(Rol r) {
        EntityManager em = new EMHandler().entityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Object[]> getSolicitudesByCliente(String email) {
        return new EMHandler().entityManager()
                .createQuery("SELECT s.id, s.titulo, s.descripcion, s.estado, s.precio, s.valoracion, s.solicitudCliente.fecha "
                        + "FROM Solicitud s "
                        + "WHERE s.solicitudCliente.clienteEmail.username = :D", Object[].class)
                .setParameter("D", email).getResultList();
    }

    @Override
    public List<Object[]> getSolicitudesByCliente(String email, String fechaDesde, String fechaHasta, String titulo) {
        String query = "SELECT s.id, s.titulo, s.descripcion, s.estado, s.precio, s.valoracion, function('to_char', s.solicitudCliente.fecha, 'DD/MM/YYYY') FROM Solicitud s WHERE s.solicitudCliente.clienteEmail.username = :D";
        if (fechaDesde != null && !fechaDesde.isEmpty()) {
            query += " AND s.solicitudCliente.fecha >= :desde";
        }
        if (fechaHasta != null && !fechaHasta.isEmpty()) {
            query += " AND s.solicitudCliente.fecha <= :hasta";
        }
        if (titulo != null && !titulo.isEmpty()) {
            query += " AND s.titulo LIKE :titulo";
        }
        TypedQuery<Object[]> sql = new EMHandler().entityManager().createQuery(query, Object[].class);
        sql.setParameter("D", email);
        if (fechaDesde != null && !fechaDesde.isEmpty()) {
            Fecha f1 = new Fecha(fechaDesde);
            sql.setParameter("desde", new GregorianCalendar(f1.getAnio(), (f1.getMes() -1), f1.getDia()).getTime(), TemporalType.DATE);
        }
        if (fechaHasta != null && !fechaHasta.isEmpty()) {
            Fecha f2 = new Fecha(fechaHasta);
            sql.setParameter("hasta", new GregorianCalendar(f2.getAnio(), (f2.getMes() -1), f2.getDia()).getTime(), TemporalType.DATE);
        }
        if (titulo != null && !titulo.isEmpty()) {
            sql.setParameter("titulo", "%" + titulo + "%");
        }
        return sql.getResultList();
    }

    @Override
    public List<Object[]> getSolicitudesByFletero(String email, String titulo) {
        String query = "SELECT s.id, s.titulo, s.descripcion, function('to_char', s.solicitudCliente.fecha, 'DD/MM/YYYY'), s.solicitudCliente.hora, s.solicitudCliente.clienteEmail.nombre, s.solicitudCliente.clienteEmail.username, s.distancia, s.precio "
                + "FROM Solicitud s "
                + "WHERE s.fleteroSolicitudCliente.fleteroEmail.username = :D";
        if (titulo != null && !titulo.isEmpty()) {
            query += " AND s.titulo LIKE :titulo ORDER BY s.solicitudCliente.fecha";
        } else {
            query += " ORDER BY s.solicitudCliente.fecha";
        }
        TypedQuery<Object[]> sql = new EMHandler().entityManager().createQuery(query, Object[].class);
        sql.setParameter("D", email);
        if (titulo != null && !titulo.isEmpty()) {
            sql.setParameter("titulo", "%" + titulo + "%");
        }
        return sql.getResultList();
    }

    @Override
    public Cliente getClienteBySolicitud(int solicitud) {
        EntityManager em = new EMHandler().entityManager();
        Cliente c = em.createQuery("SELECT s.solicitudCliente.clienteEmail FROM Solicitud s WHERE s.id = :D", Cliente.class).setParameter("D", solicitud).getSingleResult();
        em.close();
        return c;
    }

}
