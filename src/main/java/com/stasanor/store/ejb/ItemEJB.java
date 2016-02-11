package com.stasanor.store.ejb;

import com.stasanor.store.entities.Item;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mark Sahady
 */
@Stateless
@LocalBean
public class ItemEJB implements ItemEJBRemote {

    @Inject
    private EntityManager em;
    
    @Inject
    private Logger log;

    public ItemEJB() {
    }

    @Override
    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    @Override
    public Item findByName(String name) {
        TypedQuery<Item> query = em.createNamedQuery(Item.FIND_BY_NAME, Item.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public @NotNull
    Item createItem(@NotNull Item item) {
        em.persist(item);
        log.info("creating item with namme = " + item.getName());
        return item;
    }

    @Override
    public @NotNull
    Item updateItem(@NotNull Item item) {
        log.info("updating item with namme = " + item.getName());
        return em.merge(item);
    }

    @Override
    public void deleteItem(@NotNull Item item) {
        em.remove(em.merge(item));
        log.info("removing item with namme = " + item.getName());
    }
}
