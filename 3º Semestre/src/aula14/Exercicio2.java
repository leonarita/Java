package aula14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercicio2 {
	
	public static void main(String... args) {
		
		boolean valorValido = false;
		int x = 0, y = 0;
		double r;
			
		try(Scanner teclado = new Scanner(System.in)) {
			
			do {
				
				System.out.println("\n\n\n\t\t\tEu sei dividir!");

				try {
					System.out.print("\n\t\tInforme o primeiro valor: ");
					x = teclado.nextInt();
				}
				catch (InputMismatchException e) {
					
					valorValido = false;
					
					do {
						
						System.out.println("\n\tInsira um valor num�rico");
						
						try {
							teclado.nextLine();
							
							System.out.print("\n\t\tInforme o primeiro valor: ");
							x = teclado.nextInt();
							
							valorValido = true;
						}
						catch (InputMismatchException a) { }
					}
					while(valorValido == false);
				}
				
				valorValido = false;
				
				try {
					System.out.print("\n\t\tInforme o segundo valor: ");
					y = teclado.nextInt();
					
					if(y == 0) {
						throw new InputMismatchException();
					}
				}
				catch (InputMismatchException e) {
					
					valorValido = false;
					
					do {
						System.out.println("\n\tInsira um valor num�rico que n�o seja zero");
						
						try {
							teclado.nextLine();
							
							System.out.print("\n\t\tInforme o segundo valor: ");
							y = teclado.nextInt();
							
							if(y == 0) {
								throw new InputMismatchException();
							}
							
							valorValido = true;
						}
						catch (InputMismatchException a) { }
					}
					while(valorValido == false);
				}
				
				valorValido = false;
				
				try {
					r = (x/y);
					System.out.println("\n\nO resultado da soma �: " + r);
					valorValido = true;
				}
				catch(ArithmeticException e) {
					System.out.println("\n\tN�o foi poss�vel realizar a opera��o de divis�o");
				}
				
				teclado.nextLine();
				
			}
			while(valorValido == false);
		}
		
	}

}
