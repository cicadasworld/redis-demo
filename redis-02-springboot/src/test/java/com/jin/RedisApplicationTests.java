package com.jin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jin.pojo.User;
import com.jin.util.RedisUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void test() {
        // opsForValue() String
        // opsForList() List
        // opsForSet() Set
        // opsForHash() Hash
        // opsForZSet() ZSet
        // opsForGeo() Geo
        // opsForHyperLogLog() HyperLogLog
        // 获取连接对象
        // RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        // connection.flushDb();
        // connection.flushAll();
    }

    @Test
    void testUser() throws JsonProcessingException {
        User user = new User("jin", 3);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    void testUtil() {
        redisUtils.set("name", "jin");
        System.out.println(redisUtils.get("name"));
    }

}
