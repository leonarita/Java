package VI_Hash;

import java.util.Scanner;

public class C_Hashing_Implementada_Como_Lista 
{
	public static class hash
	{	int chave;
		hash prox;
	}
	
	static int tam=10;
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner (System.in);

	public static void inserir (int pos, int n)
	{	hash novo = new hash();
		novo.chave = n;
		novo.prox = tabela[pos];
		tabela[pos] = novo;
	}
	
	static int funcao_hashing (int num)
	{	return num%tam;
	}
	
	static void mostrar_hash ()
	{	hash aux;
	
		for (int i=0; i<tam; i++)
		{	aux = tabela[i];
		
			while (aux!=null)
			{	System.out.print ("\n\n\tEntrada "+i+": "+aux.chave);
				aux = aux.prox;
			}
		}
	}
	
	static void excluir_hash (int num)
	{	int pos = funcao_hashing (num);
		hash aux;
		
		if (tabela[pos]!=null)
		{
			if (tabela[pos].chave==num)
				tabela[pos] = tabela[pos].prox;
			else
			{	aux = tabela[pos].prox;
				hash ant = tabela[pos];
				
				while (aux!=null && aux.chave!=num)
				{	ant = aux;
					aux = aux.prox;
				}
				
				if (aux!=null)
					ant.prox = aux.prox;
				else
					System.out.print ("\n\n\tNúmero não encontrado!");
			}
		}
		else
			System.out.print ("\n\n\tNúmero não encontrado!");
	}
	
	public static void main (String args[])
	{	
		int op, num, pos;

		do
		{	System.out.print ("\n\n\t\tMENU DE OPÇÕES\n");
			System.out.print ("\n\t1-Inserir elemento");
			System.out.print ("\n\t2-Mostrar tabela hashing");
			System.out.print ("\n\t3-Excluir elemento");
			System.out.print ("\n\t4-Sair");
			System.out.print ("\n\nDigite sua opção: ");
			op = entrada.nextInt();
			
			if (op<1 || op>4)
				System.out.print ("\n\n\tComando inválido!");
			else
			{	switch (op)
				{
				case 1:
					System.out.print ("\n\n\tDigite um número: ");
					num = entrada.nextInt();
					pos = funcao_hashing (num);
					inserir (pos, num);
					break;
				
				case 2:
					mostrar_hash();
					break;
				
				case 3:
					System.out.print ("\n\n\tDigite um número: ");
					num = entrada.nextInt();
					excluir_hash (num);
					break;
				
				case 4:
					System.out.print ("\n\n\tAté mais!");
				}
			}
		}
	while (op!=4);
	
	}
}