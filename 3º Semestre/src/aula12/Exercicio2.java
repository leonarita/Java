package aula12;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Exercicio2 {
	
	public static void main(String... args) {
		
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<5; i++) {
			System.out.print("Insira o " + (i+1) + "° elemento: ");
			list.add(scanner.nextInt());
		}
		
		scanner.close();
		
		Optional<Integer> result = list.stream().reduce((n1, n2) -> n1 + n2);
		System.out.println("\n\nResultado: " + result.get());
	}

}
