package aula10;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ControleTest {
	
	Controle c, c2, c3;
	
	@Before
	public void criarCenario() {
		
		Estoque e1 = new EstoqueTestBuilder().builder("Estoque 1")
				.registraProduto("Produto 1", 4, 20, 45)
				.registraProduto("Produto 2", 52, 20, 45)
				.build();
		
		Estoque e2 = new EstoqueTestBuilder().builder("Estoque 2")
				.registraProduto("Produto 3", 0, 20, 45)
				.registraProduto("Produto 4", 30, 20, 45)
				.build();
		
		Estoque e3 = new EstoqueTestBuilder().builder("Estoque 3")
				.registraProduto("Produto 5", 0, 20, 45)
				.build();
				
		c = new ControleTestBuilder()
				.builder()
				.setEstoque(e1)
				.setEstoque(e2)
				.build();
		
		c2 = new ControleTestBuilder().builder().build();
		c2 = new ControleTestBuilder().builder().setEstoque(e3).build();
		c3 = new ControleTestBuilder().builder().setEstoque(e3).build();
	}

	@Test
	public void deveRetornarProdutosComEstoqueInsuficiente() {
		assertEquals(1, c.getProdutosComEstoqueInsuficiente().size());
	}
	
	@Test
	public void deveRetornarProdutosComEstoqueExcedente() {
		assertEquals(1, c.getProdutosComEstoqueExcedente().size());
	}
	
	@Test
	public void deveRetornarProdutosComEstoqueZerado() {
		// Apesar de haver um estoque com um produto com quantidade 0, 
		// há uma regra de negócio que impede que seja inserido com quantidade menor do que 5
		assertEquals(0, c.getProdutosComEstoqueZerado().size());
	}
	
	@Test
	public void deveRetornarProdutosComEstoqueAdequado() {
		assertEquals(1, c.getProdutosComEstoqueAdequado().size());
	}
	
	@Test
	public void deveRetornarListaVaziaParaEstoqueSemProdutos() {
		assertEquals(0, c2.getProdutosComEstoqueAdequado().size());
		assertEquals(0, c2.getProdutosComEstoqueExcedente().size());
		assertEquals(0, c2.getProdutosComEstoqueInsuficiente().size());
		assertEquals(0, c2.getProdutosComEstoqueZerado().size());
	}
	
	@Test
	public void deveRetornarListaVaziaParaEstoqueSemProdutosComEstoqueZerado() {
		// Apesar de haver um estoque com um produto com quantidade 0, 
		// há uma regra de negócio que impede que seja inserido com quantidade menor do que 5
		assertEquals(0, c3.getProdutosComEstoqueZerado().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveControlarEstoquesSemNenhumProduto() {
		Estoque e = new EstoqueTestBuilder().builder("Estoque 3").build();
		c.controlaEstoques(e);
	}
}