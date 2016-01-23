package com.stasanor.store.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Mark Sahady
 */
@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Item item;

    private long onHandQuantity;

    private long pendingQuantity;

    public Inventory() {
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @return the onHandQuantity
     */
    public long getOnHandQuantity() {
        return onHandQuantity;
    }

    /**
     * @param onHandQuantity the onHandQuantity to set
     */
    public void setOnHandQuantity(long onHandQuantity) {
        this.onHandQuantity = onHandQuantity;
    }

    /**
     * @return the pendingQuantity
     */
    public long getPendingQuantity() {
        return pendingQuantity;
    }

    /**
     * @param pendingQuantity the pendingQuantity to set
     */
    public void setPendingQuantity(long pendingQuantity) {
        this.pendingQuantity = pendingQuantity;
    }
    
    public long getAvailableQuantity() {
        return onHandQuantity - pendingQuantity;
    }
}
