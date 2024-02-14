package com.andre.interceptors;

import com.andre.pojo.Result;
import com.andre.utils.JwtUtil;
import com.andre.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * ClassName: LoginInterceptor
 * Package: com.andre.interceptors
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/5 - 8:08
 * @Version: v1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 令牌驗證
        String token = request.getHeader("Authorization");
        // 驗證token
        try {

            // 從redis中 獲取相同的 token
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String redisToken = operations.get(token);

            if (redisToken == null) {
                // token失效了
                // 拋出例外 - 下面catch - false
                throw new RuntimeException();
            }

            Map<String, Object> claims = JwtUtil.parseToken(token);

            // 把業務資料存儲到ThreadLocal中
            ThreadLocalUtil.set(claims);
            // 放行
            return true;
        } catch (Exception e) {
            // http status 401
            response.setStatus(401);
            // 不放行
            return false;
        }

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清空ThreadLocal中的資料, 可以防止記憶體流失
        ThreadLocalUtil.remove();
    }
}
