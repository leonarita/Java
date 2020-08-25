package sistema.gestaoEscolar;

import java.util.ArrayList;
import java.util.List;

public abstract class Professor {

	private String nome;
	private List<Disciplina> disciplinas;
	
	public void getSalario() {
		System.out.println("Professor: "+ nome + " - Salário R$ "+calculaSalario());
	}

	//método abstrato: será implementado na subclasse
	public abstract double calculaSalario();

	public void addDisciplina(Disciplina disciplina) {
		if (disciplinas == null)
			disciplinas = new ArrayList<Disciplina>();
		
		disciplinas.add(disciplina);
	}
	
	public void removeDisciplina(Disciplina disciplina) {
		if (disciplinas != null)
			disciplinas.remove(disciplinas.indexOf(disciplina));
	}
	
	public void listaDisciplina() {
		System.out.println("Lista de Disciplinas:");
		if (disciplinas != null) {
			for (Disciplina disciplina : disciplinas) {
				System.out.println(disciplina.getNome());
			}
		}
		System.out.println("-------------");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
