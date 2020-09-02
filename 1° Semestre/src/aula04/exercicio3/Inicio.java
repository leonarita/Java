package aula04.exercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner (System.in);
		
		int indice = 0, op=1;
		Cliente[] clientes = new Cliente[10];
		String[] textos = new String[] { "Inserir Cliente", "Consultar cliente espec�fico", "Consultar clientes" };
		
		for (int i=0; i<10; i++)
			clientes[i] = new Cliente();
		
		do
		{
			try {
				menu(textos);
				op = sc.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("\n\n\t\tInsira um n�mero v�lido!");
				sc.nextLine();
				continue;
			}
			
			sc.nextLine();
			System.out.println("\n\n");
			
			if (op==0)
			{
				System.out.println("At� a pr�xima!");
				break;
			}
			else if (op==1)
			{
				if (indice==10)
				{
					System.out.println("\tN�o � poss�vel inserir, pois o vetor est� lotado!");
					continue;
				}
				
				System.out.print("\tInforme o nome: ");
				String nome = sc.nextLine();
				
				System.out.print("\tInforme o CPF: ");
				String cpf = sc.nextLine();
				
				try {
				
				if (clientes[indice].setNome(nome) && clientes[indice].setCpf(cpf))
				{
					clientes[indice].setCodigo(indice);
					indice++;
				}
				
				else
					throw new IllegalArgumentException("\tO campo nome deve incluir o sobrenome e o CPF deve ter 11 digitos!");
				}
				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
			else if (op==2)
			{
				try {
					System.out.print("\tInforme o C�digo para consultar: ");
					int cod = sc.nextInt();
					
					try {
						getClientByCod(cod, clientes);
					}
					catch (IndexOutOfBoundsException e) {
						System.out.print("\n\t\t" + e.getMessage());
					}
				}
				catch (InputMismatchException e) {
					System.out.println("\n\n\t\tInsira um c�digo v�lido!");
					sc.nextLine();
					continue;
				}
				
			}
			else if (op==3)
			{
				for (Cliente i : clientes)
					if (i.getCodigo() != -1)
						System.out.println("C�digo: " + i.getCodigo() + ", nome: " + i.getNome() + ", CPF: " + i.getCpf());
			}
			else
				System.out.println("Comando inv�lido!");
		}
		while (op!=0);
		
		sc.close();
	}
	
	public static void menu (String[] textos)
	{
		System.out.println("\n\nConsidere as op��es abaixo: ");
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + (i+1) + "-" + textos[i]);
		System.out.println("\t0-Sair");
		System.out.print("\n\nInsira a op��o desejada: ");
	}
	
	public static void getClientByCod (int cod, Cliente[] clientes) {
		
		if (cod >= clientes.length)
			throw new IndexOutOfBoundsException("C�digo de cliente inexistente!");
		
		for (Cliente i : clientes)
		{
			if (i.getCodigo() == cod)
				System.out.println("C�digo: " + i.getCodigo() + ", nome: " + i.getNome() + ", CPF: " + i.getCpf());
		}
	}

}
