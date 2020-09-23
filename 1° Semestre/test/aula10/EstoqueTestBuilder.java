package aula10;

public class EstoqueTestBuilder {

	private Estoque estoque;
	
	public EstoqueTestBuilder builder(String loja) {
		estoque = new Estoque(loja);
		return this;
	}
	
	public EstoqueTestBuilder registraProduto(String nome, double quantidade, double estoqueMinimo, double estoqueMaximo) {
		estoque.armazena(criaProduto(nome, quantidade, estoqueMinimo, estoqueMaximo));
		return this;
	}
	
	public Produto criaProduto(String nome, double quantidade, double estoqueMinimo, double estoqueMaximo) {
		return new Produto(nome, quantidade, estoqueMinimo, estoqueMaximo);
	}
	
	public Estoque build() {
		return estoque;
	}
}
