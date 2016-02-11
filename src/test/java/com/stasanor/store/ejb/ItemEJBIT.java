package com.stasanor.store.ejb;

import com.stasanor.store.entities.Item;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Mark Sahady
 */
public class ItemEJBIT {

    private static final String TEST_ITEM_NAME = "ItemEJBITTestItem";

    @Test
    public void shouldCreateItem() throws Exception {

        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));

        try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
            Context ctx = ec.getContext();

            // Check JNDI dependencies (Datasource and EJBs)
            assertNotNull(ctx.lookup("java:global/jdbc/dishwareStoreDS"));
            assertNotNull(ctx.lookup("java:global/classes/ItemEJB!com.stasanor.store.ejb.ItemEJBRemote"));
            assertNotNull(ctx.lookup("java:global/classes/ItemEJB!com.stasanor.store.ejb.ItemEJB")
            );

            // Looks up the EJB
            ItemEJB itemEJB = (ItemEJB) ctx.lookup("java:global/classes/ItemEJB!com.stasanor.store.ejb.ItemEJB");

            // create an instance of an item
            Item item = new Item(TEST_ITEM_NAME, "This is a test item", null);

            // persist the item to the db
            itemEJB.createItem(item);

            // find the item in the db by id
            Item item2 = itemEJB.findById(item.getId());
            assertNotNull(item2);
            
            // find the item in the db by name
            item2 = itemEJB.findByName(TEST_ITEM_NAME);
            assertNotNull(item2);
            
            // remove the item from the db and test that it is no longer found
            itemEJB.deleteItem(item);
            
            item2 = itemEJB.findById(item.getId());
            assertNull(item2);
            
        }
    }

}
