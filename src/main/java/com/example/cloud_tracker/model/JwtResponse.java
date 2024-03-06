package com.example.cloud_tracker.model;

import com.example.cloud_tracker.service.JwtService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String email;
    public JwtResponse(String email) {
        this.email = email;
    }
}
