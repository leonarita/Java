package K_Threads;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class C_ParallelStreams {

	public static void main(String[] args) {
		
		long inicio = System.currentTimeMillis();
		IntStream.range(1, 10000).forEach(num -> System.out.println(fatorial(num)));				//SERIAL
		long fim = System.currentTimeMillis();
		System.out.println("Tempo de execução: " + (fim - inicio));
		
		inicio = System.currentTimeMillis();
		IntStream.range(1, 10000).parallel().forEach(num -> System.out.println(fatorial(num)));		//PARALLEL
		fim = System.currentTimeMillis();
		System.out.println("Tempo de execução: " + (fim - inicio));
		
		List<String> nomes = Arrays.asList("João", "Oliveira", "Paulo", "Santos");
		nomes.parallelStream().forEach(System.out::println);
	}
	
	public static long fatorial (long num) {
		long fat = 1;
		
		for (long i=2; i<=num; i++)
			fat *= i;
		
		return fat;
	}
}