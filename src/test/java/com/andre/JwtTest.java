package com.andre;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: JwtTest
 * Package: com.andre
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/5 - 6:28
 * @Version: v1.0
 */
public class JwtTest {

    @Test
    public void testGen() {
        //
        //Map<String, Object> claims = new HashMap<>();
        //claims.put("id", 1);
        //claims.put("username", "安安");
        //// 生成jwt代碼
        //String token = JWT.create()
        //        .withClaim("user", claims) // 添加載荷
        //        .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 添加過期時間
        //        .sign(Algorithm.HMAC256("it"));
        //
        //System.out.println(token);
    }

    @Test
    public void testParse() {
        // 定義字串, 模擬用戶傳遞過來的token
        //String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
        //        ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuWuieWuiSJ9LCJleHAiOjE3MDQ0NTQ3NTN9" +
        //        ".0QuxBO9kEAuPu03lP3f52rsd7TeqMdpCDwsS_W2Ypuw";
        //
        //JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("it")).build();
        //
        //DecodedJWT decodeJWT = jwtVerifier.verify(token);
        //Map<String, Claim> claims = decodeJWT.getClaims();
        //System.out.println(claims.get("user"));

        // 如果改了頭部和載荷部分的資料,那麼驗證失敗
        // 如果密鑰改了,驗證失敗

    }
}
