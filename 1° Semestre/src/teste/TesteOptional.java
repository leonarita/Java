package teste;

import java.util.Optional;

import aula05.exercicio1.Cliente;

public class TesteOptional {

	public static void main(String[] args) {
		Optional<Cliente> optional1 = gerar(1);
		Optional<Cliente> optional2 = gerar(2);
		
		System.out.println(optional1);
		System.out.println(optional2);

		// Esses métodos abaixos podem gerar NullPointer
		
		System.out.println("\n");
		System.out.println(optional1.get());
		
		try {
			System.out.println(optional2.get());
		}
		catch(NullPointerException e) {
			System.out.println("NullPointer");
		}
		System.out.println("\n");
		
		System.out.println(optional1.isPresent());		
		System.out.println(optional1.isEmpty());
	}
	
	public static Optional<Cliente> gerar(int op) {
		return (op == 1 ? Optional.of(new Cliente()) : null);
	}
}
