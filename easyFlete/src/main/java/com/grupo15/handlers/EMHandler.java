package com.grupo15.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMHandler {
   
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public EMHandler() {
        emf = Persistence.createEntityManagerFactory("com.grupo15_easyFlete_jar_0.5PU");
        em = emf.createEntityManager();
    }
    
    public EntityManager entityManager(){
        return em;
    }
    
}
