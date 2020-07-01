package VII_�rvores;

import java.util.Scanner;

public class C_�rvore_AVL 
{
	private static class ARVORE
	{	public int num, altd, alte;
		public ARVORE dir, esq;
	}

	public static void main (String args[])
	{	Scanner entrada = new Scanner (System.in);
		
		ARVORE raiz=null, aux;
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
				numero = entrada.nextInt();
				raiz = inserir (raiz, numero);
				System.out.print ("\n\t\tN�mero inserido na �rvore!");
			}
			
			else if (op==2)
			{	if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!");
				else
				{	System.out.print ("\n\n\tDigite o n�mero a ser consultado: ");
					numero = entrada.nextInt();
					achou = 0;
					achou = consultar (raiz, numero, achou);
					
					if (achou==0)
						System.out.print ("\n\t\tN�mero n�o encontrado na �rvore!");
					else
						System.out.print ("\n\t\tN�mero encontrado na �rvore!");
				}
			}
			
			else if (op==3)
			{	if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!");
				else
				{	System.out.print ("\n\n\tListando todos os elementos da �rvore em ordem: ");
					mostraremordem (raiz);
				}
			}
			
			else if (op==4)
			{	if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!");
				else
				{	System.out.print ("\n\n\tListando todos os elementos da �rvore em pr�-ordem: ");
					mostrarpreordem (raiz);
				}
			}
			
			else if (op==5)
			{	if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!");
				else
				{	System.out.print ("\n\n\tListando todos os elementos da �rvore em p�s-ordem: ");
					aux = raiz;
					mostrarposordem (aux);
				}
			}
			
			else if (op==6)
			{	if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!");
				else
				{	System.out.print ("\n\n\tDigite o n�mero que deseja excluir: ");
					numero = entrada.nextInt();
					achou = 0;
					achou = consultar (raiz, numero, achou);
					
					if (achou==0)
						System.out.print ("\n\t\tN�mero n�o encontrado na �rvore!");
					else
					{	raiz = remover (raiz, numero);
						raiz = atualiza (raiz);
						System.out.print ("\n\t\tN�mero exclu�do da �rvore!");
					}
				}
			}
			
			else if (op==7)
			{	if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!");
				else
				{	raiz = null;
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
	
	public static ARVORE inserir (ARVORE aux, int num)
	{	ARVORE novo;

		if (aux==null)
		{	novo = new ARVORE();
			novo.num = num;
			novo.altd = 0;
			novo.alte = 0;
			novo.esq = null;
			novo.dir = null;
			aux = novo;
		}
		else if (num < aux.num)
		{	aux.esq = inserir (aux.esq, num);
			
			if (aux.esq.altd > aux.esq.alte)
				aux.alte = aux.esq.altd + 1;
			else
				aux.alte = aux.esq.alte + 1;
			aux = balanceamento (aux);
		}
		else
		{	aux.dir = inserir (aux.dir, num);
			
			if (aux.dir.altd > aux.dir.alte)
				aux.altd = aux.dir.altd + 1;
			else
				aux.altd = aux.dir.alte + 1;
			aux = balanceamento (aux);
		}
		return aux;
	}
	
	public static ARVORE balanceamento (ARVORE aux)
	{	int d, df;
		d = aux.altd - aux.alte;
		
		if (d==2)
		{	df = aux.dir.altd - aux.dir.alte;
		
			if (df>=0)
				aux = rotacao_esquerda (aux);
			else
			{	aux.dir = rotacao_direita (aux.dir);
				aux = rotacao_esquerda (aux);
			}
		}
		
		else if (d==-2)
		{	df = aux.esq.altd - aux.esq.alte;
		
			if (df<=0)
				aux = rotacao_direita (aux);
			else
			{	aux.esq = rotacao_esquerda (aux.esq);
				aux = rotacao_direita (aux);
			}
		}
		return aux;
	}
	
	public static ARVORE rotacao_esquerda (ARVORE aux)
	{	ARVORE aux1, aux2;
		aux1 = aux.dir;
		aux2 = aux1.esq;
		aux.dir = aux2;
		aux1.esq = aux;
		
		if (aux.dir==null)
			aux.altd = 0;
		else if (aux.dir.alte > aux.dir.altd)
			aux.altd = aux.dir.alte+1;
		else
			aux.altd = aux.dir.altd+1;
		
		if (aux1.esq.alte > aux1.esq.altd)
			aux1.alte = aux1.esq.alte+1;
		else
			aux1.alte = aux1.esq.altd+1;
			
		return aux1;
	}
	
	public static ARVORE rotacao_direita (ARVORE aux)
	{	ARVORE aux1, aux2;

		aux1 = aux.esq;
		aux2 = aux1.dir;
		aux.esq = aux2;
		aux1.dir = aux;
		
		if (aux.esq==null)
			aux.alte=0;
		else if (aux.esq.alte > aux.esq.altd)
			aux.alte=aux.esq.alte+1;
		else
			aux.alte=aux.esq.altd+1;
			
		if (aux1.dir.alte > aux1.dir.altd)
			aux1.altd=aux1.dir.alte+1;
		else
			aux1.altd=aux1.dir.altd+1;
			
		return aux1;
	}
	
	public static int consultar (ARVORE aux, int num, int achou)
	{
		if (aux!=null && achou==0)
		{
			if (aux.num == num)
				achou = 1;
			else if (num < aux.num)
				achou = consultar (aux.esq, num, achou);
			else
				achou = consultar (aux.dir, num, achou);
		}
		return achou;
	}
	
	public static void mostraremordem (ARVORE aux)
	{
		if (aux!=null)
		{	mostraremordem (aux.esq);
			System.out.print (aux.num+" ");
			mostraremordem (aux.dir);
		}
	}

	public static void mostrarpreordem (ARVORE aux)
	{
		if (aux!=null)
		{	System.out.print (aux.num+" ");
			mostrarpreordem (aux.esq);
			mostrarpreordem (aux.dir);
		}
	}

	public static void mostrarposordem (ARVORE aux)
	{
		if (aux!=null)
		{	mostrarpreordem (aux.esq);
			mostrarpreordem (aux.dir);
			System.out.print (aux.num+" ");
		}
	}
	
	public static ARVORE remover (ARVORE aux, int num)
	{	ARVORE p, p2;

		if (aux.num==num)
		{
			if (aux.esq == aux.dir)
			{	return null;
			}
			else if (aux.esq == null)
			{	return aux.dir;
			}
			else if (aux.dir == null)
			{	return aux.esq;
			}
			else
			{	p2 = aux.dir;
				p = aux.dir;
				
				while (p.esq != null)
					p = p.esq;
				
				p.esq = aux.esq;
				return p2;
			}
		}
		else if (aux.num < num)
			aux.dir = remover (aux.dir, num);
		else
			aux.esq = remover (aux.esq, num);
		return aux;
	}

	public static ARVORE atualiza (ARVORE aux)
	{
		if (aux!=null)
		{	aux.esq = atualiza (aux.esq);
		
			if (aux.esq == null)
				aux.alte = 0;
			else if (aux.esq.alte > aux.esq.altd)
				aux.alte = aux.esq.alte +1;
			else
				aux.alte = aux.esq.altd +1;
			
			aux.dir = atualiza (aux.dir);
		
			if (aux.dir == null)
				aux.altd = 0;
			else if (aux.dir.alte > aux.dir.altd)
				aux.altd = aux.dir.alte +1;
			else
				aux.altd = aux.dir.altd +1;
			aux = balanceamento (aux);
		}
		return aux;
	}
	
}
