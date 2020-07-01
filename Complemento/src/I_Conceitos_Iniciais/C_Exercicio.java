package I_Conceitos_Iniciais;

import java.util.Scanner;

public class C_Exercicio {
	public static void main(String args[]){
		double base, altura, areaRetangulo;
		Scanner input = new Scanner(System.in);
		
		System.out.println ("\n\nInforme o valor da base: ");
		base = input.nextDouble();
	
		System.out.println ("Informe o valor da altura: ");
		altura = input.nextDouble();

		areaRetangulo= base*altura;
	
		System.out.println ("\nA área de um retângulo de base "+base);
		System.out.print (" e altura "+altura);
		System.out.print (" é "+areaRetangulo);
		
		input.close();
	}
}