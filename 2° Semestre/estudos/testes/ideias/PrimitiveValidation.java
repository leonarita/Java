package testes.ideias;

public class PrimitiveValidation {
	
	public static void main (String[] args) {
		
		Byte by = 6;
		
		System.out.println(by++);
		System.out.println(by++);
		System.out.println(by++);
		System.out.println(by++);
		System.out.println(by++);
		System.out.println(by++);
		System.out.println(by++);
		
		try {
			Integer i = null;
			int integer = i;
			
			System.out.println(integer);
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		try {
			Boolean b = null;
			boolean bool = b;
			
			System.out.println(bool);
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}
