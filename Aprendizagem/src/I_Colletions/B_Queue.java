package I_Colletions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class B_Queue {

	public static void main (String[] args) {
		
		Queue<String> filaBanco = new LinkedList<> ();
		
		filaBanco.add("Patrícia");
		filaBanco.add("Roberto");
		filaBanco.add("Flávio");
		filaBanco.add("Pamela");
		filaBanco.add("Anderson");
		
		System.out.println(filaBanco);
		
		String clienteASerAtendido = filaBanco.poll();
		System.out.println("Próximo cliente: " + clienteASerAtendido);
		System.out.println(filaBanco);
		
		String primeiroCliente = filaBanco.peek();
		System.out.println("Primeiro cliente: " + primeiroCliente);
		System.out.println(filaBanco);
		
		//filaBanco.clear();
		
		String primeiroClienteOuErro = filaBanco.element();
		System.out.println("Primeiro cliente: " + primeiroClienteOuErro);
		System.out.println(filaBanco);
		
		System.out.println(filaBanco.size());
		System.out.println(filaBanco.isEmpty());
		
		System.out.println("\n\n");
		for (String i : filaBanco)
			System.out.println("-->" + i);
		System.out.println("\n\n");
		
		Iterator<String> iterator = filaBanco.iterator();
		
		while (iterator.hasNext()) {
			System.out.println("--->" + iterator.next());
		}
	}
}
