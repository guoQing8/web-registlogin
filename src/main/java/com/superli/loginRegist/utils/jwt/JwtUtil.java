package com.superli.loginRegist.utils.jwt;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * @Author superli
 * @Description
 * @Date 2022/4/22 12:22
 */


public class JwtUtil {
    public static String signature = "superli";
    private static long time = 1000 * 10;

    public static String creatToken(String username) {
        JwtBuilder jwtBuilder = Jwts.builder();//builder是用来构建jwt的对象
        String jwToken = jwtBuilder
                //Header的设置
                .setHeaderParam("typ", "Jwt")
                .setHeaderParam("alg", "HS256")
                //PayLoad的设置
                .claim("username", username)
                .claim("role", "admin")
                .setSubject("admin-test")
                .setExpiration(new Date(System.currentTimeMillis() + time))//有效期oneday
                .setId(UUID.randomUUID().toString())
                //Signture的设置
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return jwToken;
    }

    public static boolean checkToken(String token) {
        if (token == null) {
            return false;
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
            System.out.println(claimsJws);
        } catch (Exception e) {
            return false;

        }

        return true;


    }

}

