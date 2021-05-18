package aula02;

public class ThreadSimple extends Thread {
	
	public void run() {
		System.out.println("Thread criada");
	}

	public static void main(String... args) {

		Thread thread = new ThreadSimple();
		thread.start();
		
		System.out.println("Thread original");

	}
}
