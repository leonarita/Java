package metaprogramming.cap3.ex4;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import metaprogramming.cap3.ex1.Metadado;

@Metadado(nome="teste",numero=34)
public class App {
	
	public static void main(String[] args) throws Exception {
		imprimeAnotacoes(App.class);
	}

	private static void imprimeAnotacoes(AnnotatedElement ae) throws Exception {
		Annotation[] ans = ae.getAnnotations();
		
		for(Annotation a : ans){
			Class<?> c = a.annotationType();
			System.out.println("@" + c.getName());
			
			for(Method m : c.getDeclaredMethods()){
				Object o = m.invoke(a);
				System.out.println(" |-> " + m.getName() + " = " + o);
			}
		}
	}
}
