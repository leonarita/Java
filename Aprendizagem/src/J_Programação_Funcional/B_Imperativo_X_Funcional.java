package J_Programação_Funcional;

import java.util.Arrays;

public class B_Imperativo_X_Funcional {

	public static void main(String[] args) {
		
		int[] valores = {1, 2, 3, 4};
		
		//Funcional
		Arrays.stream(valores).filter(numero -> numero % 2 == 0).map(numero -> numero * 2).forEach(numero -> System.out.println(numero));
		
		//Imperativo
		System.out.println("\n");
		for (int i = 0; i < valores.length; i++) {
			int valor = 0;
			
			if (valores[i] % 2 == 0) {
				valor = valores[i] * 2;
				
				if (valor != 0)
					System.out.println(valor);
			}
		}
	}
}
