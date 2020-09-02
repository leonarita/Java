package aula04.exercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio 
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int cod;
		try {
			System.out.print("Insira o código do produto: ");
			cod = sc.nextInt();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira um código numérico! Ultima tentativa...");
				System.out.print("\tInsira o código do produto: ");
				cod = sc.nextInt();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				cod = 0;
				System.out.println("Código zerado");
			}
		}
		
		sc.nextLine();
		System.out.print("Insira a descrição do produto: ");
		String desc = sc.nextLine();
		
		float prec = 0;
		
		try {
			System.out.print("Insira o preço do produto: ");
			prec = sc.nextFloat();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira um preço numérico! Ultima tentativa...");
				System.out.print("\tInsira o preço do produto: ");
				prec = sc.nextInt();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				prec = 0;
				System.out.println("Código zerado");
			}
		}
		
		boolean atv;
		try {
			System.out.print("Insira se o produto está ativo (true/false): ");
			atv = sc.nextBoolean();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira apenas true ou false! Ultima tentativa...");
				System.out.print("Insira se o produto está ativo (true/false): ");
				atv = sc.nextBoolean();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				atv = false;
				System.out.println("Não está ativo...");
			}
		}
		
		Produto prod = new Produto(cod, desc, prec, atv);
			
		System.out.println("\n\nO código do objeto prod é: " + prod.getCodigo());
		System.out.println("A descrição do objeto prod é: " + prod.getDescricao());
		System.out.println("O preço do objeto prod é: " + prod.getPreco());
		System.out.println("O ativo do objeto prod é: " + prod.isAtivo());
		
		try {
			System.out.print("Insira o novo código do produto: ");
			cod = sc.nextInt();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira um código numérico! Ultima tentativa...");
				System.out.print("\tInsira o novo código do produto: ");
				cod = sc.nextInt();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				cod = 0;
				System.out.println("Código zerado");
			}
		}
		
		sc.nextLine();
		System.out.print("Insira a nova descrição do produto: ");
		desc = sc.nextLine();
		
		try {
			System.out.print("Insira o novo preço do produto: ");
			prec = sc.nextFloat();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira um preço numérico! Ultima tentativa...");
				System.out.print("\tInsira o novo preço do produto: ");
				prec = sc.nextInt();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				prec = 0;
				System.out.println("Código zerado");
			}
		}
		
		try {
			System.out.print("Reinsira se o produto está ativo (true/false): ");
			atv = sc.nextBoolean();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tReinsira apenas true ou false! Ultima tentativa...");
				System.out.print("Reinsira se o produto está ativo (true/false): ");
				atv = sc.nextBoolean();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				atv = false;
				System.out.println("Não está ativo...");
			}
		}
		
		prod = new Produto(cod, desc, prec, atv);
		
		System.out.println("\n\nO novo código do objeto prod é: " + prod.getCodigo());
		System.out.println("A nova descrição do objeto prod é: " + prod.getDescricao());
		System.out.println("O novo preço do objeto prod é: " + prod.getPreco());
		System.out.println("O novo ativo do objeto prod é: " + prod.isAtivo());
		
		sc.close();
	}
}
