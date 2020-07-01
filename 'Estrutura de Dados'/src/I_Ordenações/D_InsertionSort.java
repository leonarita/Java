package I_Ordenações;
import java.util.*;

public class D_InsertionSort
{	public static void main (String args[])
	{	int X[] = new int[5];
		int i, j, eleito;
		
		Scanner entrada = new Scanner (System.in);
		
		for (i=0; i<=4; i++)
		{	System.out.println ("Digite o "+(i+1)+"° número: ");
			X[i] = entrada.nextInt();
		}
		
		for (i=1; i<=4; i++)
		{	eleito = X[i];
			j = i - 1;
			
			while (j>=0 && X[j]>eleito)
			{	X[j+1] = X[j];
				j = j - 1;
			}
			X[j+1] = eleito;
		}
		
		for (i=0; i<=4; i++)
			System.out.println ((i+1)+ "° número: "+X[i]);
		
		entrada.close();
	}
}