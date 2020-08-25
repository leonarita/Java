package sistema.gestaoEscolar;

import java.util.ArrayList;
import java.util.List;

public class Graduacao extends Professor implements NivelSuperior{

	private Titulacao titulacao;
	private int cargaHoraria;
	private List<Aluno> alunos;
	
	
	@Override
	public int getLimiteHora() {
		return limiteHora;
	}

	@Override
	public double getValorHora() {
		return valorHora;
	}

	@Override
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria += cargaHoraria;
	}

	@Override
	public void setTitulacao(Titulacao titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public boolean validaLimiteHora(int hora) {
		return (this.cargaHoraria + hora > getLimiteHora());
	}

	@Override
	public double calculaSalario() {
		double salario = this.cargaHoraria * getValorHora();
		
		if (this.titulacao == Titulacao.ESPECIALISTA)
			salario = salario * 3;
		else if (this.titulacao == Titulacao.MESTRE)
			salario = salario * 4;
		else if (this.titulacao == Titulacao.DOUTOR)
			salario = salario * 5;
		
		return salario;
	}
	
	public void addTCC(Aluno aluno) {
		if (alunos == null)
			alunos = new ArrayList<Aluno>();
		
		alunos.add(aluno);
	}
	
	public void removeTCC(Aluno aluno) {
		alunos.remove(alunos.indexOf(aluno));
	}

	public void listaTCC() {
		System.out.println("Lista de Orientados TCC:");
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
		System.out.println("-----------------");
	}
	
	public void addDisciplina(Disciplina disciplina) {
		if(!validaLimiteHora(disciplina.getCargaHoraria())) {
			super.addDisciplina(disciplina);
			setCargaHoraria(disciplina.getCargaHoraria());
		}
		else {
			System.out.println("Limite de horas atingido - CH prof:"+this.cargaHoraria+ 
					" CH Disciplina: " + disciplina.getCargaHoraria() + " Nome disc.: "+disciplina.getNome() );
		}
	}

}
