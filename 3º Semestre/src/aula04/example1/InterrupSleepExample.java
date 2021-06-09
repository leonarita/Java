package aula04.example1;

public class InterrupSleepExample {
	
	public static void main(String[] args) {
		Runnable runnable = new RandomLetters();
		Thread t1 = new Thread(runnable);
		
		t1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		// sets interrupt flag in t1
		t1.interrupt();
		
		System.out.println("\nThread " + Thread.currentThread().getName() + " is DONE!");
	}

}
