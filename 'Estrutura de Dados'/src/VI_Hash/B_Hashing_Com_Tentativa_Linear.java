package VI_Hash;

import java.util.Scanner;

public class B_Hashing_Com_Tentativa_Linear 
{
	public static class hash
	{	int chave;
		char livre;
	};
	
	static int tam=8;
	static hash tabela[] = new hash[tam];
	static Scanner entrada = new Scanner (System.in);

	public static void inserir (int n)
	{	int i=0;
		int pos = funcao_hashing (n);

		while (i<tam && tabela[(pos+i)%tam].livre!='L' && tabela[(pos+i)%tam].livre!='R')
			i++;
		
		if (i<tam)
		{	tabela[(pos+i)%tam].chave = n;
			tabela[(pos+i)%tam].livre = 'O';
		}
		else
			System.out.print ("\n\n\tTabela cheia!");
	}
	
	public static void remover (int n)
	{	int posicao = buscar (n);
	
		if (posicao<tam)
			tabela[posicao].livre = 'R';
		else
			System.out.print ("\n\n\tElemento não está presente!");
	}
	
	public static int buscar (int n)
	{	int i=0;
		int pos = funcao_hashing (n);
		
		while (i<tam && tabela[(pos+i)%tam].livre!='L' && tabela[(pos+i)%tam].chave!=n)
			i++;
		
		if (tabela[(pos+i)%tam].chave==n && tabela[(pos+i)%tam].livre!='R')
			return (pos+i)%tam;
		else
			return tam;
	}
	
	public static int funcao_hashing (int num)
	{	return num%tam;	}
	
	public static void mostrar_hash ()
	{	int i;
		for (i=0; i<tam; i++)
		{	if (tabela[i].livre=='O')
				System.out.print ("\nEntrada "+i+" : " +tabela[i].chave);
		}
	}
	
	public static void main (String args[])
	{	
		int op, num, i;
		
		for (i=0; i<tam; i++)
		{	tabela[i] = new hash();
			tabela[i].livre = 'L';
		}
			
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
						inserir (num);
						break;
					
					case 2:
						mostrar_hash();
						break;
					
					case 3:
						System.out.print ("\n\n\tDigite um número: ");
						num = entrada.nextInt();
						remover (num);
						break;
					
					case 4:
						System.out.print ("\n\n\tAté mais!");
				}
			}
		}
		while (op!=4);
	}
}
