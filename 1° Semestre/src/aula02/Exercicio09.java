package aula02;

import java.util.Scanner;

public class Exercicio09 
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner (System.in);
		int op;
		
		do
		{
			System.out.println("\n\nMENU DE OPÇÕES");
			System.out.println("\t1-Cadastrar Cliente \n\t2-Alterar Cliente \n\t3-Excluir Cliente \n\t0-Sair");
			System.out.print("\t\tInforme a opção desejada: ");
			op = sc.nextInt();
			
			switch (op)
			{
				case 1:
					System.out.println("\n\n\t\t\tCadastro de cliente");
					break;
				
				case 2:
					System.out.println("\n\n\t\t\tAlteração de cliente");
					break;
					
				case 3:
					System.out.println("\n\n\t\t\tExclusão de cliente");
					break;
				
				case 0:
					break;
				
				default:
					System.out.println("\n\n\t\t\tOpção inválida!");
					break;
			}
		}
		while (op!=0);
		
		sc.close();
	}
}
