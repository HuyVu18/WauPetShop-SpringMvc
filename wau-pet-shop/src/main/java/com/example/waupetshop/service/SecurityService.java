package com.example.waupetshop.service;

public interface SecurityService {
    boolean isAuthenticated();
    boolean isValidToken(String token);
}
