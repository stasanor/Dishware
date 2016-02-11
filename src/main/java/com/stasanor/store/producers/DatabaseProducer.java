package com.stasanor.store.producers;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mark Sahady
 */
public class DatabaseProducer {
    
    @Produces
    @PersistenceContext(unitName = "dishwareStorePU")
    private EntityManager em;
    
}
