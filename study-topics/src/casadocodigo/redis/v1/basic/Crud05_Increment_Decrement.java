package casadocodigo.redis.v1.basic;

import redis.clients.jedis.Jedis;

public class Crud05_Increment_Decrement {
	
	private static Jedis jedis = new Jedis("localhost");
	
	public static void main(String[] args) {
		String data = "02/09/2013";
		String[] paginasVisitadas = { "/inicio", "/contato", "/sobre-mim", "/todos-os-posts", "/armazenando-dados-no-redis" };
		
		incrementarEGerarEstatistica(paginasVisitadas[0], data);
		incrementarEGerarEstatistica(paginasVisitadas[1], data);
		incrementarEGerarEstatistica(paginasVisitadas[2], data);
		incrementarEGerarEstatistica(paginasVisitadas[1], data);
		incrementarEGerarEstatistica(paginasVisitadas[1], data);
		
		// GET pagina:/contato:02/09/2013
		
		// INCRBY pagina:/contato:02/09/2013 4
		// INCRBY pagina:/contato:02/09/2013 -2
		
		// INCRBYFLOAT pagina:/contato:02/09/2013 2.789
		// INCRBYFLOAT pagina:/contato:02/09/2013 -2.789
		// DECR get pagina:/contato:02/09/2013
	}
	
	public static String incrementarEGerarEstatistica(String pagina, String data) {
		
		long resultado = jedis.incr(String.format("pagina:%s:%s", pagina, data));
		
		return String.format("página %s teve %d acesso(s) em %s", pagina, resultado, data);
	}

}
