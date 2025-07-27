package com.example.auth.controller;

import com.example.auth.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
public class AuthenticationController {

    private final JwtUtil jwtUtil;

    public AuthenticationController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/authenticate")
    public TokenResponse authenticate(HttpServletRequest request) {
        try {
            String authHeader = request.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Basic ")) {
                throw new RuntimeException("Missing or invalid Authorization header");
            }

            // Decode Base64 credentials
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);
            String[] values = credentials.split(":", 2);

            if (values.length != 2) {
                throw new RuntimeException("Invalid basic authentication token");
            }

            String username = values[0];
            String password = values[1];

            // Hardcoded user validation
            if (!"user".equals(username) || !"pwd".equals(password)) {
                throw new RuntimeException("Invalid credentials");
            }

            String token = jwtUtil.generateToken(username);
            return new TokenResponse(token);

        } catch (Exception e) {
            // Print the error in the server console
            e.printStackTrace();

            // Return a meaningful error message
            throw new RuntimeException("Authentication failed: " + e.getMessage());
        }
    }

    // Inner class for token response
    public static class TokenResponse {
        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}