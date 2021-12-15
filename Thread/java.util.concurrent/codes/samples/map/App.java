package codes.samples.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class App {
	
	// ConcurrentHashMap : Mais de uma thread consegue acessar o map ao mesmo tempo

	public static void main(String[] args) {
		Map<Integer, Integer> values = new ConcurrentHashMap<Integer, Integer>();
		
		Thread writer = new Thread(new WriterRunnable(values), "writer");
		Thread reader = new Thread(new ReaderRunnable(values), "reader");
		
		writer.start();
		reader.start();
	}

}
