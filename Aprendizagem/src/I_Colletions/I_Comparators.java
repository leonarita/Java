package I_Colletions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class I_Comparators {

	public static void main(String[] args) {

		//Algoritmos de ordenação => ordenação de objetos complexos (criados pelo usuário)
		
		List<I_Estudante> estudantes = new ArrayList<>();
		
		estudantes.add(new I_Estudante("Pedro", 19));
		estudantes.add(new I_Estudante("Carlos", 23));
		estudantes.add(new I_Estudante("Mariana", 21));
		estudantes.add(new I_Estudante("João", 18));
		estudantes.add(new I_Estudante("Thiago", 20));
		estudantes.add(new I_Estudante("Jorge", 21));
		estudantes.add(new I_Estudante("Larissa", 22));
		
		System.out.println("--- Ordem de inserção ---");
		System.out.println(estudantes + "\n");
		
		System.out.println("--- Ordem de idade ---");
		estudantes.sort((first, second) -> first.getIdade() - second.getIdade());
		System.out.println(estudantes + "\n");
		
		System.out.println("--- Ordem reversa de idade ---");
		estudantes.sort((first, second) -> second.getIdade() - first.getIdade());
		System.out.println(estudantes + "\n");
		
		System.out.println("--- Ordem de idade (method reference) ---");
		estudantes.sort(Comparator.comparingInt(I_Estudante::getIdade));
		System.out.println(estudantes + "\n");
		
		System.out.println("--- Ordem reversa de idade (method reference) ---");
		estudantes.sort(Comparator.comparingInt(I_Estudante::getIdade).reversed());
		System.out.println(estudantes + "\n");
		
		System.out.println("--- Ordem de idade (interface Comparable) ---");
		Collections.sort(estudantes);
		System.out.println(estudantes + "\n");
		
		System.out.println("--- Ordem reversa de idade (interface Comparable) ---");
		Collections.sort(estudantes, new I_EstudanteOrdemIdadeReversaComparator());
		System.out.println(estudantes + "\n");
	}
}