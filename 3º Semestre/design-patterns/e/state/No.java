package e.state;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import e.state.cor_graph.Branco;
import e.state.cor_graph.Cor;

public class No {
	
	private Set<No> adjacentes = new HashSet<>();
	
	private Cor cor;
	
	private String name;
	
	public No(String name){
		this.name = name;
		cor = new Branco();
	}
	
	public void buscaProfundidade(List<No> list){
		cor.busca(this, list);
	}
	
	public Set<No> getAdjacentes() {
		return adjacentes;
	}
	
	public void addAdjacentes(No adj) {
		adjacentes.add(adj);
	}
	
	public void setCor(Cor cor, List<No> list) {
		this.cor = cor;
		cor.assumiu(this ,list);
	}
	
	public String toString() {
		return name;
	}

}
