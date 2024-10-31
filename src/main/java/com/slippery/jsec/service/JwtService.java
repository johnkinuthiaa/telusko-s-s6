package com.slippery.jsec.service;

import com.slippery.jsec.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    public Long EXPIRATIONTIME = 3600000L;
    private final String secretKey ="cccc792c0d0025d6c67a57ee2e93464f609ee01486e08ea925cb4199574de4be030dacf546642b4af9b28efcfe390682abe24078a2f5d5b290fbd8281841eae5cebe67f56719b0dbad78e324550ba15391f3e58d56cb1aa41847df3d7d3832edb85248dce5126bb54539dade19f665e506efc7a0e37df2402dc9c887a9760cc0b2161f50aac5b628b2f6fe049c8059513a8a2d475e87054d6e9843f55588662f1b1cacbbac8b72584018e401b75007e32baa9e74b47a2f6ff10110e04b1ffbadb481ef64ddc338181a40c5ca313b069b88a55edad488ea799fbd371c11454f01c71fce5d824a6e7f18182a18b4d8ece890b452ea5e69d54bfd0637a7685dd5c3";

    public String generateToken(String username) {
        Map<String, Object> claims =new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration( new Date(System.currentTimeMillis()+ EXPIRATIONTIME))
                .and()
                .signWith(getSecretKey())
                .compact();

    }

    private Key getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
