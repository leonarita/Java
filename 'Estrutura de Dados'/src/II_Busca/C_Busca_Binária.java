package II_Busca;

import java.util.Scanner;

public class C_Busca_Binária 
{	public static void main (String args[])
	{	int X[] = new int[10];
		int np, i, achou, inicio, meio, fim;
		
		Scanner entrada = new Scanner (System.in);
		
		for (i=0; i<=9; i++)
		{	System.out.print("Digite o "+(i+1)+"° número: ");
			X[i] = entrada.nextInt();
		}
		
		System.out.print("\n\tDigite o número a ser buscado no vetor: ");
		np = entrada.nextInt();
		
		achou=0;
		inicio=0;
		fim=9;
		meio = (inicio+fim)/2;
		
		while (inicio<=fim && achou==0)
		{
			if (X[meio]==np)
				achou=1;
			else
			{	if (np < X[meio])
					fim = meio - 1;
				else
					inicio = meio + 1;
				meio = (inicio+fim)/2;
			}
		}
		
		if (achou==0)
			System.out.println("Número não encontrado no vetor!");
		else
			System.out.println("Número encontrado na posição "+(meio+1));
		
		entrada.close();
	}
}