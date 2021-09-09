package casadocodigo.redis.v3.advanced;

import redis.clients.jedis.Jedis;

public class LuaScript {
	
	public static void main(String[] args) {
		StringBuilder scriptLua = new StringBuilder();
		scriptLua.append("local valor = redis.call('get', KEYS[1])");
		scriptLua.append("local resultado = redis.call('set', KEYS[1], KEYS[2])");
		scriptLua.append("return valor");

		Jedis jedis = new Jedis("localhost");
		String chave = "numero-de-acessos";
		String valorNovo = "44";

		String valorAntigo = (String) jedis.eval(scriptLua.toString(), 2, chave, valorNovo);

		System.out.println(String.format("O valor antigo da chave %s � %s e o novo � %s", chave, valorAntigo, valorNovo));
	}

}
