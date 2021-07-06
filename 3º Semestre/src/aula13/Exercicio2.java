package aula13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercicio2 {
	
	public static void main(String... args) {
		
		List<String> values = Arrays.asList("Pedro", "Gustavo", "Tiago", "Guilherme", "Andrey", "Luís");
		
		Map<String, Integer> mapValues = values.stream().collect(Collectors.toMap(value -> value, value -> value.length()));
		
		System.out.println(mapValues.toString());
	}

}
