package com.stasanor.store.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mark Sahady
 */
@Entity
public class PurchaseOrder implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @OneToOne
    private UserAccount userAccount;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    @OrderBy("name")
    private List<Item> items;

    public PurchaseOrder() {
        items = new ArrayList<>();
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the userAccount
     */
    public UserAccount getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount the userAccount to set
     */
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

}
