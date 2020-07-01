package J_Programação_Funcional;

public class D_Lambda {

	public static void main(String[] args) {
		
		//Classe Anônima
		Funcao3 funcao1 = new Funcao3 () {
			@Override
			public String gerar(String v) {
				return "Sr. " + v;
			}
		};
		
		System.out.println(funcao1.gerar("Leo"));
		
		//Lambda
		Funcao3 funcao2 = valor -> "Sr. " + valor;
		System.out.println(funcao2.gerar("Leo"));
		
		//Lambda com mais uma instrução
		Funcao3 funcao3 = valor -> {
			System.out.print("Hey! ");
			return valor;
		};
		System.out.println(funcao3.gerar("Leo"));
	}
}

/*
interface Funcao1 {
	String gerar(String valor);
}
 
interface Funcao2 {
	String gerar(String valor);
	default Integer gerarNumero(String valor) {}
}
*/

@FunctionalInterface	//Interfaces funcionais -> possuem apenas um método abstrato
interface Funcao3 {
	String gerar(String valor);
}