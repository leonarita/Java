package aula06.exercicio1;

import java.util.Scanner;

public class Inicio {
	
	// Ao alterar de estático para dinâmico, a soma de v2 torna-se zero

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Venda v1 = new Venda();
		
		for(int i=0; i<=5; i++) {
			System.out.print("Insira um valor: ");
			float val = sc.nextFloat();
			
			v1.setSum(val);
		}
		
		Venda v2 = new Venda();
		
		System.out.println("\n\nVenda v1: " + v1.getSum());
		System.out.println("Venda v2: " + v2.getSum());
		
		sc.close();
	}
}
