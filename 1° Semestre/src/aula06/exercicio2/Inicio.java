package aula06.exercicio2;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
			
		int op = 1;
		Scanner sc = new Scanner(System.in);
		
		String[] textos = new String[] { "Calcular raiz quadrada", "Calcular potencia��o", "Calcular fatorial" };
		
		do {
			menu(textos);
			op = sc.nextInt();
			sc.nextLine();
			System.out.println("\n\n");
			
			if (op == 0) {
				System.out.println("At� a pr�xima!");
				break;
			}
			else if (op == 1) {
				System.out.print("Insira o n�mero: ");
				double num = sc.nextDouble();
				System.out.println("\n\tA raiz quadrada de " + num + " � " + Calculo.ExecutarCalculo(num));
			}
			else if (op == 2) {
				System.out.print("Insira o a base: ");
				double base = sc.nextDouble();
				System.out.print("Insira o a pot�ncia: ");
				double potencia = sc.nextDouble();
				System.out.println("\n\t" + base + " elevado a " + potencia + " � " + Calculo.ExecutarCalculo(base, potencia));
			}
			else if (op == 3) {
				System.out.print("Insira o n�mero: ");
				int num = sc.nextInt();
				System.out.println("\n\t" + num + "! = " + Calculo.ExecutarCalculo(num));
			}
			else {
				System.out.print("Op��o inv�lida");
			}
			
		}
		while (op != 0);
		
		sc.close();
	}
	
	public static void menu (String[] textos)
	{
		System.out.println("\n\nConsidere as op��es abaixo: ");
		
		for (int i=0; i<textos.length; i++)
			System.out.println("\t" + (i+1) + "-" + textos[i]);
		
		System.out.println("\t0-Sair");
		System.out.print("\n\nInsira a op��o desejada: ");
	}
}
