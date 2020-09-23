package aula10;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

	private String loja;
	private List<Produto> produtos;
	
	public Estoque(String loja) {
		this.loja = loja;
		produtos = new ArrayList<Produto>();
	}

	public String getLoja() {
		return loja;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void armazena(Produto produto) {
		if(verificarSeProdutoJaExiste(produto) == 0)
			produtos.add(produto);
	}
	
	public int verificarSeProdutoJaExiste(Produto produto) {
		for(Produto p : produtos) {
			if(p.getNome().equals(produto.getNome()))
				return 1;
		}
		return 0;
	}
}
