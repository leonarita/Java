package VIII_Grafos;

import java.util.Scanner;

public class C_ListaPrior
{
	static int vet[];
	static Scanner entrada = new Scanner(System.in);
	static int tam;
	
	public C_ListaPrior (int n)
	{	vet = new int[n+1];
		tam = 0;
	}

	public void inserir (int num, int dist[])
	{	int ind;
	
		if (tam < vet.length-1)
		{	tam++;
			ind = tam;
			
			while (ind>1 && dist[vet[Pai(ind)]] > dist[num])
			{	vet[ind] = vet[Pai(ind)];
				ind = Pai(ind);
			}
			
			vet[ind] = num;
		}
	}
	
	public static int Pai (int x)
	{	return x/2; 
	}
	
	public static void heap_fica (int i, int qtde, int dist[])
	{
		int f_esq, f_dir, menor, aux;
		menor = i;
		
		if (2*i+1 <= qtde)				//o nó que está sendo analisado tem filhos para esquerda
		{	f_esq = 2*i+1;
			f_dir = 2*i;
			
			if (dist[vet[f_esq]] < dist[vet[f_dir]] && dist[vet[f_esq]] < dist[vet[i]])
				menor=2*i+1;
			else if (dist[vet[f_esq]] > dist[vet[f_dir]]  && dist[vet[f_dir]] < dist[vet[i]])
				menor=2*i+1;
		}
		else if (2*i <= qtde)
		{	f_esq = 2*i;
			
			if (dist[vet[f_esq]] < dist[vet[i]] )
				menor=2*i;
		}
		
		if (menor!=1/* && X[i]!=X[menor]*/)
		{	aux = vet[i];
			vet[i] = vet[menor];
			vet[menor] = aux;
			
			heap_fica (menor, qtde, dist);
		}
	}

	public void controiheap (int dist[])
	{
		for (int i=tam/2; i>=1; i--)
			heap_fica (1, tam, dist);
	}
	
	public int remover (int dist[])
	{
		if (tam==0)
			System.out.print ("\n\n\tLista vazia!");
		else
		{	int menor_prior = vet[1];
			vet[1] = vet[tam];
			tam--;
			heap_fica (1, tam, dist);
			return menor_prior;
		}
		return 0;
	}
	
	public static void imprimir ()
	{
		for (int i=1; i<=tam; i++)
			System.out.print(vet[i]+" ");
	}
}
