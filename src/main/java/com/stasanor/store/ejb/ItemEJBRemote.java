package com.stasanor.store.ejb;

import com.stasanor.store.entities.Item;
import javax.ejb.Remote;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mark Sahady
 */
@Remote
public interface ItemEJBRemote {

    public Item findById(Long id);
    public Item findByName(String name);
    public @NotNull Item createItem(@NotNull Item item);
    public @NotNull Item updateItem(@NotNull Item item);
    public void deleteItem(@NotNull Item item);
}
