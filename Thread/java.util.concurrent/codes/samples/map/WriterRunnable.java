package codes.samples.map;

import java.util.Map;

public class WriterRunnable implements Runnable {
	
	private Map<Integer, Integer> values;
	
	public WriterRunnable(Map<Integer, Integer> values) {
		this.values = values;
	}

	@Override
	public void run() {
		System.out.println("Rodando thread " + Thread.currentThread().getName());

		for(int i=0; i<=100; i++) {
			values.put(i, i);
			System.out.println("Escrito " + i);
		}
	}

}
