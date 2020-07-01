package I_Ordenações;
import java.util.Scanner;

public class G_QuickSort
{
	public static void main (String args[])
	{	int X[] = new int [10];
		int i;
		Scanner entrada = new Scanner (System.in);
		
		for (i=0; i<=9; i++)
		{	System.out.println("Digite o "+(i+1)+"° número: ");
			X[i] = entrada.nextInt();
		}
		
		quick (X, 0, 9);
		
		for (i=0; i<=9; i++)
			System.out.println ((i+1)+ "° número: "+X[i]);
		
		entrada.close();
	}

	public static void troca (int X[], int a, int b)
	{	int aux;
	
		aux = X[a];
		X[a] = X[b];
		X[b] = aux;
	}
	
	public static int particao (int X[], int inicio, int fim)
	{	int pivo;
		pivo = X[(inicio+fim)/2];
		inicio = inicio-1;
		fim = fim+1;
		
		while (inicio<fim)
		{	do	{	inicio++;	}	while (X[inicio] < pivo);
			do	{	fim--;		}	while (X[fim] > pivo);
			if (inicio<fim)
				troca (X, inicio, fim);
		}
		
		return fim;
	}

	public static void quick (int X[], int inicio, int fim)
	{	int meio;
	
		if (inicio<fim)
		{	meio = particao (X, inicio, fim);
			quick (X, inicio, meio);
			quick (X, meio+1, fim);
		}
	}

}
