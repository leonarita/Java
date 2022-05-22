package questao2;

import java.util.Scanner;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = lerValor();
		System.out.println("\t\tO resultado foi: " + calcularValor(n));
	}
	
	private static int lerValor() {
		
		try {
			System.out.print("Insira um valor numérico maior que 0: ");
			int n = scanner.nextInt();
			
			if(n < 1)
				throw new NumberFormatException();
			
			System.out.println("\tValor " + n + " aceito!");
			return n;
		}
		catch(NumberFormatException e) {
			System.out.println("\tO valor inserido não é maior que 0. Por favor, insira novamente.");
			return lerValor();
		}
	}
	
	private static double calcularValor(int n) {
		double resposta = 0d;
		
		for(int i=1; i<=n; i++) {
			resposta += (double)(-i + 1) / (i * i);
		}
		
		return resposta;
	}

}
