package com.github.shibor;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // String compact = Jwts.builder().setSubject("test").setExpiration(new Date()).compact();
        //
        //
        // System.out.println( compact);
        //
        // String subject = Jwts.parser().parseClaimsJws(compact).getBody().getSubject();
        // System.out.println(subject);


        Map map = new HashMap(1);
        map.put("12","zsbsd");
        String compact = Jwts.builder().addClaims(map).compact();

        System.out.println( compact);

        Object o = Jwts.parser().parse(compact);
        System.out.println(o);
    }
}
