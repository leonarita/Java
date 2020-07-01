package aula02;

import java.util.Scanner;

public class Exercicio06 
{
	public static void main(String[] args) 
	{	Scanner sc = new Scanner(System.in);

		String[] nome = new String[10];
		int[] idade = new int[10];
		
		for (int i=0; i<=9; i++)
		{	System.out.print("\n\n" + (i+1) + "° Pessoa");
			System.out.print("\n\tNome: ");
			nome[i] = sc.nextLine();
			System.out.print("\tIdade: ");
			idade[i] = sc.nextInt();
			sc.nextLine();
		}
		
		System.out.print("\n\nInforme a idade mínima: ");
		int idadeMin = sc.nextInt();
		
		System.out.println("Cadastros que possuem a idade mínima:");
		for (int i=0; i<=9; i++)
		{	if (idadeMin <= idade[i])
				System.out.println("\tNome " + nome[i] + ", cuja idade é " + idade[i]);
		}
		
		sc.close();
	}

}