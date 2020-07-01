package III_Listas;

import java.util.Scanner;


public class D_Lista_Duplamente_Encadeada_Ordenada 
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
		{	System.out.print ("\n\n\t\tMENU DE OPÇÕES\n");
			System.out.print ("\n\t1-Inserir na lista");
			System.out.print ("\n\t2-Consultar a lista do início ao fim");
			System.out.print ("\n\t3-Consultar a lista do fim ao início");
			System.out.print ("\n\t4-Remover da lista");
			System.out.print ("\n\t5-Esvaziar a lista");
			System.out.print ("\n\t6-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			if (op<1 || op>6)
				System.out.print ("\n\n\tOpção inválida!!");
			
			else if (op==1)
			{	System.out.print ("\n\n\tDigite o número a ser inserido na lista: ");
				LISTA novo = new LISTA();
				novo.num = entrada.nextInt();
				
				if (inicio == null)
				{	inicio = novo;
					fim = novo;
					novo.prox = null;
					novo.ant = null;
				}
				else
				{	aux = inicio;
				
					while (aux!=null && novo.num>aux.num)
						aux = aux.prox;
					
					if (aux == inicio)
					{	novo.prox = inicio;
						novo.ant = null;
						inicio.ant = novo;
						inicio = novo;
					}
					else if (aux == null)
					{	fim.prox = novo;
						novo.ant = fim;
						fim = novo;
						fim.prox = null;
					}
					else
					{	novo.prox = aux;
						aux.ant.prox = novo;
						novo.ant = aux.ant;
						aux.ant = novo;
					}
				}
				System.out.print ("\n\t\tNúmero inserido na lista!!");
			}
			
			else if (op==2)
			{	if (inicio == null)
					System.out.print ("\n\n\tLista vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando a lista do início ao fim: ");
					aux = inicio;
					
					while (aux != null)
					{	System.out.print (aux.num+" ");
						aux = aux.prox;
					}
				}
			}
			
			else if (op==3)
			{	if (inicio == null)
					System.out.print ("\n\n\tLista vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando a lista do fim ao início: ");
					aux = fim;
					
					while (aux != null)
					{	System.out.print (aux.num+" ");
						aux = aux.ant;
					}
				}
			}
			
			else if (op==4)
			{	if (inicio==null)
					System.out.print ("\n\n\tA lista está vazia!");
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
						System.out.print ("\n\t\tNúmero não encontrado!");
					else if (achou == 1)
						System.out.print ("\n\t\tNúmero removido uma vez!");
					else
						System.out.print ("\n\t\tNúmero removido "+achou+" vezes!");
				}
			}
			
			else if (op==5)
			{	if (inicio == null)
				{	System.out.print ("\n\n\tLista vazia!!");
				}
				else
				{	aux = inicio;
					
					do
					{	inicio = inicio.prox;
						aux = inicio;
					}
					while (aux != fim);
					
					inicio = null;
					System.out.print ("\n\n\tLista esvaziada!!");
				}
			}
			
			else if (op==6)
			{	entrada.close();
				System.out.print ("\n\n\tAté a próxima!");
			}

		}
		while (op!=6);
		
	}

}
