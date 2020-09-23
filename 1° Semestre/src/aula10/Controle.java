package aula10;

import java.util.ArrayList;
import java.util.List;

public class Controle {

	private List<Produto> produtosComEstoqueInsuficiente;
	private List<Produto> produtosComEstoqueExcedente;
	private List<Produto> produtosComEstoqueZerado;
	private List<Produto> produtosComEstoqueAdequado;
	
	public Controle() {
		this.produtosComEstoqueAdequado = new ArrayList<Produto>();
		this.produtosComEstoqueExcedente = new ArrayList<Produto>();
		this.produtosComEstoqueInsuficiente = new ArrayList<Produto>();
		this.produtosComEstoqueZerado = new ArrayList<Produto>();
	}

	public List<Produto> getProdutosComEstoqueInsuficiente() {
		if(produtosComEstoqueInsuficiente.size() == 0 || contarEstoque(produtosComEstoqueInsuficiente) == 0)
			return new ArrayList<Produto>();
		return produtosComEstoqueInsuficiente;
	}
	
	public List<Produto> getProdutosComEstoqueExcedente() {
		if(produtosComEstoqueExcedente.size() == 0 || contarEstoque(produtosComEstoqueExcedente) == 0)
			return new ArrayList<Produto>();
		return produtosComEstoqueExcedente;
	}
	
	public List<Produto> getProdutosComEstoqueZerado() {
		if(produtosComEstoqueZerado.size() == 0 || contarEstoque(produtosComEstoqueZerado) == 0)
			return new ArrayList<Produto>();
		return produtosComEstoqueZerado;
	}
	
	public List<Produto> getProdutosComEstoqueAdequado() {
		if(produtosComEstoqueAdequado.size() == 0 || contarEstoque(produtosComEstoqueAdequado) == 0)
			return new ArrayList<Produto>();
		return produtosComEstoqueAdequado;
	}
	
	public void controlaEstoques(Estoque estoque) {
		if(estoque.getProdutos().size() == 0)
			throw new IllegalArgumentException("Estoque sem produto...");
		
		for(Produto p : estoque.getProdutos()) {
			
			if(p.getQuantidade() == 0)
				produtosComEstoqueZerado.add(p);
			else if(p.getQuantidade() < p.getEstoqueMinimo())
				produtosComEstoqueInsuficiente.add(p);
			else if(p.getQuantidade() > p.getEstoqueMaximo())
				produtosComEstoqueExcedente.add(p);
			else
				produtosComEstoqueAdequado.add(p);
		}
	}
	
	public int contarEstoque(List<Produto> produtosComEstoqueInsuficiente2) {
		for (Produto p : produtosComEstoqueInsuficiente2) {
			if (p.getQuantidade() > 0)
				return 1;
		}
		return 0;
	}
	
}