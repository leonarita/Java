package J_Programa��o_Funcional;

import java.util.HashMap;
import java.util.Map;

public class F_Recursividade_2 {
	
	static Map<Integer, Integer> MAPA_FATORIAL = new HashMap<>();

	public static void main(String[] args) {
		
		System.out.println();
		long I = System.nanoTime();
		System.out.println(fatorialComMemoization(15));
		long F = System.nanoTime();
		System.out.println("Fatorial 1: " + (F - I));
		
		System.out.println();
		I = System.nanoTime();
		System.out.println(fatorialComMemoization(15));
		F = System.nanoTime();
		System.out.println("Fatorial 2: " + (F - I));
	}

	//Memoization -> Tecnica de otimiza��o que consiste no cache do resultado de unma fun��o, baseado nos par�metros de entrada, gerando execu��es r�pidas
	public static Integer fatorialComMemoization (Integer value) {
		if (value == 1)
			return value;
		else {
			if (MAPA_FATORIAL.containsKey(value)) {
				return MAPA_FATORIAL.get(value);
			}
			else {
				Integer resultado = value * fatorialComMemoization (value-1);
				MAPA_FATORIAL.put(value, resultado);
				return resultado;
			}
		}
	}
}