package VII_�rvores;

import java.util.Scanner;

public class A_�rvore_Bin�ria_Sem_Recurs�o 
{
	private static class ARVORE
	{	public int num;
		public ARVORE dir, esq;
	}
	
	private static class PILHA
	{	public PILHA prox;
		public ARVORE num;
	}
	
	public static void main (String args[])
	{	Scanner entrada= new Scanner (System.in);

		ARVORE raiz = null;
		ARVORE aux, aux1, novo, anterior;
		PILHA topo, aux_pilha;
		int op, achou, numero;
		
		do
		{	System.out.print ("\n\n\t\tMENU DE OP��ES \n");
			System.out.print ("\n\t1-Inserir na �rvore");
			System.out.print ("\n\t2-Consultar um n� da �rvore");
			System.out.print ("\n\t3-Consultar toda a �rvore em ordem");
			System.out.print ("\n\t4-Consultar toda a �rvore em pr�-ordem");
			System.out.print ("\n\t5-Consultar toda a �rvore em p�s-ordem");
			System.out.print ("\n\t6-Excluir um n� de �rvore");
			System.out.print ("\n\t7-Esvaziar a �rvore");
			System.out.print ("\n\t8-Sair");
			System.out.print ("\n\nDigite sua op��o: ");
			op = entrada.nextInt();
			
			if (op<1 || op>8)
				System.out.print ("\n\n\tOp��o inv�lida!");
				
			else if (op==1)
			{	System.out.print ("\n\n\tDigite o n�mero a ser inserido na �rvore: ");
				novo = new ARVORE ();
				novo.num = entrada.nextInt();
				novo.dir = null;
				novo.esq = null;
				
				if (raiz==null)
					raiz = novo;
				else
				{	aux = raiz;
					achou = 0;
					
					while (achou==0)
					{
						if (novo.num < aux.num)
						{
							if (aux.esq == null)
							{	aux.esq = novo;
								achou = 1;
							}
							else
								aux = aux.esq;
						}
						else if (novo.num >= aux.num)
						{
							if (aux.dir == null)
							{	aux.dir = novo;
								achou = 1;
							}
							else
								aux = aux.dir;
						}
					}
				}
				System.out.print ("\n\t\tN�mero inserido na �rvore!!");
			}
			
			else if (op==2)
			{
				if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!!");
				else
				{	System.out.print ("\n\n\tDigite o elemento a ser consultado: ");
					numero = entrada.nextInt();
					achou=0;
					aux = raiz;
					
					while (aux!=null && achou==0)
					{	if (aux.num == numero)
						{	System.out.print ("\n\n\tN�mero encontrado na �rvore!");
							achou = 1;
						}
						else if (numero < aux.num)
							aux = aux.esq;
						else
							aux = aux.dir;
					}
					
					if (achou==0)
						System.out.print ("\n\n\tN�mero n�o encontrado na �rvore!");
				}
			}
			
			else if (op==3)
			{
				if (raiz==null)
				{	System.out.print ("\n\n\t�rvore vazia!!");
				}
				else
				{	System.out.print ("\n\n\tListando todos os elementos da �rvore em ordem: ");
					aux = raiz;
					topo = null;
					
					do
					{	while (aux!=null)
						{	aux_pilha = new PILHA();
							aux_pilha.num = aux;
							aux_pilha.prox = topo;
							topo = aux_pilha;
							aux = aux.esq;
						}
						
						if (topo!=null)
						{	aux_pilha = topo;
							System.out.print (aux_pilha.num.num+" ");
							aux = topo.num.dir;
							topo = topo.prox;
						}
					}
					while (topo!=null || aux!=null);
				}
			}
			
			else if (op==4)
			{
				if (raiz==null)
				{	System.out.print ("\n\n\t�rvore vazia!!");
				}
				else
				{	System.out.print ("\n\n\tListando todos os elementos da �rvore em pr�-ordem: ");
					aux=raiz;
					topo=null;
					
					do
					{	while (aux!=null)
						{	aux_pilha = new PILHA();
							System.out.print (aux.num+" ");
							aux_pilha.num = aux;
							aux_pilha.prox = topo;
							topo = aux_pilha;
							aux = aux.esq;
						}
						
						if (topo!=null)
						{	aux_pilha = topo;
							topo = topo.prox;
							aux = aux_pilha.num.dir;
						}
					}
					while (topo!=null || aux!=null);
				}
			}
			
			else if (op==5)
			{
				if (raiz==null)
				{	System.out.print ("\n\n\t�rvore vazia!!");
				}
				else
				{	System.out.print ("\n\n\tListando todos os elementos da �rvore em p�s-ordem: ");
					aux=raiz;
					topo=null;
					
					do
					{	do
						{	while (aux!=null)
							{	aux_pilha = new PILHA();
								aux_pilha.num = aux;
								aux_pilha.prox = topo;
								topo = aux_pilha;
								aux = aux.esq;
							}
							
							if (topo.num.dir!=null)
								aux = topo.num.dir;
						}
						while (aux!=null);
						
						if (topo!=null)
						{	System.out.print (topo.num.num+" ");
						
							if (topo.prox!=null)
							{
								if (topo.prox.num.dir!=null && topo.prox.num.dir!=topo.num)
								{	aux = topo.prox.num.dir;
									topo = topo.prox;
								}
								else
								{	while (topo.prox!=null && topo.prox.num.dir==topo.num)
									{	topo = topo.prox;
										System.out.print (topo.num.num+" ");
									}
									topo = topo.prox;
									
									if (topo!=null)
										aux = topo.num.dir;
									else
										aux = null;
								}
							}
							else
							{	topo = topo.prox;
								aux = null;
							}
						}
					}
					while (topo!=null || aux!=null);
				}
			}
			
			else if (op==6)
			{
				if (raiz==null)
				{	System.out.print ("\n\n\t�rvore vazia!!");
				}
				else
				{	System.out.print ("\n\n\tDigite o n�mero que deseja excluir: ");
					numero = entrada.nextInt();
					aux = raiz;
					achou = 0;
					
					while (achou==0 && aux!=null)
					{
						if (aux.num==numero)
							achou = 1;
						else if (aux.num>numero)
							aux = aux.esq;
						else
							aux = aux.dir;
					}
					
					if (achou==0)
						System.out.print ("\n\t\tN�mero n�o encontrado!");
					else
					{
						if (aux!=raiz)
						{	anterior = raiz;
						
							while (anterior.dir!=aux && anterior.esq!=aux)
							{
								if (anterior.num>numero)
									anterior = anterior.esq;
								else
									anterior = anterior.dir;
							}
							
							if (aux.dir==null && aux.esq==null)
							{
								if (anterior.dir==aux)
									anterior.dir = null;
								else
									anterior.esq = null;
							}
							else
							{
								if (aux.dir!=null && aux.esq==null)
								{
									if (anterior.esq==aux)
										anterior.esq = aux.dir;
									else
										anterior.dir = aux.dir;
								}
								else if (aux.esq!=null && aux.dir==null)
								{	if (anterior.esq==aux)
										anterior.esq = aux.esq;
									else
										anterior.dir = aux.esq;
								}
								else if (aux.esq!=null && aux.dir!=null)
								{	if (anterior.dir==aux)
									{	anterior.dir = aux.dir;
										aux1 = aux.esq;
									}
									else
									{	anterior.esq = aux.dir;
										aux1 = aux.esq;
									}
									
									aux = anterior;
									
									while (aux!=null)
									{
										if (aux.num<aux1.num)
										{	if (aux.dir==null)
											{	aux.dir = aux1;
												aux = null;
											}
											else
												aux = aux.dir;
										}
										else if (aux.num>aux1.num)
										{	if (aux.esq==null)
											{	aux.esq = aux1;
												aux = null;
											}
											else
												aux = aux.esq;
										}
									}
								}
							}
						}
						else
						{	if (aux.dir==null && aux.esq==null)
							{	raiz = null;
							}
							else
							{	if (aux.dir!=null && aux.esq==null)
								{	raiz = aux.dir;
								}
								else if (aux.esq!=null && aux.dir==null)
								{	raiz = aux.esq;
								}
								else if (aux.esq!=null && aux.dir!=null)
								{	raiz = aux.dir;
									aux1 = aux.esq;
									aux = raiz;
									
									while (aux!=null)
									{	if (aux.num < aux1.num)
										{	if (aux.dir==null)
											{	aux.dir = aux1;
												aux = null;
											}
											else
												aux = aux.dir;
										}
										else if (aux.num>aux1.num)
										{	if (aux.esq == null)
											{	aux.esq = aux1;
												aux = null;
											}
											else
												aux = aux.esq;
										}
									}
								}
							}
						}
						System.out.print ("\n\t\tN�mero exclu�do da �rvore!");
					}
				}
			}
			
			else if (op==7)
			{
				if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!!");
				else
				{	raiz=null;
					System.out.print ("\n\t\t�rvore esvaziada!");
				}
			}
			
			
			else if (op==8)
			{	entrada.close();
				System.out.print ("\n\n\tAt� mais!!");
			}
		}
		while (op!=8);
	}

}
