package sistemaGestaoEscolar;

public class PosGraduacao extends Professor implements NivelSuperior{

	private Titulacao titulacao;
	private int cargaHoraria;
	
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
		validaTitulacao();
	}

	private boolean validaTitulacao() {
		if (this.titulacao == Titulacao.ESPECIALISTA) {
			System.out.println("Especialista não pode leciona na pós ");
			return false;
		}
		else
			return true; 
	}

	@Override
	public boolean validaLimiteHora(int hora) {
		return (this.cargaHoraria + hora > getLimiteHora());
	}

	@Override
	public double calculaSalario() {
		double salario = this.cargaHoraria * getValorHora();
		
		if (this.titulacao == Titulacao.MESTRE)
			salario = salario * 6;
		else if (this.titulacao == Titulacao.DOUTOR)
			salario = salario * 7;
		
		return salario;
	}

	public void addDisciplina(Disciplina disciplina) {
		if (validaTitulacao()) {
			if (!validaLimiteHora(disciplina.getCargaHoraria())) {
				super.addDisciplina(disciplina);
				setCargaHoraria(disciplina.getCargaHoraria());
			}
			else {
				System.out.println("Limite de horas atingido - CH prof:"+this.cargaHoraria+ 
						" CH Disciplina: " + disciplina.getCargaHoraria() + " Nome disc.: "+disciplina.getNome() );
			}
		}
	}
		
	
}
