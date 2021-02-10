package testes.fundamentos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalProgramming {
	
	public static class P {
		
	}
	
	public static void main(String[] args) {
		List<P> ps = new ArrayList<P>(Arrays.asList(new P(), new P()));
		
		ps.forEach(p -> System.out.println("i"));
	}

}
