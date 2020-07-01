package III_Listas;

import java.util.Scanner;

public class C_Lista_Duplamente_Encadeada_Não_Ordenada 
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
		{	System.out.print ("\n\n\t\t\t\tMENU DE OPÇÕES\n");
			System.out.print ("\n\t1-Inserir no início da lista");
			System.out.print ("\n\t2-Inserir no fim da lista");
			System.out.print ("\n\t3-Consultar a lista do início ao fim");
			System.out.print ("\n\t4-Consultar a lista do fim ao início");
			System.out.print ("\n\t5-Remover da lista");
			System.out.print ("\n\t6-Esvaziar a lista");
			System.out.print ("\n\t7-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			if (op<1 || op>7)
				System.out.print ("\n\n\tOpção inválida!!");
			
			else if (op==1)
			{	System.out.print ("\n\n\tDigite o número a ser inserido no início da lista: ");
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
				System.out.print ("\n\t\tNúmero inserido no início da lista!!");
			}
			
			else if (op==2)
			{	System.out.print ("\n\n\tDigite o número a ser inserido no fim da lista: ");
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
				System.out.print ("\n\t\tNúmero inserido no final da lista!!\n\n\n");
			}
			
			else if (op==3)
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
			
			else if (op==4)
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
			
			else if (op==5)
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
				System.out.print ("\n\n\tAté a próxima!");
			}

		}
		while (op!=7);
	}

}
