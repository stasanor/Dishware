package com.stasanor.store.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author Mark
 */
public class BaseTest {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dishwareStoreTestPU");

    protected EntityManager em;

    protected EntityTransaction tx;

    @Before
    public void init() throws Exception {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void close() throws Exception {
        if (em != null) {
            em.clear();
        }
    }    
    
}
