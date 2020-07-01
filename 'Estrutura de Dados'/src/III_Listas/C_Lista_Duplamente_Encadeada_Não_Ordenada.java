package III_Listas;

import java.util.Scanner;

public class C_Lista_Duplamente_Encadeada_N�o_Ordenada 
{
	private static class LISTA
	{	int num;
		LISTA prox, ant;
	}
	
	public static void main (String args[])
	{	Scanner entrada = new Scanner (System.in);
		
		LISTA inicio = null;
		LISTA fim = null;
		LISTA aux;
		
		int op, numero, achou;
		
		do
		{	System.out.print ("\n\n\t\t\t\tMENU DE OP��ES\n");
			System.out.print ("\n\t1-Inserir no in�cio da lista");
			System.out.print ("\n\t2-Inserir no fim da lista");
			System.out.print ("\n\t3-Consultar a lista do in�cio ao fim");
			System.out.print ("\n\t4-Consultar a lista do fim ao in�cio");
			System.out.print ("\n\t5-Remover da lista");
			System.out.print ("\n\t6-Esvaziar a lista");
			System.out.print ("\n\t7-Sair");
			System.out.print ("\n\nDigite sua op��o: ");
			op = entrada.nextInt();
			
			if (op<1 || op>7)
				System.out.print ("\n\n\tOp��o inv�lida!!");
			
			else if (op==1)
			{	System.out.print ("\n\n\tDigite o n�mero a ser inserido no in�cio da lista: ");
				LISTA novo = new LISTA();
				novo.num = entrada.nextInt();
				
				if (inicio == null)
				{	inicio = novo;
					fim = novo;
					novo.prox = null;
					novo.ant = null;
				}
				else
				{	novo.prox = inicio;
					inicio.ant = novo;
					novo.ant = null;
					inicio = novo;
				}
				System.out.print ("\n\t\tN�mero inserido no in�cio da lista!!");
			}
			
			else if (op==2)
			{	System.out.print ("\n\n\tDigite o n�mero a ser inserido no fim da lista: ");
				LISTA novo = new LISTA();
				novo.num = entrada.nextInt();
			
				if (inicio == null)
				{	inicio = novo;
					fim = novo;
					novo.prox = null;
					novo.ant = null;
				}
				else
				{	fim.prox = novo;
					novo.ant = fim;
					novo.prox = null;
					fim = novo;
				}
				System.out.print ("\n\t\tN�mero inserido no final da lista!!\n\n\n");
			}
			
			else if (op==3)
			{	if (inicio == null)
					System.out.print ("\n\n\tLista vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando a lista do in�cio ao fim: ");
					aux = inicio;
					
					while (aux != null)
					{	System.out.print (aux.num+" ");
						aux = aux.prox;
					}
				}
			}
			
			else if (op==4)
			{	if (inicio == null)
				System.out.print ("\n\n\tLista vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando a lista do fim ao in�cio: ");
					aux = fim;
					
					while (aux != null)
					{	System.out.print (aux.num+" ");
						aux = aux.ant;
					}
				}
			}
			
			else if (op==5)
			{	if (inicio==null)
					System.out.print ("\n\n\tA lista est� vazia!");
				else
				{	System.out.print ("\n\n\tDigite o elemento a ser removido: ");
					numero = entrada.nextInt();
					
					aux = inicio;
					achou = 0;
					
					while (aux != null)
					{	if (aux.num == numero)	
						{	achou += 1;
							if (aux == inicio)
							{	inicio = aux.prox;
								if (inicio != null)
									inicio.ant = null;
								aux = inicio;
							}
							else if (aux == fim)
							{	fim = fim.ant;
								fim.prox = null;
								aux = null;
							}
							else
							{	aux.ant.prox = aux.prox;
								aux.prox.ant = aux.ant;
								aux = aux.prox;
							}
						}
						else
						{	aux = aux.prox;
						}
					}
					if (achou==0)
						System.out.print ("\n\t\tN�mero n�o encontrado!");
					else if (achou == 1)
						System.out.print ("\n\t\tN�mero removido uma vez!");
					else
						System.out.print ("\n\t\tN�mero removido "+achou+" vezes!");
				}
			}
			
			else if (op==6)
			{	if (inicio == null)
				{	System.out.print ("\n\n\tLista vazia!!");
				}
				else
				{	inicio = null;
					System.out.print ("\n\n\tLista esvaziada!!");
				}
			}
			
			else if (op==7)
			{	entrada.close();
				System.out.print ("\n\n\tAt� a pr�xima!");
			}

		}
		while (op!=7);
	}

}
