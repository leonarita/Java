package B_Classe;

public class Veiculo {

	static int atributoEstatico = 1;
	
	float velocidadeAtual = 0f;
	long numeroDeSerie = 0;
	
	static String metodoEstatico () {
		return "Atributo estático vale " + atributoEstatico;
	}
	
	Veiculo () {
		numeroDeSerie = -1;
	}

	Veiculo(float velocidadeAtual, long numeroDeSerie) {
		this.velocidadeAtual = velocidadeAtual;
		this.numeroDeSerie = numeroDeSerie;
	}
	
	void acelerar(float deltaV) {
		velocidadeAtual += deltaV;
	}
	
	void brecar() {
		velocidadeAtual -= 1.0f;
	}
	
	void parar() {
		while(velocidadeAtual > 0)
			brecar();
		velocidadeAtual = 0;
	}
	
}
