package aula09.exercicio2;

import java.util.ArrayList;
import java.util.Arrays;

public class Inicio {
	
	public static void main(String... args) {
		
		new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
			.stream()
			.filter(element -> element % 2 == 0)
			.skip(2)
			.limit(2)
			.map(element -> element * 2)
			.forEach(element -> System.out.print(element + " "));
			
	}

}
