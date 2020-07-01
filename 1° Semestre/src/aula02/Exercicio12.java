package aula02;

import java.util.Scanner;

public class Exercicio12 
{
	public static void main (String[] args)
	{
		String[] nomes = new String[10];
		float[] alturas = new float[10];
	
		Scanner sc = new Scanner (System.in);
		int i=0;
		
		while (i!=10)
		{	System.out.print("\n\n" + (i+1) + "° Cadastro");
			System.out.print("\n\tNome: ");
			nomes[i] = sc.nextLine();
			System.out.print("\tAltura: ");
			alturas[i] = sc.nextFloat();
			i++;
			sc.nextLine();
		}
		
		i=0;
		System.out.println("\n\n\tInforme a altura mínima: ");
		float consulta = sc.nextFloat();
		
		System.out.println("\n\nCadastros com altura maior do que " + consulta + " ");
		while (i!=10)
		{
			i++;
			
			if (consulta<=alturas[i-1])
				System.out.print(nomes[i-1] + " ");
			else
				continue;
		}
		
		sc.close();
	}
}
