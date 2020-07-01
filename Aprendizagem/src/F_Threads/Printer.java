package F_Threads;

public class Printer extends Thread {

	String text;
	int delay, times;
	
	public Printer (String text, int times, int delay) {
		
		this.text = text;
		this.times = times;
		this.delay = delay;
	}
	
	@Override
	public void run () {
		
		for (int i = 0; i < times; i++) {
			
			System.out.println(text);
			
			try {
				Thread.sleep(delay);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
