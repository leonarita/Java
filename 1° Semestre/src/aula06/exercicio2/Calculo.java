package aula06.exercicio2;

public class Calculo {

	public static double ExecutarCalculo(double num) {
		return Math.sqrt(num);
	}
	
	public static double ExecutarCalculo(double base, double expoente) {
		return Math.pow(base, expoente);
	}
	
	public static double ExecutarCalculo(int num) throws ArithmeticException {
		double fatorial = 1;
				
		for (double i=num; i>=1; i--) {
			fatorial *= i;
		}
		
		return fatorial;
	}
}
