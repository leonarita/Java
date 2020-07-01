package aula02;

import java.util.Scanner;

public class Exercicio11 
{
	public static void main (String[] args)
	{
		String[] nomes = new String[10];
		
		Scanner sc = new Scanner (System.in);
		int i=0;
		
		while (i!=10)
		{
			System.out.print("Informe o " + (i+1) + "° nome: ");
			nomes[i] = sc.nextLine();
			i++;
		}
		
		i=0;
		System.out.println("\n\n\tInforme o nome para consulta: ");
		String consulta = sc.nextLine();
		
		while (i!=10)
		{
			if (nomes[i].equals(consulta))
			{	System.out.println("\n" + consulta + " encontrado na posição " + (i+1));
				break;
			}
			i++;
		}
		
		sc.close();
	}
}
