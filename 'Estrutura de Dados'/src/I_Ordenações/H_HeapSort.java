package I_Ordenações;
import java.util.*;

public class H_HeapSort 
{
	static int X[] = new int[11];
	static Scanner entrada = new Scanner (System.in);
	
	public static void main (String args[])
	{	int i, qtde;
	
		for (i=1; i<=10; i++)
		{	System.out.print ("Digite o "+i+ "° número: ");
			X[i] = entrada.nextInt();
		}
		
		qtde=10;
		transforma_heap(qtde);
		ordena (qtde);
		
		for (i=1; i<=10; i++)
			System.out.println (i+"° número: "+X[i]);
	
		entrada.close();
	}
	
	public static void heap_fica (int i, int qtde)
	{
		int f_esq, f_dir, maior, aux;
		maior = i;
		
		if (2*i+1 <= qtde)				//o nó que está sendo analisado tem filhos para esquerda
		{	f_esq = 2*i+1;
			f_dir = 2*i;
			
			if (X[f_esq]>=X[f_dir] && X[f_esq]>X[i])
				maior=2*i+1;
			else if (X[f_dir]>X[f_esq] && X[f_dir]>X[i])
				maior=2*i;
		}
		else if (2*i <= qtde)			//o nó que está sendo analisado tem filhos para direita
		{	f_dir = 2*i;
			
			if (X[f_dir]>X[i])
				maior=2*i;
		}
		
		if(maior!=1 && X[i]!=X[maior])
		{	aux=X[i];
			X[i]=X[maior];
			X[maior]=aux;
			
			heap_fica (maior, qtde);
		}
	}

	public static void transforma_heap (int qtde)
	{	int i;
		
		for (i=qtde/2; i>=1; i--)
		{	heap_fica(i, qtde);		}
	}

	public static void ordena (int qtde)
	{	int i, aux, ultima_posi;

		for (i=qtde; i>=2; i--)
		{	aux=X[1];
			X[1]=X[i];
			X[i]=aux;
			ultima_posi = i-1;
			heap_fica(1, ultima_posi);
		}
	}
}
