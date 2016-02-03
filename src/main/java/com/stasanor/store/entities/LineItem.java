package com.stasanor.store.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mark Sahady
 */
@Entity
public class LineItem implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;    
    
    @NotNull
    @OneToOne(optional=false)
    private Item item;
    
    private long quantity;
    
    public LineItem() {
    }
    
    public LineItem(Item item, long quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    
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
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the quantity
     */
    public long getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LineItem=[");
        sb.append("id=").append(id).append(", ");
        sb.append("item=").append(item).append(", ");
        sb.append("quantity=").append(quantity).append("]");        
        return sb.toString();
    } 
               
}
