package aulas;

public class ColetorLixo {
	
	public static void obterMemoriaUsada() {
		final int MB = 1024 * 1024;
		
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println((runtime.totalMemory() - runtime.freeMemory()) / MB);
	}
	
	public static void main(String[] args) {
		obterMemoriaUsada();
		
		Runtime.getRuntime().runFinalization();
		Runtime.getRuntime().gc();
		
		obterMemoriaUsada();
	}

}
