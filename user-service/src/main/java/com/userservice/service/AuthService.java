package com.userservice.service;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Map;

@Service
public interface AuthService {

    public void validateToken(String token);

    public String generateToken(String userId);

    public String createToken(Map<String, Object> claims, String userName);

    public Key getStringKey();

}
