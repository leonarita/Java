package aula08;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercicio3 {

	public static void main(String[] args) {
		
		int op = 1;
	
		String[] textos = new String[] { "Inserir livro", "Remover livro", "Imprimir pilha" };
		
		Scanner sc = new Scanner (System.in);
		
		LinkedList<String> pilha = new LinkedList<>();
		
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
				System.out.print("\nInsira o nome para inserir: ");
				String p = sc.nextLine();
				pilha.addLast(p);
				System.out.print("\n\tLivro inserido!");
			}
			
			else if (op == 2) {
				if(!pilha.isEmpty()) {
					pilha.pollFirst();
					System.out.print("\n\tLivro removido!");
				}
				else {
					System.out.print("\n\tPilha vazia!");
				}
			}
			
			else if (op == 3) {
				if(pilha.isEmpty())
					System.out.println("\n\tPilha está vazia!");
				else
					System.out.println("\n\t" + pilha);
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
