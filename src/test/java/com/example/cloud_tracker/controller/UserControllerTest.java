package com.example.cloud_tracker.controller;

import com.example.cloud_tracker.dto.UserDTO;
import com.example.cloud_tracker.model.JwtResponse;
import com.example.cloud_tracker.model.User;
import com.example.cloud_tracker.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignup_Success() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("password");
        User registeredUser = new User();
        registeredUser.setEmail(userDTO.getEmail());
        when(userService.register(userDTO)).thenReturn(registeredUser);

        ResponseEntity<User> responseEntity = userController.signup(userDTO);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(registeredUser, responseEntity.getBody());
    }

    @Test
    public void testSignup_RuntimeException() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("password");
        when(userService.register(userDTO)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> userController.signup(userDTO));
    }

    @Test
    public void testLogin_Success() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("password");
        JwtResponse jwtResponse = new JwtResponse("token", "refreshToken");
        when(userService.login(userDTO)).thenReturn(jwtResponse);

        ResponseEntity<JwtResponse> responseEntity = userController.login(userDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(jwtResponse, responseEntity.getBody());
    }

    @Test
    public void testLogin_Unauthorized() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("password");
        when(userService.login(userDTO)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> userController.login(userDTO));
    }
}

