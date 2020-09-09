package aula08;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {
		
		int op = 1;

		String[] textos = new String[] { "Inserir produto", "Consultar produtos", "Consultar produto pelo nome", "Remover produto" };
		
		Scanner sc = new Scanner (System.in);
		
		HashSet<String> produtos = new HashSet<>();
		
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
				System.out.print("\nInsira o nome do produto para inserir: ");
				produtos.add(sc.nextLine());
				System.out.print("\n\tProduto inserido!");
			}
			
			else if (op == 2) {
				if(produtos.isEmpty())
					System.out.println("\n\tConjunto de produtos est� vazio!");
				else
					System.out.println(produtos);
			}
			
			else if (op == 3) {
				System.out.print("\nInsira o nome do produto para consultar: ");
				
				System.out.println("\n\t" + (produtos.contains(sc.nextLine()) ? "Produto est� no conjunto!" : "Produto n�o est� no conjunto!"));
			}
			
			else if (op == 4) {
				if(produtos.isEmpty())
					System.out.println("\n\tConjunto de produtos est� vazio!");
				else {
					System.out.print("\nInsira o nome do produto para remover: ");

					if(produtos.remove(sc.nextLine()))
						System.out.print("\n\tProduto removido!");
					else
						System.out.print("\n\tProduto n�o encontrado!");
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
