package aula13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercicio3 {
	
	public static void main(String... args) {
		
		List<String> values = Arrays.asList("Pedro", "Gustavo", "Tiago", "Guilherme", "Andrey", "Luís");
		
		Map<Integer, List<String>> mapValues = values.stream().collect(Collectors.groupingBy(value -> value.length()));
		
		System.out.println(mapValues.toString());
	}

}
