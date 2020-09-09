package aula08;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		
		// Pesquisar interface Comparable
		
		int op = 1;

		String[] textos = new String[] { "Inserir produto", "Inserir produto em posi��o espec�fica", "Consultar produto pelo nome",
				"Consultar produto pela posi��o", "Substituir produto", "Remover produto pelo nome", "Remover produto pela posi��o" };
		
		Scanner sc = new Scanner (System.in);
		
		ArrayList<String> lista = new ArrayList<>();
		
		do {
			
			try {
				menu(textos);
				op = sc.nextInt();
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println("\n\n\t\tInsira um n�mero v�lido!");
				sc.nextLine();
				continue;
			}
			
			if (op == 0) {
				System.out.println("\n\n\t\tAt� a pr�xima!");
				break;
			}
			
			else if (op == 1) {
				System.out.print("\nInsira o nome do produto para inserir: ");
				lista.add(sc.nextLine());
				System.out.print("\n\tProduto inserido!");
			}
			
			else if (op == 2) {
				try {
					System.out.print("\n\tInsira o nome do produto para inserir: ");
					String p = sc.nextLine();
					
					System.out.print("\n\tInsira a posi��o do produto para inserir: ");
					int i = sc.nextInt();
					
					lista.add(i, p);
					
					System.out.print("\n\t\tProduto inserido!");
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("\n\n\t\tERRO: Manipula��o de �ndice inexistente");
				}
				catch (InputMismatchException e) {
					System.out.println("\n\n\t\tERRO: Dados de entrada mal formatados");
					sc.nextLine();
				}
			}
			
			else if (op == 3) {
				System.out.print("\n\tInsira o nome do produto para consultar: ");
				String p = sc.nextLine();
				
				System.out.println("\n\t\t" + (lista.indexOf(p) != -1 ? "Produto est� na posi��o " + lista.indexOf(p) + "!" : "Produto n�o est� na lista!"));
			}
			
			else if (op == 4) {
				try {
					System.out.print("\n\tInsira a posi��o do produto para consultar: ");
					int i = sc.nextInt();
				
					System.out.println(lista.get(i));
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("\n\n\t\tERRO: Manipula��o de �ndice inexistente");
				}
				catch (InputMismatchException e) {
					System.out.println("\n\n\t\tERRO: Dados de entrada mal formatados");
					sc.nextLine();
				}
			}
			
			else if (op == 5) {
				try {
					System.out.print("\n\tInsira o nome do produto para substituir: ");
					String p = sc.nextLine();
					
					System.out.print("\n\tInsira a posi��o do produto para substituir: ");
					int i = sc.nextInt();
					
					lista.set(i, p);
					
					System.out.print("\n\t\tProduto substituido!");
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("\n\n\t\tERRO: Manipula��o de �ndice inexistente");
				}
				catch (InputMismatchException e) {
					System.out.println("\n\n\t\tERRO: Dados de entrada mal formatados");
					sc.nextLine();
				}
			}
			
			else if (op == 6) {
				System.out.print("\n\tInsira o nome do produto para substituir: ");
				lista.remove(sc.nextLine());
				System.out.print("\n\t\tProduto removido!");
			}
			
			else if (op == 7) {
				try {
					System.out.print("\n\tInsira a posi��o do produto para substituir: ");
					lista.remove(sc.nextInt());
					System.out.print("\n\t\tProduto removido!");
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("\n\n\t\tERRO: Manipula��o de �ndice inexistente");
				}
				catch (InputMismatchException e) {
					System.out.println("\n\n\t\tERRO: Dados de entrada mal formatados");
					sc.nextLine();
				}
			}
			
			else
				System.out.println("\n\n\tComando inv�lido!");
			
		}
		while (op != 0);
		
		sc.close();

	}
	
	public static void menu (String[] textos) {
		System.out.println("\n\nConsidere as op��es abaixo: ");
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + (i+1) + "-" + textos[i]);
		System.out.println("\t0-Sair");
		System.out.print("\n\nInsira a op��o desejada: ");
	}
}
