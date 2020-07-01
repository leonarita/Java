package J_Programação_Funcional;

import java.util.function.UnaryOperator;

public class A_Introdução {

	public static void main(String[] args) {
		
		UnaryOperator<Integer> calcularValorVezesTres = valor -> valor * 3;
		int valor = 10;
		System.out.println("O resultado é : " + calcularValorVezesTres.apply(valor));
	}
	
/*
	public void calcular(somar(x, y)) {
		
	}
	
	public static int somar(int x, int y) {
		return x + y;
	}
*/
}