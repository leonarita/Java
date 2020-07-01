package aula02;

import java.util.Scanner;

public class Exercicio02 
{
	public static void main (String[] args)
	{
		System.out.print("\n\nInforme um ano bissexto (0 a 9999): ");
		Scanner scan = new Scanner(System.in);
		int ano = scan.nextInt();
		
		scan.close();
		
		if ((ano%4==0 && ano%100!=0) || (ano%4==0 && ano%400==0))
			System.out.println("O ano é bissexto");
		else
			System.out.println("O ano não é bissexto");
		
	}
}
