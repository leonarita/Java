package II_Busca;

import java.util.Scanner;

public class C_Busca_Bin�ria 
{	public static void main (String args[])
	{	int X[] = new int[10];
		int np, i, achou, inicio, meio, fim;
		
		Scanner entrada = new Scanner (System.in);
		
		for (i=0; i<=9; i++)
		{	System.out.print("Digite o "+(i+1)+"� n�mero: ");
			X[i] = entrada.nextInt();
		}
		
		System.out.print("\n\tDigite o n�mero a ser buscado no vetor: ");
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
			System.out.println("N�mero n�o encontrado no vetor!");
		else
			System.out.println("N�mero encontrado na posi��o "+(meio+1));
		
		entrada.close();
	}
}