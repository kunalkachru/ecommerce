package com.ecommerce.auth_service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {

    // getters & setters
    private String username;
    private String password;

    public AuthRequest() {}

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
