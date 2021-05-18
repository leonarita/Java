package aula03.example1;

public class ThreadExampleSync {

	public static void main(String[] args) {

//		example01();
		
		example02();
	}
	
	public static void example01() {
		Runnable paralelo = new RunnableHelloWorld();
		paralelo.run();
		System.out.println("Thread principal: " + Thread.currentThread().getName());
	}
	
	public static void example02() {
		Runnable paralelo = new RunnableHelloWorld();
		Thread t1 = new Thread(paralelo);
		t1.start();
		System.out.println("Thread principal: " + Thread.currentThread().getName());
	}


}
