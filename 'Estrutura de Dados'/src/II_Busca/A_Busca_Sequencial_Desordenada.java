package II_Busca;

import java.util.Scanner;

public class A_Busca_Sequencial_Desordenada 
{	public static void main (String args[])
	{	int X[] = new int[10];
		int n, i, achou;
		
		Scanner entrada = new Scanner (System.in);
		
		for (i=0; i<=9; i++)
		{	System.out.print("Digite o "+(i+1)+"° número: ");
			X[i] = entrada.nextInt();
		}
		
		System.out.print("\n\tDigite o número a ser buscado no vetor: ");
		n = entrada.nextInt();
		
		achou=0;
		i=0;
		
		while (i<=9 && achou==0)
		{
			if (X[i]==n)
				achou=1;
			else
				i++;
		}
		
		if (achou==0)
			System.out.println("Número não encontrado no vetor!");
		else
			System.out.println("Número encontrado na posição "+(i+1));
		
		entrada.close();
	}
}