package aula06.exercicio2;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
			
		int op = 1;
		Scanner sc = new Scanner(System.in);
		
		String[] textos = new String[] { "Calcular raiz quadrada", "Calcular potenciação", "Calcular fatorial" };
		
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
				System.out.print("Insira o número: ");
				double num = sc.nextDouble();
				System.out.println("\n\tA raiz quadrada de " + num + " é " + Calculo.ExecutarCalculo(num));
			}
			else if (op == 2) {
				System.out.print("Insira o a base: ");
				double base = sc.nextDouble();
				System.out.print("Insira o a potência: ");
				double potencia = sc.nextDouble();
				System.out.println("\n\t" + base + " elevado a " + potencia + " é " + Calculo.ExecutarCalculo(base, potencia));
			}
			else if (op == 3) {
				System.out.print("Insira o número: ");
				int num = sc.nextInt();
				System.out.println("\n\t" + num + "! = " + Calculo.ExecutarCalculo(num));
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
