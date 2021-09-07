package metaprogramming.cap2.ex1;

public class App {

	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		Class<String> classe = String.class;
		System.out.println(classe.getName());
		imprimeNomeClasse(Integer.class);
		System.out.println();
		
		Number object = new Integer(100);
		Class<? extends Number> c = object.getClass();
		System.out.println(c.getName());
	}
	
	public static void imprimeNomeClasse(Class<?> classe){
		System.out.println("Chamado o método com " +classe.getName());
	}
}
