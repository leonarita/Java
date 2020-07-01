package aula02;

import java.util.Scanner;

public class Exercicio04 
{
	public static void main(String[] args)
	{	Scanner sc = new Scanner(System.in);

		System.out.println("\n\nInforme o mês: ");
		String mes = sc.nextLine().toLowerCase();
		sc.close();
		
		if (mes.equals("janeiro") || mes.contentEquals("fevereiro") || mes.equals("março"))
			System.out.println("A estação é verão!");
		else if (mes.equals("abril") || mes.equals("maio") || mes.equals("junho"))
			System.out.println("A estação é outono!");
		else if (mes.equals("julho") || mes.equals("agosto") || mes.equals("setembro"))
			System.out.println("A estação é inverno!");
		else if (mes.equals("outubro") || mes.equals("novembro") || mes.equals("dezembro"))
			System.out.println("A estação é primavera!");
		else
			System.out.println("Mês " + mes + " inválido!");
	}
}
