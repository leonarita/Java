package teste.poo;

public class Main {
	
	public static void main(String args[]) {
		ClassMother c1 = new ClassSon("Mother", "Son");
		ClassSon c2 = (ClassSon) c1;
		
		System.out.println(c2.atr);
		System.out.println(c2.atrib);
	}

}
