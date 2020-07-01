package I_Ordenações;

import java.util.Scanner;

public class C_BubbleSort
{	public static void main (String args[])
	{	int X[] = new int[5];
		int n, aux, troca;
		
		Scanner entrada = new Scanner (System.in);
		
		for (int i=0; i<=4; i++)
		{	System.out.println ("Digite o "+(i+1)+ "° número:");
			X[i] = entrada.nextInt();
		}
		
		n=1;
		troca=1;
		
		while (n<=5 && troca==1)
		{	troca=0;
			
			for (int i=0; i<=3; i++)
			{	if (X[i] < X[i+1])
				{	troca=1;
					aux = X[i];
					X[i] = X[i+1];
					X[i+1] = aux;
				}
			}
			n = n + 1;
		}
		
		for (int i=0; i<=4; i++)
			System.out.println ((i+1)+ "° número: "+X[i]);
		
		entrada.close();
	}
}
