package A_Fundamentos;

import java.util.ArrayList;

public class C_ArrayList {

	public static void main (String[] args) {
		
		ArrayList<Integer> myList = new ArrayList<> ();
		
		int numOfElements = (int) (Math.random() * 100);
		
		for (int i = 0; i < numOfElements; i++)
			myList.add(i);
		
		for (int num : myList)
			System.out.println(num);
	}
}
