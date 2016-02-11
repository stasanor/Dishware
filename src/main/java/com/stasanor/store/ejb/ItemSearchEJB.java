package com.stasanor.store.ejb;

import com.stasanor.store.entities.Item;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mark Sahady
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
@LocalBean
public class ItemSearchEJB {
    
    public static final int PAGE_SIZE = 20;

    private EntityManager em;

    private long currentPage;
    private long maxResults;
    private long maxPages;

    public ItemSearchEJB() {
    }

    public long getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getMaxResults() {
        return maxResults;
    }

    public long getMaxPages() {
        return maxPages;
    }
    
    public void init() {
        currentPage = 0;
        maxResults = em.createNamedQuery(Item.FIND_ALL_SIZE,Long.class).getSingleResult();
        maxPages = (long) Math.ceil(maxResults / PAGE_SIZE);        
    }
    
    public List<Item> getCurrentResults() {
        TypedQuery<Item> query = em.createNamedQuery(Item.FIND_ALL, Item.class);
        query.setFirstResult((int)(currentPage / PAGE_SIZE)).setMaxResults(PAGE_SIZE);
        return query.getResultList();
    }
    
    public void next() {
        currentPage++;
        if(currentPage >= maxPages) {
            currentPage = maxPages - 1;
        }
    }
    
    public void previous() {
        currentPage--;
        if(currentPage < 0) {
            currentPage = 0;
        }
    }
    
    @Remove
    public void finished() {}
  
}
