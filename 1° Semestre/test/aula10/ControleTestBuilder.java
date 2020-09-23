package aula10;

public class ControleTestBuilder {

	private Controle controle;
	
	public ControleTestBuilder builder() {
		controle = new Controle();
		return this;
	}
	
	public ControleTestBuilder setEstoque(Estoque estoque) {
		controle.controlaEstoques(estoque);
		return this;
	}
	
	public Controle build() {
		return controle;
	}
	
}