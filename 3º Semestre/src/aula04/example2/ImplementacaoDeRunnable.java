package aula04.example2;

public class ImplementacaoDeRunnable implements Runnable {
	
	private long miliseconds;
	private String text;
	private int counter;
	
	public ImplementacaoDeRunnable(String text, long miliseconds) {
		this.miliseconds = miliseconds;
		this.text = text;
	}

	@Override
	public void run() {
		
		try {
			while(true) {
				System.out.println(this.text + " " + ++this.counter);
				Thread.sleep(this.miliseconds);
			}
		}
		catch(InterruptedException e) {
			System.out.println("\n" + Thread.currentThread().getName() + " interrupted.");
			System.out.println("INTERRUPTED flag: " + Thread.currentThread().isInterrupted());
		}
		
		System.out.println("Thread " + Thread.currentThread().getName() + " is DONE!");
	}

}
