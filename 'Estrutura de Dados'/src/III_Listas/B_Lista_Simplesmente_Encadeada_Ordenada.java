package III_Listas;
import java.util.*;

public class B_Lista_Simplesmente_Encadeada_Ordenada 
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
			System.out.print ("\n\t1-Inserir na lista");
			System.out.print ("\n\t2-Consultar toda a lista");
			System.out.print ("\n\t3-Remover da lista");
			System.out.print ("\n\t4-Esvaziar a lista");
			System.out.print ("\n\t5-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			if (op<1 || op>5)
				System.out.print ("\n\n\tOpção inválida!!");
			
			else if (op==1)
			{	System.out.print ("\n\n\tDigite o número a ser inserido no início da lista: ");
				LISTA novo = new LISTA();
				novo.num = entrada.nextInt();
				
				if (inicio==null)
				{	inicio = novo;
					fim = novo;
					novo.prox = null;
				}
				else
				{	anterior = null;
					aux = inicio;
					
					while (aux!=null && novo.num>aux.num)
					{	anterior = aux;
						aux = aux.prox;
					}
					
					if (anterior==null)
					{	novo.prox = inicio;
						inicio = novo;
					}
					else if (aux==null)
					{	fim.prox = novo;
						fim = novo;
						fim.prox = null;
					}
					else
					{	anterior.prox = novo;
						novo.prox = aux;
						
					}
				}
				System.out.print ("\n\t\tNúmero inserido no início da lista!!");
			}
			
			else if (op==2)
			{	if (inicio == null)
					System.out.print ("\n\n\tLista vazia!!");
				else
				{	System.out.print ("\n\n\tConsultando toda a lista: ");
					aux = inicio;
					
					while (aux != null)
					{	System.out.print (aux.num+" ");
						aux = aux.prox;
					}
				}
			}
			
			else if (op==3)
			{	if (inicio==null)
					System.out.print ("\n\n\tA lista está vazia!");
				else
				{	System.out.print ("\n\n\tDigite o elemento a ser removido: ");
					numero = entrada.nextInt();
					
					aux = inicio;
					anterior = null;
					achou = 0;
					
					while (aux != null)
					{	if (aux.num == numero)	
						{	achou += 1;
							if (aux == inicio)
							{	inicio = aux.prox;
								aux = inicio;
							}
							else if (aux == fim)
							{	anterior.prox = null;
								fim = anterior;
								aux = null;
							}
							else
							{	anterior.prox = aux.prox;
								aux = anterior.prox;
							}
						}
						else
						{	anterior = aux;
							aux = aux.prox;
						}
					}
					if (achou==0)
						System.out.print ("\n\t\tNúmero não encontrado!");
					else if (achou == 1)
						System.out.print ("\n\t\tNúmero removido uma vez!");
					else
						System.out.print ("\n\t\tNúmero removido " +achou+ " vezes!");
				}
			}
			
			else if (op==4)
			{	if (inicio == null)
				{	System.out.print ("\n\n\tLista vazia!!");
				}
				else
				{	inicio = null;
					System.out.print ("\n\n\tLista esvaziada!!");
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
