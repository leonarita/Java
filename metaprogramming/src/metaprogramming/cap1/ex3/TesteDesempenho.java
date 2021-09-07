package metaprogramming.cap1.ex3;

public class TesteDesempenho {

	public static void main(String[] args){
		
		double normal = executaTeste(new InvocadorNormal());
		System.out.println("\n");
		
		double reflection = executaTeste(new InvocadorReflexao());
		System.out.println("\t" + (reflection/normal) + " vezes mais que o normal");
		System.out.println("\n");
		
		double reflectionCache = executaTeste(new InvocadorReflexaoCache());
		System.out.println("\t" + (reflectionCache/normal) + " vezes mais que o normal");
		System.out.println("\n");
	}
		
	public static double executaTeste(InvocadorMetodo invoc){
		long millis = System.nanoTime();
		invoc.invocarMetodo(100000);
		String nomeClasse = invoc.getClass().getName();
		long diferenca = System.nanoTime() - millis;
		System.out.println("A classe " + nomeClasse + " demorou " + diferenca + " nano segundos");
		return diferenca;
	}
}
