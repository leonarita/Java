package aula06.exercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insira o primeiro valor: ");
		float value1 = scanner.nextFloat();
		
		System.out.println("Insira o segundo valor: ");
		float value2 = scanner.nextFloat();
		
		MathOperations mathOperations = new MathOperations(value1, value2);
		Thread thread = new Thread(mathOperations);
		thread.start();
		
		thread.join();
		System.out.println("Os dois valores somados resultam no valor " + mathOperations.getSoma());
		
		scanner.close();
	}

}
