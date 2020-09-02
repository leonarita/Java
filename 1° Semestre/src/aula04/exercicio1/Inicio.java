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
			System.out.print("Insira o c�digo do produto: ");
			cod = sc.nextInt();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira um c�digo num�rico! Ultima tentativa...");
				System.out.print("\tInsira o c�digo do produto: ");
				cod = sc.nextInt();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				cod = 0;
				System.out.println("C�digo zerado");
			}
		}
		
		sc.nextLine();
		System.out.print("Insira a descri��o do produto: ");
		String desc = sc.nextLine();
		
		float prec = 0;
		
		try {
			System.out.print("Insira o pre�o do produto: ");
			prec = sc.nextFloat();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira um pre�o num�rico! Ultima tentativa...");
				System.out.print("\tInsira o pre�o do produto: ");
				prec = sc.nextInt();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				prec = 0;
				System.out.println("C�digo zerado");
			}
		}
		
		boolean atv;
		try {
			System.out.print("Insira se o produto est� ativo (true/false): ");
			atv = sc.nextBoolean();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira apenas true ou false! Ultima tentativa...");
				System.out.print("Insira se o produto est� ativo (true/false): ");
				atv = sc.nextBoolean();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				atv = false;
				System.out.println("N�o est� ativo...");
			}
		}
		
		Produto prod = new Produto(cod, desc, prec, atv);
			
		System.out.println("\n\nO c�digo do objeto prod �: " + prod.getCodigo());
		System.out.println("A descri��o do objeto prod �: " + prod.getDescricao());
		System.out.println("O pre�o do objeto prod �: " + prod.getPreco());
		System.out.println("O ativo do objeto prod �: " + prod.isAtivo());
		
		try {
			System.out.print("Insira o novo c�digo do produto: ");
			cod = sc.nextInt();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira um c�digo num�rico! Ultima tentativa...");
				System.out.print("\tInsira o novo c�digo do produto: ");
				cod = sc.nextInt();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				cod = 0;
				System.out.println("C�digo zerado");
			}
		}
		
		sc.nextLine();
		System.out.print("Insira a nova descri��o do produto: ");
		desc = sc.nextLine();
		
		try {
			System.out.print("Insira o novo pre�o do produto: ");
			prec = sc.nextFloat();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tInsira um pre�o num�rico! Ultima tentativa...");
				System.out.print("\tInsira o novo pre�o do produto: ");
				prec = sc.nextInt();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				prec = 0;
				System.out.println("C�digo zerado");
			}
		}
		
		try {
			System.out.print("Reinsira se o produto est� ativo (true/false): ");
			atv = sc.nextBoolean();
		}
		catch (InputMismatchException e) {
			try {
				sc.nextLine();
				System.out.println("\tReinsira apenas true ou false! Ultima tentativa...");
				System.out.print("Reinsira se o produto est� ativo (true/false): ");
				atv = sc.nextBoolean();
			}
			catch (InputMismatchException a) {
				sc.nextLine();
				atv = false;
				System.out.println("N�o est� ativo...");
			}
		}
		
		prod = new Produto(cod, desc, prec, atv);
		
		System.out.println("\n\nO novo c�digo do objeto prod �: " + prod.getCodigo());
		System.out.println("A nova descri��o do objeto prod �: " + prod.getDescricao());
		System.out.println("O novo pre�o do objeto prod �: " + prod.getPreco());
		System.out.println("O novo ativo do objeto prod �: " + prod.isAtivo());
		
		sc.close();
	}
}
