package J_Programação_Funcional;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class H_Parametros {

	public static void main(String[] args) {

		Function<String, String> retornaNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
		System.out.println(retornaNomeAoContrario.apply("Leo"));
		
		Function<String, Integer> converterStringParaInteiroECalcularDobro = string -> Integer.valueOf(string) * 2;
		System.out.println(converterStringParaInteiroECalcularDobro.apply("20"));
		
		//Predicate<String> estaVazio = valor -> valor.isEmpty();
		Predicate<String> estaVazio = String::isEmpty;
		System.out.println(estaVazio.test(""));
		System.out.println(estaVazio.test("Leo"));
		
		Supplier<Pessoa> instanciaPessoa = () -> new Pessoa();
		Supplier<Pessoa> instanciaPessoa2 = Pessoa::new;
		System.out.println(instanciaPessoa.get());
		System.out.println(instanciaPessoa2.get());
	}
}

class Pessoa {
	private String nome;
	private Integer idade;
	
	public Pessoa() {
		nome = "Leo";
		idade = 20;
	}
	
	@Override
	public String toString() {
		return String.format("Nome: $s, idade: %d", nome, idade);
	}
}