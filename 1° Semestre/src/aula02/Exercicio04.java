package aula02;

import java.util.Scanner;

public class Exercicio04 
{
	public static void main(String[] args)
	{	Scanner sc = new Scanner(System.in);

		System.out.println("\n\nInforme o m�s: ");
		String mes = sc.nextLine().toLowerCase();
		sc.close();
		
		if (mes.equals("janeiro") || mes.contentEquals("fevereiro") || mes.equals("mar�o"))
			System.out.println("A esta��o � ver�o!");
		else if (mes.equals("abril") || mes.equals("maio") || mes.equals("junho"))
			System.out.println("A esta��o � outono!");
		else if (mes.equals("julho") || mes.equals("agosto") || mes.equals("setembro"))
			System.out.println("A esta��o � inverno!");
		else if (mes.equals("outubro") || mes.equals("novembro") || mes.equals("dezembro"))
			System.out.println("A esta��o � primavera!");
		else
			System.out.println("M�s " + mes + " inv�lido!");
	}
}
