//package com.example.SMS.Security;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtUtil {
//
//    private static String SECRET_KEY_STRING = "gNzPeANfkCjW1E6W9TGkDHqKNmbtAtP6";
//    private final String SECRET_KEY =(Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes()));
//
//    public String generatedToken(UserDetails userDetails) {
//        return Jwts.builder()
//                .subject(userDetails.getUsername())
//                .issuedAt(new Date())
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
//                .signWith(Jwts.SIG.HS256, SECRET_KEY)
//                .compact();
//    }
//}
