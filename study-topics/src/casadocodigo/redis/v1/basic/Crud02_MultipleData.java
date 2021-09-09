package casadocodigo.redis.v1.basic;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class Crud02_MultipleData {
	
	private static Jedis jedis = new Jedis("localhost");
	
	public static void main(String[] args) {
		
		String dataDoSorteio1 = "04-09-2013";
		String numerosDoSorteio1 = "10, 11, 18, 42, 55, 56";
		String chave1 = String.format("resultado:%s:megasena", dataDoSorteio1);
		
		String dataDoSorteio2 = "07-09-2013";
		String numerosDoSorteio2 = "2, 21, 30, 35, 45, 50";
		String chave2 = String.format("resultado:%s:megasena", dataDoSorteio2);
		
		String dataDoSorteio3 = "21-09-2013";
		String numerosDoSorteio3 = "2, 13, 24, 41, 42, 44";
		String chave3 = String.format("resultado:%s:megasena", dataDoSorteio3);
		
		String dataDoSorteio4 = "02-10-2013";
		String numerosDoSorteio4 = "7, 15, 20, 23, 30, 41";
		String chave4 = String.format("resultado:%s:megasena", dataDoSorteio4);
		
		System.out.println(insert(chave1, numerosDoSorteio1, chave2, numerosDoSorteio2, chave3, numerosDoSorteio3, chave4, numerosDoSorteio4));
		System.out.println(selectAllKeys());
		System.out.println(selectDataFiltered("resultado:*-%02d-%04d:megasena", 10, 2013));
		
		// KEYS *
		// KEYS resultado:0?-*-*:megasena
		
		// CARACTERES *, [], ?
		
//		KEYS resultado:0?-??-????:megasena
//		KEYS resultado:0*-??-????:megasena
//		KEYS resultado:0?-*-????:megasena
//		KEYS resultado:0*-*-????:megasena
//		KEYS resultado:0?-??-*:megasena
//		KEYS resultado:0*-??-*:megasena
//		KEYS resultado:0?-*:megasena
//		KEYS resultado:0*-*:megasena
		
	}
	
	private static Set<String> selectAllKeys() {
		return jedis.keys("*");
	}
	
	private static Set<String> selectDataFiltered(String chave, int mes, int ano) {
		return jedis.keys(String.format(chave, mes, ano));
	}
	
	private static String insert(String key1, String value1, String key2, String value2, String key3, String value3, String key4, String value4) {
		return jedis.mset(key1, value1, key2, value2, key3, value3, key4, value4);
	}

}
