package aulaTDD;

public class Curriculo {

	private Candidato candidato;
	private double pontuacao;
	
	public Curriculo(Candidato candidato, double pontuacao) {
		
		if(pontuacao < 5 || pontuacao > 10)
			throw new IllegalArgumentException();

		this.candidato = candidato;
		this.pontuacao = pontuacao;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public double getPontuacao() {
		return pontuacao;
	}
}
