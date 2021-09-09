package casadocodigo.redis.v1.basic;

import java.util.Arrays;
import java.util.Random;

import redis.clients.jedis.Jedis;

public class Crud06_BitMap_Increment_Decrement {
	
	private static Jedis jedis = new Jedis("localhost");
	
	public static void main(String[] args) {
		
		int quantidadeDeUsuarios = 500;
		int quantidadeDeAcessos = 1000;
		int quantidadeDeDias = 30;
		
		Random random = new Random();
		
		for(Integer numero=1; numero<=quantidadeDeAcessos; numero++) {
			long usuario = (random.nextInt(quantidadeDeUsuarios) + 1);
			String data = String.format("%02d/11/2013", (random.nextInt(quantidadeDeDias) + 1));
			armazenar(usuario, data);
		}
		
		
		String[] diario = { "05/11/2013" };
		String[] semanal = { "16/11/2013", "17/11/2013", "18/11/2013", "19/11/2013", "20/11/2013", "21/11/2013", "22/11/2013" };
		
		long totalDiario = acessosPorPeriodo(diario);
		long totalSemanal = acessosPorPeriodo(semanal);
		
		System.out.println(String.format("Total de usuários únicos no dia %s foi: %d", Arrays.asList(diario), totalDiario));
		System.out.println(String.format("Total de usuários únicos nos dias %s foi: %d", Arrays.asList(semanal), totalSemanal));
		
		// SETBIT cliques:anuncio:CASADOCODIGO 1000 1
		// GETBIT cliques:anuncio:CASADOCODIGO 1000
		// SETBIT cliques:anuncio:CASADOCODIGO 1001 0
		// GETBIT cliques:anuncio:CASADOCODIGO 1000
		
	}
	
	public static void armazenar(long codigoDoUsuario, String data) {
		jedis.setbit(String.format("acesso:%s", data), codigoDoUsuario, true);
	}
	
	public static long acessosPorPeriodo(String...datas) {
		long total = 0;
		
		for (String data : datas) {
			String chave = String.format("acesso:%s", data);
			total += jedis.bitcount(chave);
		}
		
		return total;
	}

}
