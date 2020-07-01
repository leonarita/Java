package aula02;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio10 
{
	public static void main (String[] args)
	{
		String[][] dados = new String[10][4];
		Scanner sc = new Scanner (System.in);
		
		for (int i=0; i<=9; i++)
		{
			System.out.print("\n\n" + (i+1) + "° Cadastro");
			System.out.print("\n\tNome: ");
			dados[i][0] = sc.nextLine();
			System.out.print("\tCPF: ");
			dados[i][1] = sc.nextLine();
			System.out.print("\tEmail: ");
			dados[i][2] = sc.nextLine();
			System.out.print("\tTelefone: ");
			dados[i][3] = sc.nextLine();
		}
		
		int op;
		
		do
		{	System.out.print("\n\nConsultas");
			System.out.print("\n\t1-Por nome \n\t2-Por CPF \n\t3-Por e-mail \n\t4-Por telefone \n\t0-Sair");
			System.out.print("\n\t\tInforme a opção desejada: ");
			op = sc.nextInt();
			
			String consulta="";
			sc.nextLine();
			
			switch (op)
			{
				case 1:
					System.out.println("\n\nInforme o nome de consulta: ");
					consulta = sc.nextLine();
					break;
				
				case 2:
					System.out.println("\n\nInforme o CPF de consulta: ");
					consulta = sc.nextLine();
					break;
				
				case 3:
					System.out.println("\n\nInforme o email de consulta: ");
					consulta = sc.nextLine();
					break;
					
				case 4:
					System.out.println("\n\nInforme o telefone de consulta: ");
					consulta = sc.nextLine();
					break;
					
				case 0:
					break;
					
				default:
					System.out.println("\n\nOpção inválida!");
					break;
			}
			
			if (op>=1 && op<=4)
			{				
				for (int i=0; i<=9; i++)
				{	if (dados[i][op-1].equals(consulta))
						System.out.println(Arrays.toString(dados[i]));
				}
			}
			else if (op==0)
				break;
			else
				continue;
		}
		while (op!=0);
		
		sc.close();
	}
}
