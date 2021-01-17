package com.jin;

import redis.clients.jedis.Jedis;

public class TestList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.106", 6379);
        jedis.flushDB();
        System.out.println("=================添加一个list==================");
        jedis.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");
        jedis.lpush("collections", "HashSet");
        jedis.lpush("collections", "TreeSet");
        jedis.lpush("collections", "TreeMap");
        System.out.println("collections的内容: " + jedis.lrange("collections", 0 , -1)); // -1代表倒索引
        System.out.println("collections区间0-3的元素: " + jedis.lrange("collections", 0 , 3));
        System.out.println("====================================");
        // 删除列表指定的值，第二个参数为删除的个数（有重复时），后加进去的值先被删除，类似于出栈
        System.out.println("删除指定元素个数: " + jedis.lrem("collections", 2, "HashMap"));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("删除下标0-3区间之外的元素: " + jedis.ltrim("collections", 0, 3));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections列表出栈（左端）:" + jedis.lpop("collections"));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("collections添加元素，从列表的右端，与lpush相对应: " + jedis.rpush("collections", "HashTable"));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("修改collections指定下标1的值: " + jedis.lset("collections", 1, "LinkedList"));
        System.out.println("collections的内容: " + jedis.lrange("collections", 0, -1));
        System.out.println("====================================");
        System.out.println("collections的长度:" + jedis.llen("collections"));
        System.out.println("获取collections下标2的元素: " + jedis.lindex("collections", 2));
        System.out.println("====================================");
        jedis.lpush("sortedList", "3", "6", "2", "0", "7", "4");
        System.out.println("sortedList排序前: " + jedis.lrange("sortedList", 0, -1));
        System.out.println(jedis.sort("sortedList"));
        System.out.println("sortedList排序后: " + jedis.lrange("sortedList", 0, -1));
    }
}