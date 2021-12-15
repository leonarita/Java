package codes.samples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	
	public static void main(String... args) throws InterruptedException {
		
		AtomicInteger count = new AtomicInteger(0);
		Arrays.asList(1, 2, 3).forEach(e -> count.getAndIncrement());
		System.out.println(count.get());
		System.out.println();
		
		BlockingQueue<List<Integer>> queue = new LinkedBlockingDeque<List<Integer>>();
		List<Integer> valuesQueue = List.of(1, 2, 3, 4, 5);
		while (!queue.offer(valuesQueue, 10, TimeUnit.SECONDS));
		System.out.println(queue.size());
		queue.poll(10, TimeUnit.SECONDS);
		System.out.println(queue.size());
		System.out.println();
		
	}

}
