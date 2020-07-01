package V_Listas_De_Prioridade;

import java.util.Scanner;

public class B_Heap_Mínimo_Máximo
{
	static int vet[] = new int[11];
	static int tam;
	
	public static void main (String[] args)
	{	Scanner entrada = new Scanner(System.in);
		int op, mp, num;
		tam = 0;
		
		do
		{	System.out.print ("\n\n\t\tMENU DE OPÇÕES - HEAP MÁXIMO E MÍNIMO \n");
			System.out.print ("\n\t1-Inserir o elemento na lista de prioridades");
			System.out.print ("\n\t2-Consultar o elemento de menor prioridade");
			System.out.print ("\n\t3-Consultar o elemento de maior prioridade");
			System.out.print ("\n\t4-Remover o elemento de menor prioridade");
			System.out.print ("\n\t5-Remover o elemento de maior prioridade");
			System.out.print ("\n\t6-Consultar toda a lista");
			System.out.print ("\n\t7-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			if (op>7 || op<1)
				System.out.print ("\n\n\tOpção inválida!!");

			if (op==1)
			{	if (tam<=9)
				{	System.out.print ("\n\n\tDigite um número: ");
					num = entrada.nextInt();
					tam++;
					inserir_num (num, tam);
					System.out.print ("\n\n\t\tNúmero inserido!");
				}
				else
					System.out.print ("\n\n\tLista de prioridades lotada!");
			}
			
			if (op==2)
			{	if (tam==0)
					System.out.print ("\n\n\tLista de prioridades vazia!");
				else
					System.out.print ("\n\n\tElemento de menor prioridade: " +vet[1]);
			}
			
			if (op==3)
			{	if (tam==0)
					System.out.print ("\n\n\tLista de prioridades vazia!");
				else
				{	mp = maior_prior ();
					System.out.print ("\n\n\tElemento de maior prioridade: " +vet[mp]);
				}
			}
			
			if (op==4)
			{	if (tam==0)
					System.out.print ("\n\n\tLista de prioridades vazia!");
				else
				{	System.out.print ("\n\n\tO elemento removido: " +vet[1]);
					vet[1] = vet[tam];
					tam--;
					descer (1);
				}
			}
			
			if (op==5)
			{	if (tam==0)
					System.out.print ("\n\n\tLista de prioridades vazia!");
				else if (tam==2)
					tam=1;
				else
				{	int max=2;
				
					if (tam>=3)
					{
						if (vet[3]>vet[2])
							max=3;
					}
					
					System.out.print ("\n\n\tO elemento removido: " +vet[max]);
					vet[max] = vet[tam];
					tam--;
					descer (max);
				}
			}
			
			if (op==6)
				impressao ();
			
			if (op==7)
			{	System.out.print ("\n\n\tAté a próxima!!");
				entrada.close();
			}
		}
		while (op!=7);
	}
	
	static void inserir_num (int num, int i)
	{	vet[i] = num;
		subir (i);
	}
	
	static void subir (int i)
	{	int pai = i/2;

		if (minimo(i))
		{
			if (pai>=1)
			{
				if (vet[i]>vet[pai])
				{	trocar (i, pai);
					subir_max (pai);
				}
				else
					subir_min (pai);
			}
		}
		else
		{
			if (pai>=1)
			{
				if (vet[i]<vet[pai])
				{	trocar (i, pai);
					subir_min (pai);
				}
				else
					subir_max (i);
			}
		}
	}
	
	static void subir_min (int i)
	{	int avo = i/4;
	
		if (avo>=1 && vet[i]<vet[avo])
		{	trocar (i, avo);
			subir_min (avo);
		}
	}
	
	static void subir_max (int i)
	{	int avo = i/4;

		if (avo>=1 && vet[i]>vet[avo])
		{	trocar (i, avo);
			subir_max (avo);
		}
	}
	
	static int maior_prior ()
	{
		if (tam==1)
			return 1;
		else if (tam>2 && vet[3]>vet[2])
			return 3;
		else
			return 2;
	}
	
	static void descer (int i)
	{
		if (minimo(i))
			descer_min (i);
		else
			descer_max (i);
	}
	
	static boolean minimo (int i)
	{	int nivel = ((int)(Math.log(i)/Math.log(2)))+1;
	
		if (nivel%2==0)
			return false;
		else
			return true;
	}
	
	static void descer_min (int i)
	{
		if (2*i<=tam)
		{	int m = min_descendente (i);
		
			if (vet[i]>vet[m])
			{	trocar (i, m);
			
				if (m >= 4*i)
				{	int p=m/2;
					
					if (vet[p]<vet[m])
						trocar (p, m);
						
					descer_min (m);
				}
			}
		}
	}
	
	static void descer_max (int i)
	{
		if (2*i<=tam)
		{	int m = max_descendente (i);
		
			if (vet[i]<vet[m])
			{	trocar (i, m);
			
				if (m >= 4*i)
				{	int p=m/2;
					
					if (vet[p]>vet[m])
						trocar (p, m);
						
					descer_max (m);
				}
			}
		}
	}
	
	static int min_descendente (int i)
	{	int m=0;
	
		if (2*i<=tam)
		{
			m = 2*i;
			
			if (vet[m+1]<vet[m])
				m++;
				int k;
			
				for (k=4*i; (k<=4*i+3) && k<=tam; k++)
					if (vet[k]<vet[m])
						m = k;
		}
		return m;
	}
	
	static int max_descendente (int i)
	{	int m=0;

		if (2*i<=tam)
		{	m=2*i;
		
			if (vet[m+1]>vet[m])
				m++;
			
			int k;
			for (k=4*i; (k<=4*i+3) && k<=tam; k++)
				if (vet[k]>vet[m])
					m = k;
		}
		return m;
	}
	
	static void impressao ()
	{
		if (tam==0)
			System.out.print ("\n\n\tLista de prioridades vazia!");
		else
		{	System.out.print ("\n\n\tTodos os elementos da lista de prioridades: ");
			
			for (int j=1; j<=tam; j++)
				System.out.print (vet[j]+" ");
			
			System.out.println();
		}
	}
	
	static void trocar (int x, int y)
	{	int temp;
		temp = vet[x];
		vet[x] = vet[y];
		vet[y] = temp;
	}
}
