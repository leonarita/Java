package aulaTDD;

import org.junit.Before;
import org.junit.Test;

public class CurriculoTest {

	private Candidato joao;
	
	@Before
	public void criarCenario() {
		this.joao = new Candidato("João");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarCurriculosComPontuacaoMenorQueCinco() {
		
		new Curriculo(joao, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveAceitarCurriculosComPontuacaoMaiorQueDez() {
		
		new Curriculo(joao, 11);
	}
}
