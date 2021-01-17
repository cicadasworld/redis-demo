package com.jin;

import com.alibaba.fastjson.JSONObject;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTransaction {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.106", 6379);
        jedis.flushDB();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "jin");
        String user1 = jsonObject.toJSONString();

        Transaction multi = jedis.multi();
        try {
            multi.set("user1", user1);
            multi.set("user2", user1);
            //int i = 1 / 0;
            multi.exec();
        } catch (Exception e) {
            multi.discard(); // 放弃事务
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();
        }
    }
}
