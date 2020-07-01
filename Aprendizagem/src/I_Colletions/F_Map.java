package I_Colletions;

import java.util.HashMap;
import java.util.Map;

public class F_Map {

	public static void main(String[] args) {
		
		//Entrada de chave e valor, onde os valores podem ser repetidos, mas as chaves n�o
		//Permite adi��o (seja por chave ou valor), atualiza��o, remo��o, navega��o e ordena��o
		
		Map<String, Integer> campeoesMundialFifa = new HashMap<>();
		//Map<String, List<Integer>> campeoesMundialFifa = new HashMap<>();
		
		campeoesMundialFifa.put("Brasil", 5);
		campeoesMundialFifa.put("Alemanha", 4);
		campeoesMundialFifa.put("It�lia", 4);
		campeoesMundialFifa.put("Uruguai", 3);
		campeoesMundialFifa.put("Argentina", 3);
		campeoesMundialFifa.put("Fran�a", 3);
		campeoesMundialFifa.put("Inglaterra", 2);
		campeoesMundialFifa.put("Espanha", 2);
		campeoesMundialFifa.put("Jap�o", 1);
		
		System.out.println(campeoesMundialFifa);
		campeoesMundialFifa.put("Brasil", 6);
		System.out.println(campeoesMundialFifa);

		System.out.println(campeoesMundialFifa.get("Argentina"));
		System.out.println(campeoesMundialFifa.containsKey("Fran�a"));

		campeoesMundialFifa.remove("Fran�a");
		System.out.println(campeoesMundialFifa.containsKey("Fran�a"));
		System.out.println(campeoesMundialFifa.containsValue(6));
		System.out.println(campeoesMundialFifa.size());
		System.out.println(campeoesMundialFifa);

		for(Map.Entry<String, Integer> i : campeoesMundialFifa.entrySet()) {
			System.out.println(i.getKey() + " -- " + i.getValue());
		}
		
		for (String i : campeoesMundialFifa.keySet()) {
			System.out.println(i + " -- " + campeoesMundialFifa.get(i));
		}
		
		System.out.println(campeoesMundialFifa);
		System.out.println(campeoesMundialFifa.containsKey("Estados Unidos"));
		System.out.println(campeoesMundialFifa.containsValue(5));
		
		System.out.println(campeoesMundialFifa.size());
		campeoesMundialFifa.clear();
		System.out.println(campeoesMundialFifa.size());
	}
}
