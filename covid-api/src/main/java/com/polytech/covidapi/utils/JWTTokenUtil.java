package com.polytech.covidapi.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTokenUtil {
    private static final long EXPIRE_TIME = 2 * 60 * 60 * 1000;
    //private key
    private static final String TOKEN_SECRET = "polytech";

    /**
     * Signature, Expire time 2h
     * @param **username**
     * @param **password**
     * @return
     */
    public static String createToken(String userId, String role) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // header info
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // return token
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId).withClaim("role",role)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Vérifier
     * @param **token**
     * @return
     */
    public static String[] verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            String role = jwt.getClaim("role").asString();
            String userId = jwt.getClaim("userId").asString();
            String[] values=new String[]{userId,role};
            return values;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
