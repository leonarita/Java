package J_Programa��o_Funcional;

import java.util.function.UnaryOperator;

public class A_Introdu��o {

	public static void main(String[] args) {
		
		UnaryOperator<Integer> calcularValorVezesTres = valor -> valor * 3;
		int valor = 10;
		System.out.println("O resultado � : " + calcularValorVezesTres.apply(valor));
	}
	
/*
	public void calcular(somar(x, y)) {
		
	}
	
	public static int somar(int x, int y) {
		return x + y;
	}
*/
}