package VIII_Grafos;

import java.util.Scanner;

public class B_Algoritmo_de_Busca_em_Largura 
{
	public static class vertice
	{	int num;
		vertice prox;
	}
	
	public static class listaadj
	{	public vertice listav;	}

	public static class fila
	{	int numv;
		fila prox;
	}
	
	public static void inserir (int n)
	{	fila novo = new fila();
		
		novo.numv = n;
		novo.prox = null;
		
		if (inicio==null)
			inicio = fim = novo;
		else
		{	fim.prox = novo;
			fim = novo;
		}
	}
	
	public static int remover()
	{
		if (inicio!=null)
		{	int vert;
		
			if (inicio==fim)
				fim = null;
			
			vert = inicio.numv;
			inicio = inicio.prox;
			return vert;
		}
		System.out.print("\n\n\tLista vazia!");
		return 0;
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
	
	static void mostrar_dist (int tam, int or)
	{	System.out.println("Distância da origem "+or+" para os demais vértices");
		
		for (int i=1; i<=tam; i++)
			System.out.println(""+i+"-"+dist[i]);
	}
	
	static void buscalargura (listaadj Adj[], int tam, int v)
	{	vertice listavert;
		
		int w, vertice;
		
		marcado[v] = 1;
		dist[v] = 0;
		inserir (v);
		
		while (inicio!=null)
		{	vertice = remover ();
			
			for (int i=1; i<=tam; i++)
			{	listavert = Adj[vertice].listav;
			
				while (listavert != null)
				{	w = listavert.num;
				
					if (marcado[w]==0)
					{	marcado[w]=1;
						dist[w] = dist[vertice]+1;
						inserir (w);
					}
					listavert = listavert.prox;
				}
			}
		}
	}
	
	static fila inicio=null, fim=null;
	static int marcado[], dist[];
	static listaadj Adj[];
	
	static Scanner entrada = new Scanner (System.in);

	public static void main (String args[])
	{	vertice novo;
		int tam, org, dest, op, num=0, tipo, flag=0;
		
		System.out.print ("\n\n\t\tTipos de Grafos\n");
		System.out.print ("\n\t1-Não Orientado \n\t2-Orientado");
		System.out.print ("\n\nInsira o tipo de grafo desejado: ");
		tipo = entrada.nextInt();
		
		System.out.print ("\n\nInsira o número de vértices do grafo: ");
		tam = entrada.nextInt();
		
		Adj = new listaadj[tam+1];
		marcado = new int[tam+1];
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
		{	novo = new vertice();
			novo.num = dest;
			novo.prox = Adj[org].listav;
			Adj[org].listav = novo;
			
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
			System.out.println ("\n\t1-Busca em largura");
			System.out.println ("\t2-Mostrar lista de adjacencias");
			System.out.println ("\t3-Menor distância a partir do vértice de origem");
			System.out.println ("\t4-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			switch (op)
			{
				case 1:
					System.out.print("\n\n\tDigite um vértice da partida de busca: ");
					num = entrada.nextInt();
					
					for (int i=1; i<=tam; i++)
					{	marcado[i] = 0;
						dist[i] = 0;
					}
					
					buscalargura (Adj, tam, num);
					flag = 1;
					break;
				
				case 2:
					mostrar_Adj (Adj, tam);
					break;
					
				case 3:
					if (flag==0)
						System.out.print("\n\n\tÉ necessário realizar a busca primeiro");
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
}
