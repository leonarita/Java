package aula02;

import java.util.Scanner;

public class Exercicio07 
{
	public static void main (String[] args)
	{
		String[] codigo = new String[10];
		String[] nome = new String[10];
		float[] preco = new float[10];
		
		Scanner sc = new Scanner (System.in);
		
		for (int i=0; i<=9; i++)
		{
			System.out.print("\n\n" + (i+1) + "° Produto");
			System.out.print("\n\tCódigo: ");
			codigo[i] = sc.nextLine();
			System.out.print("\tNome: ");
			nome[i] = sc.nextLine();
			System.out.print("\tPreço: R$");
			preco[i] = sc.nextFloat();
			sc.nextLine();
		}
		
		System.out.println("\n\nInforme o valor máximo: ");
		float max = sc.nextFloat();
		
		sc.close();
		
		System.out.println("Produtos:");
		for (int i=0; i<=9; i++)
		{
			if (preco[i]<=max)
			{
				System.out.println("\tO produto " + nome[i] + " cujo código é " + codigo[i] + " custa R$" + preco[i]);
			}
		}
	}
}
