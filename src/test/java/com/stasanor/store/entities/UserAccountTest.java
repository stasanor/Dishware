package com.stasanor.store.entities;

import static junit.framework.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Mark Sahady
 */
public class UserAccountTest extends BaseTest {

    @Test
    public void testCreateUserAccount() {
        UserAccount user = new UserAccount("first", "last", "first.last@test.com");

        tx.begin();
        em.persist(user);
        tx.commit();

        assertNotNull("Id of User Account should not be null", user.getId());
        assertNotNull("CreationDate of User Account should not be null", user.getCreationDate());
    }

}
