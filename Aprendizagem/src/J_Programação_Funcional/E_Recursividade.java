package J_Programação_Funcional;

public class E_Recursividade {
	
	//Recursão de cauda -> Não há nenhuma linha de código após a chamada do próprio método
	//[JVM lança StackOverFlow (estouro de pilha)]

	public static void main(String[] args) {
		System.out.println(fatorial(5));
		
		System.out.println(fatorial2(5));
		//System.out.println(fatorial2(100000));	->	Estouro de pilha
	}
	
	public static int fatorial (int value) {
		if (value == 1) {
			return value;
		}
		else {
			return value * fatorial (value-1);
		}
	}
	
	public static int fatorial2 (int valor) {
		return fatorialComTailCall(valor, 1);
	}
	
	public static int fatorialComTailCall(int valor, int numero) {
		if (valor == 0)
			return numero;
		return fatorialComTailCall(valor-1, numero*valor);
	}
}