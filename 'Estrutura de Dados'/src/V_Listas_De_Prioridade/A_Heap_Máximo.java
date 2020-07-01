package V_Listas_De_Prioridade;

import java.util.Scanner;

public class A_Heap_Máximo
{

	static int vet[] = new int[11];
	
	public static void main (String args[])
	{	Scanner entrada = new Scanner (System.in);
		
		int op, tam=0, ind, num;
		
		do
		{	System.out.print ("\n\n\t\tMENU DE OPÇÕES - HEAP MÁXIMO \n");
			System.out.print ("\n\t1-Inserir o elemento na lista de prioridades");
			System.out.print ("\n\t2-Consultar o elemento de maior prioridade");
			System.out.print ("\n\t3-Remover o elemento de maior prioridade");
			System.out.print ("\n\t4-Consultar toda a lista");
			System.out.print ("\n\t5-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			if (op>5 || op<1)
				System.out.print ("\n\n\tOpção inválida!!");
			
			if (op==1)
			{	if (tam<vet.length-1)
				{	tam++;
					System.out.print ("\n\n\tDigite um número: ");
					num = entrada.nextInt();
					ind = tam;
					
					while (ind>1 && vet[Pai(ind)]<num)
					{	vet[ind] = vet[Pai(ind)];
						ind = Pai(ind);
					}
					
					vet[ind] = num;
					System.out.print ("\n\n\t\tNúmero inserido!");
				}
				else
					System.out.print ("\n\n\tLista de prioridades lotada!");
			}
			
			if (op==2)
			{	if (tam==0)
					System.out.print ("\n\n\tLista de prioridades vazia!");
				else
					System.out.print ("\n\n\tElemento de maior prioridade: " +vet[1]);
			}
			
			if (op==3)
			{	if (tam==0)
				System.out.print ("\n\n\tLista de prioridades vazia!");
				else
				{	int maior_prior = vet[1];
					vet[1] = vet[tam];
					tam--;
					heap_fica (vet, 1, tam);
					System.out.print ("\n\n\tO elemento removido: " +maior_prior);
				}
			}
			
			if (op==4)
			{	if (tam==0)
				System.out.print ("\n\n\tLista de prioridades vazia!");
				else
				{	System.out.print ("\n\n\tTodos os elementos da lista de prioridades: ");
					for (int j=1; j<=tam; j++)
						System.out.print (vet[j]+ " ");
				}
			}
			
			if (op==5)
			{	System.out.print ("\n\n\tAté a próxima!!");
				entrada.close();
			}
						
		}
		while (op!=5);
	}

	
	public static int Pai (int x)
	{	return x/2;	}

	public static void heap_fica (int vet[], int i, int qtde)
	{	int f_esq, f_dir, maior, aux;
		maior = i;
		
		if (2*i+1 <= qtde)
		{	f_esq = 2*i+1;
			f_dir = 2*i;
			
			if (vet[f_esq]>=vet[f_dir] && vet[f_esq]>vet[i])
				maior = 2*i+1;
			else if (vet[f_dir]>vet[f_esq] && vet[f_dir]>vet[i])
				maior = 2*i;
		}
		else if (2*i <= qtde)
		{	f_dir = 2*i;
			if (vet[f_dir]>vet[i])
				maior = 2*i;
		}
		if (maior!=1)
		{	aux = vet[i];
			vet[i] = vet[maior];
			vet[maior] = aux;
			heap_fica (vet, maior, qtde);
		}
	}
}
