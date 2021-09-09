package f.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarteiraAcoes {
	private Map<String,Integer> acoes = new HashMap<>();
	private List<Observador> obs = new ArrayList<>();
	
	public void adicionaAcoes(String acao, Integer qtd) {
		
		if(acoes.containsKey(acao)){
			qtd += acoes.get(acao);
		}
	
		acoes.put(acao, qtd);
		notificar(acao, qtd);
	}
	
	private void notificar(String acao, Integer qtd) {
	
		for(Observador o: obs)
			o.mudancaQuantidade(acao, qtd);
	}
	
	public void addObservador(Observador o) {
		obs.add(o);
	}
}
