package aula10.exercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Inicio {
	
	public static void main(String... args) {
		
		Random generator = new Random();
		List<Integer> numbers1 = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			numbers1.add(generator.nextInt(101));
		}
		
		System.out.println("=== NÚMEROS GERADOS ===");
		String numbers = numbers1.stream().map(element -> String.valueOf(element)).collect(Collectors.joining(", "));
		System.out.println("\t" + numbers);
		
		List<Integer> numbers2 = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			numbers2.add(generator.nextInt(11));
		}
		
		System.out.println("\n\n=== NÚMEROS (1 a 10) ===");
		System.out.println("\tMaior número: " + numbers2.stream().max(Comparator.naturalOrder()));
		System.out.println("\tMenor número: " + numbers2.stream().min(Comparator.naturalOrder()));
		System.out.println("\tQuantidade de números: " + numbers2.stream().count());
	}

}
