package IV_Pilhas_Filas;

import java.util.Scanner;

public class Fila 
{
	private static class FILA
	{	public int num;
		public FILA prox;
	}
	
	public static void main (String args[])
	{	Scanner entrada = new Scanner (System.in);
		FILA inicio = null;
		FILA fim = null;
		FILA aux;
		int op;
		
		do
		{	System.out.print ("\n\n\t\tMENU DE OPÇÕES\n");
			System.out.print ("\n\t1-Inserir na fila");
			System.out.print ("\n\t2-Consultar toda a fila");
			System.out.print ("\n\t3-Remover da fila");
			System.out.print ("\n\t4-Esvaziar a fila");
			System.out.print ("\n\t5-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
		
			if (op<1 || op>5)
				System.out.print ("\n\n\tOpção inválida!!");
			
			else if (op==1)
			{	System.out.print ("\n\n\tDigite o número a ser inserido na fila: ");
				FILA novo = new FILA();
				novo.num = entrada.nextInt();
				novo.prox = null;
				
				if (inicio==null)
				{	inicio=novo;
					fim=novo;
				}
				else
				{	fim.prox = novo;
					fim = novo;
				}

				System.out.print ("\n\t\tNúmero inserido na fila!!");
			}
			
			else if (op==2)
			{	if (inicio == null)
					System.out.print ("\n\n\tFila vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando toda a fila: ");
					aux = inicio;
					
					while (aux != null)
					{	System.out.print (aux.num+" ");
						aux = aux.prox;
					}
				}
			}
			
			else if (op==3)
			{	if (inicio == null)
					System.out.print ("\n\n\tFila vazia!!");
				else
				{	System.out.print ("\n\n\tNúmero "+inicio.num+" removido!");
					inicio = inicio.prox;
				}
			}
			
			else if (op==4)
			{	if (inicio == null)
				{	System.out.print ("\n\n\tFila vazia!!");
				}
				else
				{	inicio = null;
					System.out.print ("\n\n\tFila esvaziada!!");
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
