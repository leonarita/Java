package M_Novidades;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class C_Inferencia_Lambda {

	public static void main(String[] args) {

		Function<Integer, Double> divisaoPor2 = (var numero) -> numero/2.0;
		System.out.println(divisaoPor2.apply(9846));
		
		String espaco = "                                            ";
		System.out.println(espaco == null || espaco.length() == 0 || espaco.chars().allMatch(c -> c == ' '));
		System.out.println(espaco.isBlank());
		
		String html = "<html>\n<head>\n</head>\n<body>\n</body>\n</html>";
		System.out.println(html.lines().map(s -> "[TAG] :: " + s).collect(Collectors.joining()));
		System.out.println(html.lines().map(s -> "[TAG] :: " + s).collect(Collectors.toList()));
		
		List<String> nomes = Arrays.asList("João", "Ana", "Carla");
		Collection<String> nomes2 = Arrays.asList("João", "Ana", "Carla");
		Collection<String> nomes3 = List.of("João", "Ana", "Carla");
		Collection<String> nomes4 = Set.of("João", "Ana", "Carla");
		
		System.out.println(nomes);
		System.out.println(nomes2);
		System.out.println(nomes3);
		System.out.println(nomes4);
		
		repeating("Leo");
		System.out.println("Leo".repeat(10));
	}
	
	public static void repeating(String nome) {
		String aux = "";
		
		for (int i=0; i<10; i++)
			aux += nome;
		
		System.out.println(aux);
	}
}
