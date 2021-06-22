package aula09.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inicio {
	
	public static void main(String... args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Insira um número: ");
		int number = scanner.nextInt();
		
		List<Integer> array = new ArrayList<Integer>();
		
		for(int i=0; i<number; i++) {
			array.add(i+1);
			array.add(i+1);
		}
		
		System.out.println("\n");
		array.forEach(element -> System.out.print(element + " "));
		
		System.out.println("\n");
		array.stream().distinct().forEach(element -> System.out.print(element + " "));
		
		System.out.println("\n");
		array.stream().distinct().filter(element -> element % 2 != 0).forEach(element -> System.out.print(element + " "));
		
		System.out.println("\n");
		array.stream().distinct().filter(element -> element % 2 == 0).forEach(element -> System.out.print(element + " "));
		
		System.out.println("\n");
		array.stream().distinct().skip(5).forEach(element -> System.out.print(element + " "));
		
		System.out.println("\n");
		array.stream().map(element -> element * 4).forEach(element -> System.out.print(element + " "));
		
		scanner.close();
	}

}
