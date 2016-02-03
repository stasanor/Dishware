package com.stasanor.store.entities;

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
        assertNotNull("Item1 not found",item);
    }
}
