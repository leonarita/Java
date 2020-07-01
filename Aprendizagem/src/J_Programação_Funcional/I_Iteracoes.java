package J_Programa��o_Funcional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class I_Iteracoes {

	public static void main(String[] args) {

		String[] nomes = {"Jo�o", "Paulo", "Oliveira", "Santos", "Instrutor", "Java"};
		Integer[] numeros = {1, 2, 3, 4, 5};
		
		imprimirNomesFiltrados(nomes);
		
		System.out.println("\n");
		imprimirTodosNomes(nomes);
		
		System.out.println("\n");
		dobrarElementosListas(numeros);
	}
	
	public static void imprimirNomesFiltrados(String... nomes) {
		String nomesParaImprimir = "";
		
		for (int i = 0; i < nomes.length; i++) {
			if (nomes[i].equals("Jo�o"))
				nomesParaImprimir += " " + nomes[i];
		}
		
		System.out.println("Nomes do for: " + nomesParaImprimir);
		
		String nomesDoStream = Stream.of(nomes).filter(nome -> nome.equals("Jo�o")).collect(Collectors.joining());
		System.out.println("Nomes do stream: " + nomesDoStream);
	}
	
	public static void imprimirTodosNomes(String... nomes) {
		for (String n : nomes)
			System.out.println(n);
		
		System.out.println("\n");
		Stream.of(nomes).forEach(System.out::println);
		//Stream.of(nomes).forEach(nome -> System.out.println(nome));
	}
	
	public static void dobrarElementosListas(Integer... numeros) {
		for (Integer n : numeros)
			System.out.println(n*2);
	}	
}
