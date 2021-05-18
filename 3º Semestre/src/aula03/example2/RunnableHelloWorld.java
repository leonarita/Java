package aula03.example2;

public class RunnableHelloWorld implements Runnable {

	@Override
	public void run() {
		for(int i=0; i< 10000; i++) {
			System.out.println(i);
		}
	}

}
