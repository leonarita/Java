package I_Colletions;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class D_LinkedHashSet {

	public static void main(String[] args) {

		//Ordenação é necessária
		//Não performática
		
		Set<Integer> sequenciaNumerica = new LinkedHashSet<>();
		
		sequenciaNumerica.add(1);
		sequenciaNumerica.add(2);
		sequenciaNumerica.add(4);
		sequenciaNumerica.add(8);
		sequenciaNumerica.add(16);
		
		System.out.println(sequenciaNumerica);
		
		sequenciaNumerica.remove(4);
		System.out.println(sequenciaNumerica);
		System.out.println(sequenciaNumerica.size());
		
		Iterator<Integer> iterator = sequenciaNumerica.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for(Integer n : sequenciaNumerica) {
			System.out.println(n);
		}
		
		sequenciaNumerica.clear();
		System.out.println(sequenciaNumerica.isEmpty());
	}

}
