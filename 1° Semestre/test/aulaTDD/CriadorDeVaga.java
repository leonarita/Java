package aulaTDD;

public class CriadorDeVaga {

	private Vaga vaga;
	
	public CriadorDeVaga adicionarVaga(String descricao) {
		this.vaga = new Vaga(descricao);
		return this;
	}
	
	public CriadorDeVaga cadastrarCurriculo(Candidato candidato, double pontuacao) {
		vaga.recebe(new Curriculo(candidato, pontuacao));
		return this;
	}
	
	public Vaga criar() {
		return this.vaga;
	}
}
