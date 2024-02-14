package com.andre.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

/**
 * ClassName: JwtUtil
 * Package: com.andre.utils
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/5 - 7:43
 * @Version: v1.0
 */
public class JwtUtil {

    private static final String KEY = "it";

    // 接收業務資料,生成token並返回
    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000))
                .sign(Algorithm.HMAC256(KEY));
    }

    // 接收token,驗證token,並返回資料
    public static Map<String, Object> parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
}
