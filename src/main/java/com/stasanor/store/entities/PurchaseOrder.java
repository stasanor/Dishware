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
    @OrderBy("item.name")
    private List<LineItem> lineItems;

    public PurchaseOrder() {
        lineItems = new ArrayList<>();
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
     * @return the lineItems
     */
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    /**
     * @param lineItems the lineItems to set
     */
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("PurchaseOrder=[");
        sb.append("id=").append(id).append(", ");
        sb.append("userAccount=").append(userAccount).append(", ");
        sb.append("creationDate").append(creationDate).append(", ");
        sb.append("lineItems=").append(lineItems).append("]");
        return sb.toString();
    }
}
