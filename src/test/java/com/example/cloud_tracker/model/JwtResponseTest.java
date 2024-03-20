package com.example.cloud_tracker.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JwtResponseTest {

    @Test
    public void testJwtResponseConstructorAndGetters() {
        String token = "token";
        String refreshToken = "refreshToken";

        JwtResponse jwtResponse = new JwtResponse(token, refreshToken);

        assertEquals(token, jwtResponse.getToken());
        assertEquals(refreshToken, jwtResponse.getRefreshToken());
    }

    @Test
    public void testJwtResponseEqualsAndHashCode() {
        JwtResponse jwtResponse1 = new JwtResponse("token1", "refreshToken1");
        JwtResponse jwtResponse2 = new JwtResponse("token1", "refreshToken1");
        JwtResponse jwtResponse3 = new JwtResponse("token2", "refreshToken2");

        assertTrue(jwtResponse1.equals(jwtResponse2));
        assertTrue(jwtResponse2.equals(jwtResponse1));
        assertTrue(jwtResponse1.hashCode() == jwtResponse2.hashCode());

        assertFalse(jwtResponse1.equals(jwtResponse3));
        assertFalse(jwtResponse3.equals(jwtResponse1));
        assertFalse(jwtResponse1.hashCode() == jwtResponse3.hashCode());
    }

    @Test
    public void testJwtResponseToString() {
        JwtResponse jwtResponse = new JwtResponse("token", "refreshToken");

        String result = jwtResponse.toString();

        assertTrue(result.contains("token=token"));
        assertTrue(result.contains("refreshToken=refreshToken"));
    }


    @Test
    public void testSetters() {
        JwtResponse jwtResponse = new JwtResponse();

        jwtResponse.setToken("token");
        jwtResponse.setRefreshToken("refreshToken");

        assertEquals("token", jwtResponse.getToken());
        assertEquals("refreshToken", jwtResponse.getRefreshToken());
    }

    @Test
    public void testEqualsAndHashCode() {
        JwtResponse jwtResponse1 = new JwtResponse("token1", "refreshToken1");
        JwtResponse jwtResponse2 = new JwtResponse("token1", "refreshToken1");
        JwtResponse jwtResponse3 = new JwtResponse("token2", "refreshToken2");

        assertTrue(jwtResponse1.equals(jwtResponse2));
        assertTrue(jwtResponse2.equals(jwtResponse1));
        assertTrue(jwtResponse1.hashCode() == jwtResponse2.hashCode());

        assertFalse(jwtResponse1.equals(jwtResponse3));
        assertFalse(jwtResponse3.equals(jwtResponse1));
        assertFalse(jwtResponse1.hashCode() == jwtResponse3.hashCode());

        JwtResponse jwtResponse4 = new JwtResponse("token1", "refreshToken2");
        assertFalse(jwtResponse1.equals(jwtResponse4));
        assertFalse(jwtResponse4.equals(jwtResponse1));
        assertFalse(jwtResponse1.hashCode() == jwtResponse4.hashCode());

        JwtResponse jwtResponse5 = new JwtResponse("token2", "refreshToken1");
        assertFalse(jwtResponse1.equals(jwtResponse5));
        assertFalse(jwtResponse5.equals(jwtResponse1));
        assertFalse(jwtResponse1.hashCode() == jwtResponse5.hashCode());
    }

    @Test
    public void testEqualsWithNullObject() {
        JwtResponse jwtResponse = new JwtResponse("token", "refreshToken");

        assertFalse(jwtResponse.equals(null));
    }

}
