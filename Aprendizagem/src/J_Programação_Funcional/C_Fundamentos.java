package J_Programação_Funcional;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class C_Fundamentos {

	public static void main(String[] args) {

		funcoesPuras();
		System.out.println("\n");
		
		imutabilidade();
		System.out.println("\n");
		
		System.out.println(buscarUsuario(15));
		Function<Integer, Object> user = idUsuario -> new Object();
		System.out.println(user);
	}
	
	public static void funcoesPuras() {
		
		BiPredicate<Integer, Integer> verificaSeMaior = (parametro, valorComparacao) -> parametro > valorComparacao;
		
		System.out.println(verificaSeMaior.test(13, 12));
		System.out.println(verificaSeMaior.test(13, 12));
	}
	
	public static void imutabilidade() {
		
		int valor = 20;
		
		UnaryOperator<Integer> retornarDobro = v -> v * 2;
		
		System.out.println(retornarDobro.apply(valor));
		System.out.println(valor);
	}

	public static Object buscarUsuario(int idUsuario) {
		return new Object();
	}
}
