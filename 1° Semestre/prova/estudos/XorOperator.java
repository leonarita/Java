package estudos;

public class XorOperator {
	
	// XOR (OU EXCLUSIVO) : Ou um ou outro

	public static void main(String[] args) {
		boolean pagamentoPorCartao = true;
		boolean pagamentoPorBoleto = true;
		
		System.out.println(pagamentoPorCartao ^ pagamentoPorBoleto);
		
		pagamentoPorCartao = false;
		pagamentoPorBoleto = false;
		System.out.println(pagamentoPorCartao ^ pagamentoPorBoleto);
		
		pagamentoPorCartao = true;
		pagamentoPorBoleto = false;
		System.out.println(pagamentoPorCartao ^ pagamentoPorBoleto);
		
		pagamentoPorCartao = false;
		pagamentoPorBoleto = true;
		System.out.println(pagamentoPorCartao ^ pagamentoPorBoleto);
	}

}
