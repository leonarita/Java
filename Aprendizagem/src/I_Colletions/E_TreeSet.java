package I_Colletions;

import java.util.Iterator;
import java.util.TreeSet;

public class E_TreeSet {

	public static void main(String[] args) {

		//Alterar a ordem atrav�s de comparators
		//Ordenado e pode ser reordenado
		//Perform�tico para leitura, mas para modificar n�o �
		
		TreeSet<String> treeCapitais = new TreeSet<>();
		
		treeCapitais.add("Porto Alegre");
		treeCapitais.add("Florian�polis");
		treeCapitais.add("Curitiba");
		treeCapitais.add("S�o Paulo");
		treeCapitais.add("Rio de Janeiro");
		treeCapitais.add("Belo Horizonte");
		
		System.out.println(treeCapitais);
		System.out.println(treeCapitais.first());
		System.out.println(treeCapitais.last());
		
		System.out.println(treeCapitais.lower("Florian�polis"));
		System.out.println(treeCapitais.higher("Florian�polis"));
		System.out.println(treeCapitais);

		//Fun��es que exibem e retiram do set
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
