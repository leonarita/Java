package I_Colletions;

import java.util.Iterator;
import java.util.TreeSet;

public class E_TreeSet {

	public static void main(String[] args) {

		//Alterar a ordem através de comparators
		//Ordenado e pode ser reordenado
		//Performático para leitura, mas para modificar não é
		
		TreeSet<String> treeCapitais = new TreeSet<>();
		
		treeCapitais.add("Porto Alegre");
		treeCapitais.add("Florianópolis");
		treeCapitais.add("Curitiba");
		treeCapitais.add("São Paulo");
		treeCapitais.add("Rio de Janeiro");
		treeCapitais.add("Belo Horizonte");
		
		System.out.println(treeCapitais);
		System.out.println(treeCapitais.first());
		System.out.println(treeCapitais.last());
		
		System.out.println(treeCapitais.lower("Florianópolis"));
		System.out.println(treeCapitais.higher("Florianópolis"));
		System.out.println(treeCapitais);

		//Funções que exibem e retiram do set
		System.out.println(treeCapitais.pollFirst());
		System.out.println(treeCapitais.pollLast());

		System.out.println(treeCapitais);
		
		Iterator<String> iterator = treeCapitais.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for(String n : treeCapitais) {
			System.out.println(n);
		}
	}
}
