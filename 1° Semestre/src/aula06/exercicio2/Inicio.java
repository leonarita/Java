package aula06.exercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inicio {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
			
		int op = 1;
		
		String[] textos = new String[] { "Calcular raiz quadrada", "Calcular potenciação", "Calcular fatorial" };
		
		do {
			try {
				menu(textos);
				op = sc.nextInt();
				sc.nextLine();
				System.out.println("\n\n");
			}
			catch (InputMismatchException e) {
				System.out.println("\n\n\t\tInsira um número válido!");
				sc.nextLine();
				continue;
			}
			
			if (op == 0) {
				System.out.println("Até a próxima!");
				break;
			}
			else if (op == 1) {
				try {
					System.out.print("Insira o número: ");
					double num = sc.nextDouble();
					System.out.println("\n\tA raiz quadrada de " + num + " é " + Calculo.ExecutarCalculo(num));
				}
				catch (ArithmeticException | InputMismatchException e) {
					sc.nextLine();
					if (e.getClass().toString().equals("class java.util.InputMismatchException"))
						System.out.println("Número inserido inválido!");
					else
						System.out.println("Erro na conta!");
				}
			}
			else if (op == 2) {
				try {
					System.out.print("Insira o a base: ");
					double base = sc.nextDouble();
					System.out.print("Insira o a potência: ");
					double potencia = sc.nextDouble();
					System.out.println("\n\t" + base + " elevado a " + potencia + " é " + Calculo.ExecutarCalculo(base, potencia));
				}
				catch (InputMismatchException e) {
					sc.nextLine();
					System.out.println("Número inserido inválido!");
				}
				catch (ArithmeticException e) {
					System.out.println("Erro na conta!");
				}
			}
			else if (op == 3) {
				try {
					calcularFatorial();
				}
				catch (ArithmeticException | InputMismatchException e) {
					System.out.println("Houve algum erro na execução do fatorial...");
					sc.nextLine();
				}
			}
			else {
				System.out.print("Opção inválida");
			}
			
		}
		while (op != 0);
		
		sc.close();
	}
	
	public static void calcularFatorial() throws InputMismatchException {
		System.out.print("Insira o número: ");
		int num = sc.nextInt();
		System.out.println("\n\t" + num + "! = " + Calculo.ExecutarCalculo(num));
		sc.nextLine();
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
