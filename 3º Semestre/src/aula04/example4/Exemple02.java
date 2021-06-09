package aula04.example4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exemple02 {

	static List<Double> array = Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String... args) {

		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				calculateSqrt();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				printSqrt();
			}
		});
		
		t1.start();
		t2.start();
	}
	
	public static void calculateSqrt() {
		
		for(int i=1; i<100; i += 2) {
			double raiz = Math.sqrt((double)i);
			array.add(raiz);
			System.out.println("\tAdicionado " + raiz);
		}
	}
	
	public static void printSqrt() {
		int counter = 1;
		
		for(int i=0; i<50; i++) {
			
			try {
				Thread.sleep(50);
				System.out.println("A raiz quadrada de " + counter + " é " + array.get(i));
				counter += 2;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
