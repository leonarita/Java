package I_Colletions;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class J_Optionals {

	public static void main(String[] args) {

		//Permite opera��es em valores que podem ser nulos
		Optional<String> optionalString = Optional.of("Valor presente");
		
		System.out.println(optionalString.isPresent());
		System.out.println(optionalString.isEmpty());
		optionalString.ifPresent(System.out::println);
		
		if (optionalString.isPresent()) {
			System.out.println(optionalString.get());
		}
		
		System.out.println("\nValor opcional que est� presente");
		optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("N�o est� presente"));
		
		Optional<String> optionalNull = Optional.ofNullable(null);
		System.out.println("\nValor opcional que n�o est� presente");
		optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("NULL: N�o est� presente"));
		
		Optional<String> emptyOptional = Optional.empty();
		System.out.println("\nValor opcional que n�o est� presente");
		emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("EMPTY: N�o est� presente"));
		
//		Optional<String> optionalNullErro = Optional.of(null);
//		System.out.println("\nValor opcional que lan�a erro NullPointerException");
//		optionalNullErro.ifPresentOrElse(System.out::println, () -> System.out.println("ERRO: N�o est� presente"));
		
		optionalString.map((valor) -> valor.concat("****")).ifPresent(System.out::println);
		optionalString.orElseThrow(IllegalStateException::new);
		
		System.out.println("\n***Valor inteiro opcional***");
		OptionalInt.of(12).ifPresent(System.out::println);
		
		System.out.println("\n***Valor decimal opcional***");
		OptionalDouble.of(55.2).ifPresent(System.out::println);
		
		System.out.println("\n***Valor longo opcional***");
		OptionalLong.of(23L).ifPresent(System.out::println);
	}
}
