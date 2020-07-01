package I_Colletions;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class G_TreeMap {

	public static void main(String[] args) {
	
		TreeMap<String, String> treeCapitais = new TreeMap<>();
		
		treeCapitais.put("RS", "Porto Alegre");
		treeCapitais.put("SC", "Florianópolis");
		treeCapitais.put("PR", "Curitiba");
		treeCapitais.put("SP", "São Paulo");
		treeCapitais.put("RJ", "Rio de Janeiro");
		treeCapitais.put("BH", "Belo Horizonte");
		
		System.out.println(treeCapitais);
		System.out.println(treeCapitais.firstKey());
		System.out.println(treeCapitais.lastKey());
		
		System.out.println(treeCapitais.lowerKey("SC"));		//Primeira capital acima da do parâmetro
		System.out.println(treeCapitais.higherKey("SC"));		//Primeira capital abaixo da do parâmetro
		System.out.println(treeCapitais);
		
		System.out.println(treeCapitais.firstEntry().getKey() + " -- " + treeCapitais.firstEntry().getValue());
		System.out.println(treeCapitais.lastEntry().getKey() + " -- " + treeCapitais.lastEntry().getValue());
		System.out.println(treeCapitais);
		
		Iterator<String> iterator = treeCapitais.keySet().iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " -- " + treeCapitais.get(key));
		}
		
		for (String c : treeCapitais.keySet())
			System.out.println(c + " -- " + treeCapitais.get(c));
		
		for (Map.Entry<String, String> c : treeCapitais.entrySet())
			System.out.println(c.getKey() + " -- " + c.getValue());
	}
}