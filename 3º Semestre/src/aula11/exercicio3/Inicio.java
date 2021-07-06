package aula11.exercicio3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Inicio {

	public static void main(String... args) throws Exception {
		
		List<String> values = Arrays.asList("Paulo", "Camila", "Ana Maria", "Patrick", "Ana Clara", "Pedro", "Alfredo");
		
		Optional<String> valuesStartingWithW = values.stream().filter(element -> element.startsWith("W")).findAny();
		
		valuesStartingWithW.ifPresent(System.out::println);
		valuesStartingWithW.ifPresentOrElse(System.out::println, () -> System.out.println("Nomes com esta letra não consta na lista"));
	}
	
}
