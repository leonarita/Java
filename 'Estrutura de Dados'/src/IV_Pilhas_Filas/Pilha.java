package IV_Pilhas_Filas;

import java.util.Scanner;

public class Pilha
{
	private static class PILHA
	{	public int num;
		public PILHA prox;
	}
	
	public static void main (String args[])
	{	Scanner entrada = new Scanner (System.in);
		PILHA topo = null;
		PILHA aux;
		int op;
		
		do
		{	System.out.print ("\n\n\t\tMENU DE OPÇÕES\n");
			System.out.print ("\n\t1-Inserir na pilha");
			System.out.print ("\n\t2-Consultar toda a pilha");
			System.out.print ("\n\t3-Remover da pilha");
			System.out.print ("\n\t4-Esvaziar a pilha");
			System.out.print ("\n\t5-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
		
			if (op<1 || op>5)
				System.out.print ("\n\n\tOpção inválida!!");
			
			else if (op==1)
			{	System.out.print ("\n\n\tDigite o número a ser inserido na pillha: ");
				PILHA novo = new PILHA();
				novo.num = entrada.nextInt();
				novo.prox = topo;
				topo = novo;
				System.out.print ("\n\t\tNúmero inserido na pilha!!");
			}
			
			else if (op==2)
			{	if (topo == null)
					System.out.print ("\n\n\tPilha vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando toda a pilha: ");
					aux = topo;
					
					while (aux != null)
					{	System.out.print (aux.num+" ");
						aux = aux.prox;
					}
				}
			}
			
			else if (op==3)
			{	if (topo == null)
					System.out.print ("\n\n\tPilha vazia!!");
				else
				{	System.out.print ("\n\n\tNúmero "+topo.num+" removido!");
					topo = topo.prox;
				}
			}
			
			else if (op==4)
			{	if (topo == null)
				{	System.out.print ("\n\n\tPilha vazia!!");
				}
				else
				{	topo = null;
					System.out.print ("\n\n\tPilha esvaziada!!");
				}
			}
			
			else if (op==5)
			{	entrada.close();
				System.out.print ("\n\n\tAté a próxima!");
			}
		}
		while (op!=5);
	}
}