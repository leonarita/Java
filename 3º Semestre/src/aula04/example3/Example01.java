package aula04.example3;

import aula04.example2.ImplementacaoDeRunnable;

public class Example01 {
	
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
		
		interruptThread(t1);
		interruptThread(t2);
		interruptThread(t3);
		
		System.out.println("\nThread " + Thread.currentThread().getName() + " is DONE!");
	}
	
	public static void interruptThread(Thread thread) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		finally {
			thread.interrupt();
		}
	}

}
