package I_Conceitos_Iniciais;

import java.util.Scanner;

public class N_Introdu��o_�_M�todos 
{
	 public static void main(String[] args)
	 { 	double areaTotal = retangulo();
		areaTotal += retangulo();
		
		System.out.println ("A soma das �reas dos dois ret�ngulos � "+areaTotal);
	 }
		 
	public static double retangulo()		//void -> m�todo n�o retorna nada
	{
		Scanner input = new Scanner(System.in);
		double base, altura, areaRetangulo, areaTotal = 0;
		 
		System.out.println("Informe a base do ret�ngulo: ");
		base = input.nextDouble();
		System.out.println("Informe a altura do ret�ngulo: ");
		altura = input.nextDouble();
		areaRetangulo = base * altura;
		System.out.println("A �rea do ret�ngulo � "+areaRetangulo+"\n\n");

		areaTotal+=areaRetangulo;
		
		input.close();
		 
		return areaTotal;		//return finaliza o m�todo
	}
}