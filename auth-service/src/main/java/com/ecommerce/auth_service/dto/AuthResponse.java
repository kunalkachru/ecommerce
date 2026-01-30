package com.ecommerce.auth_service.dto;

import lombok.Getter;

@Getter
public class AuthResponse {

    private String token;
    private String message;

    public AuthResponse() {}

    public AuthResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

}
