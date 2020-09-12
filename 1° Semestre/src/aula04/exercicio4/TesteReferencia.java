package aula04.exercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class TesteReferencia {

	public static void main (String[] args) {

		// Para tipos de dados provenientes de classes, a referência de memória não se aplicana atribuição (autoboxing por new)
		// => Integer, Float, Long, Double, Character, Boolean, String, BigDecimal
		
		String st1 = "aaa";
		String st2 = st1;
		st2 = "bbb";
		imprimirDados(st1, st2);

		String st3 = new String("aaa");
		String st4 = st3;
		st4 = "bbb";
		imprimirDados(st3, st4);
		
		// Valor Monetário, Data, Hora => Atribuição por referência
		Calendar dt1 = Calendar.getInstance();
		dt1.set(2020, 07, 13, 02, 00);
		Calendar dt2 = dt1;
		dt2.set(2020, 07, 13, 12, 00);
		imprimirDados(dt1.getTimeInMillis(), dt2.getTimeInMillis());
		
		// Para classes e coleções, a referência se aplica na atribuição
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 3));
		ArrayList<Integer> b = a;
		b.add(4);
		imprimirDados(a, b);
		
		// Lembrando que se atribuir um new, cria-se uma nova instância, e não altera a antiga
	}
	
	public static void imprimirDados(Object a, Object b) {
		System.out.println(a);
		System.out.println(b);
		System.out.println();
	}
}
