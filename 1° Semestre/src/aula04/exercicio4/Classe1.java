package aula04.exercicio4;

public class Classe1 {

	protected int number;
	protected String text;

	public Classe1(int number, String text) {
		this.number = number;
		this.text = text;
	}
	
	protected String gerarFrase() {
		return text + " " + number;
	}
}
