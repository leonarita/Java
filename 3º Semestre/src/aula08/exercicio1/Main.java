package aula08.exercicio1;

public class Main {
	
	public static void main(String... args) {
		
		new Thread(() -> System.out.println("Hello by " + Thread.currentThread().getName())).start();
	}

}
