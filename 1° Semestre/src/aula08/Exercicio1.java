package aula08;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio1 {

	public static void main(String[] args) {
		
		// Pesquisar interface Comparable
		
		int op = 1;

		String[] textos = new String[] { "Inserir produto", "Inserir produto em posição específica", "Consultar produto pelo nome",
				"Consultar produto pela posição", "Substituir produto", "Remover produto pelo nome", "Remover produto pela posição" };
		
		Scanner sc = new Scanner (System.in);
		
		ArrayList<String> lista = new ArrayList<>();
		
		do {
			
			try {
				menu(textos);
				op = sc.nextInt();
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println("\n\n\t\tInsira um número válido!");
				sc.nextLine();
				continue;
			}
			
			if (op == 0) {
				System.out.println("\n\n\t\tAté a próxima!");
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
					
					System.out.print("\n\tInsira a posição do produto para inserir: ");
					int i = sc.nextInt();
					
					lista.add(i, p);
					
					System.out.print("\n\t\tProduto inserido!");
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("\n\n\t\tERRO: Manipulação de índice inexistente");
				}
				catch (InputMismatchException e) {
					System.out.println("\n\n\t\tERRO: Dados de entrada mal formatados");
					sc.nextLine();
				}
			}
			
			else if (op == 3) {
				System.out.print("\n\tInsira o nome do produto para consultar: ");
				String p = sc.nextLine();
				
				System.out.println("\n\t\t" + (lista.indexOf(p) != -1 ? "Produto está na posição " + lista.indexOf(p) + "!" : "Produto não está na lista!"));
			}
			
			else if (op == 4) {
				try {
					System.out.print("\n\tInsira a posição do produto para consultar: ");
					int i = sc.nextInt();
				
					System.out.println(lista.get(i));
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("\n\n\t\tERRO: Manipulação de índice inexistente");
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
					
					System.out.print("\n\tInsira a posição do produto para substituir: ");
					int i = sc.nextInt();
					
					lista.set(i, p);
					
					System.out.print("\n\t\tProduto substituido!");
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("\n\n\t\tERRO: Manipulação de índice inexistente");
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
					System.out.print("\n\tInsira a posição do produto para substituir: ");
					lista.remove(sc.nextInt());
					System.out.print("\n\t\tProduto removido!");
				}
				catch (IndexOutOfBoundsException e) {
					System.out.println("\n\n\t\tERRO: Manipulação de índice inexistente");
				}
				catch (InputMismatchException e) {
					System.out.println("\n\n\t\tERRO: Dados de entrada mal formatados");
					sc.nextLine();
				}
			}
			
			else
				System.out.println("\n\n\tComando inválido!");
			
		}
		while (op != 0);
		
		sc.close();

	}
	
	public static void menu (String[] textos) {
		System.out.println("\n\nConsidere as opções abaixo: ");
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + (i+1) + "-" + textos[i]);
		System.out.println("\t0-Sair");
		System.out.print("\n\nInsira a opção desejada: ");
	}
}
