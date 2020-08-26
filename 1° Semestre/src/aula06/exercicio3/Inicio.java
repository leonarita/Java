package aula06.exercicio3;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
			
		int op = 1;
		Scanner sc = new Scanner(System.in);
		
		String[] textos = new String[] { "Informar texto", "Buscar string", "Buscar string no início", "Buscar string no fim" };
		
		Pesquisa p1;
		
		do {
			menu(textos);
			op = sc.nextInt();
			sc.nextLine();
			System.out.println("\n\n");
			
			if (op == 0) {
				System.out.println("Até a próxima!");
				break;
			}
			else if (op == 1) {
				System.out.print("Insira um texto: ");
				String text = sc.nextLine();
				Pesquisa.setText(text);
			}
			else if (op == 2) {
				System.out.print("Insira uma string a ser pesquisada: ");
				String text = sc.nextLine();
				
				p1 = new Pesquisa();
				
				if (p1.buscarString(text)) {
					System.out.println("\nHá essa string no texto!");
				}
				else {
					System.out.println("\nNão há essa string no texto!");
				}
			}
			else if (op == 3) {
				System.out.print("Insira uma string a ser pesquisada no início do texto: ");
				String text = sc.nextLine();
				
				p1 = new PesquisaInicio();
				
				if (p1.buscarString(text)) {
					System.out.println("\nHá essa string no texto no início do texto!");
				}
				else {
					System.out.println("\nNão há essa string no texto no início do texto!");
				}
			}
			else if (op == 4) {
				System.out.print("Insira uma string a ser pesquisada no fim do texto: ");
				String text = sc.nextLine();
				
				p1 = new PesquisaFim();
				
				if (p1.buscarString(text)) {
					System.out.println("\nHá essa string no texto no fim do texto!");
				}
				else {
					System.out.println("\nNão há essa string no texto no fim do texto!");
				}
			}
			else {
				System.out.print("Opção inválida");
			}
			
			
		}
		while (op != 0);
		
		sc.close();
	}
	
	public static void menu (String[] textos)
	{
		System.out.println("\n\nConsidere as opções abaixo: ");
		
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + (i+1) + "-" + textos[i]);
		
		System.out.println("\t0-Sair");
		System.out.print("\n\nInsira a opção desejada: ");
	}
}
