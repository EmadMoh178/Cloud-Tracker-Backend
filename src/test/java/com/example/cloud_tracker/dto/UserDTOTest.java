package com.example.cloud_tracker.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDTOTest {

    @Test
    public void testConstructorAndGetters() {
        String email = "test@example.com";
        String password = "password";
        String name = "John Doe";

        UserDTO userDTO = UserDTO.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();

        assertEquals(email, userDTO.getEmail());
        assertEquals(password, userDTO.getPassword());
        assertEquals(name, userDTO.getName());
    }

    @Test
    public void testEqualsAndHashCode() {
        UserDTO userDTO1 = UserDTO.builder().email("test@example.com").password("password").name("John Doe").build();
        UserDTO userDTO2 = UserDTO.builder().email("test@example.com").password("password").name("John Doe").build();
        UserDTO userDTO3 = UserDTO.builder().email("another@example.com").password("password").name("Jane Doe").build();

        assertTrue(userDTO1.equals(userDTO2));
        assertTrue(userDTO2.equals(userDTO1));
        assertTrue(userDTO1.hashCode() == userDTO2.hashCode());

        assertFalse(userDTO1.equals(userDTO3));
        assertFalse(userDTO3.equals(userDTO1));
        assertFalse(userDTO1.hashCode() == userDTO3.hashCode());
    }

    @Test
    public void testCanEqual() {
        UserDTO userDTO = UserDTO.builder().email("test@example.com").password("password").name("John Doe").build();

        assertTrue(userDTO.canEqual(UserDTO.builder().email("test@example.com").password("password").name("John Doe").build()));
        assertFalse(userDTO.canEqual(new Object()));
    }

    @Test
    public void testToString() {
        UserDTO userDTO = UserDTO.builder().email("test@example.com").password("password").name("John Doe").build();

        String result = userDTO.toString();

        assertTrue(result.contains("email=test@example.com"));
        assertTrue(result.contains("password=password"));
        assertTrue(result.contains("name=John Doe"));
    }

    @Test
    public void testBuilderToString() {
        String email = "test@example.com";
        String password = "password";
        String name = "John Doe";

        UserDTO userDTO = UserDTO.builder()
                .email(email)
                .password(password)
                .name(name)
                .build();

        String builderToString = userDTO.toString();
        String directToString = UserDTO.builder().toString();

        assertTrue(builderToString.contains("email=" + email));
        assertTrue(builderToString.contains("password=" + password));
        assertTrue(builderToString.contains("name=" + name));
        assertEquals(directToString, "UserDTO.UserDTOBuilder(email=null, password=null, name=null)");
    }

    @Test
    public void testSetters() {
        UserDTO userDTO = new UserDTO();
        String email = "test@example.com";
        String password = "password";
        String name = "John Doe";

        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setName(name);

        assertEquals(email, userDTO.getEmail());
        assertEquals(password, userDTO.getPassword());
        assertEquals(name, userDTO.getName());
    }
}

