package aula08.exercicio2;

public class Main {
	
	public static void main(String... args) {
		
		createThread("HELLO 01", 200);
		createThread("HELLO 02", 300);
		createThread("HELLO 03", 500);
	}
	
	public static void createThread(String text, int seconds) {
		
		new Thread(() -> {
			
			System.out.println(Thread.currentThread().getName() + "- " + text);
			
			for(int i=0; i<5; i++) {
				
				System.out.println("Thread paralela " + Thread.currentThread().getName() + ", iteração " + i);
				
				try {
					Thread.sleep(seconds);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}).start();
	}

}
