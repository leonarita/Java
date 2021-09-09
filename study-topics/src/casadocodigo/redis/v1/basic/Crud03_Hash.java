package casadocodigo.redis.v1.basic;

import redis.clients.jedis.Jedis;

public class Crud03_Hash {
	
	private static Jedis jedis = new Jedis("localhost");
	
	public static void main(String[] args) {
		System.out.println(insert(String.format("resultado:%s:megasena", "09-11-2013"), "ganhadores", "8, 18, 26, 42, 56, 58"));
		System.out.println(select(String.format("resultado:%s:megasena", "09-11-2013"), "ganhadores"));
		System.out.println(delete(String.format("resultado:%s:megasena", "09-11-2013"), "ganhadores"));
	}
	
	private static String select(String key, String field) {
		return jedis.hget(key, field);
	}
	
	private static Long insert(String key, String field, String value) {
		return jedis.hset(key, field, value);
	}
	
	private static Long delete(String key, String field) {
		return jedis.hdel(key, field);
	}

}
