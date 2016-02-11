package com.stasanor.store.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mark Sahady
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Item.FIND_BY_NAME, query = "select i from Item i where i.name = :name"),
    @NamedQuery(name = Item.FIND_ALL, query = "select  i from Item i"),
    @NamedQuery(name = Item.FIND_ALL_SIZE, query = "select count(i) from Item i")
})
public class Item implements Serializable {

    public static final String FIND_BY_NAME = "Item.findByName";
    public static final String FIND_ALL = "Item.findAll";
    public static final String FIND_ALL_SIZE = "Item.findAllSize";

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Integer version;

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(length = 2000, nullable = false)
    private String description;

    private String imagePath;

    private long onHandQuantity;

    private long pendingQuantity;

    public Item() {
    }

    public Item(String name, String description, String imagePath) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Item=[");
        sb.append("id=").append(id).append(", ");
        sb.append("name=").append(name).append(", ");
        sb.append("description=").append(description).append(", ");
        sb.append("imagePath=").append(imagePath).append(", ");
        sb.append("onHandQuantity=").append(onHandQuantity).append(", ");
        sb.append("pendingQuantity=").append(pendingQuantity).append("]");
        return sb.toString();
    }
}
