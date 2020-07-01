package I_Ordenações;
import java.util.Scanner;

public class B_BubbleSort
{	public static void main (String args[])
	{	int X[] = new int[5];
		int aux;
		
		Scanner entrada = new Scanner (System.in);
		
		for (int i=0; i<=4; i++)
		{	System.out.println ("Digite o "+(i+1)+ "° número:");
			X[i] = entrada.nextInt();
		}
		
		for (int j=1; j<=4; j++)
		{	for (int i=4; i>=j; i--)
			{	if (X[i]>X[i-1])
				{	aux = X[i];
					X[i] = X[i-1];
					X[i-1] = aux;
				}
			}
		}
		
		for (int i=0; i<=4; i++)
			System.out.println ((i+1)+ "° número: "+X[i]);
		
		entrada.close();
	}
}
