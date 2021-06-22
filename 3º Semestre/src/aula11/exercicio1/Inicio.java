package aula11.exercicio1;

import java.util.Optional;

public class Inicio {
	
	// Ao rodar o programa, aparecerá as repostas do exercícios
	
	public static void main(String... args) {
		
		Optional<String> optionalEmpty = formatOptional(null);
		Optional<String> optionalWithData = formatOptional("ABCDE");
		
		getMessages(optionalEmpty);
		getMessages(optionalWithData);
	}
	
	public static Optional<String> formatOptional(String value) {
		try {
			return Optional.of(value);
		}
		catch(Exception e) {
			return Optional.empty();
		}
	}
	
	public static void getMessages(Optional<String> value) {
		System.out.println(value.orElse("ESTÁ VAZIO"));
		System.out.println(value.orElseGet(() -> "VALOR VAZIO"));
		System.out.println("\n");
	}

}
