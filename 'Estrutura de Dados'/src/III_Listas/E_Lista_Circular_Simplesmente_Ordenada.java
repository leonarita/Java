package III_Listas;

import java.util.Scanner;

public class E_Lista_Circular_Simplesmente_Ordenada 
{
	private static class LISTA
	{	public int num;
		public LISTA prox;
	}
	
	public static void main (String args[])
	{	Scanner entrada = new Scanner (System.in);
		
		LISTA inicio = null;
		LISTA fim = null;
		LISTA aux, anterior;
			
		int op, numero, achou;
		
		do
		{	System.out.print ("\n\n\t\tMENU DE OPÇÕES\n");
			System.out.print ("\n\t1-Inserir no início da lista");
			System.out.print ("\n\t2-Inserir no fim da lista");
			System.out.print ("\n\t3-Consultar toda a lista");
			System.out.print ("\n\t4-Remover da lista");
			System.out.print ("\n\t5-Esvaziar a lista");
			System.out.print ("\n\t6-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			if (op<1 || op>6)
				System.out.print ("\n\n\tOpção inválida!!");
			
			else if (op==1)
			{	System.out.print ("\n\n\tDigite o número a ser inserido no início da lista: ");
				LISTA novo = new LISTA();
				novo.num = entrada.nextInt();
				
				if (inicio == null)
				{	inicio = novo;
					fim = novo;
					fim.prox = inicio;
				}
				else
				{	novo.prox = inicio;
					inicio=novo;
					fim.prox = inicio;
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
					fim.prox = inicio;
				}
				else
				{	fim.prox = novo;
					fim = novo;
					fim.prox = inicio;
				}
				System.out.print ("\n\t\tNúmero inserido no final da lista!!\n\n\n");
			}
			
			else if (op==3)
			{	if (inicio == null)
					System.out.print ("\n\n\tLista vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando toda a lista: ");
					aux = inicio;
					
					do
					{	System.out.print (aux.num+ " ");
						aux = aux.prox;
					}
					while (aux != inicio);
				}
			}
			
			else if (op==4)
			{	if (inicio==null)
					System.out.print ("\n\n\tA lista está vazia!");
				else
				{	System.out.print ("\n\n\tDigite o elemento a ser removido: ");
					numero = entrada.nextInt();
					
					aux = inicio;
					anterior = null;
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
									fim.prox = inicio;
									aux = inicio;
								}
								else if (aux == fim)
								{	fim = anterior;
									fim.prox = inicio;
									aux = aux.prox;
								}
								else
								{	anterior.prox = aux.prox;
									aux = aux.prox;
								}
							}
							else
							{	anterior = aux;
								aux = aux.prox;
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
			
			else if (op==5)
			{	if (inicio == null)
				{	System.out.print ("\n\n\tLista vazia!!");
				}
				else
				{	inicio = null;
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
