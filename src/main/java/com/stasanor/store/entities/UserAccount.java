package com.stasanor.store.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Represents a User Account
 *
 * @author Mark Sahady
 */
@Entity
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false, unique = true)
    private String emailAddress;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public UserAccount() {
    }

    public UserAccount(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    @PrePersist
    private void setCreationDate() {
        this.creationDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserAccount=[");
        sb.append("id=").append(id).append(", ");
        sb.append("firstName=").append(firstName).append(", ");
        sb.append("lastName=").append(lastName).append(", ");
        sb.append("emailAddress=").append(emailAddress).append(", ");
        sb.append("creationDate=").append(creationDate).append("]");
        return sb.toString();
    }
}
