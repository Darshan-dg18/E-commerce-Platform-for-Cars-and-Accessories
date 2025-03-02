package com.CarEcommerse.CarEcommerse.dto.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthenticationResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}