package A_Fundamentos;

public class H_Instâncias {

	public static void main(String[] args) {
		
		//O operador new é aplicado para definir novas "instance" de classes.
		Object obj = new String("Exemplo");
		
		//O operador instanceof aplica um comparativo do objeto que está "instanciado" no objeto.
		if (obj instanceof String) 
			System.out.println("comparativo positivo");
	}
}
