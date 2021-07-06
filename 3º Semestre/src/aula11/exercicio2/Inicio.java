package aula11.exercicio2;

import java.util.Optional;

public class Inicio {

	public static void main(String... args) throws Exception {
		
		Optional<String> optionalEmpty = formatOptional(null);
		Optional<String> optionalWithData = formatOptional("ABCDE");

		getMessages(optionalWithData);
		getMessages(optionalEmpty);
	}
	
	public static Optional<String> formatOptional(String value) {
		try {
			return Optional.of(value);
		}
		catch(Exception e) {
			return Optional.empty();
		}
	}
	
	public static void getMessages(Optional<String> value) throws Exception {
		System.out.println(value.orElseThrow(() -> new Exception("Valor inválido")));
	}
	
}
