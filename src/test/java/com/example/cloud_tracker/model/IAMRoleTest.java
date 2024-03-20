package com.example.cloud_tracker.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IAMRoleTest {

    @Test
    public void testConstructorAndGetters() {
        int roleId = 1;
        User user = new User();

        IAMRole iamRole = new IAMRole(roleId, user);

        assertEquals(roleId, iamRole.getId());
        assertEquals(user, iamRole.getUser());
    }

    @Test
    public void testSetters() {
        IAMRole iamRole = new IAMRole();
        int roleId = 1;
        User user = new User();

        iamRole.setId(roleId);
        iamRole.setUser(user);

        assertEquals(roleId, iamRole.getId());
        assertEquals(user, iamRole.getUser());
    }

    @Test
    public void testEqualsAndHashCode() {
        IAMRole iamRole1 = new IAMRole();
        iamRole1.setId(1);
        IAMRole iamRole2 = new IAMRole();
        iamRole2.setId(1);
        IAMRole iamRole3 = new IAMRole();
        iamRole3.setId(2);

        assertTrue(iamRole1.equals(iamRole2));
        assertTrue(iamRole2.equals(iamRole1));
        assertTrue(iamRole1.hashCode() == iamRole2.hashCode());

        assertFalse(iamRole1.equals(iamRole3));
        assertFalse(iamRole3.equals(iamRole1));
        assertFalse(iamRole1.hashCode() == iamRole3.hashCode());
    }

    @Test
    public void testCanEqual() {
        IAMRole iamRole = new IAMRole();

        assertTrue(iamRole.canEqual(new IAMRole()));
        assertFalse(iamRole.canEqual(new Object()));
    }

    @Test
    public void testToString() {
        IAMRole iamRole = new IAMRole();
        iamRole.setId(1);
        User user = new User();
        user.setId(1);
        iamRole.setUser(user);

        String result = iamRole.toString();

        assertTrue(result.contains("id=1"));
        assertTrue(result.contains("user=" + user.toString()));
    }
}
