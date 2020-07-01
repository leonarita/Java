package J_Programa��o_Funcional;

public class E_Recursividade {
	
	//Recurs�o de cauda -> N�o h� nenhuma linha de c�digo ap�s a chamada do pr�prio m�todo
	//[JVM lan�a StackOverFlow (estouro de pilha)]

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