package aulaTDD;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecrutadorTest {
	
	private Recrutador recrutador;
	private Candidato joao, maria, jose, ana, pedro;
	private Vaga vaga;
	
	@Before
	public void criarCenario() {
		this.joao = new Candidato("João");
		this.maria = new Candidato("Maria");
		this.jose = new Candidato("José");
		this.ana = new Candidato("Ana");
		this.pedro = new Candidato("Pedro");
		
		this.vaga = new Vaga("Analista de Sistemas");
		this.recrutador = new Recrutador();
	}
	
	@After
	public void deletarCenario() {
		this.joao = null;
		this.maria = null;
		this.jose = null;
		this.ana = null;
		this.pedro = null;
		
		this.vaga = null;
		this.recrutador = null;
	}

	@Test
	public void deveAvaliarPontuacoesEmOrdemCrescente() {
		
		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.cadastrarCurriculo(maria, 9)
				.cadastrarCurriculo(joao, 8)
				.cadastrarCurriculo(jose, 6)
				.criar();
		
		recrutador.avaliaCurriculo(vaga);
		
		assertEquals(9, recrutador.getMaiorPontuacao(), 0.001);
		assertEquals(6, recrutador.getMenorPontuacao(), 0.001);
	}
	
	@Test
	public void deveAvaliarPontuacoesEmOrdemDecrescente() {
		
		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.cadastrarCurriculo(joao, 9)
				.cadastrarCurriculo(maria, 8)
				.cadastrarCurriculo(jose, 7)
				.cadastrarCurriculo(ana, 5)
				.criar();
		
		recrutador.avaliaCurriculo(vaga);
		
		assertEquals(9, recrutador.getMaiorPontuacao(), 0.001);
		assertEquals(5, recrutador.getMenorPontuacao(), 0.001);
	}
	
	@Test
	public void deveAvaliarPontuacoesEmOrdemAleatoria() {
		
		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.cadastrarCurriculo(joao, 10)
				.cadastrarCurriculo(maria, 7)
				.cadastrarCurriculo(jose, 6)
				.cadastrarCurriculo(ana, 10)
				.cadastrarCurriculo(pedro, 8)
				.criar();
		
		recrutador.avaliaCurriculo(vaga);
		
		assertEquals(10, recrutador.getMaiorPontuacao(), 0.001);
		assertEquals(6, recrutador.getMenorPontuacao(), 0.001);
	}
	
	@Test
	public void deveCalcularMediaDePontuacoes() {
		
		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.cadastrarCurriculo(maria, 9)
				.cadastrarCurriculo(joao, 8)
				.cadastrarCurriculo(jose, 6)
				.criar();
		
		recrutador.avaliaCurriculo(vaga);
		
		assertEquals(7.666, recrutador.getMediaPontuacao(), 0.001);
	}
	
	@Test
	public void deveRetornarAsTresMaioresPontuacoes() {
		
		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.cadastrarCurriculo(joao, 5)
				.cadastrarCurriculo(maria, 6)
				.cadastrarCurriculo(jose, 8)
				.cadastrarCurriculo(ana, 10)
				.criar();

		recrutador.avaliaCurriculo(vaga);
		List<Curriculo> maiores = recrutador.getTresMaioresPontuacoes();
		
		assertEquals(3, maiores.size());
		assertEquals(10, maiores.get(0).getPontuacao(), 0.001);
		assertEquals(8, maiores.get(1).getPontuacao(), 0.001);
		assertEquals(6, maiores.get(2).getPontuacao(), 0.001);
	}
	
	@Test
	public void deveRetornarAsTresMaioresPontuacoesEmVagaComMenosDeTresCurriculos() {

		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.cadastrarCurriculo(joao, 9)
				.cadastrarCurriculo(maria, 8)
				.criar();

		recrutador.avaliaCurriculo(vaga);
		List<Curriculo> maiores = recrutador.getTresMaioresPontuacoes();
		
		assertEquals(2, maiores.size());
		assertEquals(9, maiores.get(0).getPontuacao(), 0.001);
		assertEquals(8, maiores.get(1).getPontuacao(), 0.001);
	}
	
	@Test
	public void deveAvaliarPontuacoesDeVagaComApenasUmCurriculo() {
		
		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.cadastrarCurriculo(joao, 8)
				.criar();

		recrutador.avaliaCurriculo(vaga);
		List<Curriculo> maiores = recrutador.getTresMaioresPontuacoes();
		
		assertEquals(1, maiores.size());
		assertEquals(8, recrutador.getMenorPontuacao(), 0.001);
		assertEquals(8, recrutador.getMaiorPontuacao(), 0.001);
	}
	
	@Test(expected=RuntimeException.class)
	public void naoDeveAvaliarVagasSemNenhumCurriculo() {
		
		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.criar();
		
		recrutador.avaliaCurriculo(vaga);
	}
	
	@Test
	public void naoDeveAceitarDoisCurriculosDoMesmoCandidato() {
		
		vaga = new CriadorDeVaga()
				.adicionarVaga("Analista de Sistemas")
				.cadastrarCurriculo(joao, 8)
				.cadastrarCurriculo(joao, 9)
				.criar();
		
		assertEquals(1, vaga.getCurriculos().size());
		assertEquals(8, vaga.getCurriculos().get(0).getPontuacao(), 0.001);
	}
}
