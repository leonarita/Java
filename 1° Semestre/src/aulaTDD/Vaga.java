package aulaTDD;

import java.util.ArrayList;
import java.util.List;

public class Vaga {

	private String descricao;
	private List<Curriculo> curriculos;
	
	public Vaga(String descricao) {
		this.descricao = descricao;
		this.curriculos = new ArrayList<Curriculo>();
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Curriculo> getCurriculos() {
		return curriculos;
	}
	
	public void recebe(Curriculo curriculo) {
		
		if(curriculos.isEmpty() || qtdDeCurriculosDoCandidato(curriculo.getCandidato()) == 0)
			curriculos.add(curriculo);
	}
	
	private int qtdDeCurriculosDoCandidato(Candidato candidato) {
		int total = 0;
		
		for(Curriculo l : curriculos) {
			if(l.getCandidato().equals(candidato))
				total++;
		}
		
		return total;
	}
}
