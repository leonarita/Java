package casadocodigo.redis.v3.advanced;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TransactionRedis {
	
	public String getSet(String chave, String novoValor) {
		Jedis jedis = new Jedis("localhost");
		Transaction transaction = jedis.multi();

		transaction.get(chave);
		transaction.set(chave, novoValor);

		List<Object> resultados = transaction.exec();

		return (String) resultados.get(0);
	}

	public static void main(String[] args) {
		String valorNovo = "20";
		String chave = "numero-de-acessos";

		TransactionRedis transacao = new TransactionRedis();

		String valorAntigo = transacao.getSet(chave, valorNovo);

		System.out.println(String.format("O valor antigo da chave %s � %s e o novo � %s", chave, valorAntigo, valorNovo));
	}

}
