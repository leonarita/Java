package M_Novidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

public class B_ClientHttp {
	
	static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory () {

		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			System.out.println("Nova thread criada: " + (t.isDaemon() ? "daemon" : "") + " Thread group: " + t.getThreadGroup());
			return t;
		}
	});

	public static void main(String[] args) throws Exception {
		//connectAndPrintUrlJavaOracle();
		connectAkamaiHttp11Cliente();
	}
	
	private static void connectAndPrintUrlJavaOracle() throws IOException, InterruptedException {	
		
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create("https://docs.oracle.com/javase/10/language/")).build();
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());	
		
		System.out.println("Status code: " + response.statusCode());
		System.out.println("Headers code: " + response.headers());
		System.out.println(response.body());
	}
	
	private static void connectAkamaiHttp11Cliente() throws Exception {
		System.out.println("Running HTTP/1.1 example...");
		
		try {
			HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).proxy(ProxySelector.getDefault()).build();
			long start = System.currentTimeMillis();
			HttpRequest mainRequest = HttpRequest.newBuilder().uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html")).build();
			HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());
			
			System.out.println("Status code: " + response.statusCode());
			System.out.println("Response headers: " + response.headers());
			String responseBody = response.body();
			System.out.println(responseBody);
			
			List<Future<?>> future = new ArrayList<>();
			
			responseBody.lines().filter(line -> line.trim().startsWith("<ing height")).map(line -> line.substring(line.indexOf("src='") + 5, 
					line.indexOf("'/>"))).forEach(image -> { 
						Future<?> imgFuture = executor.submit(() -> {  HttpRequest imgResquest = HttpRequest.newBuilder().build();
						
						try {
							HttpResponse<String> imageResponse = httpClient.send(imgResquest, HttpResponse.BodyHandlers.ofString());
							System.out.println("Imagem carregada: " + image + ", status code: " + imageResponse.statusCode());
						} catch (IOException | InterruptedException e) {
							e.printStackTrace();
						}
					});
						
					future.add(imgFuture);
					System.out.println("Submetido um futuro para a imagem: "+ image);
					
				});
			
			future.forEach(f -> {
				try {
					f.get();
				}
				catch (InterruptedException | ExecutionException e) {
					System.out.println("Error ao esperar carregar imagem do futuro.");
				}
				
				long end = System.currentTimeMillis();
				System.out.println("Tempo de carregamento total: " + (end - start));
			});
		}
		finally {
			executor.shutdown();
		}
	}
}