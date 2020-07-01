package aula02;

import java.util.Scanner;

public class Exercicio05 
{
	public static void main(String[] args) 
	{
		String[] prod = new String[10];
		Scanner sc = new Scanner (System.in);
		
		for (int i=0; i<=9; i++)
		{	System.out.print("Informe o nome do " + (i+1) + "° produto: ");
			prod[i] = sc.nextLine();
			//sc.hasNextLine();
		}
		
		System.out.print("\n\n\tInforme a faixa mínima de produto: ");
		int min = sc.nextInt();
		System.out.print("\tInforme a faixa máxima de produto: ");
		int max = sc.nextInt();
		
		sc.close();
		
		System.out.print("\n\n\t\tProdutos dentro da faixa: ");
		for (int i=min-1; i<max; i++)
			System.out.print(prod[i] + " ");
	}

}
