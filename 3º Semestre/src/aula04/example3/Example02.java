package aula04.example3;

import aula04.example2.ImplementacaoDeRunnable;

public class Example02 {
	
	public static void main(String[] args) {
		Runnable runnable1 = new ImplementacaoDeRunnable("Leo-01", 2000);
		Thread t1 = new Thread(runnable1);
		
		Runnable runnable2 = new ImplementacaoDeRunnable("Leo-02", 1000);
		Thread t2 = new Thread(runnable2);
		
		Runnable runnable3 = new ImplementacaoDeRunnable("Leo-03", 1200);
		Thread t3 = new Thread(runnable3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		finally {
			t1.interrupt();
			t2.interrupt();
			t3.interrupt();
		}
		
		// sets interrupt flag in t1
		t1.interrupt();
		
		System.out.println("\nThread " + Thread.currentThread().getName() + " is DONE!");
	}
}
