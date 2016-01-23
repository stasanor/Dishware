package com.stasanor.store.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static junit.framework.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Mark Sahady
 */
public class ItemTest {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("dishwareStoreTestPU");

    private EntityManager em;

    private EntityTransaction tx;

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

    @Test
    public void testCreateItem() {
        Item item = new Item("name", "description", "");
        
        tx.begin();
        em.persist(item);
        tx.commit();
        
        assertNotNull("ID of item should not be null",item.getId());
    }
}
