package com.huey.learning.java.jjwt.quickstart;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JjwtSample {

    public static void main(String[] args) {

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jwsStr = Jwts.builder()
                .setId("1234567890")
                .setSubject("Hello, JWT")
                .setIssuedAt(new Date())
                .claim("foo", "hello")
                .claim("bar", "world")
                .signWith(key)
                .compact();
        System.out.println("jws = " + jwsStr);

        Jws<Claims> jws = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwsStr);

        JwsHeader<?> header = jws.getHeader();
        String algorithm = header.getAlgorithm();
        System.out.println("algorithm = " + algorithm);

        Claims claims = jws.getBody();

        String id = claims.getId();
        System.out.println("id = " + id);

        String subject = claims.getSubject();
        System.out.println("subject = " + subject);

        Date issuedAt = claims.getIssuedAt();
        System.out.println("issuedAt = " + issuedAt);

        Object foo = claims.get("foo");
        System.out.println("foo = " + foo);

        Object bar = claims.get("bar");
        System.out.println("bar = " + bar);


    }

}
