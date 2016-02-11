package com.stasanor.store.entities;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Mark Sahady
 */
public class ItemTest extends BaseTest {
    
    @Test
    public void testCreateItem() {
        Item item = new Item("name", "description", "");

        tx.begin();
        em.persist(item);
        tx.commit();

        assertNotNull("Id of item should not be null", item.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void testNameNotNull() {
        Item item = new Item(null, "description", null);

        tx.begin();
        em.persist(item);
        tx.commit();
    }

    @Test
    public void testQuantitites() {
        Item item = new Item("name", "description", "");
        item.setOnHandQuantity(12);
        item.setPendingQuantity(6);
        assertEquals("Available quantity should equal 6", 6, item.getAvailableQuantity());
    }

    @Test
    public void testFindByName() {
        TypedQuery<Item> query = em.createNamedQuery(Item.FIND_BY_NAME, Item.class).setParameter("name", "Item1");
        Item item = query.getSingleResult();
        assertNotNull("Item1 not found", item);
    }

    @Test(expected = PersistenceException.class)
    public void testDuplicateNames() {
        Item i1 = new Item("a1", "", "");
        Item i2 = new Item("a1", "", "");

        tx.begin();
        em.persist(i1);
        em.persist(i2);
        tx.commit();
    }
}
