package aula06.exercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insira o primeiro valor: ");
		int value1 = scanner.nextInt();
		
		System.out.println("Insira o segundo valor: ");
		int value2 = scanner.nextInt();
		
		MathOperations mathOperations = new MathOperations(value1, value2);
		Thread thread = new Thread(mathOperations);
		thread.start();
		
		thread.join();
		System.out.println("O resultado é " + mathOperations.getResult());
		
		scanner.close();
	}

}
