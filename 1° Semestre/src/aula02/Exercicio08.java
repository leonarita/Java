package aula02;

import java.util.Scanner;

public class Exercicio08 
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner (System.in);
				
		System.out.print("Informe o número de nomes para armazenar: ");
		int num = sc.nextInt();
		sc.nextLine();
	
		String[] nome = new String[num];
		
		for (int i=0; i<num; i++)
		{
			System.out.print("Insira o " + (i+1) + "° nome: ");
			nome[i] = sc.nextLine();
		}
		
		sc.close();
		
		System.out.println("\n\nNomes cadastrados");
		for (String name : nome)
		{
			System.out.println("\t" + name);
		}
	}
}
