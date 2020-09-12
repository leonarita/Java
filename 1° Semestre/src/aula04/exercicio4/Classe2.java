package aula04.exercicio4;

public class Classe2 {
	
	private Classe1 c;

	public Classe2(int i, String t) {
		c = new Classe1(i, t);
	}

	public Classe1 getC() {
		return c;
	}

	public void setC(Classe1 c) {
		this.c = c;
	}

	public String gerarFraseWithoutMethod() {
		return c.text + " " + c.number;
	}
	
	public String gerarFraseWithMethod() {
		return c.gerarFrase();
	}
}
