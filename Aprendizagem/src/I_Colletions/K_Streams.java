package I_Colletions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class K_Streams {

	public static void main(String[] args) {
		
		List<String> estudantes = new ArrayList<>();
		
		estudantes.add("Pedro");
		estudantes.add("Thayse");
		estudantes.add("Marcelo");
		estudantes.add("Carla");
		estudantes.add("Juliana");
		estudantes.add("Thiago");
		estudantes.add("Rafael");
		
		System.out.println("\nContagem: " + estudantes.stream().count());
		System.out.println("\nMaior numero de letras: " + estudantes.stream().max(Comparator.comparingInt(String::length)));
		System.out.println("\nMenor numero de letras: " + estudantes.stream().min(Comparator.comparingInt(String::length)));
		
		System.out.println("\nCom a letra r no nome: " + estudantes.stream().filter((estudante) -> 
			estudante.toLowerCase().contains("r")).collect(Collectors.toList()));
		
		System.out.println("\nRetorna uma nova coleção com a quantidade de letras: " + estudantes.stream().map((estudante) -> 
			estudante.concat(" - ").concat(String.valueOf(estudante.length()))).collect(Collectors.toList()));
		
		System.out.println("\nRetorna os 3 primeiros elementos: " + estudantes.stream().limit(3).collect(Collectors.toList()));
		System.out.println("\nRetorna os elementos: " + estudantes.stream().peek(System.out::println).collect(Collectors.toList()));
		
		System.out.println("\nRetorna os elementos novamente: ");
		estudantes.stream().forEach(System.out::println);
		
		System.out.println("\nTem algum elemento com W no nome? " + estudantes.stream().allMatch((elemento) -> elemento.contains("W")));
		System.out.println("\nTem algum elemento com a letra minuscula no nome? " + estudantes.stream().anyMatch((elemento) -> elemento.contains("a")));
		System.out.println("\nNão tem nenhum elemento com a minúscula no nome? " + estudantes.stream().noneMatch((elemento) -> elemento.contains("a")));
		
		System.out.println("\nRetorna o primeiro elemento da coleção: ");
		estudantes.stream().findFirst().ifPresent(System.out::println);
		
		System.out.println("\nOperação encadeada: ");

		System.out.println(estudantes.stream().peek(System.out::println).map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length())))
				.peek(System.out::println).filter((estudante) -> estudante.toLowerCase().contains("r")).collect(Collectors.toList()));
		//		.collect(Collectors.joining(", ")));
		//		.collect(Collectors.toSet()));
		//		.collect(Collectors.groupingBy(estudante -> estudante.substring(estudante.indexOf(" - ") + 1))));
	}
}