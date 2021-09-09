package casadocodigo.redis.v1.basic;

import redis.clients.jedis.Jedis;

public class Crud01_SimpleData {
	
	private static Jedis jedis = new Jedis("localhost");
	
	public static void main(String[] args) {
		
		// ECHO "ola redis!"
		String resultado = jedis.echo("ola redis!");

		System.out.println(resultado);
		
		// SET ultimo_usuario_logado "Bruce Banner"
		// GET ultimo_usuario_logado
		// DEL ultimo_usuario_logado
		
		System.out.println(insert("ultimo_usuario_logado", "Bruce Banner"));
		System.out.println(select("ultimo_usuario_logado"));
		System.out.println(delete("ultimo_usuario_logado"));
		
		// flushall
	}
	
	private static String select(String key) {
		return jedis.get(key);
	}
	
	private static String insert(String key, String value) {
		return jedis.set(key, value);
	}
	
	private static Long delete(String key) {
		return jedis.del(key);
	}

}
