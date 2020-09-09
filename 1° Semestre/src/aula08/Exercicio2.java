package aula08;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {
		
		int op = 1;

		String[] textos = new String[] { "Inserir pessoas", "Remover pessoas", "Imprimir fila" };
		
		Scanner sc = new Scanner (System.in);
		
		LinkedList<String> fila = new LinkedList<>();
		
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
			
			if (op == 1) {
				System.out.print("\nInsira o nome para inserir: ");
				String p = sc.nextLine();
				fila.addLast(p);
				System.out.print("\n\tPessoa inserida!");
			}
			
			else if (op == 2) {
				if(!fila.isEmpty()) {
					fila.pollFirst();
					System.out.print("\n\tPessoa removida!");
				}
				else {
					System.out.print("\n\tFila vazia!");
				}
			}
			
			else if (op == 3) {
				if(fila.isEmpty())
					System.out.println("\n\tFila est� vazia!");
				else
					System.out.println("\n\t" + fila);
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
