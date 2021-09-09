package aula16;

import java.util.Random;
import java.util.Scanner;

public class Exercicio1 {

	private static Scanner scanner = new Scanner(System.in);
	private static Random random = new Random();
	
	public static void main(String... args) {
		validateVariableX();
		System.out.println("\n\n");
		divisionByZero();
		System.out.println("\n\n");
	}
	
	private static void validateVariableX() {
		System.out.print("Insira o valor da vari�vel x: ");
		int x = scanner.nextInt();
		
		try {
			ExceptionHandler.validateVariable(x);
		}
		catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Finalizada a execu��o do m�todo validateVariable()");
		}
	}
	
	private static void divisionByZero() {
		try {
			int value = random.nextInt();
			System.out.println(value + " dividido por zero � " + ExceptionHandler.divisonByZero(value));
		}
		catch(ArithmeticException e) {
			System.out.println("Erro ao realizar opera��o de divis�o por zero");
		}
		finally {
			System.out.println("Finalizada a execu��o do m�todo divisionByZero()");
		}
	}

}
