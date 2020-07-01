package I_Ordenações;

import java.util.Scanner;

public class E_SelectionSort 
{	public static void main (String args[])
	{	int X[] = new int[5];
		int i, j, eleito, menor, pos;
		
		Scanner entrada = new Scanner (System.in);
		
		for (i=0; i<=4; i++)
		{	System.out.println ("Digite o "+(i+1)+"° número: ");
			X[i] = entrada.nextInt();
		}
		
		for (i=0; i<=3; i++)
		{	eleito = X[i];
			menor = X[i+1];
			pos = i+1;
			
			for (j=i+1; j<=4; j++)
			{	if (X[j]<menor)
				{	menor = X[j];
					pos = j;
				}
			}
			
			if (eleito>menor)
			{	X[i] = X[pos];
				X[pos] = eleito;
			}
		}
		
		for (i=0; i<=4; i++)
			System.out.println ((i+1)+ "° número: "+X[i]);
		
		entrada.close();
	}
}
