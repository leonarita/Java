package A_Fundamentos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class B_List {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("Informe o valor para trocar as notas: ");
		int amount = sc.nextInt();
		System.out.println("\n\n");
		
		List<Integer> billValues = Arrays.asList( 100, 50, 20, 10, 5, 2, 1 );
		
		List<Integer> numberOfBills = getBillDistribution(amount, billValues);
		
		printOutput(amount, billValues, numberOfBills);
		
		sc.close();
		
	}
	
	public static List<Integer> getBillDistribution (int amount, List<Integer> billValues) {
		
		ArrayList<Integer> numberOfBills = new ArrayList<>();
		
		for (int value : billValues) {
			numberOfBills.add(amount / value);
			amount %= value;
		}
		
		return numberOfBills;
	}
	
	public static void printOutput(int amount, List<Integer> billValues, List<Integer> numberOfBills) {
		
		System.out.println("Dividindo R$" + amount + " em notas de R$100, R$50, R$20, R$10, R$5, R$2 e R$1");
		
		for (int i = 0; i < numberOfBills.size(); i++) {
			System.out.println("Notas de R$" + billValues.get(i) + " : " + numberOfBills.get(i));
		}
	}
}
