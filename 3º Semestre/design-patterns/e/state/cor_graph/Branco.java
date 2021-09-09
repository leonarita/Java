package e.state.cor_graph;

import java.util.List;

import e.state.No;

public class Branco extends Cor {
	
	public void busca(No no, List<No> list) {
		no.setCor(new Cinza(), list);
	}

}
