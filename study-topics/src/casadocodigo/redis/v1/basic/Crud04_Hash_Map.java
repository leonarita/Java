package casadocodigo.redis.v1.basic;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Crud04_Hash_Map {
	
	private static Jedis jedis = new Jedis("localhost");
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		final String codigoDoUsuario = "1962";
		final String nomeDoUsuario = "Peter Parker";
		final String emailDoUsuario = "spidey@marvel.com";
		
		Map<String, String> campos = new HashMap<>() {{
			put("codigo", codigoDoUsuario);
			put("nome", nomeDoUsuario);
			put("email", emailDoUsuario);
		}};
		
		// TTL "sessao:usuario:1962" : Retorna -1, pois não há tempo de expiração
		System.out.println(insert("sessao:usuario:" + codigoDoUsuario, campos));

		// TTL "sessao:usuario:1962" : Retorna tempo restante para expirar
		System.out.println(setTimeExpiration("sessao:usuario:" + codigoDoUsuario, 1800));
	}
	
	private static String insert(String key, Map<String, String> values) {
		return jedis.hmset(key, values);
	}
	
	private static Long setTimeExpiration(String key, int timeExpiration) {
		return jedis.expire(key, timeExpiration);
	}

}
