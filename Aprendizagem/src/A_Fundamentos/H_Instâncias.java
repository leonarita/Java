package A_Fundamentos;

public class H_Inst�ncias {

	public static void main(String[] args) {
		
		//O operador new � aplicado para definir novas "instance" de classes.
		Object obj = new String("Exemplo");
		
		//O operador instanceof aplica um comparativo do objeto que est� "instanciado" no objeto.
		if (obj instanceof String) 
			System.out.println("comparativo positivo");
	}
}
