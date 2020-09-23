package aula10;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EstoqueTest {
	
	Estoque e;
	
	@Before
	public void criarCenario() {
		Produto p1 = new Produto("Produto 1", 12, 20, 60);
		Produto p2 = new Produto("Produto 2", 12, 20, 60);
		
		e = new Estoque("Estocaria");
		e.armazena(p1);
		e.armazena(p2);
	}

	@Test
	public void naoDeveAceitarProdutosComMesmoNome() {
		e.armazena(new Produto("Produto 2", 12, 20, 60));
		assertEquals(2, e.getProdutos().size());
	}
}
