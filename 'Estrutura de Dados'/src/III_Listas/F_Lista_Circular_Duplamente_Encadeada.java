package III_Listas;

import java.util.Scanner;

public class F_Lista_Circular_Duplamente_Encadeada
{
	private static class LISTA
	{	public int num;
		public LISTA prox;
		public LISTA ant;
	}
	
	public static void main (String args[])
	{	Scanner entrada = new Scanner (System.in);
	
		LISTA inicio = null;
		LISTA fim = null;
		LISTA aux;
		
		int op, numero, achou;
		
		do
		{	System.out.print ("\n\n\t\tMENU DE OPÇÕES\n");
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
					novo.prox = inicio;
					novo.ant = inicio;
				}
				else
				{	novo.prox = inicio;
					inicio.ant = novo;
					novo.ant = fim;
					fim.prox = novo;
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
					novo.prox = inicio;
					novo.ant = inicio;
				}
				else
				{	fim.prox = novo;
					novo.ant = fim;
					fim = novo;
					fim.prox = inicio;
					inicio.ant = fim;
				}
				System.out.print ("\n\t\tNúmero inserido no final da lista!!\n\n\n");
			}
			
			else if (op==3)
			{	if (inicio == null)
					System.out.print ("\n\n\tLista vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando a lista do início ao fim: ");
					aux = inicio;
					
					do
					{	System.out.print (aux.num+" ");
						aux = aux.prox;
					}
					while (aux != inicio);
				}
			}
			
			else if (op==4)
			{	if (inicio == null)
					System.out.print ("\n\n\tLista vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando a lista do início ao fim: ");
					aux = fim;
					
					do
					{	System.out.print (aux.num+" ");
						aux = aux.ant;
					}
					while (aux != fim);
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
					int quantidade=0;
					
					do
					{	quantidade++;
						aux = aux.prox;
					}
					while (aux != inicio);
					
					int elemento = 1;
					
					do
					{	if (inicio==fim && inicio.num==numero)
						{	inicio = null;
							achou++;
						}
						else
						{	if (aux.num == numero)
							{	achou++;
								if (aux == inicio)	
								{	inicio = aux.prox;
									inicio.ant = fim;
									fim.prox = inicio;
									aux = inicio;
								}
								else if (aux == fim)
								{	fim = fim.ant;
									fim.prox = inicio;
									inicio.ant = fim;
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
						elemento++;
					}
					while (elemento <= quantidade);
					
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
			
			else if (op==7)
			{	entrada.close();
				System.out.print ("\n\n\tAté a próxima!");
			}

		}
		while (op!=7);
	}
}
