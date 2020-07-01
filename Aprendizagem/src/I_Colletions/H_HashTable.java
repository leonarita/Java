package I_Colletions;

import java.util.Hashtable;
import java.util.Map;

public class H_HashTable {

	public static void main(String[] args) {
	
		Hashtable<String, Integer> estudantes = new Hashtable<>();
		
		estudantes.put("Carlos", 21);
		estudantes.put("Mariana", 33);
		estudantes.put("Rafaela", 18);
		estudantes.put("Pedro", 44);
		
		System.out.println(estudantes);
		
		estudantes.put("Pedro", 55);
		System.out.println(estudantes);
		
		estudantes.remove("Pedro");
		System.out.println(estudantes);
		
		int idadeMariana = estudantes.get("Mariana");
		System.out.println(idadeMariana);
		System.out.println(estudantes.size());
		
		for (Map.Entry<String, Integer> e : estudantes.entrySet())
			System.out.println(e.getKey() + " -- " + e.getValue());
		
		for (String e : estudantes.keySet())
			System.out.println(e + " -- " + estudantes.get(e));
		
		System.out.println(estudantes);
	}
}