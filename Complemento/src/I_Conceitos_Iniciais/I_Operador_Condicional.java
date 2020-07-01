package I_Conceitos_Iniciais;

public class I_Operador_Condicional {
	public static void main(String[] args){
		 
		int a = 10;
		int b = 20;
		int maior;
		
		//Condição ?  Caso-Verdadeiro :  Caso-Falso
		maior = (a > b) ?	 500 	: 	1000	;
		
		//maior = false ? 500 : 1000 -> O Caso-False (1000) será retornado
		 
		System.out.println(maior);
		System.out.println("\n\n-------------------------------------\n\n");
		
//Pré-incremento e Pós-incremento
//Pré-decrecremento e Pós-decremento
		
		int c=10;
		int d=c++;
		System.out.println (c);
		System.out.println (d);
		//Pré-incremento -> Incrementa o original c
		
		System.out.println ("\n");
		
		int e=10;
		int f=++e;
		System.out.println (e);
		System.out.println (f);
		//Pós-incremento -> Incrementa o original e e o que recebe f
		 
	}
}