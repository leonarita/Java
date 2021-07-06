package threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
		
	public static void main(String... args) {
	
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

		executor.submit(() -> {
			Thread.sleep(1000);
			return null;
		});
		
		executor.submit(() -> {
			Thread.sleep(1000);
			return null;
		});
		
		executor.submit(() -> {
			Thread.sleep(1000);
			return null;
		});
		
		System.out.println(executor.getPoolSize());
		System.out.println(executor.getQueue().size());
	}

}
