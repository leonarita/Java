package I_Conceitos_Iniciais;

import java.util.Scanner;

public class N_Introdução_À_Métodos 
{
	 public static void main(String[] args)
	 { 	double areaTotal = retangulo();
		areaTotal += retangulo();
		
		System.out.println ("A soma das áreas dos dois retângulos é "+areaTotal);
	 }
		 
	public static double retangulo()		//void -> método não retorna nada
	{
		Scanner input = new Scanner(System.in);
		double base, altura, areaRetangulo, areaTotal = 0;
		 
		System.out.println("Informe a base do retângulo: ");
		base = input.nextDouble();
		System.out.println("Informe a altura do retângulo: ");
		altura = input.nextDouble();
		areaRetangulo = base * altura;
		System.out.println("A área do retângulo é "+areaRetangulo+"\n\n");

		areaTotal+=areaRetangulo;
		
		input.close();
		 
		return areaTotal;		//return finaliza o método
	}
}