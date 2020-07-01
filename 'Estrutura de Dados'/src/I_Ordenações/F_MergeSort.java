 package I_Ordena��es;

import java.util.Scanner;

public class F_MergeSort 
{	public static void main (String args[])
	{	int X[] = new int [10];
		int i;
		Scanner entrada = new Scanner (System.in);
		
		for (i=0; i<=9; i++)
		{	System.out.println("Digite o "+(i+1)+"� n�mero: ");
			X[i] = entrada.nextInt();
		}
		
		merge (X, 0, 9);
		
		for (i=0; i<=9; i++)
			System.out.println ((i+1)+ "� n�mero: "+X[i]);
		
		entrada.close();
	}

	public static void merge (int X[], int inicio, int fim)
	{	int meio;
		
		if (inicio<fim)
		{	meio = (inicio+fim)/2;
			merge (X, inicio, meio);
			merge (X, meio+1, fim);
			intercala (X, inicio, meio, fim);
		}
	}
	
	public static void intercala (int X[], int inicio, int meio, int fim)
	{	int inicio_vetor1, inicio_vetor2, i, poslivre;
		int aux[] = new int[10];
		
		inicio_vetor1 = inicio;
		inicio_vetor2=meio+1;
		poslivre=inicio;
		
		while (inicio_vetor1<=meio && inicio_vetor2<=fim)
		{	if (X[inicio_vetor1]<X[inicio_vetor2])
			{	aux[poslivre] = X[inicio_vetor1];
				inicio_vetor1++;
			}
			else
			{	aux[poslivre] = X[inicio_vetor2];
				inicio_vetor2++;
			}
			poslivre++;
		}
		
		for (i=inicio_vetor1; i<=meio; i++)
		{	aux[poslivre] = X[i];
			poslivre++;
		}
		
		for (i=inicio_vetor2; i<=fim; i++)
		{	aux[poslivre] = X[i];
			poslivre++;
		}
		
		for (i=inicio; i<=fim; i++)
			X[i] = aux[i];
	}
}