package VIII_Grafos;

import java.util.Scanner;

public class A_Algoritmo_de_Busca_em_Profundidade
{
	public static class vertice
	{	int num;
		vertice prox;
	}
	
	public static class listaadj
	{	public vertice listav;	}

	public static class queue
	{	int numv;
		queue prox;
	}
	
	static Scanner entrada = new Scanner (System.in);

	static queue pilha = null;
	static int marcado[];
	static listaadj Adj[];
	
	public static void empilhar (int n)
	{	queue novo = new queue ();
		novo.numv = n;
		novo.prox = pilha;
		pilha = novo;
	}
	
	public static void desempilhar (int v)
	{
		if (pilha.numv == v)
			pilha = pilha.prox;
	}
	
	static void buscaprof (listaadj Adj[], int tam, int v)
	{	vertice vert;
		int w;
		marcado[v]=1;
		empilhar (v);
		
		for (int i=1; i<=tam; i++)
		{	vert = Adj[v].listav;
		
			while (vert!=null)
			{	w = vert.num;
				
				if (marcado[w]!=1)
				{	System.out.print(" "+w);
					buscaprof (Adj, tam, w);
				}
				vert = vert.prox;
			}
		}
		desempilhar (v);
	}
	
	static void mostrar_Adj (listaadj Adj[], int tam)
	{	vertice v;
		
		for (int i=1; i<tam; i++)
		{	v = Adj[i].listav;
			System.out.print("Entrada "+i+" ");
			
			while (v!=null)
			{	System.out.println("("+i+","+v.num+") ");
				v = v.prox;
			}
		}
	}
	
	public static void main (String args[])
	{	vertice novo;
		int tam, org, dest, op, num, tipo;
		
		System.out.print ("\n\n\t\tTipos de Grafos\n");
		System.out.print ("\n\t1-Não Orientado \n\t2-Orientado");
		System.out.print ("\n\nInsira o tipo de grafo desejado: ");
		tipo = entrada.nextInt();
		
		System.out.print ("\n\nInsira o número de vértices do grafo: ");
		tam = entrada.nextInt();
		
		Adj = new listaadj[tam+1];
		marcado = new int[tam+1];
		
		for (int i=1; i<=tam; i++)
		{	Adj[i] = new listaadj();
			marcado[i]=0;
		}
		
		System.out.print("\n\n\tArestas do grafo: VérticeOrigem (-1 para parar): ");
		org = entrada.nextInt();
		
		System.out.print("\n\n\tArestas do grafo: VérticeDestino (-1 para parar): ");
		dest = entrada.nextInt();
		
		while (org!=-1 && dest!=-1)
		{	novo = new vertice();
			novo.num = dest;
			novo.prox = Adj[org].listav;
			
			if (tipo==1)
			{	novo= new vertice();
				novo.num = org;
				novo.prox = Adj[dest].listav;
				Adj[dest].listav = novo;
			}
			
			System.out.print("\n\n\tArestas do grafo: VérticeOrigem (-1 para parar): ");
			org = entrada.nextInt();
			
			System.out.print("\n\n\tArestas do grafo: VérticeDestino (-1 para parar): ");
			dest = entrada.nextInt();
		}
		
		do
		{	System.out.println ("\n\n\t\tMENU DE OPÇÕES");
			System.out.println ("\n\t1-Busca em profundidade");
			System.out.println ("\t2-Mostrar lista de adjacencias");
			System.out.println ("\t3-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			switch (op)
			{
				case 1:
					System.out.print("\n\n\tDigite um vértice da partida de busca: ");
					num = entrada.nextInt();
					
					System.out.print(" "+ num);
					buscaprof (Adj, tam, num);
					
					for (int i=1; i<=tam; i++)
					{	marcado[i] = 0;	}
					
					break;
				
				case 2:
					mostrar_Adj (Adj, tam);
					break;
					
				case 3:
					System.out.print("\n\n\tAté a próxima!");
					break;
				
				default:
					System.out.print("\n\n\tComando inválido!");
			}
		}
		while (op!=3);
	}
	
}