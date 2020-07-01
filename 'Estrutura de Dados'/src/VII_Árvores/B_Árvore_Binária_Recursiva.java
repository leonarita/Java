package VII_�rvores;

import java.util.*;

public class B_�rvore_Bin�ria_Recursiva 
{
	private static class ARVORE
	{	public int num;
		public ARVORE dir, esq;
	}
	
	public static void main (String args[])
	{	Scanner entrada = new Scanner (System.in);
		
		ARVORE raiz=null;
		ARVORE aux;
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
			{	System.out.print("\n\n\tDigite o n�mero a ser inserido na �rvore: ");
				numero = entrada.nextInt();
				raiz = inserir (raiz, numero);
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
					achou = consultar (raiz, numero, achou);
					
					if (achou==0)
						System.out.print ("\n\t\tN�mero n�o encontrado na �rvore!");
					else
						System.out.print ("\n\t\tN�mero encontrado na �rvore!");
				}
			}
			
			else if (op==3)
			{
				if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!!");
				else
				{	System.out.print("\n\n\tListando todos os elementos da �rvore em ordem: ");
					mostraremordem (raiz);
				}
			}
			
			else if (op==4)
			{
				if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!!");
				else
				{	System.out.print("\n\n\tListando todos os elementos da �rvore em pr�-ordem: ");
					mostrarpreordem (raiz);
				}
			}
			
			else if (op==5)
			{
				if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!!");
				else
				{	System.out.print("\n\n\tListando todos os elementos da �rvore em p�s-ordem: ");
					aux = raiz;
					mostrarposordem (aux);
				}
			}
			
			else if (op==6)
			{
				if (raiz==null)
					System.out.print ("\n\n\t�rvore vazia!!");
				else
				{	System.out.print ("\n\n\tDigite o n�mero que deseja excluir: ");
					numero = entrada.nextInt();
					achou = 0;
					achou = consultar (raiz, numero, achou);
					
					if (achou==0)
						System.out.print ("\n\t\tN�mero n�o encontrado!");
					else
					{	raiz = remover (raiz, numero);
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
	
	public static ARVORE inserir (ARVORE aux, int num)
	{
		if (aux == null)
		{	aux = new ARVORE();
			aux.num = num;
			aux.esq = null;
			aux.dir = null;
		}
		else if (num < aux.num)
			aux.esq = inserir (aux.esq, num);
		else
			aux.dir = inserir (aux.dir, num);
		return aux;
	}
	
	public static int consultar (ARVORE aux, int num, int achou)
	{
		if (aux!=null && achou==0)
		{
			if (aux.num == num)
				achou=1;
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
		
		if (aux.num == num)
		{
			if (aux.esq == aux.dir)
				return null;
			else if (aux.esq == null)
				return aux.dir;
			else if (aux.dir == null)
				return aux.esq;
			
			else
			{	
				p2 = aux.dir;
				p = aux.dir;
				
				while (p.esq != null)
				{	p.esq = aux.esq;
					return p2;
				}
			}
		}
		else if (aux.num < num)
			aux.dir = remover (aux.dir, num);
		else
			aux.esq = remover (aux.esq, num);
		return aux;
	}
}