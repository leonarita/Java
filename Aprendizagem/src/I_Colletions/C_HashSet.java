package I_Colletions;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class C_HashSet {

	public static void main(String[] args) {
		
		//Não é necessária a ordenação
		//Não permite repetição de dados
		//Mais performática
		
		Set<Double> notasAlunos = new HashSet<>();
		
		notasAlunos.add(5.8);
		notasAlunos.add(9.3);
		notasAlunos.add(6.5);
		notasAlunos.add(10.0);
		notasAlunos.add(5.4);
		notasAlunos.add(7.3);
		notasAlunos.add(3.8);
		notasAlunos.add(4.0);
		
		System.out.println(notasAlunos);
		
		notasAlunos.remove(3.8);
		System.out.println(notasAlunos);
		System.out.println(notasAlunos.size());
		
		Iterator<Double> iterator = notasAlunos.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for(Double n : notasAlunos) {
			System.out.println(n);
		}
		
		notasAlunos.clear();
		System.out.println(notasAlunos.isEmpty());
	}
}
