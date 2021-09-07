package metaprogramming.cap4.ex2;

import java.util.List;

import metaprogramming.cap1.ex1.Produto;

public class App {

	public static void main(String[] args){
		Produto p = Historico.guardar(new Produto());
		
		p.setNome("Design Patterns com Java");
		p.setPreco(59.90);
		
		//blackfriday
		p.setPreco(49.90);
		
		//normal
		p.setPreco(59.90);
		
		//natal
		p.setPreco(54.90);
		
		List<Object> lista = ((RecuperadorHistorico)p).getHistorico("preco");

		for(Object valor : lista){
			System.out.println(valor);
		}
		
	}
}
