package aula02;

public class Teste {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		MinhaThreadRunnable thread1 = new MinhaThreadRunnable("#1", 900);
		
		MinhaThreadRunnable thread2 = new MinhaThreadRunnable("#2", 650);
		
		MinhaThreadRunnable thread3 = new MinhaThreadRunnable("#3", 1100);
	}

}