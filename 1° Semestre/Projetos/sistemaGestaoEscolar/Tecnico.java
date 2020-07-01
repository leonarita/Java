package sistemaGestaoEscolar;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Professor {

	private double valorBase = 1500.00;
	private List<Aluno> alunos;
	
	@Override
	public double calculaSalario() {
		return valorBase * 1.5;
	}
	
	public double getValorBase() {
		return valorBase;
	}
	
	public void addBolsista(Aluno aluno) {
		if (alunos == null)
			alunos = new ArrayList<Aluno>();
		
		alunos.add(aluno);
	}
	
	public void removeBolsista(Aluno aluno) {
		alunos.remove(alunos.indexOf(aluno));
	}

	public void listaBolsistas() {
		System.out.println("Lista de Bolsistas:");
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
		System.out.println("-----------------");
		
	}
	
}
