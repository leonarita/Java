package casadocodigo.redis.v3.advanced;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Radio {
	
	static class Ouvinte {
		private final String nome;
		private final String estacao;
		
		private AtomicInteger musicasOuvidas = new AtomicInteger(0);
		
		private static final Executor threadPool = Executors.newFixedThreadPool(3);
		
		Ouvinte(String nome, String estacao) {
			this.nome = nome;
			this.estacao = estacao;
		}
		
		public void ouvirEstacao() {
			Runnable ouvinte = new Runnable() {

				public void run() {
					Jedis jedis = new Jedis("localhost");
					JedisPubSub jedisPubSub = new JedisPubSub() {

						@Override
						public void onUnsubscribe(String channel, int subscribedChannels) {
							System.out.println(String.format("%s deixou de escutar a esta��o %s", nome, channel));
						}

						@Override 
						public void onSubscribe(String channel, int subscribedChannels) {
							System.out.println(String.format("%s come�ou a escutar a esta��o %s", nome, channel));
						}

						@Override
						public void onMessage(String channel, String message) {
							System.out.println(String.format("%s est� ouvindo %s na esta��o %s", nome, message, channel));

							if (musicasOuvidas.addAndGet(1) >= 3) {
								this.unsubscribe();
							}
						}

						@Override
						public void onPUnsubscribe(String pattern, int subscribedChannels) {
						}

						@Override
						public void onPSubscribe(String pattern, int subscribedChannels) {
						}

						@Override
                        public void onPMessage(String pattern, String channel, String message) {
						}
					};

					jedis.subscribe(jedisPubSub, estacao);
					jedis.subscribe(jedisPubSub, "ab");
				}
			};
			
			threadPool.execute(ouvinte);
		}
	}
		
	
	public static void main(String[] args) {
		Ouvinte rodrigo = new Ouvinte("Rodrigo", "punk-rock");
		rodrigo.ouvirEstacao();

		Ouvinte rafael = new Ouvinte("Rafael", "surf-music");
		rafael.ouvirEstacao();

		Ouvinte andressa = new Ouvinte("Andressa", "pop-rock");
		andressa.ouvirEstacao();
	}

}
