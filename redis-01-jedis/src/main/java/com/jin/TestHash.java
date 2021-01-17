package com.jin;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class TestHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.106", 6379);
        jedis.flushDB();
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        jedis.hmset("hash", map);
        jedis.hset("hash", "key5", "value5");
        System.out.println("散列hash的所有键值对为: " + jedis.hgetAll("hash"));
        System.out.println("散列hash的所有键为: " + jedis.hkeys("hash"));
        System.out.println("散列hash的所有值为: " + jedis.hvals("hash"));
        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6: " + jedis.hincrBy("hash", "key6", 1));
        System.out.println("散列hash的所有键值对为: " + jedis.hgetAll("hash"));
        System.out.println("将key6保存的值加上一个整数，如果key6不存在则添加key6: " + jedis.hincrBy("hash", "key6", 1));
        System.out.println("散列hash的所有键值对为: " + jedis.hgetAll("hash"));
        System.out.println("删除一个或者多个键值对: " + jedis.hdel("hash", "key2"));
        System.out.println("散列hash的所有键值对为: " + jedis.hgetAll("hash"));
        System.out.println("散列hash中键值对的个数: " + jedis.hlen("hash"));
        System.out.println("判断hash中是否存在key2: " + jedis.hexists("hash", "key2"));
        System.out.println("判断hash中是否存在key3: " + jedis.hexists("hash", "key3"));
        System.out.println("获取hash中的值: " + jedis.hmget("hash", "key3"));
        System.out.println("获取hash中的值: " + jedis.hmget("hash", "key3", "key4"));
    }
}
