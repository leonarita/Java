package e.state.cor_graph;

import java.util.List;

import e.state.No;

public class Cinza extends Cor {
	
	public void assumiu(No no, List<No> list) {
		
		for(No adj : no.getAdjacentes())
			adj.buscaProfundidade(list);
		
		no.setCor(new Preto(), list);
	}

}
