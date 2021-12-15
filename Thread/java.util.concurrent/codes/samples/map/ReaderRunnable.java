package codes.samples.map;

import java.util.Map;

public class ReaderRunnable implements Runnable {
	
	private Map<Integer, Integer> values;
	
	public ReaderRunnable(Map<Integer, Integer> values) {
		this.values = values;
	}

	@Override
	public void run() {
		System.out.println("Rodando thread " + Thread.currentThread().getName());
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " esperando 1 milisegundo");

		for(Integer i : values.keySet()) {
			System.out.println(values.get(i));
		}
		
	}

}
