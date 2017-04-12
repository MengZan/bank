package com.bankofshanghai.spark;

import java.sql.Date;
import java.util.*;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;

public class JedisTest {
	public static void main(String[] args) {
		// 创建Redis客户端
		Jedis jedis = new Jedis("192.168.11.129", 6379);

		// String response = jedis.ping();
		//
		// jedis.set("name", "dmm");
		//
		// jedis.set("age", "24");
		// jedis.incr("age");
		// jedis.decr("age");
		//
		// jedis.mset("mm", "24", "zz", "25");
		// jedis.set("mm", "100");
		// List<String> l = jedis.mget("mm", "zz");

		// 设置自动过期时间，单位秒
		// jedis.setex("love", 10, "zz");
		// while(jedis.exists("love")){
		// System.out.println("么么哒");
		// Thread.sleep(1000);
		// }

		// 对已存在的字段设置过期时间
		// jedis.expire("name", 10000);

		// 保存对象：保存toString/保存序列化之后的对象

		// list
		// jedis.del("names");
		// jedis.lpush("names", "mm", "zz", "gy");
		// jedis.rpush("names", "db");
		// jedis.linsert("names", BinaryClient.LIST_POSITION.AFTER, "gy",
		// "trg");
		// jedis.linsert("names", BinaryClient.LIST_POSITION.BEFORE, "gy",
		// "ll");
		// jedis.lpop("names");
		// jedis.rpop("names");
		// String result = jedis.ltrim("names", 1, 2);
		// if ("OK".equals(result)) {
		// // ...
		// }
		// List<String> names = jedis.lrange("names", 0, -1);

		// map
		// jedis.del("dmm");
		// jedis.hset("dmm", "name", "不为人知");
		// jedis.hset("dmm","age","24");
		// jedis.hset("dmm", "sex", "man");
		// jedis.hdel("dmm", "sex");
		// Map<String,String> dmm = jedis.hgetAll("dmm");
		// Set<String> fields = jedis.hkeys("dmm");
		// List<String> vals = jedis.hvals("dmm");
		// jedis.hincrBy("dmm", "age", 10);
		// String age = jedis.hget("dmm", "age");

		// set
		// jedis.del("gfs");
		// String[] gf = {"zz","ll","lx"};
		// jedis.sadd("gfs", gf);
		// Set<String> gfs = jedis.smembers("gfs");
		// boolean isIn = jedis.sismember("gfs", "zz");
		// long num = jedis.scard("gfs");

		// sortset

		String s = jedis.hget("dmm", "name");
		System.out.println(s);

		jedis.close();
	}
}
