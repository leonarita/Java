package A_Fundamentos;

import java.util.HashMap;
import java.util.Map.Entry;

public class F_HashMap {

	public static void main (String[] args) {
		
		HashMap<String, Integer> myBooks = new HashMap<> ();
		
		myBooks.put("Ender's game", 4);
		myBooks.put("Ringworld", 3);
		myBooks.put("Heir to the Empire", 5);
		
		for (String title : myBooks.keySet())
			System.out.print(title + " - ");
		
		System.out.println("\n");
		for (int score : myBooks.values())
			System.out.print(score + " - ");
		
		System.out.println("\n");
		for (String title : myBooks.keySet())
			System.out.println(title + " é nota " + myBooks.get(title));
		
		System.out.println("\n");
		for (Entry<String, Integer> entry : myBooks.entrySet()) {
			
			String title = entry.getKey();
			int score = entry.getValue();
			
			System.out.println(title + " é nota " + score);
		}
		
		System.out.println("\n" + myBooks.containsKey("Ringworld"));
		System.out.println(myBooks.containsKey("Crusce"));
		
		myBooks.remove("Ringworld");
		System.out.println(myBooks.containsKey("Ringworld"));
		
		System.out.println(myBooks.containsValue(5));
		System.out.println(myBooks.containsValue(2));
	}
}
