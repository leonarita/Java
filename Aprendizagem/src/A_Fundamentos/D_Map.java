package A_Fundamentos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class D_Map {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("Informe o valor para trocar as notas: ");
		int amount = sc.nextInt();
		System.out.println("\n\n");
		
		List<Integer> billValues = Arrays.asList( 100, 50, 20, 10, 5, 2, 1 );
		
		Map<Integer, Integer> distribution = getBillDistribution(amount, billValues);
		
		printOutput(amount, distribution);
		
		sc.close();
		
	}
	
	public static Map<Integer, Integer> getBillDistribution (int amount, List<Integer> billValues) {
		
		HashMap<Integer, Integer> distribution = new HashMap<>();
		
		for (int value : billValues) {
			
			int bills = amount / value;
			
			if (bills > 0)
				distribution.put(value, bills);
				
			amount %= value;
		}
		
		return distribution;
	}
	
	public static void printOutput(int amount, Map<Integer, Integer> distribution) {
		
		System.out.println("Dividindo R$" + amount + " em notas de R$100, R$50, R$20, R$10, R$5, R$2 e R$1");
		
		for (Entry<Integer, Integer> e : distribution.entrySet()) {
			
			int value = e.getKey();
			int bills = e.getValue();
			
			System.out.println("Notas de R$" + value + " : " + bills);
		}
	}
}
