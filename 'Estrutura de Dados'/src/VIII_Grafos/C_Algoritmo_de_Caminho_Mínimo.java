package VIII_Grafos;

import java.util.Scanner;
import VIII_Grafos.C_ListaPrior;

public class C_Algoritmo_de_Caminho_Mínimo 
{	public static class vertice
	{	int num, peso;
		vertice prox;
	}
	
	public static class listaadj
	{
		public vertice listav;
	}
	
	static C_ListaPrior lista;
	static Scanner entrada = new Scanner (System.in);
	static int marcado[];
	static int pai[];
	static int dist[];
	static listaadj Adj[];
	
	public static void main(String args[])
	{	vertice novo;
		
		int tam, org, dest, op, num=0, flag=0, peso=0;
		
		System.out.print("\n\n\tDigite o número de vértices do grafo orientado: ");
		tam = entrada.nextInt();
		
		Adj = new listaadj[tam+1];
		marcado = new int[tam+1];
		pai = new int[tam+1];
		dist = new int[tam+1];
		
		for (int i=1; i<=tam; i++)
		{	Adj[i] = new listaadj();
			marcado[i]=0;
		}
		
		System.out.print("\n\n\tArestas do grafo: VérticeOrigem (-1 para parar): ");
		org = entrada.nextInt();
		
		System.out.print("\n\n\tArestas do grafo: VérticeDestino (-1 para parar): ");
		dest = entrada.nextInt();
		
		while (org!=-1 && dest!=-1)
		{	System.out.print("\n\n\tPeso da aresta: ");
			peso = entrada.nextInt();
			
			novo = new vertice();
			novo.num = dest;
			novo.peso = peso;
			novo.prox = Adj[org].listav;
			
			System.out.print("\n\n\tArestas do grafo: VérticeOrigem (-1 para parar): ");
			org = entrada.nextInt();
			
			System.out.print("\n\n\tArestas do grafo: VérticeDestino (-1 para parar): ");
			dest = entrada.nextInt();
		}
		
		do
		{	System.out.println ("\n\n\t\tMENU DE OPÇÕES");
			System.out.println ("\n\t1-Caminho Mínimo");
			System.out.println ("\t2-Mostrar lista de adjacencias");
			System.out.println ("\t3-Mostrar distâncias");
			System.out.println ("\t4-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			switch (op)
			{
				case 1:
					System.out.print("\n\n\tDigite um vértice de origem: ");
					num = entrada.nextInt();
					
					for (int i=1; i<=tam; i++)
					{	marcado[i] = 0;
						dist[i] = 0;
					}
					
					dijkstra (Adj, tam, num);
					flag=1;
					break;
				
				case 2:
					mostrar_Adj (Adj, tam);
					break;
				
				case 3:
					if (flag==0)
						System.out.print ("\n\n\tÉ necessário realizar a busca primeiro");
					else
						mostrar_dist (tam, num);
					break;
					
				case 4:
					System.out.print("\n\n\tAté a próxima!");
					break;
				
				default:
					System.out.print("\n\n\tComando inválido!");
			}
		}
		while (op!=4);
	}
	
	static void dijkstra(listaadj Adj[], int tam, int v)
	{	int i, w;
		int C[] = new int[tam];
		int tamC = 0;
		lista = new C_ListaPrior(tam);
		dist[v]=0;
		
		lista.inserir(v, dist);
		
		for (i=1; i<=tam; i++)
		{
			if (i!=v)
			{	dist[i] = Integer.MAX_VALUE;
				pai[i]=0;
				lista.inserir(i, dist);
			}
		}
		
		while (C_ListaPrior.tam != 0)
		{	w = lista.remover(dist);
			C[tamC] = w;
			tamC++;
			
			vertice x = Adj[w].listav;
			
			while (x!=null)
			{	relax (w, x.num, x.peso);
				x = x.prox;
			}
			lista.controiheap(dist);
		}
	}
	
	static void relax (int u, int v, int peso)
	{
		if (dist[v] > dist[u]+peso)
		{	dist[v] = dist[u] + peso;
			pai[v] = u;
		}
	}
	
	static void mostrar_Adj (listaadj Adj[], int tam)
	{	vertice v;
		
		for (int i=1; i<=tam; i++)
		{	v = Adj[i].listav;
			System.out.print("\n\n\tEntrada "+i+ " ");
			
			while (v!=null)
			{	System.out.print("("+i+", "+v.num+")" +"");
				v = v.prox;
			}
		}
	}
	
	static void mostrar_dist (int tam, int or)
	{	System.out.print("Distância da origem "+or+" para os demais vértice\n");
	
		for (int i=1; i<=tam; i++)
			System.out.println (""+i+"-"+dist[i]);
	}
}
