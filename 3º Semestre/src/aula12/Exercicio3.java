package aula12;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exercicio3 {
	
	public static void main(String... args) {
		
		List<String> list = Arrays.asList("Cheiro", "de", "pimenta");
		
		Optional<String> result = list.stream().reduce((s1, s2) -> s1.concat("-").concat(s2));
		System.out.println("\n\nResultado: " + result.get());
	}

}
