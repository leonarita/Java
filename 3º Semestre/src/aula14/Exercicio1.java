package aula14;

public class Exercicio1 {
	
	public static void main(String... args) {
		System.out.println("Inicio do main");
		metodo1();
		System.out.println("fim do main");
	}
	
	public static void metodo1() {
		System.out.println("Inicio do metodo 1");
		metodo2();
		System.out.println("fim do metodo 1");
	}
	
	public static void metodo2() {
		System.out.println("Inicio do metodo 2");
		
		try {
			int[] array = new int[10];
			
			for (int i =0; i<= 15;i++) {
				array[i] = i;
				System.out.println(i);
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\tErro na execução da atribuição no vetor: Vetor lotado");
		}
		finally {
			System.out.println("fim do metodo 1");
		}
		
	}

}
