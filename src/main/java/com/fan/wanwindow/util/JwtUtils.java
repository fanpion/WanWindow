package com.fan.wanwindow.util;


import cn.hutool.jwt.JWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @Author: ODM
 * @Date: 2023-12-27 21:48
 * @Description:
 * @Version: v1.0
 */


public class JwtUtils {
    private static final long EXPIRE = 1000 * 60 * 60;//过期时间
    private static final String SIGNKEY = "ODMWANWIN";//签名

    public static String generateJwt(Map<String, Object> claims){
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, SIGNKEY)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .compact();
    }

    public static Claims parseJwt(String jwtStr) {
        return Jwts.parser()
                .setSigningKey(SIGNKEY)
                .parseClaimsJws(jwtStr)
                .getBody();
    }
}
