package e.state;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		No a = new No("A"); No b = new No("B");
		No c = new No("C"); No d = new No("D");
		No e = new No("E"); No f = new No("F");
		No g = new No("G"); No h = new No("H");
		
		a.addAdjacentes(b); b.addAdjacentes(c);
		c.addAdjacentes(d); d.addAdjacentes(b);
		a.addAdjacentes(e); e.addAdjacentes(f);
		f.addAdjacentes(c); f.addAdjacentes(g);
		f.addAdjacentes(h); a.addAdjacentes(h);
		
		List<No> l = new ArrayList<>();
		
		a.buscaProfundidade(l);
		
		for(No n : l)
			System.out.println(n);
	}
	
}
