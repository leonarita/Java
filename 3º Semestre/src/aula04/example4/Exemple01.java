package aula04.example4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exemple01 {

	static List<Double> array = Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String... args) {
		
		calculateSqrt();
	}
	
	public static void calculateSqrt() {
		
		for(int i=1; i<100; i += 2) {
			double raiz = Math.sqrt((double)i);
			array.add(raiz);
			
			try {
				Thread.sleep(50);
				System.out.println("A raiz quadrada de " + i + " é " + raiz);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
