package aula18.exercicio2;

import java.util.Arrays;
import java.util.List;

public class Exercicio2 {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread());
		new Thread(() -> System.out.println("Executando.")).run();
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer soma = numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println(soma);
		
		Integer soma2 = numbers.stream().reduce(0, Integer::sum);
		System.out.println(soma2);
		
	}

}
