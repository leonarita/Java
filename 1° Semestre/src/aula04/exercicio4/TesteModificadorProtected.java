package aula04.exercicio4;

public class TesteModificadorProtected {

	public static void main(String[] args) {
		
		Classe2 c = new Classe2(2, "Valor");
		
		System.out.println(c.gerarFraseWithoutMethod());
		System.out.println(c.gerarFraseWithMethod());
		
		System.out.println(c.getC().gerarFrase());
		System.out.println(c.getC().text + " " + c.getC().number);
		
		Classe2 c2 = c;
		c2.setC(new Classe1(3, "Valor novo"));
		 
		System.out.println();
		System.out.println(c.getC().gerarFrase());
		System.out.println(c2.getC().gerarFrase());

	}
}
