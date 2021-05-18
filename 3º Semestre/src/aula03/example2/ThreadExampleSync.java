package aula03.example2;

public class ThreadExampleSync {

	public static void main(String[] args) {
		Runnable paralelo = new RunnableHelloWorld();
		paralelo.run();

		System.out.println("Fim");
	}

}
