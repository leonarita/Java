package J_Programação_Funcional;

import java.util.function.Consumer;

public class G_Funcoes_De_Alta_Ordem {

	//Funções de alta ordem -> retorna ou recebe uma função como parâmetro
	
	public static void main(String[] args) {
		
		Calculo soma = (a, b) -> a+b;
		Calculo subtracao = (a, b) -> a-b;
		System.out.println(executarOperacao(soma, 1, 2));
		System.out.println(executarOperacao(subtracao, 1, 2));
		
		Consumer<String> imprimirUmaFrase1 = System.out::println;
		Consumer<String> imprimirUmaFrase2 = frase -> System.out.println(frase);
		imprimirUmaFrase1.accept("Hello world");
		imprimirUmaFrase2.accept("Hello world");
	}
	
	public static int executarOperacao(Calculo c, int a, int b) {
		return c.calcular(a, b);
	}
}

interface Calculo {
	public int calcular (int a, int b);
}