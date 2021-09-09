package files;

public class Test {

	public static void main(String[] args) {
		ex1();
		ex2();
		ex3();
	}
	
	private static void ex1() {
		int x, a=6, b=7;
		x = a++ + b++;
		System.out.println(x + " " + a + " " + b + " ");
	}
	
	private static void ex2() {
		final Object str = new String("a");
		
		if(str instanceof String) {
			System.out.println("String");
		}
		if(str instanceof Character) {
			System.out.println("Character");
		}
		if(str instanceof Integer) {
			System.out.println("Integer");
		}
	}
	
	private static void ex3() {
		final int VALOR = 6;
		
		for(int i=0; i<VALOR; i++) {
			System.out.print(x(i) + " ");
		}
	}
	
	private static int x(final int n) {
		int result = 1;
		for(int i=2; i<=n; i++) {
			result *= i;
		}
		
		return result;
	}

}
