package com.example.cloud_tracker.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.cloud_tracker.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Mock
    private UserDTO userDTO;

    @InjectMocks
    private User user;

    @Test
    public void testUserInitializationFromDTO() {
        String email = "test@example.com";
        String name = "Test User";
        
        when(userDTO.getEmail()).thenReturn(email);
        when(userDTO.getName()).thenReturn(name);

        User user = new User(userDTO);

        assertEquals(email, user.getEmail());
        assertEquals(name, user.getName());
    }

    @Test
    public void testUserDetailsMethods() {
        String email = "test@example.com";
        user.setEmail(email);

        assertEquals(email, user.getUsername());
        assertEquals(true, user.isAccountNonExpired());
        assertEquals(true, user.isAccountNonLocked());
        assertEquals(true, user.isCredentialsNonExpired());
        assertEquals(true, user.isEnabled());
    }

    @Test
    public void testUserRolesAndImage() {
        List<IAMRole> roles = new ArrayList<>();
        IAMRole role1 = new IAMRole();
        roles.add(role1);
        IAMRole role2 = new IAMRole();
        roles.add(role2);

        user.setRoles(roles);
        String image = "profile.jpg";
        user.setImage(image);
        int id = 1;
        user.setId(id);

        assertEquals(roles, user.getRoles());
        assertEquals(image, user.getImage());
        assertEquals(id, user.getId());
    }

    @Test
    public void testPasswordGetterSetter() {
        String password = "password";

        user.setPassword(password);

        assertEquals(password, user.getPassword());
    }

    @Test
    public void testNameGetterSetter() {
        String name = "John Doe";

        user.setName(name);

        assertEquals(name, user.getName());
    }

    @Test
    public void testToString() {
        User user = new User();
        user.setId(1);
        user.setEmail("test@example.com");
        user.setName("John Doe");

        String toString = user.toString();

        assertTrue(toString.contains("id=1"));
        assertTrue(toString.contains("email=test@example.com"));
        assertTrue(toString.contains("name=John Doe"));
    }

    @Test
    public void testHashCode() {
        User user1 = new User();
        user1.setId(1);
        User user2 = new User();
        user2.setId(1);

        assertEquals(user1.hashCode(), user2.hashCode());
    }


    @Test
    public void testEqualsWithDifferentType() {
        User user = new User();

        assertFalse(user.equals("not a User object"));
    }

    @Test
    public void testCanEqual() {
        User user = new User();

        assertTrue(user.canEqual(new User()));
        assertFalse(user.canEqual(new Object()));
    }

    @Test
    public void testEqualsAndHashCode() {
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("test@example.com");
        user1.setName("John Doe");

        User user2 = new User();
        user2.setId(1);
        user2.setEmail("test@example.com");
        user2.setName("John Doe");

        assertTrue(user1.equals(user2));
        assertTrue(user2.equals(user1));
        assertTrue(user1.hashCode() == user2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentId() {
        User user1 = new User();
        user1.setId(1);

        User user2 = new User();
        user2.setId(2);

        assertFalse(user1.equals(user2));
        assertFalse(user2.equals(user1));
        assertFalse(user1.hashCode() == user2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithNullFields() {
        User user1 = new User();
        user1.setId(1);
        user1.setEmail(null);
        user1.setName(null);

        User user2 = new User();
        user2.setId(1);
        user2.setEmail(null);
        user2.setName(null);

        assertTrue(user1.equals(user2));
        assertTrue(user2.equals(user1));
        assertTrue(user1.hashCode() == user2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithDifferentClass() {
        User user = new User();
        user.setId(1);

        Object obj = new Object();

        assertFalse(user.equals(obj));
        assertFalse(user.hashCode() == obj.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeWithNullObject() {
        User user = new User();
        user.setId(1);

        assertFalse(user.equals(null));
    }
}

