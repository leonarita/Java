package casadocodigo.redis.v3.advanced;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
	
public class PipelineRedis {
	
	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();
		Jedis jedis = new Jedis("localhost");
		Pipeline pipeline = jedis.pipelined();

		for (int i = 1; i <= 100000; i++) {
			
			// Pipeline   : Rápido 
			pipeline.set("chave-" + i, String.valueOf(i));
			
			
			// Sequencial : Lento
			// jedis.set("chave-" + i, String.valueOf(i));
		}

		pipeline.sync();

		long tempoFinal = System.currentTimeMillis();
		System.out.println(String.format("Tempo total: %.2f segundos", ((tempoFinal - tempoInicial) / 1000.0)));
	}

}
