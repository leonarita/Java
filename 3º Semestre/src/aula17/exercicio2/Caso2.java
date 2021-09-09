package aula17.exercicio2;

public class Caso2 {
	
	// PARAMETRIZAR MÉTODO
	
	private double salario;

	public void aumentarSalalario(double fator) {
		salario *= (1 + fator);
	}
	
	public double get_salario() {
		return this.salario;
	}

}
