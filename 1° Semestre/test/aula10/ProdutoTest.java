package aula10;

import org.junit.Test;
import aula10.Produto;

public class ProdutoTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarProdutosComEstoqueMinimoMenorQueCinco() {
		new Produto("Produto ilegal", 12, 2, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarProdutosComEstoqueMaximoMaiorQueCem() {
		new Produto("Produto ilegal", 12, 20, 120);
	}
}
