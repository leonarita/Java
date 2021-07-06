package aula13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercicio1 {
	
	public static void main(String... args) {
		
		List<String> values = Arrays.asList("Pedro", "Gustavo", "Tiago", "Guilherme", "Andrey", "Luís");
		
		Double avg = values.stream().collect(Collectors.averagingInt(element -> element.length()));
		
		System.out.println("Média: " + avg);
	}

}
