package I_Colletions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class A_List {

	public static void main (String[] args) {
		
		List<String> nomes = new ArrayList<> ();
	//	List<String> nomes = new Vector<> ();
		
		nomes.add("Carlos");
		nomes.add("Pedro");
		nomes.add("Juliana");
		nomes.add("Anderson");
		nomes.add("Maria");
		nomes.add("João");
		
		System.out.println(nomes);
		
		nomes.set(2, "Larissa");
		System.out.println(nomes);
		
		Collections.sort(nomes);
		System.out.println(nomes);
		
		nomes.set(2, "Wesley");
		System.out.println(nomes);
		
		nomes.remove(4);
		System.out.println(nomes);
		
		nomes.remove("Wesley");
		System.out.println(nomes);
		
		System.out.println(nomes.get(1));
		System.out.println(nomes.size());
		System.out.println(nomes.contains("Anderson"));
		System.out.println(nomes.contains("Fernando"));
		System.out.println(nomes.indexOf("Carlos"));
		System.out.println(nomes.isEmpty());
		
		System.out.println("\n\n");
		for (String i : nomes)
			System.out.println("-->" + i);
		System.out.println("\n\n");
		
		Iterator<String> iterator = nomes.iterator();
		
		while (iterator.hasNext()) {
			System.out.println("--->" + iterator.next());
		}
		
		nomes.clear();
		System.out.println(nomes.isEmpty());

	}
}
