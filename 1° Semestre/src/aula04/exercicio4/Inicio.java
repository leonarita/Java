package aula04.exercicio4;

public class Inicio {

	public static void main(String[] args) {
		
		Classe2 c = new Classe2(2, "Valor");
		
		System.out.println(c.gerarFraseWithoutMethod());
		System.out.println(c.gerarFraseWithMethod());
		
		System.out.println(c.getC().gerarFrase());
		System.out.println(c.getC().text + " " + c.getC().number);
	}

}
