package testes.annotations.v2;

import testes.annotations.ValidatorsMethod;

public class Main {
	
	private static Pessoa pessoa = new Pessoa() {};
	
	public static void main(String[] args){
		
		ValidatorsMethod.setDataAtInterface(pessoa);
		
	}

}
