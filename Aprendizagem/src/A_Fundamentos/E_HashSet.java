package A_Fundamentos;

import java.util.HashSet;

public class E_HashSet {

	public static void main (String[] args) {
			
		HashSet<String> mySet = new HashSet<> ();
		
		mySet.add("Banana");
		mySet.add("Apple");
		
		System.out.println("Banana: " + mySet.contains("Banana"));
		System.out.println("Orange: " + mySet.contains("Orange"));
		
		mySet.remove("Banana");
		System.out.println("Banana: " + mySet.contains("Banana"));
		
		for (String fruit : mySet)
			System.out.print(fruit + " ");
	}
}
