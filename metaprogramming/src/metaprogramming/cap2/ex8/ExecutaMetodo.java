package metaprogramming.cap2.ex8;

import java.lang.reflect.Method;
import java.util.Scanner;

public class ExecutaMetodo {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception{
		System.out.println("Entre com o nome da classe com m�todo que deseja executar: ");
		
		Scanner in = new Scanner(System.in);
		String nomeClasse = in.nextLine();
		Class<?> c = Class.forName(nomeClasse);

		System.out.println("Entre com o nome do m�todo: ");
		String nomeMetodo = in.nextLine();
		
		Method m = acharMetodoPeloNome(c, nomeMetodo);
		Object[] params = new Object[m.getParameterTypes().length];
		
		for(int i=0; i<params.length; i++) {
			Class<?> paramType = m.getParameterTypes()[i];
			System.out.println("Parametro " + (i+1) + " (" + paramType.getName() + ")");
			String valor = in.nextLine();
			params[i] = paramType.getConstructor(String.class).newInstance(valor);
		}

		Object retorno = m.invoke(c.newInstance(), params);
		System.out.println("O m�todo retornou: " + retorno);
		in.close();
	}
	
	public static Method acharMetodoPeloNome(Class<?> c, String nome) throws Exception {
		for(Method m : c.getMethods()){
			if(m.getName().equals(nome)){
				return m;
			}
		}
		
		throw new Exception("M�todo " + nome + " n�o encontrado");
	}
}
