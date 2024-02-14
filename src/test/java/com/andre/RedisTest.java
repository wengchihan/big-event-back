package com.andre;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: RedisTest
 * Package: com.andre
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/10 - 11:13
 * @Version: v1.0
 */
@SpringBootTest // 如果在測試類上添加了這個註解,那麼將來單元測試方法執行之前,會先初始化Spring容器
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet() {
        // 在redis中存儲一個 key value , StringRedisTemplate;
        //ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        //// 設置時間 , 時間到了 id 就會消失
        //operations.set("id", "1", 15, TimeUnit.SECONDS);
        //operations.set("username", "安安");
    }

    @Test
    public void testGet() {
        // get key
        //ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        //System.out.println(operations.get("username"));
    }
}
