package aula10.exercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Inicio {
	
	public static void main(String... args) {
		
		List<String> values = new ArrayList<>(Arrays.asList("Paulo", "Camila", "Ana Maria", "Patrick", "Ana Clara", "Pedro", "Alfredo"));
		
		String valuesStartingWithP = values.stream().filter(value -> value.startsWith("P")).map(value -> value).collect(Collectors.joining(", "));
		System.out.println("Valores que começam com P: " + valuesStartingWithP);
		System.out.println("\n");
		
		Map<Integer, List<String>> valuesGroupingByLengthChar = values.stream().collect(Collectors.groupingBy(e -> e.length()));
		
		for(Integer value : valuesGroupingByLengthChar.keySet()) {
			
			System.out.println("Valores com " + value + " caracteres: " + 
					valuesGroupingByLengthChar.get(value).stream().collect(Collectors.joining(", "))
			);
		}
		System.out.println("\n");
		
		Map<Boolean, List<String>> valuesStartingWithA = values.stream().collect(Collectors.groupingBy(e -> e.startsWith("A")));
		
		System.out.println("Valores que começam com a letra A: " + valuesStartingWithA.get(true).stream().collect(Collectors.joining(", ")));
		System.out.println("Valores que não começam com a letra A: " + valuesStartingWithA.get(false).stream().collect(Collectors.joining(", ")));
		System.out.println("\n");
		
		Map<Integer, List<String>> valuesGroupingByLegth = values.stream()
				.map(element -> element.toUpperCase())
				.collect(Collectors.groupingBy(e -> e.length()));
		
		for(Integer value : valuesGroupingByLegth.keySet()) {
			
			System.out.println("Valores com " + value + " caracteres: " + 
					valuesGroupingByLegth.get(value).stream().collect(Collectors.joining(", "))
			);
		}
		
	}

}
