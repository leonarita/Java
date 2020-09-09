package aula08;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio5 {

	public static void main(String[] args) {
		
		int op = 1;

		String[] textos = new String[] { "Inserir produtos no 1° conjunto", 
				"Inserir produtos no 2° conjunto", 
				"Consultar todos os produtos dos dois conjuntos", 
				"Consultar apenas os produtos em comum nos dois conjuntos", 
				"Consultar produtos do 1° conjunto que não existem no 2° conjunto", 
				"Consultar se o 1° conjunto está contido no 2° conjunto" };
		
		Scanner sc = new Scanner (System.in);
		
		HashSet<String> c1 = new HashSet<>();
		HashSet<String> c2 = new HashSet<>();
		
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
			
			if (op == 1) {
				System.out.print("\nInsira o nome do produto para inserir: ");
				c1.add(sc.nextLine());
				System.out.print("\n\tProduto inserido!");
			}
			
			else if (op == 2) {
				System.out.print("\nInsira o nome do produto para inserir: ");
				c2.add(sc.nextLine());
				System.out.print("\n\tProduto inserido!");
			}
			
			else if (op == 3) {
				HashSet<String> temp = new HashSet<>();
				
				for(String c : c1) {
					temp.add(c);
				}
				
				temp.addAll(c2);
				
				System.out.println("\n\tUnião: " + (temp.size() == 0 ? "Vazio" : temp));
			}
			
			else if (op == 4) {
				HashSet<String> temp = new HashSet<>();
				
				for(String c : c1) {
					temp.add(c);
				}
				
				temp.retainAll(c2);
				
				System.out.println("\n\tIntersecção: " + (temp.size() == 0 ? "Vazio" : temp));
			}
			
			else if (op == 5) {
				HashSet<String> temp = new HashSet<>();
				
				for(String c : c1) {
					temp.add(c);
				}
				
				temp.removeAll(c2);
				
				System.out.println("\n\tDiferença: " + (temp.size() == 0 ? "Vazio" : temp));
			}
			
			else if (op == 6) {
				System.out.println("\n\t" + (c2.containsAll(c1) ? "c2 contem c1" : "c2 não contem c1"));
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
