package sistema.gestaoEscolar;

public class Principal {

	public static void main(String[] args) {
		Disciplina banco = new Disciplina("Banco de Dados", 10);
		Disciplina lp2a4 = new Disciplina("Ling. Prog. Java Web ", 10);
		Disciplina lp3a5 = new Disciplina("Ling. Prog. Java II", 10);
		Disciplina engsoft = new Disciplina("Eng. de Software", 10);
		
		Aluno aluno1 = new Aluno("João");
		
		Tecnico tecnico = new Tecnico();
		tecnico.setNome("Aldo");
		tecnico.addBolsista(aluno1);
		tecnico.addDisciplina(banco);
		tecnico.addDisciplina(lp2a4);
		tecnico.removeDisciplina(lp2a4);
		tecnico.listaBolsistas();
		tecnico.listaDisciplina();
		tecnico.getSalario();
		
		
		Graduacao graduacao = new Graduacao();
		graduacao.setNome("Aldo");
		graduacao.setTitulacao(Titulacao.MESTRE);
		graduacao.addDisciplina(banco);
		graduacao.addDisciplina(engsoft);
		graduacao.addDisciplina(lp3a5);
		graduacao.addDisciplina(lp2a4);
		graduacao.listaDisciplina();
		graduacao.getSalario();
		
		PosGraduacao posGraduacao = new PosGraduacao();
		posGraduacao.setNome("João");
		posGraduacao.setTitulacao(Titulacao.ESPECIALISTA);
		//posGraduacao.setTitulacao(Titulacao.DOUTOR);
		posGraduacao.addDisciplina(banco);
		posGraduacao.listaDisciplina();
		posGraduacao.getSalario();
		
	}
}
